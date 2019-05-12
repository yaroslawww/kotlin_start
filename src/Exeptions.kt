package club.globalcyberspace.kotlin.starter

import java.lang.NullPointerException

fun main(args: Array<String>) {
    try {

    } catch (ex: NullPointerException) {
        println("nullPointerExeption: " + ex.toString())
    } catch (ex: Throwable) {
        println("throwable: " + ex.toString())
    } finally {
        println("Allways")
    }

    a()
    /*
    -- in: a
    --- in: b
    ---- in: c
    ----- in: d
    finally c()
    exception handled
    --- our: b
    -- our: a
     */

}

fun a() {
    println("-- in: a")
    b()
    println("-- our: a")
}

fun b() {
    println("--- in: b")
    try {
        c()
    } catch (ex: Throwable) {
        println("exception handled")
    }
    println("--- our: b")
}

fun c() {
    println("---- in: c")
    try {
        d()
    } finally {
        println("finally c()")
    }
    println("---- our: c")
}

fun d() {
    println("----- in: d")
    throw NullPointerException("test")
    println("----- our: d")
}