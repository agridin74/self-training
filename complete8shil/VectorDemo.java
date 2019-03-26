import java.util.*;

class VectorDemo{
	public static void main(String args[]){
		Vector<Integer> v = new Vector<Integer>(3, 2);
		System.out.println("size => " + v.size());
		System.out.println("capacity => " + v.capacity());
		v.addElement(1);
		v.addElement(2);
		v.addElement(3);
		v.addElement(4);

		System.out.println("capacity => " + v.capacity());
		v.addElement(5);
		System.out.println("capacity => " + v.capacity());

		v.addElement(6);
		v.addElement(7);
		System.out.println("capacity =>" + v.capacity());

		v.addElement(9);
		v.addElement(10);

		System.out.println("capacity => " + v.capacity());

		v.addElement(11);
		v.addElement(12);
		System.out.println("first: " + v.firstElement());
		System.out.println("last:" + v.lastElement());
		if(v.contains(3))
				  System.out.println("=> 3");
		Enumeration<Integer> eNum = v.elements();
		System.out.println("\n elements: ");
		while(eNum.hasMoreElements())
				  System.out.print(eNum.nextElement() + " ");
		System.out.println();

		Iterator<Integer> vItr = v.iterator();
		System.out.println("=====>");
		while(vItr.hasNext())
			System.out.print(vItr.next()+" ");
		System.out.println();

		System.out.println("\n for each:");
		for(int i : v)
			System.out.print(i + " ");
		System.out.println();

	}
}
