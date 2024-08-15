import java.util.Scanner;

public class Matrixsum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số dòng của ma trận A: ");
        int rowsA = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận A: ");
        int colsA = scanner.nextInt();
        System.out.print("Nhập số dòng của ma trận B: ");
        int rowsB = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận B: ");
        int colsB = scanner.nextInt();
        if (rowsA != rowsB || colsA != colsB) {
            System.out.println("Không thể thực hiện.");
        } else {
            int[][] matrixA = new int[rowsA][colsA];
            int[][] matrixB = new int[rowsA][colsA];
            System.out.println("\nNhập giá trị phần tử ma trận A:");
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsA; j++) {
                    System.out.print("Nhập phần tử A[" + i + "][" + j + "]:" + "\t");
                    matrixA[i][j] = scanner.nextInt();
                }
            }
            System.out.println("\nNhập giá trị phần tử ma trận B:");
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsA; j++) {
                    System.out.print("Nhập phần tử B[" + i + "][" + j + "]:" + "\t");
                    matrixB[i][j] = scanner.nextInt();
                }
            }
            System.out.println("\nMa trận A:");
            displayMatrixA(matrixA);
//            for (int i = 0; i < rowsA; i++) {
//                for (int j = 0; j < colsA; j++) {
//                    System.out.print(matrixA[i][j] + "\t");
//                }
//                System.out.println();
//            }
            System.out.println("\nMa trận B:");
//            for (int i = 0; i < rowsA; i++) {
//                for (int j = 0; j < colsA; j++) {
//                    System.out.print(matrixB[i][j] + "\t");
//                }
//                System.out.println();
//            }
            displayMatrixB(matrixB);
            int[][] matrixSum = new int[rowsA][colsA];
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsA; j++) {
                    matrixSum[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
            System.out.println("\nTổng của hai ma trận A và B là:");
//            for (int i = 0; i < rowsA; i++) {
//                for (int j = 0; j < colsA; j++) {
//                    System.out.print(matrixSum[i][j] + "\t");
//                }
//                System.out.println();
//            }
            displayMatrixSum(matrixSum);
        }
        scanner.close();
    }
    public static void displayMatrixA(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void displayMatrixB(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void displayMatrixSum(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
