package club.globalcyberspace.kotlin.starter

fun main(args: Array<String>) {

    /**
     * while
     */
    var count: Byte = 0
    while (++count < 10) {
        print("$count->") // 1->2->3->4->5->6->7->8->9->
    }
    println("")
    println("${++count}, ${count++}, ${count}") // 11, 11, 12
    println("${--count}, ${count--}, ${count}") // 11, 11, 10

    var someMessage = "Hello"
    val it = someMessage.iterator()
    while (it.hasNext()) {
        print(it.next())
        print("->")//

    }// H->e->l->l->o->
    println()

    /**
     * do...while
     */

    /*do {
        println("enter 1:")
        val (pin) = readLine()!!.split(' ')
    } while (pin.toInt() != 1)*/

    /**
     * for
     */
    var numbers = arrayListOf<Byte>(2, 4, 6, 7, 9)
    for (n in numbers) {
        print("$n->") // 2->4->6->7->9->
    }
    println()

    for (r in 3..9) {
        print("$r->") // 3->4->5->6->7->8->9->
    }
    println()

    for (r in 3..9 step 3) {
        print("$r->") // 3->6->9->
    }
    println()

    for (r in 9..3) { // empty range
        print("$r->")
    }
    println()

    for (r in 9 downTo 3) {
        print("$r->") // 9->8->7->6->5->4->3->
    }
    println()

    val map = mapOf<Int, String>(1 to "key1", 2 to "key2")
    for ((key, value) in map) {
        print("$key:$value->") // 1:key1->2:key2->
    }
    println()

    for ((key, value) in numbers.withIndex()) {
        print("$key:$value->") // 0:2->1:4->2:6->3:7->4:9->
    }
    println()

    for ((key, value) in numbers.withIndex()) {
        if (key == 1) {
            continue
        } else if (key == 3) {
            break
        }
        print("$key:$value->") // 0:2->2:6->
    }
    println()

    val arryListOfMapElement = arrayListOf(map)
    someLabel@for(i in arryListOfMapElement) {
        for ((key, value) in map) {
            if(key == 2) {
                break@someLabel
            }
            print("$key:$value->") // 1:key1->
        }

    }
    println()

    println('h' in 'a'..'z') // true
    println('H' in 'a'..'z') // false

    /**
     * Foreach in map
     */
    map.forEach { key, value ->
        print("$key:$value->") // 1:key1->2:key2->
    }
    println()

    map.forEach {
        print("${it.key}:${it.value}->") // 1:key1->2:key2->
    }
    println()

    numbers.forEachIndexed {key, value ->
        print("$key:$value->") // 0:2->1:4->2:6->3:7->4:9->
    }
    println()

    numbers.reversed().forEach {
        print("${it}->") // 9->7->6->4->2->
    }
    println()

    numbers.reversed().forEach {
        if (it == 6.toByte()) {
            return@forEach
        }
        print("${it}->") // 9->7->4->2->
    }
    println()

}