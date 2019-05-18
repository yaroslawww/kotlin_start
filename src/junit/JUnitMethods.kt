package club.globalcyberspace.kotlin.starter.junit

object JUnitMethods {
    private var passed = 0
    private var failed = 0

    val failedTests = ArrayList<String>()

    val passedTests: String
        get() = "passed $passed tests"

    fun <T> isEqualsPass(current: T, expected: T) {
        if (current == expected) {
            passes()
        } else {
            failed()
        }
    }

    fun <T> isEqualsFail(current: T, expected: T) {
        if(current == expected) {
            failed()
        } else {
            passes()
        }
    }

    fun passes() {
        passed++
    }

    fun failed() {
        failed++
        failedTests.add("${Thread.currentThread().stackTrace[3]}")
    }
}