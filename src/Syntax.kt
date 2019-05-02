package club.globalcyberspace.kotlin.starter

fun main(args: Array<String>) {
    /**
     * Variables
     * val - Initialise variable with finalised value (value can't be changed after initialisation)
     * var - Initialise standard variable, value type can't be changed but value can be changed
     * */

    val message: String = "Hello"
    // The type can be set depending on the type of value.
    val defaultResponse = "Hi"
    // Error: Val can not be reassigned
    //defaultResponse = "test error"
    println("$message <=> $defaultResponse")

    var usersCount: Int = 0
    println("$usersCount") // 0
    var maxUsersCount = 40
    usersCount = 2
    println("$usersCount") // 2
    println("$maxUsersCount") // 40


    /**
     * Function arguments can has default value
     */
    functionArgumentWithDefaultValue() // default value
    functionArgumentWithDefaultValue(message) // Hello
    println(functionArgumentWithoutDefaultValueButWithReturnValue(message)) // Ho
    // Execution Error: String index out of range
    // println(functionArgumentWithoutDefaultValueButWithReturnValue(""))
    // Error: no value passed for parameter
    // println(functionArgumentWithoutDefaultValueButWithReturnValue())

    println(getLastAndFirstLetter("Letter")) // Lr3
    // Execution Error: Char sequence is empty.
    // println(getLastAndFirstLetter(""))

    println(functionWithoutBody())  // 0
    println(functionWithoutBody("Hello")) // 5
}

fun functionArgumentWithDefaultValue(message: String = "default value") {
    println("$message")
}

fun functionArgumentWithoutDefaultValueButWithReturnValue(message: String) : String {
    return message[0].toString() + message.last()
}

fun getLastAndFirstLetter(message: String) : String {
    // second values will be cast to String automatically
    return message.first().toString() + message.last() + 3
}

fun functionWithoutBody(message: String = ""): Int = message.length
