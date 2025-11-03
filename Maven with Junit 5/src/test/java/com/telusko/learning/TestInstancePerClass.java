package com.telusko.learning;

import org.junit.jupiter.api.*;

/**
 * This class demonstrates @TestInstance(TestInstance.Lifecycle.PER_CLASS)
 * 
 * With PER_CLASS:
 * - Single test instance is used for ALL test methods
 * - Instance variables are shared across tests
 * - @BeforeAll and @AfterAll can be non-static
 * - State can accumulate across tests (be careful!)
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestInstancePerClass {

    // Instance variables that will be shared across ALL tests
    private int sharedCounter = 0;
    private StringBuilder sharedLog = new StringBuilder();

    /**
     * @BeforeAll with PER_CLASS - Can be NON-STATIC!
     * Runs once before all tests
     */
    @BeforeAll
    void setupOnce() {
        System.out.println("\n========================================");
        System.out.println("@BeforeAll (PER_CLASS): Setup once");
        System.out.println("Note: This is NON-STATIC!");
        System.out.println("========================================\n");
        
        sharedLog.append("Setup complete. ");
    }

    /**
     * @BeforeEach runs before each test
     */
    @BeforeEach
    void setupBeforeEach() {
        sharedCounter++;
        sharedLog.append("Test#").append(sharedCounter).append(" started. ");
        
        System.out.println("  @BeforeEach: Test #" + sharedCounter);
        System.out.println("  - Shared counter: " + sharedCounter);
    }

    /**
     * @AfterEach runs after each test
     */
    @AfterEach
    void cleanupAfterEach() {
        System.out.println("  @AfterEach: Completed test #" + sharedCounter);
        System.out.println("  - Log so far: " + sharedLog.toString());
        System.out.println();
    }

    /**
     * @AfterAll with PER_CLASS - Can be NON-STATIC!
     * Runs once after all tests
     */
    @AfterAll
    void tearDownOnce() {
        System.out.println("\n========================================");
        System.out.println("@AfterAll (PER_CLASS): Cleanup once");
        System.out.println("Final counter: " + sharedCounter);
        System.out.println("Complete log: " + sharedLog.toString());
        System.out.println("========================================\n");
    }

    // ============= TESTS =============

    @Test
    @Order(1)
    void test1_FirstTest() {
        System.out.println("    [TEST 1] Shared counter = " + sharedCounter);
        Assertions.assertEquals(1, sharedCounter, "First test: counter should be 1");
    }

    @Test
    @Order(2)
    void test2_SecondTest() {
        System.out.println("    [TEST 2] Shared counter = " + sharedCounter);
        // With PER_CLASS, counter is now 2 (accumulates from previous test)
        Assertions.assertEquals(2, sharedCounter, "Second test: counter should be 2");
    }

    @Test
    @Order(3)
    void test3_ThirdTest() {
        System.out.println("    [TEST 3] Shared counter = " + sharedCounter);
        // Counter continues to accumulate
        Assertions.assertEquals(3, sharedCounter, "Third test: counter should be 3");
    }

    @Test
    @Order(4)
    void test4_FinalTest() {
        System.out.println("    [TEST 4] Shared counter = " + sharedCounter);
        Assertions.assertEquals(4, sharedCounter, "Fourth test: counter should be 4");
        
        // Verify the shared log contains all test executions
        String log = sharedLog.toString();
        Assertions.assertTrue(log.contains("Test#1"), "Log should contain Test#1");
        Assertions.assertTrue(log.contains("Test#2"), "Log should contain Test#2");
        Assertions.assertTrue(log.contains("Test#3"), "Log should contain Test#3");
        Assertions.assertTrue(log.contains("Test#4"), "Log should contain Test#4");
    }
}

/**
 * COMPARISON: PER_METHOD vs PER_CLASS
 * 
 * ┌─────────────────────────────────────────────────────────────────┐
 * │                    PER_METHOD (Default)                         │
 * ├─────────────────────────────────────────────────────────────────┤
 * │ ✓ New instance for each test                                   │
 * │ ✓ Better test isolation                                         │
 * │ ✓ Instance variables reset between tests                       │
 * │ ✓ @BeforeAll/@AfterAll must be static                          │
 * │ ✓ Safer for most use cases                                     │
 * └─────────────────────────────────────────────────────────────────┘
 * 
 * ┌─────────────────────────────────────────────────────────────────┐
 * │                    PER_CLASS                                    │
 * ├─────────────────────────────────────────────────────────────────┤
 * │ ✓ Single instance for all tests                                │
 * │ ✓ State can be shared between tests                            │
 * │ ✓ @BeforeAll/@AfterAll can be non-static                       │
 * │ ⚠ Tests may depend on each other (risky!)                      │
 * │ ✓ Useful for expensive setup operations                        │
 * └─────────────────────────────────────────────────────────────────┘
 * 
 * WHEN TO USE PER_CLASS:
 * - Expensive setup that you want to share (database, server, etc.)
 * - Tests that need to run in sequence with shared state
 * - Integration tests where order matters
 * 
 * WHEN TO USE PER_METHOD (Default):
 * - Unit tests (most cases)
 * - When tests should be independent
 * - When you want maximum test isolation
 */
