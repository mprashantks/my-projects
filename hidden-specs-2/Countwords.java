package hidden_specs_assignment;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class Countwords implements Runnable {
	private String threadName;
	private String fileName;
	
	Countwords(String tname, String filename) {
		threadName = tname;
		fileName = filename;
		// System.out.println("Creating thread: "+threadName+" on file: "+fileName);
	}
	
	void countWords() throws IOException{
		Scanner sc = null;
		try {
			sc = new Scanner(new FileInputStream(fileName));
			while (sc.hasNext()) {
				String word = sc.next();
				if (word.length() < 3)
					System.out.print(word+"\t");
			}
		} finally {
			if (sc != null)
				sc.close();
		}
	}
	
	public void run() {
		// System.out.println("Running "+threadName+" on "+fileName);
		try {
	        countWords();
	    } catch (IOException e) {
	    	System.out.println("Thread " +  threadName + " | " + e);
	    }
		// System.out.println("Thread " +  threadName + "on " + fileName + " exiting.");
	}
}
