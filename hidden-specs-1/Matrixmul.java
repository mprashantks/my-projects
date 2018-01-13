package hidden_specs_assignment;

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Matrixmul {
	private int row = 5;
	private int col = 5;
	
	void genrateMatrix () throws IOException{
		Random rand = new Random();
		File file1 = new File("matrix1.txt");
		File file2 = new File("matrix2.txt");
		Writer wr1 = null;
		Writer wr2 = null;
		
		try {
			wr1 = new FileWriter(file1);
			wr2 = new FileWriter(file2);
			for (int i=0; i<row; i++) {
				for (int j=0; j<col; j++) {
					int n1 = rand.nextInt(10) + 1;
					int n2 = rand.nextInt(10) + 1;
					wr1.write(String.valueOf(n1)+" ");
					wr2.write(String.valueOf(n2)+" ");
				}
				wr1.write("\r\n");
				wr2.write("\r\n");
			}
		} finally {
			if (wr1 != null)
				wr1.close();
			if (wr2 != null)
				wr2.close();
		}
	}
	
	void matrixMul() throws IOException{
		File file1 = new File("matrix1.txt");
		File file2 = new File("matrix2.txt");
		Scanner sc1 = new Scanner(file1);
		Scanner sc2 = new Scanner(file2);
		
		int arr1[][] = new int[row][col];
		int arr2[][] = new int[row][col];
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				arr1[i][j] = sc1.nextInt();
				arr2[i][j] = sc2.nextInt();
			}
		}
		sc1.close();
		sc2.close();
		
		int product[][] = new int[row][col];
		for (int i=0; i<row; i++)
			for (int j=0; j<col; j++)
				for (int k=0; k<col; k++)
					product[i][j] += arr1[i][k]*arr2[k][j];
		
		File file = new File("product.txt");
		Writer wr = null;
		try {
			wr = new FileWriter(file);
			for (int i=0; i<row; i++) {
				for (int j=0; j<col; j++)
					wr.write(String.valueOf(product[i][j]+" "));
				wr.write("\r\n");
			}
		} finally {
			if (wr != null)
				wr.close();
		}
		
		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++)
				System.out.print(product[i][j]+"\t");
			System.out.println();
		}
	}
}
