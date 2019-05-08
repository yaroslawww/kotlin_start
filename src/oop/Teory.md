## Abstraction
Generalization of the selection of the most significant properties and methods of the class

## Inheritance
The ability of classes to use the properties and methods of a existing class by complementing or 
 overriding its properties and methods

## Encapsulation
The ability of classes to hide the implementation and perform the calculation 
without affecting the environment

## Polymorphism
The ability to use the same code for different data types or different classes with a common interface

#

## Association
means a relationship between classes of objects, which allows one instance of an object to call 
another to perform an action on its behalf.

## Aggregation
Case of association where class can exist after remove other class
```kotlin
class Employer(val name: String, var respozibilities: ArrayList<Responsibility>)
class Responsibility(val title: String)



val closeDoor = Responsibility("closeDoor")
val openWindow = Responsibility("openWindow")
val lightsOff = Responsibility("Turn the lights off")

val employer1 = Employer("Jonh Snow", arrayListOf<Responsibility>(closeDoor, lightsOff))
val employer2 = Employer("Jonh Snow", arrayListOf<Responsibility>(openWindow, lightsOff))

```


## Composition
Case of association where class can't exist after remove other class

```kotlin
class IdCard(val id: Int, val Name: String) {
   fun displayId() {
       println("$id")
   }
}
class Employer(var idCard: IdCard)

val employer = Employer(IdCard(10, "Jonh Snow"))

employer.idCard.displayId() // 10

```