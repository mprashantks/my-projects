package hidden_specs_assignment;

import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class MainClass {
	static String filename = "numbers.txt";
	static String student_info = "student_info.csv";
	static String student_hobby = "student_hobby.txt";
	
	public static void main(String args[]) {		
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;
		do {
			System.out.print("\n1. Bubble Sort\n2. Maximum and Minimum\n3. Matrix multiplication\n4. HashMap\n5. Exit\nEnter your choice(1-5): ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:		bubbleSort();
							break;				
			case 2:		maxMin();
							break;
			case 3:		matrixMul();
							break;
			case 4:		try {
							hashMap();
							} catch (Exception e) {
								System.out.println(e);
							}
							break;
			case 5:		repeat = false;
			}
		} while (repeat);
		sc.close();
	}
	
	public static void bubbleSort() {
		try {
			Bubblesort o = new Bubblesort(filename);
			o.bubbleSort();
			o.displayArraylist();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void maxMin() {
		try {
			Maxmin o = new Maxmin(filename);
			o.maxMin();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void matrixMul() {
		Matrixmul o =new Matrixmul();
		try {
			o.genrateMatrix();
			o.matrixMul();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public static void hashMap() throws IOException{
		HashMap<Student, List<String>> student_map = new HashMap<Student, List<String>>();
		BufferedReader br1 = new BufferedReader(new FileReader(student_info));
		String student_bio = br1.readLine();
		BufferedReader br2 = new BufferedReader(new FileReader(student_hobby));
		String student_hob;
		
		while ((student_bio = br1.readLine()) != null && !student_bio.isEmpty() && (student_hob = br2.readLine()) != null && !student_hob.isEmpty()) {
			String fields_bio[] = student_bio.split(",");
			String fields_hob[] = student_hob.split("\t");
			String fields_hobby[] = fields_hob[1].split(",");
			
			boolean flag = true;
			for (Student key: student_map.keySet()) {
				if (key.getRollno() != Integer.parseInt(fields_bio[0]))
					flag = true;
				else if (key.getRollno() == Integer.parseInt(fields_bio[0])){
					flag = false;
					break;
				}
			}
		
			if (flag) {
				Student student = new Student(Integer.parseInt(fields_bio[0]), fields_bio[1], fields_bio[2]);
				List<String> ls = new ArrayList<String>();
				for (String hobby: fields_hobby)
					ls.add(hobby);
				student_map.put(student, ls);
			}
		}
		br1.close();
		br2.close();
		
		for (Student key: student_map.keySet()) {
			System.out.printf("%-66s%-66s\n", key, student_map.get(key));
		}		
	}
}
