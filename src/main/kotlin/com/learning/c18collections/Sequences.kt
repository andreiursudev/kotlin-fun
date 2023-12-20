package academy.learnprogramming.sequences


fun main(args: Array<String>) {

    val immutableMap = mapOf<Int, Car>(1 to Car("green", "Toyota", 2015),
            2 to Car("red", "Ford", 2016),
            3 to Car("silver", "Honda", 2013),
            17 to Car("red", "BMW", 2015),
            8 to Car("green", "Ford", 2010))

    println(immutableMap.asSequence().filter { it.value.model == "Ford"}
            .map { it.value.color })

    //sequences are the same as streams in java
    //sequences are never-ending, they are a continuous stream of elements
    listOf("Mary", "Jane", "Joe").asSequence()//only to use for large collections
            .map { println("mapping $it"); it.uppercase() }
            .filter { println("filtering $it"); it[0] == 'J'}
            .find { it.endsWith('E') }//terminal operation, might not evaluate the full sequence

}

data class Car(val color: String, val model: String, val year: Int) {

}