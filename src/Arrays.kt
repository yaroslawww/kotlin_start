@file:JvmName("Arrays")

package club.globalcyberspace.kotlin.starter

fun main(args: Array<String>) {
    /**
     * Array - this is group of variables with same type
     * what can be accessible by index
     *
     * Array has fixed size
     */
    val array1 = arrayOf(1, 2, 3, 4)
    println("${array1::class.javaObjectType}") // class [Ljava.lang.Integer;
    val array2 = arrayOf("1", "2", "3", "4")
    println("${array2::class.javaObjectType}") // class [Ljava.lang.String;
    val array3 = arrayOf(1, Programmer("John", 22, null), "some string", 4)
    println("${array3::class.javaObjectType}") // class [Ljava.lang.Object;


    val array4 = listOf(1, 3, 6, 8).toIntArray()
    println("${array4::class.javaObjectType}") // class [I


    val array5 = listOf(1, 3, 6, 8).toTypedArray()
    println("${array5::class.javaObjectType}") // class [Ljava.lang.Integer;

    val array6 = arrayOfNulls<String>(6)
    println("${array6::class.javaObjectType}") // class [Ljava.lang.String;
    println(array6[0]) // null

    val array7: Array<Int> = Array<Int>(4) {i -> i+10 }
    array7.forEach {
        print("$it, ") // 10, 11, 12, 13,
    }
    println()

    val array8 = intArrayOf(1, 2, 3)
    println("${array8::class.javaObjectType}") // class [I

    // Array alse can be nullable
    val nullableArray: Array<Int?>? = arrayOf(1, 5, null, 9)
    nullableArray?.forEach {
        print("${it?.times(2)}, ") // 2, 10, null, 18,
    }
    println()

    println(nullableArray?.filterNotNull()?.count()) // 3


}