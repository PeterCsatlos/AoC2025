package day1

fun main(args: Array<String>) {
    task1()
    task2()
}


fun task1() {
    val strings = object {}.javaClass.getResource("/input.txt")?.readText()?.split("\n")!!.filter { it.isNotEmpty() }
    var counter = 0
    var current = 50
    for (string in strings) {
        val direction = string[0]
        val rotation = string.substring(1).toInt()
        if (direction == 'R') {
            current = (current + rotation) % 100
        } else {
            current = (100 + current - rotation) % 100
        }
        if(current == 0) {
            counter++
        }
    }
    println("counter $counter")
}

fun task2() {
    val strings = object {}.javaClass.getResource("/input.txt")?.readText()?.split("\n")!!.filter { it.isNotEmpty() }
    var counter = 0
    var current = 50
    for (string in strings) {
        val direction = string[0]
        val rotation = string.substring(1).toInt()
        val circle: Int = rotation / 100
        val remainingRotation = rotation % 100
        counter += circle
        if (direction == 'R') {
            if (current != 0 && remainingRotation + current > 100) {
                counter++
            }
            current = (current + remainingRotation) % 100
        } else {
            if (current != 0 && remainingRotation > current ) {
                counter++
            }
            current = (100 + current - remainingRotation) % 100
        }
        if(current == 0) {
            counter++
        }
    }
    println("counter $counter")
}
