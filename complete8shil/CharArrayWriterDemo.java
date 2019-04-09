import java.io.*;

class CharArrayWriterDemo {
	public static void main(String args[]) throws IOException {
		CharArrayWriter f = new CharArrayWriter();
		String s = "dshksdhkjsdhkjsdhksdhkjsdhkjhsdkhfsdkjfh";
		char buf[] = new char[s.length()];
		s.getChars(0, s.length(), buf, 0);
		try{
			f.write(buf);
		}catch(IOException e){
			System.out.println("err write buf");
			return;
		}

		System.out.println("Buffer v vide str");
		System.out.println(f.toString());
		System.out.println("V massiv");

		char c[] = f.toCharArray();
		for(int i=0; i<c.length; i++){
			System.out.print(c[i]);
		}

		System.out.println("\n ===>>>> FileWriter()");

		try(FileWriter f2 = new FileWriter("test.txt")){
			f.writeTo(f2);
		}catch(IOException e){
			System.out.println("err read-write: "+e);
		}
		System.out.println("ish ===>>>");
		f.reset();
		for(int i=0; i<3; i++) f.write('X');

		System.out.println(f.toString());
	}
}
