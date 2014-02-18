/**
 * @author Daniel G Maldonado
 */
package lab2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Student object has two important fields; name and grades. These can be returned using the 
 * methods from this class.
 */
public class Student {
	private final String name;
	private final ArrayList<Integer> grades;
	
	/**
	 * StudentBuilder is a factory that is used to create the Student objects.
	 */
	public static class StudentBuilder {
		private final String name;
		private final ArrayList<Integer> grades;
		
		/**
		 * @param name a non-null String object.
		 * @param grades a non-null ArrayList object of type Integer.
		 */
		public StudentBuilder(String name, ArrayList <Integer> grades) {
			this.name = name;
			this.grades = grades;
		}
		
		/**
		 * @return buildStudent will return an object of type Student.
		 */
		public Student buildStudent(){
			return new Student(this);
		}
	}
	/**
	 * A private method so that only the class can call construction of a Student object.
	 * 
	 * @param studentBuilder a non-null StudetBuilder object that is used to create a Student.
	 */
	private Student(StudentBuilder studentBuilder) {
		name = studentBuilder.name;
		grades = studentBuilder.grades;	
	}
	
	/**
	 * @return name of the student.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return ArrayList of grades.
	 */
	public ArrayList<Integer> getGrades() {
		return this.grades;
	}
	
	/**
	 * @return number of grades.
	 */
	public int getNumberOfGrades() {
		return this.grades.size();
	}
	
	/**
	 * @return average of the grades.
	 */
	public double getAverage() {
		double total = 0;
		for(int item : this.grades) {
			total += item;
		}
		return total / this.getNumberOfGrades();
	}
	
	/**
	 * @return median of the grades.
	 */
	public double getMedian() {
		ArrayList<Integer> temp = this.grades;
		Collections.sort(temp);
		
		if (this.getNumberOfGrades() % 2 == 0) {
			double grade1 = temp.get(this.getNumberOfGrades() / 2);
			double grade2 = temp.get((this.getNumberOfGrades() / 2) - 1);
			return (grade1 + grade2) / 2;
		} else {
			return temp.get((this.getNumberOfGrades() - 1) / 2);
		}
	}
	
	/**
	 * @return maximum of the grades.
	 */
	public int getMaximum() {
		return Collections.max(this.grades);
	}
	/**
	 * @return minimum of the grades.
	 */
	public int getMinimum() {
		return Collections.min(this.grades);
	}
}
