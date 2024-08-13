import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Mời bạn nhập số nguyên n: ");
//        int n = scanner.nextInt();
//        int arr[] = new int[n];
//        for (int i=0; i < n; i++){
//            System.out.println("Nhập phần tử thứ "+(i+1) );
//            int a = scanner.nextInt();
//            arr[i] = a;
//            System.out.println(arr[i]);
//        }
//        int[][] arr = new int[2][3];
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.println("Moi b nhap gia tri arr[" + i + "][" + j + "]");
//                arr[i][j] = scanner.nextInt();
//            }
//        }
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.println(arr[" + i + "][" + j + "]= " + arr[i][j]);
//            }
//        }
//        System.out.println("Nhap so hang: ");
//        int m = scanner.nextInt();
//        System.out.println("Nhap so cot: ");
//        int n = scanner.nextInt();
//        int arr[][] = new int[m][n];
//        for (int i =0; i<m; i++){
//            for (int j =0; j<n; j++){
//                System.out.print("Nhap phan tu arr["+i+"]["+j+"]:"+"\t");
//                arr[i][j] = scanner.nextInt();
//            }
//        }
//        int sum = 0;
//        for (int i =0; i<m; i++) {
//            for (int j = 0; j < n; j++) {
//                sum += arr[i][j];
//            }
//        }
//        System.out.println("Tong la: "+sum);
        System.out.println("Nhap so hang va cot ma tran A: ");
        int r1 = Integer.parseInt(scanner.nextLine());
        int c1 = Integer.parseInt(scanner.nextLine());
        int[][] A = new int[r1][c1];
        System.out.println("Nhap so hang va cot ma tran B: ");
        int r2 = Integer.parseInt(scanner.nextLine());
        int c2 = Integer.parseInt(scanner.nextLine());
        int[][] B = new int[r2][c2];
        if (r1 != r2 && c1 != c2) {
            System.out.println("K the thuc hien.");
        }
        System.out.println("Nhap gia tri ma tran A:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.print("Nhap phan tu A[" + i + "][" + j + "]:" + "\t");
                A[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Nhap gia tri ma tran B:");
        for (int m = 0; m < r2; m++) {
            for (int n = 0; n < c1; n++) {
                System.out.print("Nhap phan tu B[" + m + "][" + n + "]:" + "\t");
                B[m][n] = scanner.nextInt();
            }
        }
        System.out.println("Các gia tri ma tran A:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                System.out.print(A[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("\nCác gia tri ma tran B:");
        for (int m = 0; m < r2; m++) {
            for (int n = 0; n < c1; n++) {
                System.out.print(B[m][n]+"\t");
            }
            System.out.println();
        }
//        int[][] resultMatix = new int[c1][r1];
//        for (int i = 0; i < r1; i++) {
//            for (int j = 0; j < r1; j++) {
//                resultMatix[i][j] = A[i][j] + B[m][n];
//            }
    }
}