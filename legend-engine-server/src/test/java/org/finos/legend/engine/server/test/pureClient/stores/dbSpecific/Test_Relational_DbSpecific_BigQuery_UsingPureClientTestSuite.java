package org.finos.legend.engine.server.test.pureClient.stores.dbSpecific;

import junit.framework.Test;

public class Test_Relational_DbSpecific_BigQuery_UsingPureClientTestSuite extends Relational_DbSpecific_UsingPureClientTestSuite
{
    public static Test suite() throws Exception
    {
        return createSuite("meta::relational::tests::dbSpecificTests::bigquery", "org/finos/legend/engine/server/test/userTestConfig_withBigQueryTestConnection.json");
    }
}