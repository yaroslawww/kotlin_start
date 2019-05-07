package club.globalcyberspace.kotlin.starter.classes

abstract class Page {
    val title: String

    constructor(title: String) {
        // "this" is required
        this.title = title
    }

    constructor(titleId: Int) {
        title = titleId.toString()
    }

    constructor(titles: Array<String>): this(titles.joinToString())
}