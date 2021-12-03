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
            String line;
            int depth = 0;
            int horz = 0;
            String[] directions;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                directions = line.split(" ");
                if (directions[0].equals("forward")) {
                    horz += Integer.parseInt(directions[1]);
                }
                if (directions[0].equals("up")) {
                    depth -= Integer.parseInt(directions[1]);
                }
                if (directions[0].equals("down")) {
                    depth += Integer.parseInt(directions[1]);
                }
            }
            scan.close();
            System.out.println(depth*horz);
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    public static void partTwo(){
        try {
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            String line;
            int depth = 0;
            int horz = 0;
            int aim = 0;
            String[] directions;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                directions = line.split(" ");
                if (directions[0].equals("forward")) {
                    horz += Integer.parseInt(directions[1]);
                    depth += aim * Integer.parseInt(directions[1]);
                }
                if (directions[0].equals("up")) {
                    aim -= Integer.parseInt(directions[1]);
                }
                if (directions[0].equals("down")) {
                    aim += Integer.parseInt(directions[1]);
                }
            }
            scan.close();
            System.out.println(depth*horz);
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

}