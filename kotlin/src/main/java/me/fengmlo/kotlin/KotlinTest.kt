package me.fengmlo.kotlin

/**
 * Created by User on 2017/5/25.
 */
//fun sum(a: Int, b: Int): Int {
//    return a + b
//}

//fun main(args: Array<String>) {
//    print("sum of 3 and 5 is")
//    println(sum(3, 5))
//}

fun sum(b: Int, a: Int) = a + b

//fun printSum(a: Int, b: Int): Unit {
//    println("sum of $a and $b is ${a + b}")
//}

fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun main(args: Array<String>) {
    println("sum of 19 and 23 is ${sum(19, 23)}")
    printSum(-1, 8)

//    val a: Int = 1
//    val b = 2
//    val c: Int
//    c = 3
//    println("a = $a, b = $b, c = $c")

//    var x = 5
//    x += 1
//    println("x = $x")
    var a = 1
    val s1 = "a is $a"
    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)

    println("max of 0 and 42 is ${maxOf(0, 42)}")

    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, not a string"} ")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength("")
    printLength(listOf(Any()))

    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    for ((index, value) in items.withIndex()) {
        println("item at $index is $value")
    }

    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))

    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }

    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }

    for (x in 1..5) {
        print(x)
    }
    println()

    for (x in 1..10 step 2) {
        print(x)
    }
    println()

    for (x in 9 downTo 0 step 3) {
        print(x)
    }
    println()

    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }


}

fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

//fun maxOf(a: Int, b: Int): Int {
//    if (a > b) {
//        return a
//    } else {
//        return b
//    }
//}

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun getStringLength(obj: Any): Int? {
//    if (obj is String) {
//        // obj 将会在这个分支中自动转换为 String 类型
//        return obj.length
//    }

    // obj 将会在&&右边自动转换为 String 类型
    if (obj is String && obj.length > 0) {
        return obj.length
    }

    // obj 在种类检查外仍然是 Any 类型
    return null
}