import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

class DirList2 {
	public static void main(String args[]){
		String dirname="\\home";

		DirectoryStream.Filter<Path> how =
				  new DirectoryStream.Filter<Path>(){
				  	public boolean accept(Path filename) throws IOException{
							  if(Files.isWritable(filename)) return true;
							  return false;
						}
				  };

		try(DirectoryStream<Path> dirstrm =
				Files.newDirectoryStream(Paths.get(dirname), how)){
			System.out.println("Directory " + dirname);
			for(Path entry : dirstrm){
				BasicFileAttributes attribs = 
					Files.readAttributes(entry, BasicFileAttributes.class);
				if(attribs.isDirectory())
						  System.out.print("<DIR> ");
				else
						  System.out.print("      ");
				System.out.println(entry.getName(1));
			}		
		}catch(InvalidPathException e){
			System.out.println("err path " + e);
		}catch(NotDirectoryException e) {
			System.out.println(dirname + " not directory");
		} catch(IOException e) {
			System.out.println("err read-write: " + e);
		}
	}
}
