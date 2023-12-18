package academy.learnprogramming.nullreferences

fun main(args: Array<String>) {

    //? = nullable variable
    //String not a nullable type
    //String? is a nullable type
    val str: String? = null
    val str1: String? = "Some string"
    if (str1 != null) {
        str1.uppercase()
    }

    //safe access expression= evaluates to null instead of throwing NullPointerException
    //safe call operator
    str1?.uppercase()



    //!! the not null assertion - use in case you want to get a NullPointerException if str is null
    //str!! -Throws NPE if str is null
    val str4 = str!!.uppercase()

    //let this happen as long as str is not null
    str?.let { printText(it) }


    println("What happens when we do this: ${str?.uppercase()}")

    //elvis operator ?:
    val str2 = str ?: "This is the default value"
    println(str2)

    //val whatever = bankBranch?.address?.country ?: "US"

    val something: Any = arrayOf(1, 2, 3, 4)

    //as? = safe cast operator
    val str3 = something as? String
    println(str3)

    println(str3?.uppercase())
}

fun printText(text: String) {
    println(text)
}




