
public class Student extends Person{
	private String major;

	public Student(String n, String m){
		super(n);
		major = m;
	}

	public String getDescription(){
		return "jsdkjaskjasdk "+ major;
	}
}
