import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

class PathDemo {
	public static void main(String args[]){
		Path filepath = Paths.get("test.txt");
		System.out.println("name file: "+ filepath.getName(0));
		System.out.println("path file: "+ filepath);
		System.out.println("abs path: "+ filepath.toAbsolutePath());
		System.out.println("parent path: " + filepath.getParent());

		if(Files.exists(filepath))
				  System.out.println("file exists");
		else
				  System.out.println("file not exists");

		try{
			if(Files.isHidden(filepath))
					  System.out.println("file hidden");
			else
					  System.out.println("file not hidden");
		}catch(IOException e){
			System.out.println("err read-write: " + e);
		}

		Files.isWritable(filepath);
		System.out.println("file write");
		Files.isReadable(filepath);
		System.out.println("file read");

		try{
			BasicFileAttributes attribs =
					  Files.readAttributes(filepath, BasicFileAttributes.class);
			if(attribs.isDirectory())
					  System.out.println("is directory");
			else
					  System.out.println("is not directory");
			if(attribs.isRegularFile())
					  System.out.println("is file");
			else
					  System.out.println("is not file");
			if(attribs.isSymbolicLink())
					  System.out.println("symbolic");
			else
					  System.out.println("not symbolic");

			System.out.println("last modify " + attribs.lastModifiedTime());
			System.out.println("size: " + attribs.size() + " byte");
		}catch(IOException e){
			System.out.println("err attrib " + e);
		}
	}
}
