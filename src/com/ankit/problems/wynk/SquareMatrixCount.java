package com.ankit.problems.wynk;

import java.io.IOException;
import java.util.Scanner;

/**
 * M x N matrix with 0 or 1
 * Count total no of squares created by 0
 * 0 itself is a square
 * so for 0 0 0
 *        0 0 0
 *        0 0 0
 * Count is 14 = 9+4+1 
 * @author ankit
 *
 */
public class SquareMatrixCount {

	static int squaresCount(int[][] mat) {
		int count = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				int length = 1;
				while (isSquareNodes(mat, i, j, length)) {
					count++;
					length++;
				}
				System.out.println("j ends");
			}
			System.out.println("i ends");
		}
		return count;
	}

	static boolean isSquareNodes(int[][] mat, int i, int j, int length) {
		if (i + length - 1 >= mat.length) {
			return false;
		}
		if (j + length - 1 >= mat[i].length) {
			return false;
		}
		for (int k = 0; k < length; k++) {
			System.out.println(i+":"+j+":"+k+":"+length);
			if (mat[i + length - 1][j + k] != 0) {

				return false;

			}

			if (mat[i + k][j + length - 1] != 0) {

				return false;

			}

		}

		if (mat[i + length - 1][j + length - 1] == 0) {

			return true;

		} else {

			return false;

		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int matRows = 3;// scanner.nextInt();

		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int matColumns = 3;// scanner.nextInt();

		// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int[][] mat = new int[matRows][matColumns];

		for (int matRowItr = 0; matRowItr < matRows; matRowItr++) {

			String[] matRowItems = scanner.nextLine().split(" ");

			// scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

			for (int matColumnItr = 0; matColumnItr < matColumns; matColumnItr++) {

				int matItem = Integer.parseInt(matRowItems[matColumnItr]);

				mat[matRowItr][matColumnItr] = matItem;

			}

		}

		int res = squaresCount(mat);

		System.out.println(res);

		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();

	}
}
