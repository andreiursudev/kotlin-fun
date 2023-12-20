package academy.learnprogramming.contravariance

fun main(args: Array<String>) {

    val flowerTender = object: FlowerCare<Flower> {
        override fun prune(flower: Flower) = println("I'm tending a ${flower.name}!")
    }

    val roseTender = object: FlowerCare<Rose> {
        override fun prune(flower: Rose) = println("I'm pruning a rose!")
    }
    val roseGarden = Garden<Rose>(listOf(Rose(), Rose()), flowerTender)
    roseGarden.tendFlower(0)

    val daffodilTender = object: FlowerCare<Daffodil> {
        override fun prune(flower: Daffodil) = println("I'm pruning a daffodil!")
    }
    val daffodilGarden = Garden<Daffodil>(listOf(Daffodil(), Daffodil(), Daffodil()),
            flowerTender)
    daffodilGarden.tendFlower(2)

    val flowerTender2 = object: FlowerCare<Flower> {
        override fun prune(flower: Flower) = println("I'm tending a flower")
        fun pick(): Flower = Flower("some random flower")
    }
    val roseGarden2 = Garden<Rose>(listOf(Rose()), flowerTender2)
    //val rose: Rose = roseGarden2.pickFlower(0)


}

class Garden<T: Flower>(val flowers: List<T>, val flowerCare: FlowerCare<T>) {
    //fun pickFlower(i: Int) = flowerCare.pick(i)
    fun tendFlower(i: Int) {
        flowerCare.prune(flowers[i])
    }
}

open class Flower(val name: String) {

}

class Rose: Flower("Rose") {

}

class Daffodil: Flower("Daffodil") {

}

//Contravariant is the opposite of covariance.
//When we use covariance we're preserving the subtyping when we use contravariant.
//We're going in the opposite direction so we're starting at a subclass and we wind to accept instances
//of that subclass or any of its superclasses.

interface FlowerCare<in T> {
    fun prune(flower: T)
    //fun pick(): T
}
