package club.globalcyberspace.kotlin.starter.classes

class OverrideMethods(override val abstractProperty: String) : SomeInterface {

    override fun abstractFunction() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class OverrideMethods2(override val abstractProperty: String) : SomeInterface, SomeInterface2WithSameDefault {

    override fun functionWithDefaultRealisation() {
        super<SomeInterface>.functionWithDefaultRealisation()
        super<SomeInterface2WithSameDefault>.functionWithDefaultRealisation()
        println("Some others")
    }

    override fun abstractFunction() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}