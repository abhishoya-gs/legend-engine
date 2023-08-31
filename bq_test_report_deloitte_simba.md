Legend SQL Compatibility Report
===============================

Overview
--------
This is a summary report of SQL tests for databases supported by Legend.

The report summarizes the output of each database's Junit integration test results.

The 'Test Name' column refers to a Pure test function.



Cheat sheet
-----------
| Test Status             | Emoji                             | Description                                                                                                                                                                      |
| ----------------------- | --------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Success                 | :green_circle:                    | Test passed                                                                                                                                                                      |
| Error                   | :red_circle:                      | Test failed                                                                                                                                                                      |
| Unsupported             | :black_circle:                    | Legend feature has not been implemented for this database as yet. (The feature very well might be supported in the target database)                                              |
| Behavior Deviation      | :diamond_shape_with_a_dot_inside: | Deviation from standard behavior. (TODO : The semantics of this status are not clear and needs to be refined.)                                                                   |
| Missing                 | :purple_circle:                   | Test result not available. Most likely because of a systemic failure or omission (e.g Github workflow failed or we have not included the database in the testing framework etc.) |
| Report Generation Error | :confused:                        | An error/bug in the generation of this report                                                                                                                                    |

Test Statistics By Database
---------------------------
| Database            | Success | Error | Unsupported | Behavior Deviation | Missing | Report Generation Error | Total |
| ------------------- | ------- | ----- | ----------- | ------------------ | ------- | ----------------------- | ----- |
| BigQuery (Deloitte) | 52      | 62    | 35          | 0                  | 0       | 0                       | 149   |
| BigQuery (Simba)    | 52      | 62    | 35          | 0                  | 0       | 0                       | 149   |

Test Details By Database
------------------------
| Test Name                                       | BigQuery (Deloitte) | BigQuery (Simba) |
| ----------------------------------------------- | ------------------- | ---------------- |
| testDaysDiff                                    | :black_circle:      | :black_circle:   |
| testPositive                                    | :green_circle:      | :green_circle:   |
| testJoinBySingleColumnName                      | :red_circle:        | :red_circle:     |
| testHoursDiff                                   | :black_circle:      | :black_circle:   |
| testDropLimitByVendor                           | :red_circle:        | :red_circle:     |
| testSqlTrue                                     | :red_circle:        | :red_circle:     |
| testCustomStartIndexOnly                        | :green_circle:      | :green_circle:   |
| testAverage                                     | :red_circle:        | :red_circle:     |
| testViewOnView                                  | :red_circle:        | :red_circle:     |
| testYearsDiffZero                               | :black_circle:      | :black_circle:   |
| testFirstDayOfThisMonth                         | :black_circle:      | :black_circle:   |
| testStartsWith                                  | :green_circle:      | :green_circle:   |
| simpleGroupByCount                              | :red_circle:        | :red_circle:     |
| testNumberInequality                            | :green_circle:      | :green_circle:   |
| testCustomStartIndex                            | :green_circle:      | :green_circle:   |
| testMonthNumber                                 | :green_circle:      | :green_circle:   |
| testDecimal1                                    | :green_circle:      | :green_circle:   |
| testInt                                         | :green_circle:      | :green_circle:   |
| testHour                                        | :green_circle:      | :green_circle:   |
| testAndwithConditions                           | :green_circle:      | :green_circle:   |
| testDecimalUpper                                | :green_circle:      | :green_circle:   |
| testDecimal                                     | :green_circle:      | :green_circle:   |
| testFirstDayOfQuarter                           | :black_circle:      | :black_circle:   |
| testFirstDayOfThisYear                          | :black_circle:      | :black_circle:   |
| testFilterAfterJoinInner                        | :red_circle:        | :red_circle:     |
| testSize                                        | :red_circle:        | :red_circle:     |
| testViewAllOneSimpleProperty                    | :red_circle:        | :red_circle:     |
| testQuarterNumber                               | :green_circle:      | :green_circle:   |
| testCharReplace                                 | :green_circle:      | :green_circle:   |
| testDecimalLower                                | :green_circle:      | :green_circle:   |
| testMin                                         | :red_circle:        | :red_circle:     |
| testInt1                                        | :green_circle:      | :green_circle:   |
| testSlice                                       | :red_circle:        | :red_circle:     |
| testInt2                                        | :green_circle:      | :green_circle:   |
| testMilliSecondsDiff                            | :black_circle:      | :black_circle:   |
| testSelectEqual                                 | :red_circle:        | :red_circle:     |
| testFirstDayOfWeek                              | :black_circle:      | :black_circle:   |
| testRightOuterJoinSimple                        | :red_circle:        | :red_circle:     |
| testTrailingSpace                               | :green_circle:      | :green_circle:   |
| testFilterAfterFilter                           | :black_circle:      | :black_circle:   |
| testNegative                                    | :green_circle:      | :green_circle:   |
| testASCiiAliasName                              | :red_circle:        | :red_circle:     |
| testASCiiColumnName                             | :red_circle:        | :red_circle:     |
| testIsNull                                      | :green_circle:      | :green_circle:   |
| testPreviousDayOfWeekWithDate                   | :black_circle:      | :black_circle:   |
| testApostrophe                                  | :green_circle:      | :green_circle:   |
| testSliceWithRestrict                           | :red_circle:        | :red_circle:     |
| testSqlNull                                     | :green_circle:      | :green_circle:   |
| testYear                                        | :black_circle:      | :black_circle:   |
| testSimpleConcatenate                           | :red_circle:        | :red_circle:     |
| testAsciiColumnNameAndAsciiAliasName            | :red_circle:        | :red_circle:     |
| testSqlFalse                                    | :red_circle:        | :red_circle:     |
| testDoubleSortMixedChain                        | :red_circle:        | :red_circle:     |
| testEndsWith                                    | :green_circle:      | :green_circle:   |
| testOrWithConditions                            | :green_circle:      | :green_circle:   |
| testNotEndsWith                                 | :green_circle:      | :green_circle:   |
| testCustomEndIndex                              | :green_circle:      | :green_circle:   |
| testDatePartWithStrictDate                      | :black_circle:      | :black_circle:   |
| testDayOfWeekNumber                             | :black_circle:      | :black_circle:   |
| testYearsDiffPositive                           | :black_circle:      | :black_circle:   |
| testDayOfMonth                                  | :black_circle:      | :black_circle:   |
| testMonthAsNumber                               | :green_circle:      | :green_circle:   |
| testSimpleTake                                  | :red_circle:        | :red_circle:     |
| testColumnNames                                 | :red_circle:        | :red_circle:     |
| testSpace                                       | :green_circle:      | :green_circle:   |
| testIntAsFloat                                  | :green_circle:      | :green_circle:   |
| testStartingSpace                               | :green_circle:      | :green_circle:   |
| testNotStartsWith                               | :green_circle:      | :green_circle:   |
| testChar                                        | :black_circle:      | :black_circle:   |
| testIn                                          | :green_circle:      | :green_circle:   |
| testMatchesAlphaNumeric                         | :black_circle:      | :black_circle:   |
| testNow                                         | :green_circle:      | :green_circle:   |
| testApostropheInParameterValue                  | :red_circle:        | :red_circle:     |
| testSelfJoinOuter                               | :red_circle:        | :red_circle:     |
| testSimpleDrop                                  | :red_circle:        | :red_circle:     |
| testStdDevPopulation                            | :red_circle:        | :red_circle:     |
| testStartsWithSpace                             | :green_circle:      | :green_circle:   |
| test1                                           | :green_circle:      | :green_circle:   |
| testAdjustWithMicroseconds                      | :green_circle:      | :green_circle:   |
| testCastBoolean                                 | :black_circle:      | :black_circle:   |
| testminute                                      | :green_circle:      | :green_circle:   |
| testIntNonDivisible                             | :green_circle:      | :green_circle:   |
| testNumbers                                     | :green_circle:      | :green_circle:   |
| testSimpleSortAsc                               | :red_circle:        | :red_circle:     |
| testSpaceBeforeSecondString                     | :green_circle:      | :green_circle:   |
| testDatePartWithDateTime                        | :black_circle:      | :black_circle:   |
| testUnionOnViewsMapping                         | :red_circle:        | :red_circle:     |
| groupByAfterConcatenate                         | :red_circle:        | :red_circle:     |
| windowAvg                                       | :red_circle:        | :red_circle:     |
| testStringReplace                               | :green_circle:      | :green_circle:   |
| testSelfJoinInner                               | :red_circle:        | :red_circle:     |
| testNumberEquality                              | :green_circle:      | :green_circle:   |
| testDoubleSortMixed                             | :red_circle:        | :red_circle:     |
| testSecondsDiff                                 | :black_circle:      | :black_circle:   |
| testSum                                         | :red_circle:        | :red_circle:     |
| testMostRecentDayOfWeekWithDate                 | :black_circle:      | :black_circle:   |
| testMinutesDiff                                 | :black_circle:      | :black_circle:   |
| testMatchesNonAlphaNumeric                      | :black_circle:      | :black_circle:   |
| testFilterOnAssociatedClassAggValueAfterGroupBy | :red_circle:        | :red_circle:     |
| testGreaterThanEqualString                      | :red_circle:        | :red_circle:     |
| testFirstDayOfThisQuarter                       | :black_circle:      | :black_circle:   |
| testConcatenateWithPreOperation                 | :red_circle:        | :red_circle:     |
| testInnerJoinSimple                             | :red_circle:        | :red_circle:     |
| testMax                                         | :red_circle:        | :red_circle:     |
| testWindowWithSortSingle                        | :red_circle:        | :red_circle:     |
| testStdDevSample                                | :red_circle:        | :red_circle:     |
| testFilterMultipleExpressions                   | :red_circle:        | :red_circle:     |
| testGroupByAfterJoinInner                       | :red_circle:        | :red_circle:     |
| testEndsWithSpace                               | :green_circle:      | :green_circle:   |
| testZero                                        | :green_circle:      | :green_circle:   |
| testJoinByMultiColumnName                       | :red_circle:        | :red_circle:     |
| testDoubleSortDescChain                         | :red_circle:        | :red_circle:     |
| testSimpleSortDesc                              | :red_circle:        | :red_circle:     |
| testYearsDiffNegative                           | :black_circle:      | :black_circle:   |
| testOnAllRows                                   | :red_circle:        | :red_circle:     |
| testDoubleSortAscChain                          | :red_circle:        | :red_circle:     |
| testFirstDayOfYear                              | :black_circle:      | :black_circle:   |
| testIntDivisible                                | :green_circle:      | :green_circle:   |
| testDatePartAsString                            | :black_circle:      | :black_circle:   |
| testString                                      | :black_circle:      | :black_circle:   |
| testToTimestamp                                 | :black_circle:      | :black_circle:   |
| testDoubleSortAsc                               | :red_circle:        | :red_circle:     |
| testEndIndexExceedingStringLength               | :green_circle:      | :green_circle:   |
| testLessThanEqualString                         | :red_circle:        | :red_circle:     |
| testToday                                       | :green_circle:      | :green_circle:   |
| testSecond                                      | :green_circle:      | :green_circle:   |
| testDayOfYear                                   | :black_circle:      | :black_circle:   |
| testFilterAfterJoinOuter                        | :red_circle:        | :red_circle:     |
| testSpaceFalse                                  | :green_circle:      | :green_circle:   |
| testWeekOfYear                                  | :red_circle:        | :red_circle:     |
| setUp                                           | :black_circle:      | :black_circle:   |
| testMonthsDiff                                  | :black_circle:      | :black_circle:   |
| testAdjustWithStringUnit                        | :red_circle:        | :red_circle:     |
| testCoalesce                                    | :green_circle:      | :green_circle:   |
| testFirstDayOfMonth                             | :black_circle:      | :black_circle:   |
| testConcatenateWithPostOperation                | :red_circle:        | :red_circle:     |
| testFirstDayOfQuarterWithDateLiteral            | :black_circle:      | :black_circle:   |
| testSelectNotEqual                              | :red_circle:        | :red_circle:     |
| windowWithSortMultiple                          | :red_circle:        | :red_circle:     |
| testTableNameInJoinAlias                        | :red_circle:        | :red_circle:     |
| testAdjust                                      | :red_circle:        | :red_circle:     |
| testGroupByAfterJoinOuter                       | :red_circle:        | :red_circle:     |
| testLeftOuterJoinSimple                         | :red_circle:        | :red_circle:     |
| testWindowWithoutSortMultiple                   | :red_circle:        | :red_circle:     |
| testQuarterAsNumber                             | :green_circle:      | :green_circle:   |
| testDoubleSortDesc                              | :red_circle:        | :red_circle:     |
| testSimpleLimit                                 | :red_circle:        | :red_circle:     |
| testWithString                                  | :black_circle:      | :black_circle:   |
| testNoSpace                                     | :green_circle:      | :green_circle:   |
