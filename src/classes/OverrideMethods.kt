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

/**
 * Kotlin has access modificators
 * - final: default modificator (can't be override)
 * - open: open for inheritor
 * - abstract: can;t have objects
 *
 * Kotlin visibility modificators
 * - public: default modificator -> java public
 * - private: visible on same file -> java default
 * - internal: visible in module -> java public that why from java we can call this class but in Kotlin not
 */

final class ClassFinal()

class ClassFinal2()

/**
 * In Kotlin you can create classes inside classes
 */

class Outer {
    inner class InnerClass
    class EnclosedClass

    fun test() {
        /**
         * Inner class can not be serialised
         */
        var inner = InnerClass()
        var enclosed = EnclosedClass()
    }
}

var outer = Outer()
var inner = outer.InnerClass()

/**
 * Sealed classes are used for representing restricted class hierarchies, when a value can have one of the types
 * from a limited set, but cannot have any other type.
 * A sealed class can have subclasses, but all of them must be declared in the same file as the sealed class itself.
 */
sealed class Expr

data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber : Expr()

fun eval(expr: Expr): Double = when (expr) {
    is Const -> expr.number
    is Sum -> eval(expr.e1) + eval(expr.e2)
    NotANumber -> Double.NaN
    // the `else` clause is not required because we've covered all the cases
}

/**
 * Override getters and setters
 */
class Laptop {

    var cpu: Int = 1000
        get() {
            return field / 1024
        }
        set(value) {
            field = value * 1024
        }

    var workersCount: Int = 2

    var isNeedNewCPU: Boolean = false
        get() {
            return this.cpu / this.workersCount > 10
        }
        private set


}
