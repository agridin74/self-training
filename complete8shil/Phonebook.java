import java.io.*;
import java.util.*;

class Phonebook {
	public static void main(String args[]) throws IOException {
		Properties ht = new Properties();
		BufferedReader br = new BufferedReader(
							 	  new InputStreamReader(System.in));
		String name, number;
		FileInputStream fin = null;
		boolean changed = false;
		try {
			fin = new FileInputStream("phonebook.dat");
		}catch(FileNotFoundException e){
		
		}

		try{
			if(fin != null){
				ht.load(fin);
				fin.close();
			}
		}catch(IOException e){
			System.out.println("Error read file");
		}

		do{
			System.out.println("==>Input name  'quit'-exit :");
			name = br.readLine();
			if(name.equals("quit")) continue;
			System.out.println("Input number: ");
			number = br.readLine();
			ht.put(name, number);
			changed = true;
		}while(!name.equals("quit"));

		if(changed){
			FileOutputStream fout = new FileOutputStream("phonebook.dat");
			ht.store(fout, "Telefon book");
			fout.close();
		}
		do{
			System.out.println("find ('quit')=>>");
			name = br.readLine();
			if(name.equals("quit")) continue;
			number = (String) ht.get(name);
			System.out.println(number);
		}while(!name.equals("quit"));
	}
}
