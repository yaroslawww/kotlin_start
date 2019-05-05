package club.globalcyberspace.kotlin.starter.util

fun Int.isEvenNumber(): Boolean {
    return this.div(2).times(2) == this
}

/**
 * There we can create "infix" function
 * and use it inline, but this function require one parameter
 * */
infix fun Int.multiple(int: Int): Int {
    return this * int
}