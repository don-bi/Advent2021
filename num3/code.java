import java.util.*;
import java.io.*;

public class code {
    public static void main(String[] args) {
        partOne();
        partTwo();
    }

    public static void partOne(){
        try {
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            ArrayList<String> data = new ArrayList<String>();
            int[] bits = new int[12];
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
            for (int i = 0; i < data.size(); i ++) {
                for (int k = 0; k < data.get(i).length(); k ++) {
                    if (data.get(i).charAt(k) == '1') {
                        bits[k] ++;
                    }
                }
            }
            scan.close();
            System.out.println(binaryMaker(bits));
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    public static String binaryMaker(int[] ary) {
        String binary = "";
        String binary2 = "";
        for (int i = 0; i < ary.length; i ++) {
            if (ary[i] > (1000 - ary[i])) {
                binary += 1;
            } else {
                binary += 0;
            }
        }
        for (int i = 0; i < binary.length(); i ++) {
            if (binary.charAt(i) == '1') {
                binary2 += 0;
            } else {
                binary2 += 1;
            }
        }
        return binary + " " + binary2;
    }

    public static void partTwo(){
        try {
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            ArrayList<String> data = new ArrayList<String>();
            while (scan.hasNextLine()) {
                data.add(scan.nextLine());
            }
            scan.close();
            System.out.println(oxygenRating(data) + " " + carbonRating(data));
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    public static char bigBitFinder(int position, ArrayList<String> data) {
        int ones = 0;
        for (int i = 0; i < data.size(); i ++) {
            if (data.get(i).charAt(position) == '1') {
                ones ++;
            }
        }
        if (ones >= data.size() - ones) {
            return '1';
        } else {
            return '0';
        }
    }

    public static char smallBitFinder(int position, ArrayList<String> data) {
        int ones = 0;
        for (int i = 0; i < data.size(); i ++) {
            if (data.get(i).charAt(position) == '1') {
                ones ++;
            }
        }
        if (ones < data.size() - ones) {
            return '1';
        } else {
            return '0';
        }
    }

    public static String oxygenRating(ArrayList<String> ary) {
        int position = 0;
        ArrayList<String> data = copy(ary);
        while (data.size() != 1) {
            char bigBit = bigBitFinder(position, data);
            for (int i = data.size() - 1; i > -1; i --) {
                String number = data.get(i);
                if (number.charAt(position) != bigBit) {
                    data.remove(i);
                }
            }
            position ++;
        }
        return data.get(0);
    }

    public static String carbonRating(ArrayList<String> ary) {
        int position = 0;
        ArrayList<String> data = copy(ary);
        while (data.size() != 1) {
            char smallBit = smallBitFinder(position, data);
            for (int i = data.size() - 1; i > -1; i --) {
                String number = data.get(i);
                if (number.charAt(position) != smallBit) {
                    data.remove(i);
                }
            }
            position ++;
        }
        return data.get(0);
    }

    public static ArrayList<String> copy(ArrayList<String> ary) {
        ArrayList<String> copy = new ArrayList<String>();
        for (int i = 0; i < ary.size(); i ++) {
            copy.add(ary.get(i));
        }
        return copy;
    }

}