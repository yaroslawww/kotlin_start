package club.globalcyberspace.kotlin.starter

fun main(args: Array<String>) {

    /**
     * By default collection is not mutable
     * for edit collection you need to use mutable collection
     * Both are easy to create, but the type system doesn't express the difference,
     * so keeping track of that (if it's relevant) is up to you.
     * NOTE: mutable and imutable collection can be linked to same object:
     */
    val mutableCollection: MutableCollection<String> = arrayListOf("")
    val collection: Collection<String> = mutableCollection
    println("collection size = ${collection.size}") // 1
    println("mutableCollection size = ${mutableCollection.size}") // 1
    mutableCollection.add("test")
    println("collection size = ${collection.size}") // 2
    println("mutableCollection size = ${mutableCollection.size}") // 2

    /**
     * Types of collections
     */

    /**
     * Set - group of elements that can not be duplicated
     * LinkedHashSet - elements preserves the insertion order
     * HashSet - elements NOT preserves the insertion order
     * TreeSet - the elements are ordered using their natural ordering
     */
    val set1 = setOf<String>("test", "test", "test1", "alpha") // LinkedHashSet
    println(set1::class.qualifiedName) // java.util.LinkedHashSet
    println(set1.size) // 3
    // we can't add
    //set1.add()
    val set2 = linkedSetOf<String>("test", "test", "test1", "alpha") // LinkedHashSet
    val set3 = hashSetOf<String>("test", "test", "test1", "alpha") // HashSet
    val set4 = sortedSetOf<String>("test", "test", "test1", "alpha") // TreeSet
    val set5 = mutableSetOf<String>("test", "test", "test1", "alpha") // Support add/remove elements

    /**
     * List - group of elements preserves the insertion order
     *
     */
    var list1 = listOf<String>("test", "test", "test1", "alpha")
    println(list1::class.qualifiedName) // java.util.Arrays.ArrayList
    println(list1.size) // 4
    // Transform to mutable list
    list1 = list1.toMutableList()
    list1.add("asdasd")
    // Shuffle list (reorder)
    list1 = list1.shuffled()

    val list2 = listOfNotNull("test", null, null, "test", null, "test1", "alpha")
    // or use mutableListOf<>()
    println(list2.size) // 4

    val numbers = listOf("one", "two", "three", "four")
    println(numbers.joinToString()) // one, two, three, four
    println(numbers.joinToString(prefix = "[", postfix = "]")) // [one, two, three, four]
    println(numbers.joinToString(prefix = "{", postfix = "}", separator = "|")) // {one|two|three|four}

    /**
     * Map - key->value collection
     */
    val map = mapOf<String, Char>("point".to('.'), "coma" to ',')
    println(map.get("point")) // .
    println(map["point"]) // .
    // map.toMutableMap()

    var mutableMap = mutableMapOf<String, Char>("point".to('.'), "question" to '?')
    mutableMap.put("and", '&')
    println(mutableMap.getOrDefault("not exist", '[')) // [
    println(mutableMap.size) // 3
    println(mutableMap) // {point=., question=?, and=&}
    println(mutableMap.toSortedMap()) // {and=&, point=., question=?}
    // ore use sortedMapOf()
    println(mutableMap.putAll(map)) // kotlin.Unit
    println(mutableMap) // {point=., question=?, and=&, coma=,}
    // hashMapOf<>() // HashMap
    // linkedMapOf<>() // LinkedHashMap
}