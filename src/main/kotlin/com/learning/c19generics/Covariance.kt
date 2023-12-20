package academy.learnprogramming.covariance

//Nullable versus non nullable types a nullable type is a wider type than the
// non-nullable type.

//if we want a list of short to be treated like a list of number then the list of short has to be a subtype of list of number.
//And if we want the subtyping to be preserved we have to declare the parameter is covariant.

//an immutable collection is covariant but a mutable collection is not.
fun main(args: Array<String>) {

    val shortList: List<Short> = listOf(1, 2, 3, 4, 5)
    convertToInt(shortList)
}

fun convertToInt(collection: List<Number>) {
    for (num in collection) {
        println("${num.toInt()}")
    }
    //collection.add(25.3)
}

fun tendGarden(roseGarden: Garden<Rose>) {
    waterGarden(roseGarden)
}

//subtypes of Flower will not be accepted
fun waterGarden(garden: Garden<Flower>) {

}

open class Flower {

}

class Rose: Flower() {

}

//out -makes Garden covariant
//in position = function paramters
//out position = return type

class Garden<out T: Flower>(private var something: T) {

    val flowers: List<T> = listOf()

    //can only use T in the out position
    fun pickFlower(i: Int): T = flowers[i]
//    fun plantFlower(flower: T) {
//
//    }

}