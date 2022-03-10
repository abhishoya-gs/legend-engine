// Copyright 2021 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.plan.execution.stores.relational.connection.test;
import org.eclipse.collections.api.list.MutableList;
import org.finos.legend.engine.authentication.DatabaseAuthenticationFlow;
import org.finos.legend.engine.authentication.LegendDefaultDatabaseAuthenticationFlowProvider;
import org.finos.legend.engine.plan.execution.stores.relational.config.TemporaryTestDbConfiguration;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.relational.connection.specification.BigQueryDatasourceSpecification;
import org.finos.legend.engine.plan.execution.stores.relational.connection.manager.ConnectionManagerSelector;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.relational.connection.DatabaseType;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.relational.connection.RelationalDatabaseConnection;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.relational.connection.authentication.GCPApplicationDefaultCredentialsAuthenticationStrategy;
import org.finos.legend.engine.shared.core.vault.EnvironmentVaultImplementation;
import org.finos.legend.engine.shared.core.vault.Vault;
import org.junit.Before;
import org.junit.BeforeClass;
import org.finos.legend.engine.authentication.LegendDefaultDatabaseAuthenticationFlowProviderConfiguration;
import org.finos.legend.engine.authentication.vaults.InMemoryVaultForTesting;
import org.finos.legend.engine.protocol.pure.v1.model.packageableElement.store.relational.connection.authentication.GCPWorkloadIdentityFederationWithAWSAuthenticationStrategy;
import org.junit.Test;
import org.pac4j.core.profile.CommonProfile;

import javax.security.auth.Subject;
import java.io.IOException;
import java.sql.Connection;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ExternalIntegration_TestConnectionAcquisitionWithFlowProvider_BigQuery extends DbSpecificTests
{
    public static final String GOOGLE_APPLICATION_CREDENTIALS = "GOOGLE_APPLICATION_CREDENTIALS";
    public static final String AWS_ACCESS_KEY_ID = "AWS_ACCESS_KEY_ID";
    public static final String AWS_SECRET_ACCESS_KEY = "AWS_SECRET_ACCESS_KEY";
    private static final InMemoryVaultForTesting inMemoryVault = new InMemoryVaultForTesting();

    private ConnectionManagerSelector connectionManagerSelector;

    @BeforeClass
    public static void verifyTestSetup()
    {
        String googleApplicationCredentials = System.getenv(GOOGLE_APPLICATION_CREDENTIALS);
        if (googleApplicationCredentials == null || googleApplicationCredentials.trim().isEmpty())
        {
           // fail(String.format("Tests cannot be run. GCP env variable %s has not been set", GOOGLE_APPLICATION_CREDENTIALS));
        }
        String awsAccessKeyId = System.getenv(AWS_ACCESS_KEY_ID);
        if (awsAccessKeyId == null || awsAccessKeyId.trim().isEmpty())
        {
            // fail(String.format("Tests cannot be run. AWS env variable %s has not been set", AWS_ACCESS_KEY_ID));
        }
        String awsSecretAccessKey = System.getenv(AWS_SECRET_ACCESS_KEY);
        if (awsSecretAccessKey == null || awsSecretAccessKey.trim().isEmpty())
        {
            // fail(String.format("Tests cannot be run. AWS env variable %s has not been set", AWS_SECRET_ACCESS_KEY));
        }
    }

    @BeforeClass
    public static void setupTest() throws IOException
    {
        Vault.INSTANCE.registerImplementation(new EnvironmentVaultImplementation());
        Vault.INSTANCE.registerImplementation(inMemoryVault);
    }

    @Override
    protected Subject getSubject()
    {
        return null;
    }

    @Before
    public void setup()
    {
        LegendDefaultDatabaseAuthenticationFlowProvider flowProvider = new LegendDefaultDatabaseAuthenticationFlowProvider();
        LegendDefaultDatabaseAuthenticationFlowProviderConfiguration flowProviderConfiguration = new LegendDefaultDatabaseAuthenticationFlowProviderConfiguration();
        flowProvider.configure(flowProviderConfiguration);
        assertBigQueryFlowIsAvailable(flowProvider);
        assertBigQueryWifUsingAwsFlowIsAvailable(flowProvider);
        this.connectionManagerSelector = new ConnectionManagerSelector(new TemporaryTestDbConfiguration(-1), Collections.emptyList(), Optional.of(flowProvider));
    }

    public void assertBigQueryFlowIsAvailable(LegendDefaultDatabaseAuthenticationFlowProvider flowProvider)
    {
        BigQueryDatasourceSpecification datasourceSpecification = new BigQueryDatasourceSpecification();
        GCPApplicationDefaultCredentialsAuthenticationStrategy authenticationStrategy = new GCPApplicationDefaultCredentialsAuthenticationStrategy();
        RelationalDatabaseConnection relationalDatabaseConnection = new RelationalDatabaseConnection(datasourceSpecification, authenticationStrategy, DatabaseType.BigQuery);
        relationalDatabaseConnection.type = DatabaseType.BigQuery;
        Optional<DatabaseAuthenticationFlow> flow = flowProvider.lookupFlow(relationalDatabaseConnection);
        assertTrue("bigquery gcp adc flow does not exist ", flow.isPresent());
    }

    public void assertBigQueryWifUsingAwsFlowIsAvailable(LegendDefaultDatabaseAuthenticationFlowProvider flowProvider)
    {
        BigQueryDatasourceSpecification datasourceSpecification = new BigQueryDatasourceSpecification();
        GCPWorkloadIdentityFederationWithAWSAuthenticationStrategy authenticationStrategy = new GCPWorkloadIdentityFederationWithAWSAuthenticationStrategy();
        RelationalDatabaseConnection relationalDatabaseConnection = new RelationalDatabaseConnection(datasourceSpecification, authenticationStrategy, DatabaseType.BigQuery);
        relationalDatabaseConnection.type = DatabaseType.BigQuery;
        Optional<DatabaseAuthenticationFlow> flow = flowProvider.lookupFlow(relationalDatabaseConnection);
        assertTrue("BigQuery Workload Identity Federation Using AWS Flow does not exist ", flow.isPresent());
    }


    @Test
    public void testBigQueryGCPADCConnection_subject() throws Exception
    {
        RelationalDatabaseConnection systemUnderTest = this.bigQuerySpec();
        Connection connection = this.connectionManagerSelector.getDatabaseConnection((Subject) null, systemUnderTest);
        testConnection(connection, "select * from `legend-integration-testing.legend_testing_dataset.basic_test_table`");

    }

    @Test
    public void testBigQueryWIFConnection_subject() throws Exception {

        RelationalDatabaseConnection systemUnderTest = this.bigQueryWithWIFSpec();
        Connection connection = this.connectionManagerSelector.getDatabaseConnection((Subject) null, systemUnderTest);
        testConnection(connection, "select * from `legend-integration-testing.legend_testing_dataset.basic_test_table`");
    }

    @Test
    public void testBigQueryGCPADCConnection_profile() throws Exception {
        RelationalDatabaseConnection systemUnderTest = this.bigQuerySpec();
        Connection connection = this.connectionManagerSelector.getDatabaseConnection((MutableList<CommonProfile>) null, systemUnderTest);
        testConnection(connection, "select * from `legend-integration-testing.legend_testing_dataset.basic_test_table`");
    }

    @Test
    public void testBigQueryWIFConnection_profile() throws Exception
    {
        RelationalDatabaseConnection systemUnderTest = this.bigQueryWithWIFSpec();
        Connection connection = this.connectionManagerSelector.getDatabaseConnection((MutableList<CommonProfile>)null, systemUnderTest);
        testConnection(connection, "select * from `legend-integration-testing.legend_testing_dataset.basic_test_table`");
    }

    private RelationalDatabaseConnection bigQuerySpec() throws Exception
    {
        BigQueryDatasourceSpecification bigQueryDatasourceSpecification = new BigQueryDatasourceSpecification();
        bigQueryDatasourceSpecification.projectId = "legend-integration-testing";
        bigQueryDatasourceSpecification.defaultDataset = "legend_testing_dataset";
        GCPApplicationDefaultCredentialsAuthenticationStrategy authSpec = new GCPApplicationDefaultCredentialsAuthenticationStrategy();
        return new RelationalDatabaseConnection(bigQueryDatasourceSpecification, authSpec, DatabaseType.BigQuery);
    }

    private RelationalDatabaseConnection bigQueryWithWIFSpec() {
        inMemoryVault.setValue("key1", System.getenv(AWS_ACCESS_KEY_ID));
        inMemoryVault.setValue("secret1", System.getenv(AWS_SECRET_ACCESS_KEY));
        BigQueryDatasourceSpecification bigQueryDatasourceSpecification = new BigQueryDatasourceSpecification();
        bigQueryDatasourceSpecification.projectId = "legend-integration-testing";
        bigQueryDatasourceSpecification.defaultDataset = "legend_testing_dataset";
        GCPWorkloadIdentityFederationWithAWSAuthenticationStrategy authSpec = new GCPWorkloadIdentityFederationWithAWSAuthenticationStrategy();
        authSpec.workloadProjectNumber = "412074507462";
        authSpec.workloadPoolId = "aws-wif-pool2";
        authSpec.workloadProviderId = "aws-wif-provider2";
        authSpec.serviceAccountEmail = "legend-integration-wif1@legend-integration-testing.iam.gserviceaccount.com";
        authSpec.awsAccountId = "564704738649";
        authSpec.awsRegion = "us-east-1";
        authSpec.awsRole = "gcp-wif";
        authSpec.awsAccessKeyIdVaultReference = "key1";
        authSpec.awsSecretAccessKeyVaultReference = "secret1";
        return new RelationalDatabaseConnection(bigQueryDatasourceSpecification, authSpec, DatabaseType.BigQuery);
    }
}
