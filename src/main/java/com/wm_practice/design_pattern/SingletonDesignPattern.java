package com.wm_practice.design_pattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class SingletonDesignPattern {

	/***why we declare static for instance variable?
	 * 
	 * bcz we are going to create and store only single object
	 * 
	 * we are using getInstance() to get object from outside class. which can be accessed by class reference
	 * so it is static method. hence this memeber also static
	 */
	
	static Singleton instance1 = Singleton.getSingleton();

	static void cloneSingleton() {
		
		System.out.println("====cloning===");

		Singleton instance2 = (Singleton) instance1.clone();

		System.out.println("instance2 hashCode:- " + instance2.hashCode());
	}

	static void serialzeSingleton() {

		try {
			System.out.println("===serializing===");
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.text"));
			out.writeObject(instance1);
			out.close();

			ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
			Singleton instance2 = (Singleton) in.readObject();
			in.close();

			System.out.println("instance2 hashCode:- " + instance2.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {

		Singleton ins2 = Singleton.getSingleton();


		instance1.s = (instance1.s).toUpperCase();

		ins2.s = (ins2.s).toLowerCase();

		System.out.println("======instance 1===" + instance1.hashCode());
		System.out.println("=======insrance 2===" + ins2.hashCode());

		cloneSingleton();
		serialzeSingleton();
	}
}
