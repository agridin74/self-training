import java.io.*;

class ByteArrayOutputStreamDemo {
	public static void main(String args[]){
		ByteArrayOutputStream f = new ByteArrayOutputStream();
		String s = "jjkasslkasjlasjlkasjdlkajsldkajsldjaldjlasjl";
		byte buf[] = s.getBytes();

		try{
			f.write(buf);
		}catch(IOException e){
			System.out.println("err write buffer");
			return;
		}
		System.out.println("==>>>>");
		System.out.println(f.toString());
		System.out.println("massiv");

		byte b[] = f.toByteArray();
		for(int i=0; i<b.length; i++) System.out.print((char) b[i]);
		System.out.println("\n ===>>>> ");
		try(FileOutputStream f2 = new FileOutputStream("test.txt")){
			f.writeTo(f2);
		}catch(IOException e){
			System.out.println("err read-write: " + e);
			return;
		}
		System.out.println("====>>>>>");
		f.reset();
		for(int i=0; i<3; i++) f.write('X');
		System.out.println(f.toString());
	}
}
