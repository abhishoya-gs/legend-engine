package org.finos.legend.engine.query.graphQL.api.test.dynamic.filters.operators;

import org.finos.legend.engine.query.graphQL.api.test.dynamic.filters.*;
import org.junit.*;

public class TestGteOperator extends TestGraphQLDynamicFilters
{
    @Test
    public void test_Int_gte() throws Exception
    {
        String query = "query Query {\n" +
                "  allEmployees(where: { age: { _gte: 50 } }) {\n" +
                "      fullName," +
                "      age" +
                "    }\n" +
                "  }";
        String expected = "{\"data\":{\"allEmployees\":[{\"fullName()\":\"Fabrice Roberts\",\"age\":50},{\"fullName()\":\"Oliver Hill\",\"age\":60},{\"fullName()\":\"David Harris\",\"age\":55}]}}";
        runTest(query, expected);
    }

    @Test
    public void test_Float_gte() throws Exception
    {
        String query = "query Query {\n" +
                "  allEmployees(where: { bankBalance: { _gte: 5500.0 } }) {\n" +
                "      fullName," +
                "      bankBalance" +
                "    }\n" +
                "  }";
        String expected = "{\"data\":{\"allEmployees\":[{\"fullName()\":\"Oliver Hill\",\"bankBalance\":6000.0},{\"fullName()\":\"David Harris\",\"bankBalance\":5500.0}]}}";
        runTest(query, expected);
    }

    @Test
    public void test_StrictDate_gte() throws Exception
    {
        String query = "query Query {\n" +
                "  allEmployees(where: { dateOfBirth: { _gte: \"1989-01-28\" } }) {\n" +
                "      fullName," +
                "      dateOfBirth" +
                "    }\n" +
                "  }";
        String expected = "{\"data\":{\"allEmployees\":[{\"fullName()\":\"Peter Smith\",\"dateOfBirth\":\"1999-01-28\"},{\"fullName()\":\"John Johnson\",\"dateOfBirth\":\"1989-01-28\"},{\"fullName()\":\"John Hill\",\"dateOfBirth\":\"1994-01-28\"}]}}";
        runTest(query, expected);
    }

    @Test
    public void test_DateTime_gte() throws Exception
    {
        String query = "query Query {\n" +
                "  allEmployees(where: { modifiedAt: { _gte: \"2024-01-28 00:00:00\" } }) {\n" +
                "      fullName," +
                "      modifiedAt" +
                "    }\n" +
                "  }";
        String expected = "{\"data\":{\"allEmployees\":[{\"fullName()\":\"Peter Smith\",\"modifiedAt\":\"2024-01-29T00:00:00.000000000\"},{\"fullName()\":\"John Johnson\",\"modifiedAt\":\"2024-01-28T00:00:00.000000000\"}]}}";
        runTest(query, expected);
    }
}
