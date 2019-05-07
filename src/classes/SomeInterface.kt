package club.globalcyberspace.kotlin.starter.classes

interface SomeInterface {
    val abstractProperty: String

    fun abstractFunction()

    fun functionWithDefaultRealisation(): Unit = println("Some string")
}