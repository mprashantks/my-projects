package hidden_specs_assignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class Filecopy implements Runnable {
	private String threadName;
	private String fileName;
	
	Filecopy(String tname, String filename) {
		threadName = tname;
		fileName = filename;
		System.out.println("Creating thread: "+threadName+" on file: "+fileName);
	}
	
	void copyFile() throws IOException{
		InputStream input = null;
		OutputStream output = null;		
		try {
			input = new FileInputStream(fileName);
			output = new FileOutputStream("copy.txt", true);
			byte[] buf = new byte[1024];
			int bytesRead;
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
		} finally {
			if (input != null)
				input.close();
			if (output != null)
				output.close();
		}
	}
	
	public void run() {
		System.out.println("Running "+threadName+" on "+fileName);
		 try {
			 // To prevent clatter of file during writing, file is copied in one go
	         copyFile();
	      } catch (IOException e) {
	         System.out.println("Thread " +  threadName + " | " + e);
	      }
	      System.out.println("Thread " +  threadName + " on " + fileName + " exiting.");
	}
}
