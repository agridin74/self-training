import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

class MyFileVisitor extends SimpleFileVisitor<Path> {
	public FileVisitResult visitFile(
			Path path, BasicFileAttributes attribs)
			  throws IOException{
				System.out.println(path);
				return FileVisitResult.CONTINUE;
			}

}


