package academy.learnprogramming.lambdas

fun main(args: Array<String>) {
    //run { println("I'm in a lambda!") }

    val employees = listOf(
        Employee("John", "Smith", 2012),
        Employee("Jane", "Wilson", 2015),
        Employee("Mary", "Johnson", 2010),
        Employee("Mike", "Jones", 2002)
    )

    println(employees.minBy { e -> e.startYear })
    println(employees.minBy({ e -> e.startYear }))
    println(employees.minBy({ it.startYear }))
    println(employees.minBy( Employee::startYear ))//member reference

    //works with mutable variables
//    var num = 10
//    run {
//        num += 15
//        println(num)
//    }

    run(::topLevel)//cannot accept arguments

}

fun topLevel() = println("I'm in a function!")

fun useParameter(employees: List<Employee>, num: Int) {
    employees.forEach {
        println(it.firstName)
        println(num)//num cannot be changed
    }
}

data class Employee(val firstName: String, val lastName: String, val startYear: Int) {

}