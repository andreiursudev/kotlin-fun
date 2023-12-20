package academy.learnprogramming.usesitevariance


fun main(args: Array<String>) {

    val cars1 = mutableListOf(Car(), Car())
    val cars2: MutableList<Car> = mutableListOf()
    copyCars(cars1, cars2)

    val fords1 = mutableListOf(Ford(), Ford())
    val fords2: MutableList<Ford> = mutableListOf()
    copyCars(fords1, fords2)

    copyCars(fords1, cars2)

    val cars3: MutableList<Car> = mutableListOf(Ford(), Ford())

}

//We're not using declarations site covariance we're using use-site covariance.
//use-site covariance is called also type projection
fun <T: Car> copyCars(source: MutableList<out T>, destination: MutableList<T>) {
    for (car in source) {
        destination.add(car)
    }
}

open class Car {

}

class Toyota: Car() {

}

class Ford: Car() {

}

// List<? extends Car>

// List<? super Car>