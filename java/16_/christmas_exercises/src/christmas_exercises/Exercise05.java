package christmas_exercises;

public class Exercise05 {

	/*
	 * Write an algorithm that cyclically fills a 2d array
	 * with values, starting from
	 * bottom right, bottom right ... centre.
	 * 
	 * e.g.
	 * 
	 * 9 10 11 12 13
	 * 8 21 22 23 14
	 * 7 20 25 24 15
	 * 6 19 18 17 16
	 * 5 4  3  2  1
	 * 
	 * input is two integers
	 */
	
	public static void main(String[] args) {
		
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
	}

	/**
	 * Method returns a matrix whose nRows = nColumns
	 * @param firstInteger
	 * @param secondInteger
	 * @return int[][]
	 */
	public static int[][] initialiseMatrix(int firstInteger, int secondInteger) {
		// setting up array size
		int numberOfNumbers = secondInteger - (firstInteger - 1);
		for (int i = 1; i <= numberOfNumbers; i++) {
			if (numberOfNumbers / i == i) {
				return new int[i][i];
			}
		}
		return new int[0][0];
	}
	
	/**
	 * Gets user input from console. Returns two ints stored in int[]
	 * whereby int[0] < int[1]
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
	
	public static void fillMatrix(int[][] matrix, int firstInteger, int secondInteger) {
		int column = matrix.length;
		int row = matrix[0].length;
		int currentNumber = firstInteger;
		
		for (int i = matrix.length; i < column || i > 0;) {
			for (int j = matrix[0].length; j < row || j > 0;) {
				matrix[i][j] = currentNumber++;
			}
		}
			

		}
		
	}
	
}
