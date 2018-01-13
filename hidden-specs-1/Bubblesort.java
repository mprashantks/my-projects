package hidden_specs_assignment;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Bubblesort {
	private ArrayList<Integer> array_list = new ArrayList<Integer>();
	
	Bubblesort (String filename) throws IOException {
		File file = new File(filename);
		Scanner sc = new Scanner(file);
		while (sc.hasNextInt()) {
			array_list.add(sc.nextInt());
		}
		sc.close();
	}
	
	void bubbleSort () {
		int size = array_list.size();
		boolean flag = true;
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size-i-1; j++)
				if (array_list.get(j) > array_list.get(j+1)) {
					int temp = array_list.get(j);
					array_list.set(j, array_list.get(j+1));
					array_list.set(j+1, temp);
					flag = true;
				}
			if (!flag)
				break;
		}
	}
	
	void displayArraylist () {
		for (int ele: array_list)
			System.out.print(ele+" ");
	}
}
