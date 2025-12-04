fun main(args: Array<String>) {
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
