package club.globalcyberspace.kotlin.starter.classes

class Robot() {
    var x: Int = 5
    var y: Int = 6


}

class Robot2() {
    var x: Int = 5
    var y: Int = 6

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Robot2

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        return x.hashCode() / 2 + y.hashCode() / 2
    }

    override fun toString(): String {
        return "Robot2(x=$x, y=$y)"
    }


}

/**
 * For data class methods equals, hashCode, toString already overridden
 */
data class SomeData(var x: Int, var message: String)

/**
 * This is class and object instance in same time
 * Not allowed constructor
 * Can be without name
 * Can override properties from parent class
 */
object Singleton {
    var someMessage = "I am Singleton"
}

/**
 * companions
 */
class Dog {
    var name: String
    var age: Int

    private constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    override fun toString(): String {
        return "name: $name, age: $age"
    }

    companion object {
        fun getInstance(name: String, age: Int): Dog {
            return Dog(name, age)
        }
    }

}

fun main(args: Array<String>) {

    println("not overridden: ")

    val simpleRobot = Robot()
    val simpleRobot2 = Robot()
    val simpleRobot3 = simpleRobot

    println(simpleRobot == simpleRobot2) // false
    println(simpleRobot == simpleRobot3) // true
    println(simpleRobot === simpleRobot2) // false
    println(simpleRobot === simpleRobot3) // true
    // equals() same as ==
    println(simpleRobot.equals(simpleRobot2)) // false
    println(simpleRobot.equals(simpleRobot3)) // true
    println(simpleRobot.hashCode() == simpleRobot2.hashCode()) // false
    println(simpleRobot.hashCode() == simpleRobot3.hashCode()) // true
    // Deprecated
    // println(simpleRobot.hashCode() === simpleRobot2.hashCode()) // false
    // println(simpleRobot.hashCode() === simpleRobot3.hashCode()) // true
    println(simpleRobot.toString()) // club.globalcyberspace.kotlin.starter.classes.Robot@6a5fc7f7

    println("overridden: ")

    val overriddenRobot = Robot2()
    val overriddenRobot2 = Robot2()
    val overriddenRobot3 = overriddenRobot

    println(overriddenRobot == overriddenRobot2) // true
    println(overriddenRobot == overriddenRobot3) // true
    println(overriddenRobot === overriddenRobot2) // false
    println(overriddenRobot === overriddenRobot3) // true
    // equals() same as ==
    println(overriddenRobot.equals(overriddenRobot2)) // true
    println(overriddenRobot.equals(overriddenRobot3)) // true
    println(overriddenRobot.hashCode() == overriddenRobot2.hashCode()) // true
    println(overriddenRobot.hashCode() == overriddenRobot3.hashCode()) // true
    // Deprecated
    // println(overriddenRobot.hashCode() === overriddenRobot2.hashCode()) // true
    // println(overriddenRobot.hashCode() === overriddenRobot3.hashCode()) // true
    println(overriddenRobot.toString()) // Robot2(x=5, y=6)

    println("data class:")

    val someData = SomeData(10, "Hi")
    val someData2 = SomeData(10, "Hi")
    println(someData.toString()) // SomeData(x=10, message=Hi)
    println(someData.hashCode()) // 2647
    println(someData == someData2) // true

    val someData3 = someData.copy(message = "Copied Hi")
    println(someData3.toString()) // SomeData(x=10, message=Copied Hi)

    println("object: ")
    val singletonObject1 = Singleton
    val singletonObject2 = Singleton

    println(singletonObject1.someMessage) // I am Singleton
    println(singletonObject2.someMessage) // I am Singleton
    singletonObject1.someMessage = "Rewrote message"
    println(singletonObject1.someMessage) // Rewrote message
    println(singletonObject2.someMessage) // Rewrote message

    println("companion: ")
    println(Dog.getInstance("Redpub", 20).toString()) // name: Redpub, age: 20
}