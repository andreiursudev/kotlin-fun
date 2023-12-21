package com.learning.c21javainteroperability.javacode;


import com.learning.c21javainteroperability.calljava.KotlinCar;
import com.learning.c21javainteroperability.calljava.StaticCar;

public class Main {

    public static void main(String[] args) {
		//KotlinCarKt.topLevel();
	    StaticCar.topLevel();

	    StaticCar.print("print this Java string");

		KotlinCar car = new KotlinCar("blue", "BMW", 2011);
	    System.out.println(car.model);
	    System.out.println(car.getColor());

    }
}
