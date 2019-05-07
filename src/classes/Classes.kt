package club.globalcyberspace.kotlin.starter.classes

/**
 * Constructor
 * */
class SomeClass constructor(someString: String, otherString: String) {
    private val internalValue: String = someString.replace('-', '_')
    private val internalValue2: String

    init {
        val replaced = someString.replace('-', '_')
        val replaced2 = otherString.replace('-', ' ')
        internalValue2 = "$replaced && $replaced2"
    }
}

/**
 * Initialisation with visibility domain
 */
class SomeClass2 constructor(private val numbers: Int = 30)

/**
 * Initialisation vithout name constuctor
 */
class SomeClass3 (protected val numbers: Int = 30)

/**
 * Create abstract class
 */
abstract class AbstractClass



open class Parrent(someString: String)

class Child(someString: String): Parrent(someString)