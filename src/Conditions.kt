package club.globalcyberspace.kotlin.starter

import java.awt.Color

fun main(args: Array<String>) {
    /**
     * Simple example
     */
    if (true) {

    } else if (true) {

    } else {

    }

    /**
     * Initialise variable with condition
     */
    var isMorning = true

    var message = if (isMorning) {
        "Good morning"
    } else {
        "Hello"
    }
    println(message) // Good morning

    /**
     * Conditions operators
     * >, <, >=, <=
     * == - equal value
     * === - equal links
     */
    println(1 > 2) // false
    println(1 < 2) // true
    println("test" == "test") // true
    // primitive types will be equal because it saves to strings pool
    println("test" === "test") // true
    println(String().plus("test") == String().plus("test")) // true
    println(String().plus("test") === String().plus("test")) // false
    val someString = String().plus("test")
    val someOtherString = someString
    println(someString === someOtherString) // true

    /**
     * when simple example
     */
    when (2) {
        0 -> {
            println(0)
        }
        1 -> println(1)
        2 -> println("print") // print
        else -> "default value"
    }

    /**
     * Comparation will be with "==="
     */
    var string1 = String().plus("test")
    var string2 = String().plus("test")
    var string3 = string1
    var string4 = "test"

    when (string1) {
        string2 -> println("string2") // will equal
        string4 -> println("string4") // will equal
        String().plus("test") -> println("initialisation") // will equal
        string3 -> println("string3") // will equal
    }

    var dog1 = Dog()
    var dog2 = Dog("red")
    var dog3 = Dog()
    var dog4 = dog1
    when (dog1) {
        dog2 -> println("dog1")
        dog3 -> println("dog3")
        Dog() -> println("Dog()")
        dog4 -> println("dog4") // will equal
    }

    val setOfDogs = setOf<Dog>(dog1, dog2)
    when (setOfDogs) {
        setOf<Dog>(Dog(), dog2) -> println("setOf<Dog>(Dog(), dog2)")
        setOf<Dog>(dog1, dog2) -> println("setOf<Dog>(dog1, dog2)") // will equal
        setOf<Dog>(dog4, dog2) -> println("setOf<Dog>(dog4, dog2)") // will equal
    }

    /**
     * example without argument
     */
    when {
        1 > 2 -> println("1 > 2")
        1 < 2 -> println("1 < 2") // will equal
    }

    /**
     * example with range
     */
    when (10) {
        in 1..3 -> println("in 1..3")
        in 1..10 -> println("in 1..10") // will equal
    }

    /**
     * example with is
     */
    var any: Any = Dog("red")
    when (any) {
        is String -> println("String")
        is Dog -> println("Dog") // will equal
    }

    /**
     * when and if/else return last value in block of code
     */
    var value: Any = when {
        1 < 10 -> {
            false
            "hello"
        }
        1> 10 -> "no"
        else -> {
            true
        }
    }
    println(value) // hello
}

