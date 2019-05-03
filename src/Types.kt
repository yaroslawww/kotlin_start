package club.globalcyberspace.kotlin.starter

fun main(args: Array<String>) {
    var byte: Byte = 1 // 2^8 = 256 (-128:127)
    var short: Short = 1 // 2^16 = 65536 (-32768:32767)
    var int: Int = 1 // 2^32 = 4294967296 (-2147483648:2147483647)
    var long: Long = 1L // 2^64

    var floaf: Float = 2.35f // 2^32
    var double: Double = 2.35 // 2^64

    var char: Char = '{' // 2^16 (unsigned)

    var boolean: Boolean = true //

    /**
     * Supper class for all classes
     */
    var any: Any = Any()
    println(any.toString()) //java.lang.Object@5594a1b5

    /**
     * Void class
     */
    var unit: Unit = Unit
    println(unit.toString()) // kotlin.Unit



    /**
     * Work with variables
     */
    // Error: Type mismatch: inferred type is Byte but Short was expected
    //short = byte
    println(byte + short) // 2
    println(byte.plus(short)) // 2

    /**
     * type "Nothing" used for return infinit loop
     */
    whileTrue()
    // this code will be unreachable because whileTrue() return "Nothing"
    println("some text")
}

fun whileTrue(): Nothing {
    while (true) {

    }
}