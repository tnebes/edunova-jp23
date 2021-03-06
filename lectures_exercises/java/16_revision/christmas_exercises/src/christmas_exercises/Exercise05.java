package christmas_exercises;

import java.util.InputMismatchException;

public class Exercise05 {

	/*
	 * Write an algorithm that cyclically fills a 2d array with values, starting
	 * from bottom right, bottom right ... centre.
	 * 
	 * e.g.
	 * 
	 * 9 10 11 12 13
	 * 8 21 22 23 14
	 * 7 20 25 24 15
	 * 6 19 18 17 16
	 * 5 4  3  2  1
	 * 
	 * input is two integers representing the width and height of the matrix
	 */

	public static void main(String[] args) {

		// declare the matrix and the input numbers
		int[][] circulantMatrix;
		int firstInteger, secondInteger;

		do {
			// get user input
			int[] temp = getUserInput();
			firstInteger = temp[0];
			secondInteger = temp[1];
			// initialise the matrix
			circulantMatrix = initialiseMatrix(firstInteger, secondInteger);
		} while (circulantMatrix.length == 0 || circulantMatrix[0].length == 0);

		fillMatrix(circulantMatrix);
		printMatrix(circulantMatrix);
	}

	/**
	 * Method returns a matrix with height = firstInteger, width = secondInteger
	 * 
	 * @param firstInteger
	 * @param secondInteger
	 * @return int[][]
	 */
	public static int[][] initialiseMatrix(int firstInteger, int secondInteger) {
		// setting up array size
		if (firstInteger < 0 || secondInteger < 0) {
			System.out.print("Width and height must be whole numbers.\n");
			return new int[0][0];
		} else {
			return new int[firstInteger][secondInteger];
		}
	}

	/**
	 * Gets user input from console. Returns two ints stored in int[] 
	 * 
	 * @return int[]
	 */
	public static int[] getUserInput() {
		// getting input from user
		java.util.Scanner input = new java.util.Scanner(System.in);
		int[] temp = new int[2];
		try {
			System.out.print("Please enter matrix height: ");
			temp[0] = input.nextInt();
			System.out.print("Please enter matrix width: ");
			temp[1] = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.print("Input must be an integer.\n");
			return getUserInput();
		}
		return temp;
	}

	/**
	 * Fills a matrix starting from [max][max] spiralling towards centre
	 * anticlockwise.
	 * 
	 * @param matrix
	 * @param firstInteger
	 * @param secondInteger
	 */
	public static void fillMatrix(int[][] matrix) {
		int maxColumn = matrix.length - 1, minColumn = 0;
		int maxRow = matrix[0].length - 1, minRow = 0;
		int currentNumber = 1, desiredNumber = matrix.length * matrix[0].length;

		while (currentNumber <= desiredNumber) {
			// L->R
			for (int j = maxRow; j >= minRow; j--) {
				matrix[maxColumn][j] = currentNumber++;
				if (currentNumber > desiredNumber)
					return;
			}
			maxColumn--;

			// D->U
			for (int i = maxColumn; i >= minColumn; i--) {
				matrix[i][minRow] = currentNumber++;
				if (currentNumber > desiredNumber)
					return;
			}
			minRow++;

			// R->L
			for (int j = minRow; j <= maxRow; j++) {
				matrix[minColumn][j] = currentNumber++;
				if (currentNumber > desiredNumber)
					return;
			}
			minColumn++;

			// U->D
			for (int i = minColumn; i <= maxColumn; i++) {
				matrix[i][maxRow] = currentNumber++;
				if (currentNumber > desiredNumber)
					return;
			}
			maxRow--;
		}
	}

	/**
	 * Prints a 2d matrix to console.
	 * 
	 * @param matrix
	 */
	public static void printMatrix(int[][] matrix) {
		for (int[] i : matrix) {
			for (int j : i) {
				System.out.printf("%3d ", j);
			}
			System.out.print("\n");
		}
	}

}
