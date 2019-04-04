import java.io.*;

class FileInputStreamDemo {
	public static void main(String args[]){
		int size;
		try(FileInputStream f =
				new FileInputStream("FileInputStreamDemo.java")){
			System.out.println(" count byte: "+(size = f.available()));
			int n = size/40;
			System.out.println("1-> " + n + " byte," + " read");
			for(int i=0; i < n; i++) {
				System.out.print((char) f.read());
			}
			System.out.println("\n =>> " + f.available());

			System.out.println(" =>> "+ n);
			byte b[] = new byte[n];
			if(f.read(b) != n) {
				System.err.println("err " + n);
			}
			System.out.println(new String(b, 0, n));
			System.out.println("\n =>> "+ (size = f.available()));
			System.out.println("skip ");
			f.skip(size/2);
			System.out.println("=> " + f.available());
			System.out.println("Read " + n/2 +" byte");
			if(f.read(b, n/2, n/2) != n/2){
				System.err.println(" err "+n/2);
			}
			System.out.println(new String(b, 0, b.length));
			System.out.println("\n => "+f.available());
		}catch(IOException e){
			System.out.println(" err "+e);
		}
	}
}
