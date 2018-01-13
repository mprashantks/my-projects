package hidden_specs_assignment;

import java.util.Scanner;

public class MainClass {
	static String filename = "numbers.txt";
	static String student_info = "student_info.csv";
	static String student_hobby = "student_hobby.txt";
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;
		do {
			System.out.print("\n1. Palindrome\n2. Count occurance\n3. Regular Expression\n4. File copy\n5. Count less than 3 characters word\n6. Exit\nEnter your choice(1-5): ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:		palindromeString();
							break;				
			case 2:		countOccurance();
							break;
			case 3:		regExp();
							break;
			case 4:		copyFile();
							break;
			case 5:		countWords();
							break;
			case 6:		repeat = false;
			}
		} while (repeat);
		sc.close();
		
	}
	
	public static void palindromeString() {
		String str = "nitin";
		Palindrome o = new Palindrome();
		System.out.println(o.isPalindrome(str));
	}
	
	public static void countOccurance() {
		Occurance o = new Occurance();
		String str = "The 14th Prime Minister of India is Narendra Modi. Narendra Modi was born 17 Sept 1950.";
		String key = "Narendra Modi";
		System.out.println(o.countOccurance(str, key));
	}
	
	public static void regExp() {
		Regex o = new Regex();
		String str = "The 14th Prime Minister of India is Narendra Modi. Narendra Modi was born 17 Sept 1950.";
		System.out.println("The sentences are: ");
		String sentences[] = o.getSentences(str);
		for (String sentence: sentences)
			System.out.println(sentence);
		System.out.println("Person name: "+o.getName(sentences[0])+"\nDate: "+o.getDate(sentences[1]));
	}
	
	public static void copyFile() {
		int num_threads = 5;
		Thread threads[] = new Thread[num_threads];
		for (int i=0; i<num_threads; i++ ) {
			String threadName = "Thread"+(i+1);
			String fileName = "file"+(i+1)+".txt";
			threads[i] = new Thread(new Filecopy(threadName, fileName));
			threads[i].start();
		}
		
		for (int i=0; i<num_threads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
	
	public static void countWords() {
		int num_threads = 5;
		Thread threads[] = new Thread[num_threads];
		for (int i=0; i<num_threads; i++ ) {
			String threadName = "Thread"+(i+1);
			String fileName = "file"+(i+1)+".txt";
			threads[i] = new Thread(new Countwords(threadName, fileName));
			threads[i].start();
		}
		
		for (int i=0; i<num_threads; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}	
	}
}
