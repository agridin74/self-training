import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class NIOCopy {
	public static void main(String args[]){
		if(args.length !=2 ){
			System.out.println("== arg1 arg2");
			return;
		}

		try{
			Path source = Paths.get(args[0]);
			Path target = Paths.get(args[1]);

			Files.copy(source, target,
								 StandardCopyOption.REPLACE_EXISTING);
		}catch(InvalidPathException e){
			System.out.println("err path " + e);
		} catch(IOException e){
			System.out.println("err read-write " + e);
		}
	}
}
