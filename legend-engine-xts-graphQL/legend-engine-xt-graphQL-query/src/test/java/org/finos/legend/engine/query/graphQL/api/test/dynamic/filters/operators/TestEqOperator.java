package org.finos.legend.engine.query.graphQL.api.test.dynamic.filters.operators;

import org.finos.legend.engine.query.graphQL.api.test.dynamic.filters.TestGraphQLDynamicFilters;
import org.junit.Test;

public class TestEqOperator extends TestGraphQLDynamicFilters
{
    @Test
    public void test_String_eq() throws Exception
    {
        String query = "query Query {\n" +
                "  allEmployees(where: { firstName: { _eq: \"John\" } }) {\n" +
                "      fullName" +
                "    }\n" +
                "  }";
        String expected = "{\"data\":{\"allEmployees\":[{\"fullName()\":\"John Johnson\"},{\"fullName()\":\"John Hill\"}]}}";
        runTest(query, expected);
    }

    @Test
    public void test_Int_eq() throws Exception
    {
        String query = "query Query {\n" +
                "  allEmployees(where: { age: { _eq: 25 } }) {\n" +
                "      fullName," +
                "      age" +
                "    }\n" +
                "  }";
        String expected = "{\"data\":{\"allEmployees\":{\"fullName()\":\"Peter Smith\",\"age\":25}}}";
        runTest(query, expected);
    }

    @Test
    public void test_Float_eq() throws Exception
    {
        String query = "query Query {\n" +
                "  allEmployees(where: { bankBalance: { _eq: 5000.0 } }) {\n" +
                "      fullName," +
                "      bankBalance" +
                "    }\n" +
                "  }";
        String expected = "{\"data\":{\"allEmployees\":{\"fullName()\":\"Fabrice Roberts\",\"bankBalance\":5000.0}}}";
        runTest(query, expected);
    }

    @Test
    public void test_Boolean_eq() throws Exception
    {
        String query = "query Query {\n" +
                "  allEmployees(where: { isAFullTimeEmployee: { _eq: true } }) {\n" +
                "      fullName," +
                "      isAFullTimeEmployee" +
                "    }\n" +
                "  }";
        String expected = "{\"data\":{\"allEmployees\":[{\"fullName()\":\"Peter Smith\",\"isAFullTimeEmployee\":true},{\"fullName()\":\"John Hill\",\"isAFullTimeEmployee\":true},{\"fullName()\":\"Fabrice Roberts\",\"isAFullTimeEmployee\":true},{\"fullName()\":\"David Harris\",\"isAFullTimeEmployee\":true}]}}";
        runTest(query, expected);
    }

    @Test
    public void test_Enum_eq() throws Exception
    {
        String query = "query Query {\n" +
                "  firms(where: { firmType: { _eq: LLC } }) {\n" +
                "      legalName," +
                "      firmType" +
                "    }\n" +
                "  }";
        String expected = "{\"data\":{\"firms\":{\"legalName\":\"Firm A\",\"firmType\":\"LLC\"}}}";
        runTest(query, expected);
    }

    @Test
    public void test_StrictDate_eq() throws Exception
    {
        String query = "query Query {\n" +
                "  allEmployees(where: { dateOfBirth: { _eq: \"1999-01-28\" } }) {\n" +
                "      fullName," +
                "      dateOfBirth" +
                "    }\n" +
                "  }";
        String expected = "{\"data\":{\"allEmployees\":{\"fullName()\":\"Peter Smith\",\"dateOfBirth\":\"1999-01-28\"}}}";
        runTest(query, expected);
    }

    @Test
    public void test_DateTime_eq() throws Exception
    {
        String query = "query Query {\n" +
                "  allEmployees(where: { modifiedAt: { _eq: \"2024-01-26 12:00:00\" } }) {\n" +
                "      fullName," +
                "      modifiedAt" +
                "    }\n" +
                "  }";
        String expected = "{\"data\":{\"allEmployees\":{\"fullName()\":\"Anthony Allen\",\"modifiedAt\":\"2024-01-26T12:00:00.000000000\"}}}";
        runTest(query, expected);
    }
}
