package academy.learnprogramming.generics

import java.math.BigDecimal


fun main(args: Array<String>) {

    val list = mutableListOf("Hello")
    list.add("another string")
    list.printCollection()


    val bdList = mutableListOf(BigDecimal(-33.45), BigDecimal(3503.99),
            BigDecimal(0.329))
    bdList.printCollection()

}

//extension function
fun <T> List<T>.printCollection() {
    for (item in this) {
        println(item)
    }
}