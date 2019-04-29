package club.globalcyberspace.kotlin.starter

fun main(args: Array<String>) {
    println("Hello from kotlin")

    /**
     * Check nullable
     */
    printNullable("Hello")
    printNullable(null)
    printNotNullable("Hello")
    //printNotNullable(null)
    /**
     * Operator "is"
     */
    checkAndCastWithIs(1)
    checkAndCastWithIs("2")
    checkAndCastWithIs(3.toChar())
    checkAndCastWithIs(4.56)


    /**
     * Kotlin provides the ability to extend a class with new functionality without having to inherit from the class
     * or use any type of design pattern such as Decorator.
     * This is done via special declarations called extensions.
     */
    val cat1 = Cat("cat1")
    cat1.hello()
    // Error: Unresolved reference: hi
    //cat1.hi()
    fun Cat.hi() {
        println("${this.name}: urrrr")
    }
    val cat2 = Cat("cat2")
    cat2.hello()
    cat2.hi()
    cat1.hi()

    /**
     * Operator overloading
     */
    val coordinates = Coordinates(10, 20)
    println(coordinates)
    println(-coordinates)

    /**
     * Lazy initialisation
     * Initialisation execute one time when called get()
     * If you use multi thread please read https://kotlinlang.org/docs/reference/delegated-properties.html
     */
    val lazyVariable: String by lazy {
        println("variable init!")
          "VariableValue"
    }

    println(lazyVariable)
    println(lazyVariable)
    println(lazyVariable)
}

/**
 * @param nullableParam  - "?" allow us pass null as value (String|null)
 */
fun printNullable(nullableParam: String?) {
    if (nullableParam != null) {
        println(nullableParam)
    } else {
        println("${27.toChar()}[31m" + "Parameter can not be null${27.toChar()}[0m")
    }
}

/**
 * @param notNullableParam - allow only String
 */
fun printNotNullable(notNullableParam: String) {
    println(notNullableParam)
}


fun checkAndCastWithIs(number: Any) {
    println("${number::class.simpleName}")
    if (number is Int) {
        println("${number::class.simpleName}")
    } else {
        println("${27.toChar()}[31m" + "Parameter is not Integer${27.toChar()}[0m")
    }
}

class Cat(internal val name: String) {

    fun hello() {
        println("$name: myaw")
    }
}

data class Coordinates(val x: Int, val y: Int)

operator fun Coordinates.unaryMinus() = Coordinates(-x, -y)