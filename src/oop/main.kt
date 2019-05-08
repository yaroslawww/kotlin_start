package club.globalcyberspace.kotlin.starter.oop

fun main(args: Array<String>) {


    // Association
    val employer = Employer(IdCard(10, "Jonh Snow"))

    employer.idCard.displayId() // 10


}

class IdCard(val id: Int, val Name: String) {
    fun displayId() {
        println("$id")
    }
}
class Employer(var idCard: IdCard)