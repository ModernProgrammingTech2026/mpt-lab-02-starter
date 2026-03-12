

/**
 * Практика 2, Задание 3.1: print, transpose, multiply, diagonalSum.
 */
public class MatrixOperations {

    public static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.printf("%4d", cell);
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int aCols = a[0].length;
        int bRows = b.length;
        if (aCols != bRows) {
            System.out.println("Ошибка: несовместимые размеры для умножения матриц");
            return null;
        }
        int rows = a.length;
        int cols = b[0].length;
        int[][] c = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                for (int k = 0; k < aCols; k++) {
                    sum += a[i][k] * b[k][j];
                }
                c[i][j] = sum;
            }
        }
        return c;
    }

    public static int diagonalSum(int[][] matrix) {
        int sum = 0;
        int n = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] a = { {1, 2, 3}, {4, 5, 6} };
        int[][] b = { {7, 8}, {9, 10}, {11, 12} };

        System.out.println("Матрица A (2x3):");
        print(a);

        System.out.println("\nТранспонированная A (3x2):");
        print(transpose(a));

        System.out.println("\nМатрица B (3x2):");
        print(b);

        int[][] c = multiply(a, b);
        System.out.println("\nA * B (2x2):");
        print(c);

        System.out.println("\nСумма диагонали A*B: " + diagonalSum(c));
    }
}
