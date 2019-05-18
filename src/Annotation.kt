package club.globalcyberspace.kotlin.starter

import org.junit.jupiter.api.Test
import kotlin.reflect.KClass
import kotlin.reflect.full.functions

/**
 * Annotations are means of attaching metadata to code.
 *
 * Reflection is mean to get information about program during execution
 */

fun main(args: Array<String>) {

    val testClass = SomeClassWithAnnotation()

    testClass.someDeprecatedMethod() // deprecated function
    testClass.someNewMethod()

    SomeClassWithAnnotation.f1()
    SomeClassWithAnnotation.f2()


    var someClassRecusive: KClass<SomeClassWithAnnotation> = SomeClassWithAnnotation::class
    println(someClassRecusive.functions) //[fun club.globalcyberspace.kotlin.starter.SomeClassWithAnnotation.someDeprecatedMethod(): kotlin.Unit, fun club.globalcyberspace.kotlin.starter.SomeClassWithAnnotation.someFu

}

@MyAnnotation("message")
class SomeClassWithAnnotation {

    // Подавление предупреждений
    @Suppress("UNUSED")
    @get:[Suppress Deprecated("Deprecated only getter")]
    val someValue = 33

    @Deprecated(
            message = "This Function is deprecated",
            replaceWith = ReplaceWith("someNewMethod()"),
            level = DeprecationLevel.WARNING
    )
    fun someDeprecatedMethod(): Unit = println("deprecated function")

    @Test
    fun someNewMethod(): Unit = println("new function")

    @Suppress("UNUSED")
    fun someFun(@Suppress("UNUSED_PARAMETER") vararg string: String) = println("test")

    @JvmField
    var someLambdaFunc = @Suppress("UNUSED_PARAMETER") { p: String -> println("no p here") }

    companion object {
        /**
         * JvmStatic - used only for java files
         */
        @JvmStatic
        fun f1() {
        }

        fun f2() {}
    }

    /**
     * Annotation types (retention):
     * SOURCE - Isn't stored in binary file only in source code
     * BINARY - Stored in binary file but not visible for reflection
     * RUNTIME - (default retention) Stored in binary file and visible for reflections
     */

    /**
     * Also annotation have different target (purpose)
     */
    /** Class, interface or object, annotation class is also included */
    //CLASS,
    /** Annotation class only */
    //ANNOTATION_CLASS,
    /** Generic type parameter (unsupported yet) */
    //TYPE_PARAMETER,
    /** Property */
    //PROPERTY,
    /** Field, including property's backing field */
    //FIELD,
    /** Local variable */
    //LOCAL_VARIABLE,
    /** Value parameter of a function or a constructor */
    //VALUE_PARAMETER,
    /** Constructor only (primary or secondary) */
    //CONSTRUCTOR,
    /** Function (constructors are not included) */
    //FUNCTION,
    /** Property getter only */
    //PROPERTY_GETTER,
    /** Property setter only */
    // PROPERTY_SETTER,
    /** Type usage */
    //TYPE,
    /** Any expression */
    //EXPRESSION,
    /** File */
    //FILE,
    /** Type alias */
    //@SinceKotlin("1.1")
    //TYPEALIAS


}

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.BINARY)
@MustBeDocumented
annotation class MyAnnotation(val message: String)