/**
 * By default kotlin create class with name created from filename
 * but we can change this name by annotation @file:JvmName
 */
@file:JvmName("Functions")

package club.globalcyberspace.kotlin.starter

import club.globalcyberspace.kotlin.starter.util.isEvenNumber as isEven
import club.globalcyberspace.kotlin.starter.util.multiple as multi


fun main(args: Array<String>) {

    /**
     * Functional programming concepts
     * 1. The function should always return one and the same,
     *    with the same input data, to be predictable.
     * 2. Variables declared outside the function,
     *    and used in the function, must be unchanged,
     *    otherwise unpredictable behavior.
     * 3. To create complex functional structures you need use composition,
     *    in other words, call some functions as arguments of others.
     */


    /**
     * Access modifiers
     * public - accessible in whole project
     * private - accessible in class or file where declared
     * protected - accessible in class where declared and child classes
     * internal - accessible in module (package)
     */

    println(2.isEven()) // true
    println(3.isEven()) // false

    // infix call
    println(2 multi 3) // 6

    /**
     * Kotlin support multi arguments in function
     */
    multiArgumentsFunction(10, 3, 0, 2, 5) // 10, 3, 0, 2, 5,

    /**
     * Init key->value variables
     */
    val (key, value) = "key" to "value"
    println("$key->$value") // key->value

    /**
     * Lambda
     */

    val lambda = { a: Int, b: Int -> a.plus(b).div(a) }
    println(lambda(30, 30)) // 2
    println({ "Hello".length }()) // 5
    println({ "Hello".length }) // () -> kotlin.Int

    /**
     * Link to constructor or var of class
     */
    // Link to constructor
    val programmer = ::Programmer
    // Link to var
    val age = Programmer::age

    println(age(programmer("Myname", 29, null))) // 29

    /**
     *
     */
    val array = arrayListOf<Programmer>(
            programmer("Taylor", 43, null),
            programmer("Jeff", 33, null),
            programmer("Yaro", 29, null),
            programmer("Serge", 33, null),
            programmer("Megan", 27, null)
    )

    println(array.filter { it.age > 40 }) // [Taylor(43)]
    println(array.map { it.age }) // [43, 33, 29, 18, 27]

    val predicate = { unit: Programmer -> unit.name.contains("a") }
    println(array.find(predicate)?.name) // Taylor
    println(array.all(predicate)) // false
    println(array.any(predicate)) // true
    println(array.count(predicate)) // 3

    println(array.groupBy(age)) // {43=[Taylor(43)], 33=[Jeff(33), Serge(33)], 29=[Yaro(29)], 27=[Megan(27)]}

    /**
     * Flat map
     */
    var count = 0
    array.map {
        it.programmingLanguages = arrayListOf(
                arrayListOf("Java", "Kotlin"),
                arrayListOf("Python"),
                arrayListOf("C#", "Kotlin"),
                arrayListOf("C#", "Java"),
                arrayListOf("C#", "Java")
        )[count++]
    }

    println(array.flatMap { it.programmingLanguages!! }.toSet()) // [Java, Kotlin, Python, C#]

    println(arrayListOf(
            arrayListOf("Java", "Kotlin"),
            arrayListOf("Python"),
            arrayListOf("C#", "Kotlin"),
            arrayListOf("C#", "Java")
    ).flatten()) // [Java, Kotlin, Python, C#, Kotlin, C#, Java]

    /**
     * Performance
     * When you use big arrays probably more easy use sequence
     */
    val ints = getArray()
    val startTime = System.currentTimeMillis()
    val result = ints.map { it * 2 }.filter { it.isEven() }
    val stopTime = System.currentTimeMillis()
    println("without sequence: work time = ${stopTime - startTime}, result = ${result.size}") // without sequence: work time = 367, result = 1000001

    val ints2 = getArray()
    val startTime2 = System.currentTimeMillis()
    val result2 = ints2.asSequence().map { it * 2 }.filter { it.isEven() }.toList()
    val stopTime2 = System.currentTimeMillis()
    println("with sequence: work time = ${stopTime2 - startTime2}, result = ${result2.size}") // with sequence: work time = 244, result = 1000001

    /**
     * Threads with lambda
     */
    Thread {
        ints.map { it * 2 }.filter { it.isEven() }
        println("Hello new thread with long calculation")
    }.start()
    Thread { println("Hello new thread") }.start()
    println("Hello old thread")

    /**
     * "with" pass variable inside lambda
     */
    with(array) {
        println(this.count()) // 5
    }

    /**
     * "apply" - allow edit onject and return it after
     */
    val teamLead = Programmer("John", 40, null).apply {
        this.status = "Team Lead"
    }
    val developer = Programmer("Hugo", 40, null).apply {
        status = "Developer"
    }
    println(teamLead.status) // Team Lead
    println(developer.status) // Developer

    /**
     * Lambda as variables
     */
    val lambdaExpresion: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    val lambdaExpresion2: (a: Int, b: Int) -> Int = { a, b -> a + b }
    val lambdaExpresion3: (a: Int, b: Int) -> Int = { a: Int, b: Int -> a + b }
    val lambdaUnit: (String) -> Unit = {name -> println("Hello $name") }

    println(lambdaExpresion(10, 20)) // 30
    println(executeLambdaExpr(10, 30, lambdaExpresion)) // 40
    println(executeLambdaExpr(11, 31, lambdaExpresion2)) // 42
    println(executeLambdaExpr(10, 30, lambdaExpresion3)) // 40
    println(executeLambdaExpr(10, 30, getLambda(Operation.MULTIPLE))) // 300


}

private fun executeLambdaExpr(a: Int, b:Int, lambda: (first: Int, second: Int) -> Int): Int {
    return lambda(a, b)
}

fun getLambda(operation: Operation): (Int, Int) -> Int {
    return when (operation){
        Operation.PLUS -> {a: Int, b: Int -> a + b}
        Operation.MINUS -> {a: Int, b: Int -> a - b}
        Operation.MULTIPLE -> {a: Int, b: Int -> a * b}
        Operation.DIVIDE -> {a: Int, b: Int -> a / b}
    }
}

enum class Operation {PLUS, MINUS, MULTIPLE, DIVIDE}

// for using multiarguments you need use word "vararg"
fun multiArgumentsFunction(vararg ints: Int) {
    for (int in ints) {
        print("$int, ")
    }
    println()
}

class Programmer(val name: String, val age: Int, var programmingLanguages: ArrayList<String>? = null) {
    var status: String? = null

    override fun toString(): String {
        return "$name($age)"
    }
}

fun getArray(): ArrayList<Int> {
    val arr = ArrayList<Int>()
    var count = 1000000; while (count-- >= 0) {
        arr.add(count)
    }
    return arr
}
