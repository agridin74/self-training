import java.net.*;
import java.io.*;
import java.util.*;

class HttpURLDemo {
	public static void main(String args[]) throws Exception {
		URL hp = new URL("http://www.google.com");
		HttpURLConnection hpCon = (HttpURLConnection) hp.openConnection();
		System.out.println("Method :" + hpCon.getRequestMethod());
		System.out.println("Response Code: " + hpCon.getResponseCode());
		Map<String, List<String>> hdrMap = hpCon.getHeaderFields();
		Set<String> hdrField = hdrMap.keySet();
		System.out.println("\n HEADER: ");
		for(String k : hdrField){
			System.out.println("Key: " + k + " Value: " + hdrMap.get(k));
		}
	}
}
