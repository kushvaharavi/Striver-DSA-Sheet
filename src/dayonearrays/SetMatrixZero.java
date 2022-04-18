package dayonearrays;

import java.util.Arrays;

public class SetMatrixZero {
	
	/* Time Complexity : (N*M) + (N+M)
	 * Space Complexity: 0(1)
	 * */
	static void setZeroesUsingBruteForce(int[][] matrix) {
		int rows = matrix.length, cols = matrix[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {

					int ind = i - 1;
					while (ind >= 0) {
						if (matrix[ind][j] != 0) {
							matrix[ind][j] = -1;
						}
						ind--;
					}
					ind = i + 1;
					while (ind < rows) {
						if (matrix[ind][j] != 0) {
							matrix[ind][j] = -1;
						}
						ind++;
					}
					ind = j - 1;
					while (ind >= 0) {
						if (matrix[i][ind] != 0) {
							matrix[i][ind] = -1;

						}
						ind--;
					}
					ind = j + 1;
					while (ind < cols) {
						if (matrix[i][ind] != 0) {
							matrix[i][ind] = -1;

						}
						ind++;
					}
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] <= 0) {
					matrix[i][j] = 0;
				}
			}
		}

	}
	
	/* Time Complexity : (N*M + N*M)
	 * Space Complexity: 0(N) + 0(M)
	 * */
	static void setZeroesBeeterApproach(int [][] matrix) {
		  int rows = matrix.length, cols = matrix[0].length;
		  int dummy1[]=new int[rows];
		  int dummy2[]=new int[cols];
		  Arrays.fill(dummy1,-1);
		  Arrays.fill(dummy2,-1);
		  for (int i = 0; i < rows; i++) {
		    for (int j = 0; j < cols; j++) {
		      if (matrix[i][j] == 0) {
		        dummy1[i] = 0;
		        dummy2[j] = 0;
		      }
		    }

		  }
		  for (int i = 0; i < rows; i++) {
		    for (int j = 0; j < cols; j++) {
		      if (dummy1[i] == 0 || dummy2[j]==0) {
		        matrix[i][j] = 0;
		      }
		    }
		  }
		}

	/* Time Complexity : 2*(N*M)
	 * Space Complexity: 0(1)
	 * */
	static void setZeroesOptimized(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
	public static void main(String args[]) {
		int arr[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroesOptimized(arr);
		System.out.println("The Final Matrix is ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
