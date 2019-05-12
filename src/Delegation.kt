package club.globalcyberspace.kotlin.starter

interface Sport {
    fun move() {
        println("Sport")
    }

    abstract fun turnLeft(): Unit
    abstract fun message(): Unit

    fun turnRight() {
        println("Go Right")
    }
}

class Car : Sport {
    val message = "hello"
    override fun message() {
        println(message)
    }

    override fun turnLeft() {
        println("Turn Left")
    }

    override fun turnRight() {
        println("Turn Right")
    }
}


class DelegationCar(private val car: Car = Car()) : Sport by car {
    val message = "bye"

    override fun turnRight() {
        println("Wow right")
    }
}

fun main(args: Array<String>) {
    var sportCat = Car()
    sportCat.move()
    sportCat.turnLeft()
    sportCat.turnRight()
    sportCat.message()
    println(sportCat.message)



    var myCar = DelegationCar()
    myCar.move()
    myCar.turnLeft()
    myCar.turnRight()
    // Prop message will be get from implemented class
    myCar.message()
    println(myCar.message)
}