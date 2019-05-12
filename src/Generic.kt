package club.globalcyberspace.kotlin.starter

interface IGeneric<A> {
    fun deleteObject(): A?
}

class Generic<T>(var obj: T?) : IGeneric<T> {
    override fun deleteObject(): T? {
        val temp = obj
        obj = null
        return temp
    }

    fun getOb(): T? = obj
}

fun <T> runFun(func: () -> T): T = func()

fun <T : Number> List<T>.average(): Double {
    var av = 0.0
    this.forEach {
        av += it.toDouble()
    }
    return av.div(this.size)
}

fun main(args: Array<String>) {
    var objec = Generic<Int>(12)
    val int = runFun { objec.getOb() }

    println(int) // 12

    var obStr = Generic<String>("test")
    val str = runFun { obStr.getOb() }

    println(str) // test

    var obNull = Generic<Any>(null)
    val emptyNull = runFun { obNull.getOb() }

    println(emptyNull) // null

    var obAny = Generic<String>(null)
    obAny.obj = "asd"
    // error expect String
    // obAny.obj = 12

    println(listOf(1, 2, 3, 4).average()) // 2.5
    // Error:(50, 40) Kotlin: Type parameter bound for T in fun <T : Number> List<T>.average(): Double
    // println(listOf("1", "2", "3", "4").average())


    var list1 = listOf<Int>()
    var list2 = listOf<String>()
    val sequense = 1..3

    // We used *
    fun <T> compare(value: T) {
        if (value is List<*>) println("true") else println("false")
    }

    compare(list1) // true
    compare(list2) // true
    compare(sequense) // false

    compare2<String>("") // true
    compare2<String>(1) // false

}


inline fun <reified T> compare2(value: Any) {
    if (value is T) println("true") else println("false")
}