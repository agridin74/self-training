import java.net.*;
import java.io.*;
import java.util.Date;

class UCDemo {
	public static void main(String args[]) throws Exception{
		int c;
		URL hp = new URL("http://www.internic.net");
		URLConnection hpCon = hp.openConnection();

		long d = hpCon.getDate();
		if(d == 0)
			System.out.println("date not found");
		else
			System.out.println("Date: " + new Date(d));
		System.out.println("Content type: " + hpCon.getContentType());
		d = hpCon.getExpiration();
		if( d==0 )
			System.out.println("Expiration not found");
		else
			System.out.println("Expiration : " + new Date(d));

		d = hpCon.getLastModified();
		if( d==0 )
			System.out.println("Last modified not found");
		else
			System.out.println("Last modified: " + new Date(d));
		long len = hpCon.getContentLengthLong();
		if (len == -1)
			System.out.println("Content Length not found");
		else
			System.out.println("Content length: " + len);

		if(len != 0){
			System.out.println("=== Content ===");
			InputStream input = hpCon.getInputStream();
			while(((c = input.read()) != -1)){
				System.out.print((char) c);
			}
			input.close();
		} else {
			System.out.println("Content not found");
		}
	}

}
