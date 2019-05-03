package club.globalcyberspace.kotlin.starter

fun main(args: Array<String>) {

    /**
     * Variables can be initialised latest
     * "val" can't be lateinit
     */
    lateinit var someStringLateinitialised: String
    // Error Execution: lateinit property someStringLateinitialised has not been initialized
    // println(someStringLateinitialised)
    someStringLateinitialised = "message"
    println(someStringLateinitialised) // message

    /**
     * By default in kotlin all variable can't be null
     * but with "?" we can set null to variable
     */

    var someString: String = "message"
    // Error: Null can not be a value of a non-null type String
    //var someOtherString: String = null
    var someStringOrNull: String? = null

    println(someString) // message
    println(someStringOrNull) // null

    println(someString.length) // 7
    // Error: Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
    // println(someStringOrNull.length)
    // Example of safe mode (return value or null)
    println(someStringOrNull?.length) // null
    println(someStringOrNull?.length ?: 0) // 0
    println(someStringOrNull ?: "") // ""
    // Example of unsafe mode (alvays return value)
    // Error Execution: kotlin.KotlinNullPointerException
    // println(someStringOrNull!!.length)
    someStringOrNull = "Hello"
    println(someStringOrNull?.length) // 5
    println(someStringOrNull!!.length) // 5

    // Example with cast and if can't cast then return null
    // Error Execution: java.lang.ClassCastException
    //var someDog: Dog = someString as Dog
    var someDog: Dog = someString as? Dog ?: Dog("black")
    var someOtherDog: Dog? = Dog("red")
    // !! - force
    someDog = someOtherDog!!
    println(someDog.color)

    // Func "let" can pass fata to other function with instance "it"
    println(someOtherDog?.let { it.color.length }) // 3
    someOtherDog = null
    println(someOtherDog?.let { it.color.length }) // null

    // Function extend
    someStringOrNull = null
    println(someStringOrNull.addPrefix("test")) // teststring is null
    someStringOrNull = "message"
    println(someStringOrNull.addPrefix("test")) // testmessage


    someStringOrNull = null
    castToDogIfPossible(someStringOrNull)
    println(castToDogIfPossible(someString)) // kotlin.Unit (see Types.kt)
    println(someString) // message
    println(someStringOrNull) // null
}

fun String?.addPrefix(prefix: String) : String {
    return "${prefix}${(this ?: "string is null")}"
}

fun <T> castToDogIfPossible(objToCast: T) {
    objToCast as? Dog
}

class Dog(val color: String = "brown")