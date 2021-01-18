package christmas_exercises;

public class Exercise04 {

	public static void main(String[] args) {

		/*
		 * Program creates 2 matrices 4x4 program returns the sum of the matrices
		 */

		// setting up rng machine and matrix size
		final int MATRIX_SIZE = 4;
		java.util.Random rng = new java.util.Random();

		// initialising matrices
		int[][] firstMatrix = new int[MATRIX_SIZE][MATRIX_SIZE];
		int[][] secondMatrix = new int[MATRIX_SIZE][MATRIX_SIZE];
		int[][] matrixSum = new int[MATRIX_SIZE][MATRIX_SIZE];
		int[][][] matrices = { firstMatrix, secondMatrix, matrixSum };

		// populating matrices
		for (int i = 0; i < MATRIX_SIZE; i++) {
			for (int j = 0; j < MATRIX_SIZE; j++) {
				firstMatrix[i][j] = rng.nextInt(101);
				secondMatrix[i][j] = rng.nextInt(101);
				matrixSum[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
			}
		}

		// printing the matrices
		for (int i = 0; i < matrices.length; i++) {
			for (int j = 0; j < matrices[i].length; j++) {
				for (int k = 0; k < matrices[i][j].length; k++) {
					System.out.printf("%3d ", matrices[i][j][k]);
				}
				System.out.print("\n");
			}
			if (i == matrices.length - 2) {
				System.out.printf("\n%8s\n\n", "=");
			} else if (i < matrices.length - 1) {
				System.out.printf("\n%8s\n\n", "+");
			}
		}
	}

}
