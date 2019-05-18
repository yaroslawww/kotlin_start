package club.globalcyberspace.kotlin.starter.junit.exception

class IllegalAnnotationException @JvmOverloads constructor(
        private val e: String = "Illegal annotation!"
): Exception() {

    override fun toString(): String {
        return "$e"
    }
}