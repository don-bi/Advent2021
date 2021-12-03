import java.util.*;
import java.io.*;

public class code {
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    public static void partOne(){
        int count = 0;
        try {
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            int n = scan.nextInt();
            int a;
            while (scan.hasNextInt()) {
                a = scan.nextInt();
                if (a > n) {
                    count ++;
                }
                n = a;
            }
            scan.close();
            System.out.println(count);
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    public static void partTwo(){
        int count = 0;
        try {
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            int[] window = new int[3];
            window[0] = scan.nextInt();
            window[1] = scan.nextInt();
            window[2] = scan.nextInt();
            int sum = sum(window);
            int n;
            int i = 0;
            while (scan.hasNextInt()) {
                window[i] = scan.nextInt();
                n = sum(window);
                System.out.println(sum + " " + n);
                if (n > sum) {
                    count ++;
                }
                sum = n;
                i++;
                if (i == 3) {
                    i = 0;
                }
            }
            scan.close();
            System.out.println(count);
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    public static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
