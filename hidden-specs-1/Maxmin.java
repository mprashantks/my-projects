package hidden_specs_assignment;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Maxmin {
	private ArrayList<Integer> array_list = new ArrayList<Integer>();
	
	Maxmin (String filename) throws IOException {
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		while (sc.hasNextInt()) {
			array_list.add(sc.nextInt());
		}
		sc.close();
	}
	
	void maxMin () {
		int max, min;
		max = min = array_list.get(0);
		
		for (int ele: array_list) {
			if (ele > max)
				max = ele;
			if (ele < min)
				min = ele;
		}
		
		System.out.print("Maximum number: "+max+"\nMinimum number: "+min);
	}
}
