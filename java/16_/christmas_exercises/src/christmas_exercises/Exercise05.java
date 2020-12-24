package christmas_exercises;

public class Exercise05 {

	/*
	 * Write an algorithm that cyclically fills a 2d array with values, starting
	 * from bottom right, bottom right ... centre.
	 * 
	 * e.g.
	 * 
	 * 9 10 11 12 13 8 21 22 23 14 7 20 25 24 15 6 19 18 17 16 5 4 3 2 1
	 * 
	 * input is two integers
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
		} while (circulantMatrix.length == 0);
		
		fillMatrix(circulantMatrix, firstInteger, secondInteger);
		printMatrix(circulantMatrix);
	}

	/**
	 * Method returns a matrix whose nRows * nColumns ~ n
	 * 
	 * @param firstInteger
	 * @param secondInteger
	 * @return int[][]
	 */
	public static int[][] initialiseMatrix(int firstInteger, int secondInteger) {
		// setting up array size
		int numberOfNumbers = secondInteger - (firstInteger - 1);
		int matrixSize = (int) Math.sqrt(numberOfNumbers);
		if (matrixSize * matrixSize >= numberOfNumbers)
			return new int[matrixSize][matrixSize];
		else if (matrixSize * (matrixSize + 1) >= numberOfNumbers)
			return new int[matrixSize][matrixSize + 1];
		else
			return new int[matrixSize + 1][matrixSize + 1];
	}

	/**
	 * Gets user input from console. Returns two ints stored in int[] whereby int[0]
	 * < int[1]
	 * 
	 * @return int[]
	 */
	public static int[] getUserInput() {
		// getting input from user
		java.util.Scanner input = new java.util.Scanner(System.in);
		int[] temp = new int[2];
		System.out.print("Please enter the first integer: ");
		temp[0] = input.nextInt();
		System.out.print("Please enter the second integer: ");
		temp[1] = input.nextInt();
		input.close();

		// validating input
		if (temp[0] > temp[1]) {
			int tempInt = temp[0];
			temp[0] = temp[1];
			temp[1] = tempInt;
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
	public static void fillMatrix(int[][] matrix, int firstInteger, int secondInteger) {
		int maxColumn = matrix.length - 1, minColumn = 0;
		int maxRow = matrix[0].length - 1, minRow = 0;
		int currentNumber = firstInteger;

		while (currentNumber <= secondInteger) {
			// L->R
			for (int j = maxRow; j >= minRow; j--) {
				matrix[maxColumn][j] = currentNumber++;
				if (currentNumber > secondInteger)
					return;
			}
			maxColumn--;

			// D->U
			for (int i = maxColumn; i >= minColumn; i--) {
				matrix[i][minRow] = currentNumber++;
				if (currentNumber > secondInteger)
					return;
			}
			minRow++;

			//R->L
			for (int j = minRow; j <= maxRow; j++) {
				matrix[minColumn][j] = currentNumber++;
				if (currentNumber > secondInteger)
					return;
			}
			minColumn++;

			//U->D
			for (int i = minColumn; i <= maxColumn; i++) {
				matrix[i][maxRow] = currentNumber++;
				if (currentNumber > secondInteger)
					return;
			}
			maxRow--;
		}
	}

	/**
	 * Prints a 2d matrix to console.
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
