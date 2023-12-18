package com.learning.declarations

typealias EmployeeSet = Set<Employee>

fun main(args: Array<String>) {
    val employeeOne = Employee("Mary", 1)
    val employeeTwo = Employee("John", 2)
    val employeeThree = Employee("John", 2)

    println(employeeOne == employeeTwo)
    println(employeeTwo == employeeThree)
    println(employeeOne === employeeTwo)
    println(employeeTwo === employeeThree)
    println(employeeOne.equals(employeeTwo))
    println(employeeTwo.equals(employeeThree))
    val employeeFour =employeeTwo
    println(employeeFour === employeeThree)

    println(employeeFour != employeeTwo)
    println(employeeFour !== employeeTwo)
    println(employeeTwo != employeeThree)
    println(employeeTwo !== employeeThree)


    val something: Any = employeeFour
    if(something is Employee){
        val newEmployee = something as Employee //as = cast
        println(something.name)//smart casting
    }



    println("Hello World!")

    //val = final
    val number1: Int
    val number2 = 25
    val number3: Int = 25
    val number4: Short = 25
    //var = mutable
    var number5: Int
    number5 = 10

    val employee1 = Employee("Lynn Jones", 500)
    employee1.name = "Lynn Smith"

    //employee1 = Employee("Tim Watson", 100) cannot assign a new instance to employee1 reference variable

    val employees: EmployeeSet

    println(employee1)

    val change = 4.22
    println("To show the value of change, we use \$change")
    println("Your change is $\$change")

    val numerator = 10.99
    val denominator = 20.00
    println("The value of $numerator divided by $denominator is ${numerator/denominator}")

    println("The employee's id is ${employee1.id}")

    val filePath = """c:\somedir\somedir2"""

    val eggName = "Humpty"
    val nurseryRhyme = """$eggName Dumpty sat on the wall
         |$eggName Dumpty had a great fall
         |All the king's horses and all the king's men
         |Couldn't put $eggName together again""".trimMargin()

    println(nurseryRhyme)

}

class Employee(var name: String, val id: Int) {
    override fun equals(obj: Any?): Boolean {
        if(obj is Employee){
            return name==obj.name && id==obj.id
        }
        return false
    }

    override fun toString(): String {
        return "Employee(name=$name, id=$id)"//string template
    }

}