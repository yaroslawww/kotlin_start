package club.globalcyberspace.kotlin.starter.classes

interface SomeInterface2WithSameDefault {
    val abstractProperty: String

    fun abstractFunction()

    fun functionWithDefaultRealisation(): Unit = println("Some string2")
}