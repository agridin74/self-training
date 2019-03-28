import java.util.*;
class GregorianCalendarDemo {
	public static void main(String args[]) {
		String mon[] = {
		"Jan", "Feb", "Mar", "Apr",
		"May", "Jun", "Jul", "Aug",
		"Sep", "Oct", "Nov", "Dec"
		};
		int year;
		GregorianCalendar gcal = new GregorianCalendar();
		System.out.print("Date: ");
		System.out.print(mon[gcal.get(Calendar.MONTH)]);
		System.out.print(" " + gcal.get(Calendar.DATE) + " ");
		System.out.println(year = gcal.get(Calendar.YEAR));

		System.out.print("Time: ");
		System.out.print(gcal.get(Calendar.HOUR) + ":");
		System.out.print(gcal.get(Calendar.MINUTE) + ":");
		System.out.println(gcal.get(Calendar.SECOND));

		if(gcal.isLeapYear(year)){
			System.out.println("Leap");
		}else{
			System.out.println("No Leap");
		}
	}
}
