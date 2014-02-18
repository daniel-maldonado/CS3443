package lab3;

import java.util.HashMap;
import java.util.Map;


public class Date implements Comparable<Date> {
	private int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31,29};
	private String[] monthFull = {"January", "February", "March", "April", 
			"May", "June", "July", "August","September", "October", "November", "December"};
	
	private String month;
	private String day;
	private String year;
	
	public Date(String month, String day, String year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public boolean isValid(){
		if (!monthValid()) {
			return false;
		}
		
		if (!dayValid()) {
			return false;
		}
		
		return true;
	}
	
	public boolean monthValid() {
		int i = 0;
		while (i++ < monthFull.length - 1) {
			if(monthFull[i].contains(this.month)) {
				this.month = monthFull[i];
				return true;
			}
		}	
		return false;
	}
	
	public boolean dayValid() {
		int i = 0;
		while (i++ < monthFull.length - 1) {
			if(monthFull[i].contains(this.month)) {
				int day = Integer.parseInt(this.day);
				if (day > 0 && day <= daysInMonth[i]) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public int compareTo(Date arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String toString() {
		return "Date: " + this.month + " " + this.day + ", " + this.year;
	}

}
