import java.io.File;
class FileDemo {
	static void p(String s){
		System.out.println(s);
	}

	public static void main(String args[]){
		File f1 = new File("test.txt");
		p("name file: " + f1.getName());
		p("path: " + f1.getPath());
		p("Absolut path: " + f1.getAbsolutePath());
		p("Parent path: " + f1.getParent());
		p(f1.exists() ? "yes" : "no");
		p(f1.canWrite() ? "write" : "not write");
		p(f1.canRead() ? "read" : "not read");
		p(f1.isDirectory() ? "catalog" : "no catalog");
		p(f1.isFile() ? "file" : "no file");
		p(f1.isAbsolute() ? "abslut" : "no absolut");
		p("Last write: " + f1.lastModified());
		p(" ==>: " + f1.length() + " b ");
	}
}
