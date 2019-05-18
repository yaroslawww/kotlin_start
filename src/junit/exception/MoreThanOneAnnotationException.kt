package club.globalcyberspace.kotlin.starter.junit.exception

class MoreThanOneAnnotationException @JvmOverloads constructor(
        private val e: String = "More than one annotation used"
): Exception() {

    override fun toString(): String {
        return "$e"
    }
}