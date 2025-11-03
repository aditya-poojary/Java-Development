package com.telusko.learning;

import org.junit.jupiter.api.*;

/**
 * This class demonstrates JUnit 5 Lifecycle Methods and @TestInstance
 * 
 * LIFECYCLE ANNOTATIONS:
 * @BeforeAll    - Runs ONCE before ALL tests (must be static unless @TestInstance is used)
 * @BeforeEach   - Runs BEFORE EACH test method
 * @AfterEach    - Runs AFTER EACH test method
 * @AfterAll     - Runs ONCE after ALL tests (must be static unless @TestInstance is used)
 * 
 * @TestInstance - Controls test instance lifecycle
 *                 - PER_METHOD (default): New instance for each test method
 *                 - PER_CLASS: Single instance for all test methods
 */

// Uncomment this to see @TestInstance(TestInstance.Lifecycle.PER_CLASS) behavior
// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestLifecycleMethods {

    // Instance variable to track state across tests
    private int testCounter = 0;
    private String testData;
    
    // Static variable to track total tests executed
    private static int totalTestsExecuted = 0;

    /**
     * @BeforeAll runs ONCE before all test methods
     * - Must be static (unless using @TestInstance(PER_CLASS))
     * - Used for expensive setup like database connections, loading config files
     * - Executed only ONE time per test class
     */
    @BeforeAll
    static void setupOnce() {
        System.out.println("\n========================================");
        System.out.println("@BeforeAll: Setting up test environment");
        System.out.println("This runs ONCE before ALL tests");
        System.out.println("========================================\n");
        
        // Example: Initialize database connection, load configuration
        totalTestsExecuted = 0;
    }

    /**
     * @BeforeEach runs BEFORE each test method
     * - NOT static
     * - Used for setup that needs to run before every test
     * - Executed BEFORE EACH test method
     */
    @BeforeEach
    void setupBeforeEachTest() {
        testCounter++;
        totalTestsExecuted++;
        testData = "Fresh Data for Test #" + testCounter;
        
        System.out.println("  @BeforeEach: Preparing test #" + testCounter);
        System.out.println("  - Initialized testData: " + testData);
        System.out.println("  - Test counter: " + testCounter);
    }

    /**
     * @AfterEach runs AFTER each test method
     * - NOT static
     * - Used for cleanup after every test
     * - Executed AFTER EACH test method (even if test fails)
     */
    @AfterEach
    void cleanupAfterEachTest() {
        System.out.println("  @AfterEach: Cleaning up after test #" + testCounter);
        System.out.println("  - Resetting test data");
        testData = null;
        System.out.println();
    }

    /**
     * @AfterAll runs ONCE after all test methods
     * - Must be static (unless using @TestInstance(PER_CLASS))
     * - Used for final cleanup like closing database connections
     * - Executed only ONE time per test class
     */
    @AfterAll
    static void tearDownOnce() {
        System.out.println("\n========================================");
        System.out.println("@AfterAll: Tearing down test environment");
        System.out.println("Total tests executed: " + totalTestsExecuted);
        System.out.println("This runs ONCE after ALL tests");
        System.out.println("========================================\n");
    }

    // ============= TEST METHODS =============

    /**
     * Test 1: Demonstrates lifecycle execution
     * Watch the console to see @BeforeEach runs before this
     * and @AfterEach runs after this
     */
    @Test
    void test1_CheckInitialization() {
        System.out.println("    [TEST 1] Running test1_CheckInitialization");
        System.out.println("    - testData = " + testData);
        System.out.println("    - testCounter = " + testCounter);
        
        // Assertions to verify setup worked
        Assertions.assertNotNull(testData, "Test data should be initialized");
        Assertions.assertEquals(1, testCounter, "First test should have counter = 1");
    }

    /**
     * Test 2: Shows that instance variables reset between tests
     * (when using default PER_METHOD lifecycle)
     */
    @Test
    void test2_CheckInstanceReset() {
        System.out.println("    [TEST 2] Running test2_CheckInstanceReset");
        System.out.println("    - testData = " + testData);
        System.out.println("    - testCounter = " + testCounter);
        
        // With PER_METHOD (default), testCounter resets to 0, then @BeforeEach increments to 1
        // So each test sees testCounter = 1 (even though this is the second test)
        Assertions.assertNotNull(testData, "Test data should be initialized");
        Assertions.assertEquals(1, testCounter, "Counter should be 1 (new instance per test)");
    }

    /**
     * Test 3: Another test to demonstrate lifecycle
     */
    @Test
    void test3_VerifyLifecycle() {
        System.out.println("    [TEST 3] Running test3_VerifyLifecycle");
        System.out.println("    - testData = " + testData);
        System.out.println("    - testCounter = " + testCounter);
        
        Assertions.assertNotNull(testData, "Test data should be initialized");
        Assertions.assertEquals(1, testCounter, "Counter should be 1 (new instance per test)");
    }

    /**
     * Test 4: Demonstrates cleanup even after test
     */
    @Test
    void test4_FinalTest() {
        System.out.println("    [TEST 4] Running test4_FinalTest");
        System.out.println("    - Total tests so far: " + totalTestsExecuted);
        
        // Static variable persists across all tests (order may vary)
        Assertions.assertTrue(totalTestsExecuted >= 1 && totalTestsExecuted <= 4, 
            "Total tests should be between 1 and 4");
    }
}


/**
 * EXECUTION ORDER VISUALIZATION:
 * 
 * @BeforeAll (once)
 *     ↓
 * @BeforeEach → Test1 → @AfterEach
 *     ↓
 * @BeforeEach → Test2 → @AfterEach
 *     ↓
 * @BeforeEach → Test3 → @AfterEach
 *     ↓
 * @BeforeEach → Test4 → @AfterEach
 *     ↓
 * @AfterAll (once)
 * 
 * 
 * NOTES:
 * 
 * 1. DEFAULT BEHAVIOR (@TestInstance.Lifecycle.PER_METHOD):
 *    - New test instance created for EACH test method
 *    - Instance variables reset between tests
 *    - @BeforeAll and @AfterAll must be static
 *    - Better test isolation (tests don't affect each other)
 * 
 * 2. WITH @TestInstance(TestInstance.Lifecycle.PER_CLASS):
 *    - Single test instance used for ALL test methods
 *    - Instance variables shared across tests
 *    - @BeforeAll and @AfterAll can be non-static
 *    - Tests can share state (use with caution!)
 * 
 * 3. COMMON USE CASES:
 *    - @BeforeAll: Database connection, load config, start server
 *    - @BeforeEach: Create test data, initialize objects, reset state
 *    - @AfterEach: Clean up test data, reset mocks, clear cache
 *    - @AfterAll: Close connections, stop server, cleanup resources
 * 
 * 4. EXECUTION GUARANTEE:
 *    - @AfterEach runs even if test fails
 *    - @AfterAll runs even if tests fail
 *    - Ensures cleanup always happens
 */
