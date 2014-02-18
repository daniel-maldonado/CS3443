/**
 * @author Daniel Maldonado
 */
package lab4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import length.*;

/**
 * 
 * @author Daniel Maldonado
 *
 */
public class Lab4 {
	private static ArrayList<Length> myList = new ArrayList<Length>();

	public static void main(String[] args) {
	    processFile("data.txt");    
	    printDetails(myList);
	}
	
	/**
	 * Opens the file that is to be processed. Parses the file and adds the elements to the ArrayList
	 * in the appropriate type.
	 * 
	 * @param file String representing the file that is to be processed.
	 */
	public static void processFile(String file) {
		InputStream myInputStream = getFileInputStream(file);
		BufferedReader myReader = new BufferedReader(new InputStreamReader(myInputStream));
	    String line;
	    try {
			while ((line = myReader.readLine()) != null) {
			    processLine(line);
			}
		} catch (IOException e) {
			System.out.println("Problem getting line from input stream.");
			e.printStackTrace();
		}
	    
	    closeInputStream(myReader);
	}
	
	/**
	 * Processing each line and adding the types of Length to the ArrayList.
	 * 
	 * @param line String representing the current line of the file being processed.
	 */
	public static void processLine(String line) {
		String length = "";
		String type = "";
		String currentElement = "";
		StringTokenizer stringParts = new StringTokenizer(line);
		
		while(stringParts.hasMoreElements()) {
			currentElement = stringParts.nextToken();
			
			if(isNumeric(currentElement)) {
				length = currentElement;
			} else {
				type = currentElement;
			}
		}
		
		if (!addElement(length, type)) {
			System.out.println("Problem adding: " + length + " " + type);
		}
	}
	
	/**
	 * Add element to ArrayList of Lengths in the correct type of subclass.
	 * 
	 * @param length String containing the value of the length element.
	 * @param type String containing the value of the type of Length it will be. 
	 * @return boolean returns true if the element was added correctly, and false if it was not.
	 */
	public static boolean addElement(String length, String type) {
		Length newElement = getTypeOfLength(type);
		newElement.setLength(Double.parseDouble(length));
		try {
			myList.add(newElement);
			return true;
		} catch (Exception e) {
			System.out.println("There was a problem adding the length to the list.");
		}
		return false;
	}
	
	/**
	 * Compares the String type to subclasses available to return the correct type.
	 * 
	 * @param type String that has the type from the formated file input.
	 * @return Length Subclass of Inch, Foot, Meter, or Yard depending on the match of type.
	 */
	public static Length getTypeOfLength(String type) {
		if (type.equalsIgnoreCase("inch") || type.equalsIgnoreCase("inches")) {
			return new Inch(0.0);
		}
		
		if (type.equalsIgnoreCase("meter") || type.equalsIgnoreCase("meters")) {
			return new Meter(0.0);
		}
		
		if (type.equalsIgnoreCase("foot") || type.equalsIgnoreCase("feet")) {
			return new Foot(0.0);
		}
		
		if (type.equalsIgnoreCase("yard") || type.equalsIgnoreCase("yards")) {
			return new Yard(0.0);
		}
		
		return null;
	}
	
	/**
	 * Prints the details of the list in the desired format.
	 * 
	 * @param myList list of non-null Length elements. 
	 */
	public static void printDetails(ArrayList<Length> myList) {
		printMyList(myList);
		System.out.println();
		
		printMin(myList);
		printMax(myList);
		System.out.println();
		
		printFirstToLast(myList);
		System.out.println();
		printLastToFirst(myList);
	}
	
	/**
	 * Prints the list in the desired format.
	 * 
	 * @param myList list of non-null Length elements. 
	 */
	public static void printMyList(ArrayList<Length> myList) {
		for (Length current : myList) {
			System.out.println(current);
		}
	}
	
	/**
	 * Finds the minimum length of the elements in the list and prints out that element.
	 * 
	 * @param myList list of non-null Length elements. 
	 */
	public static void printMin(ArrayList<Length> myList) {
		double min = 0.0;
		Length smallestElement = null;
		for (Length current : myList) {
			if (min == 0.0) {
				min = current.toMeters();
				smallestElement = current;
			} else if (current.toMeters() < min) {
				min = current.toMeters();
				smallestElement = current;
			}
		}
		System.out.println("Minimum is " + smallestElement);
	}
	
	/**
	 * Finds the maximum length of the elements in the list and prints out that element.
	 * 
	 * @param myList list of non-null Length elements. 
	 */
	public static void printMax(ArrayList<Length> myList) {
		double max = 0.0;
		Length largestElement = null;
		for (Length current : myList) {
			if (current.toMeters() > max) {
				max = current.toMeters();
				largestElement = current;
			}
		}
		System.out.println("Maximum is " + largestElement);
	}
	
	/**
	 * Adds the elements in the ArrayList from the first to last and then prints the total in each type of subclass.
	 * 
	 * @param myList list of non-null Length elements. 
	 */
	public static void printFirstToLast(ArrayList<Length> myList) {
		Meter meter = new Meter(0.0);
		Inch inch = new Inch(0.0);
		Foot foot = new Foot(0.0);
		Yard yard = new Yard(0.0);
		
		for (Length current : myList) {
			meter.add(current);
			inch.add(current);
			foot.add(current);
			yard.add(current);
		}

		System.out.println("Sum of Lengths Adding from First to Last");
		System.out.println(meter);
		System.out.println(inch);
		System.out.println(foot);
		System.out.println(yard);
	}
	
	/**
	 * Adds the elements in the ArrayList from last to first and then prints to total in each type of subclass.
	 * 
	 * @param myList list of non-null Length elements.
	 */
	public static void printLastToFirst(ArrayList<Length> myList) {
		Meter meter = new Meter(0.0);
		Inch inch = new Inch(0.0);
		Foot foot = new Foot(0.0);
		Yard yard = new Yard(0.0);
		
		int end = myList.size() - 1;
		while (end >= 0) {
			meter.add(myList.get(end));
			inch.add(myList.get(end));
			foot.add(myList.get(end));
			yard.add(myList.get(end));
			end --;
		}
		
		System.out.println("Sum of Lengths Adding from Last to First");
		System.out.println(meter);
		System.out.println(inch);
		System.out.println(foot);
		System.out.println(yard);
	}
	
	/**
	 * This method will return an InputStream from the desired file in the resource folder.
	 * 
	 * @param file valid file in the the resource folder.
	 * @return IputStream get the desired file from the resource folder.
	 */
	public static InputStream getFileInputStream(String file) {
		return Lab4.class.getResourceAsStream("/resource/" + file);	
	}
	
	/**
	 * Closes the Input Stream that is used read from file.
	 * 
	 * @param myReader an opened BufferedReader
	 */
	public static void closeInputStream(BufferedReader myReader) {
		try {
			myReader.close();
		} catch (IOException e) {
			System.out.println("Problem closing the file.");
			e.printStackTrace();
		}
	}

	/**
	 * Compares string to a pattern to determine if the string is a number and returns a boolean value of true or false based on the comparison.
	 * 
	 * @param string a non-null String object.
	 * @return Returns a boolean, true if the string given is representative of a number and false if it does not.
	 */
	public static boolean isNumeric(String string) {
	  return string.matches("-?\\d+(\\.\\d+)?");
	}

}
