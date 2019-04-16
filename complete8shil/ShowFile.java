import java.io.*;
import java.nio.file.*;

class ShowFile {
	public static void main(String args[]){
		int i;
		if(args.length != 1) {
			System.out.println("==>>> ShowFile name");
			return;		
		}

		try(InputStream fin = Files.newInputStream(Paths.get(args[0]))){
			do{
				i = fin.read();
				if(i != -1) System.out.print((char) i);
			}while(i != -1);
		
		}catch(InvalidPathException e){
			System.out.println("err path " + e);
		}catch(IOException e){
			System.out.println("err read-write " + e);
		}
	}
}
