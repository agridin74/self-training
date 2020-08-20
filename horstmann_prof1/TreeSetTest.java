import java.util.*;

public class TreeSetTest{
	public static void main(String[] args){
		SortedSet<Item> parts = new TreeSet<>();
		parts.add(new Item("Item1",1234));
		parts.add(new Item("Item99",4562));
		parts.add(new Item("Item3",9912));
		System.out.println(parts);
		SortedSet<Item> sortByDescription = new TreeSet<>(
			new Comparator<Item>(){
				public int compare(Item a, Item b){
					String descrA = a.getDescription();
					String descrB = b.getDescription();
					return descrA.compareTo(descrB);
				}
			}
							 );
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
	}
}

class Item implements Comparable<Item> {
	private String description;
	private int partNumber;

	public Item(String aDescription, int aPartNumber){
		description = aDescription;
		partNumber = aPartNumber;
	}

	public String getDescription(){
		return description;
	}

	public String toString(){
		return "[description=" +description +", partNumber="+partNumber+"]";
	}

	public boolean equals(Object otherObject){
		if(this == otherObject) return true;
		if(otherObject == null) return false;
		if(getClass() != otherObject.getClass()) return false;
		Item other = (Item) otherObject;
		return Objects.equals(description, other.description) &&
				  partNumber == other.partNumber;
	}

	public int hashCode(){
		return Objects.hash(description, partNumber);
	}

	public int compareTo(Item other){
		return Integer.compare(partNumber, other.partNumber);
	}
}
