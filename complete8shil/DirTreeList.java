import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

class MyFileVisitor extends SimpleFileVisitor<Path>{
	public FileVisitResult visitFile(Path path, BasicFileAttributes attribs)
			  throws IOException{
		System.out.println(path);
		return FileVisitResult.CONTINUE;
	}
}

class DirTreeList {
	public static void main(String args[]){
		String dirname ="\\";
		System.out.println("Dir tree " + dirname + ":\n");
		try{
			Files.walkFileTree(Paths.get(dirname), new MyFileVisitor());
		}catch(IOException exc){
			System.out.println("Err read-write" + exc);
		}
	}
}
