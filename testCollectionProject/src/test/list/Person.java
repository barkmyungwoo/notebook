package test.list;

import java.io.*;

public class Person implements Serializable{
	private String name;
	private int age;
	private double point;

	public Person() {
	}
	public Person(String name, int age, double point) {
		this.name = name;
		this.age = age;
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", point=" + point + "]";
	}

	
	
	

}
