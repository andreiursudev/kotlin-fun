package com.learning.c21javainteroperability.javacode;


import com.learning.c21javainteroperability.calljava.KotlinCar;
import com.learning.c21javainteroperability.calljava.SingletonObj;
import com.learning.c21javainteroperability.calljava.StaticCar;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //KotlinCarKt.topLevel();
        StaticCar.topLevel();

        StaticCar.print("print this Java string");

        KotlinCar car = new KotlinCar("blue", "BMW", 2011);
        System.out.println(car.model);

        System.out.println(car.getColor());
        KotlinCar.carComp();
        System.out.println("isAuto = " + KotlinCar.constant);

        SingletonObj.doSomething();

        //Throws IllegalArgumentException because Kotlin String is non-nullable
        //car.printMe(null);

        try {
            StaticCar.doIO();
        } catch (IOException e) {
            System.out.println("IOException!");
        }

        StaticCar.defaultArgs("The Number is: ");
    }
}
