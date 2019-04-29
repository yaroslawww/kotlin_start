fun main(args: Array<String>) {
    println("Hello from kotlin")

    /**
     * Check nullable
     */
    printNullable("Hello")
    printNullable(null)
    printNotNullable("Hello")
    //printNotNullable(null)
}

/**
 * @param nullableParam  - "?" allow us pass null as value
 */
fun printNullable(nullableParam: String?) {
    if(nullableParam != null) {
        println(nullableParam)
    } else {
        println(27.toChar() + "[31m" + "Parameter can not be null" + 27.toChar() + "[0m")
    }
}

fun printNotNullable(notNullableParam: String) {
    println(notNullableParam)
}