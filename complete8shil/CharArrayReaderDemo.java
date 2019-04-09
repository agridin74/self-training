import java.io.*;
public class CharArrayReaderDemo {
	public static void main (String args[]) {
		String tmp = "ashdgjahsdgjahsgdjasgdjha";
		int length = tmp.length();
		char c[] = new char[length];
		tmp.getChars(0, length, c, 0);
		int i;

		try(CharArrayReader input1 = new CharArrayReader(c)){
			System.out.println("input1: ");
			while((i = input1.read()) != -1){
				System.out.print((char) i);
			}
			System.out.println();
		}catch(IOException e){
			System.out.println("err read-write: "+ e);
		}

		try(CharArrayReader input2 = new CharArrayReader(c, 0, 5)){
			System.out.println("input2: ");
			while((i = input2.read()) != -1){
				System.out.print((char)i);
			}
			System.out.println();
		}catch(IOException e){
			System.out.println("Err read-write: " + e);
		}
	}

}
