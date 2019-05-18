package club.globalcyberspace.kotlin.starter.junit.exception

class NotTestClassException @JvmOverloads constructor(
        private val e: String = "Not test class!"
): Exception() {

    override fun toString(): String {
        return "$e"
    }
}