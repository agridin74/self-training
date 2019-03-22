import java.util.*;
class Address {
	private String name;
	private String street;
	private String city;
	private String state;
	private String code;

	Address(String n, String s, String c, String st, String cd){
		name = n;
		street = s;
		city = c;
		state = st;
		code = cd;


	}

	public String toString() {
		return name + "\n" + street + "\n" +
				  city + " " + state + " " + code;
	}
}

class MailList {
	public static void main(String args[]) {
		LinkedList<Address> ll = new LinkedList<Address>();
		ll.add(new Address("sdfsdfsd","sfdfsdf","fdgsdsdf","hgjas","23123"));
		ll.add(new Address("dsfsdf","wqeqwe","qweqweqw","axz","23123"));
		ll.add(new Address("lklkkl","ytryututu","bnnbvnv","ghf","87687"));

		for(Address el : ll)
				  System.out.println(el + "\n");
		System.out.println();
	}
}
