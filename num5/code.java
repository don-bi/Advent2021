import java.util.*;
import java.io.*;

public class code {
    public static void main(String[] args) {
        partOne();
    }

    public static void partOne(){
        try {
            File file = new File("input.txt");
            Scanner scan = new Scanner(file);
            int[][] map = new int[1000][1000];
            int overlap = 0;
            while (scan.hasNextLine()) {
                String[] line = scan.nextLine().split(" -> ");
                String[] startstr = line[0].split(",");
                int[] start = strToIntArray(startstr);
                String[] endstr = line[1].split(",");
                int[] end = strToIntArray(endstr);
                if (start[0] == (end[0])) {
                    moveHorz(map, start[1], end[1], start[0]);
                } else if (start[1] == (end[1])) {
                    moveVert(map, start[0], end[0], start[1]);
                } else {
                    moveDiag(map, start[1], end[1], start[0], end[0]);
                }
            }
            for (int i = 0; i < map.length; i ++) {
                for (int k = 0; k < map[i].length; k ++) {
                    if (map[i][k] >= 2) {
                        overlap ++;
                    }
                }
            }
            System.out.println(overlap);
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }
    }

    public static int[] strToIntArray(String[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i ++) {
            ans[i] = Integer.parseInt(arr[i]);
        }
        return ans;
    }

    public static void print2d(int[][] board) {
        for (int i = 0; i < board.length; i ++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public static void moveHorz(int[][] map, int startx, int endx, int ycor) {
        if (startx < endx) {
            for (int x = startx; x <= endx; x ++) {
                map[x][ycor] ++;
            }
        }
        if (startx > endx) {
            for (int x = endx; x <= startx; x ++) {
                map[x][ycor] ++;
            }
        }
    }

    public static void moveVert(int[][] map, int starty, int endy, int xcor) {
        if (starty < endy) {
            for (int y = starty; y <= endy; y ++) {
                map[xcor][y] ++;
            }
        }
        if (starty > endy) {
            for (int y = endy; y <= starty; y ++) {
                map[xcor][y] ++;
            }
        }
    }

    public static void moveDiag(int[][] map, int startx, int endx, int starty, int endy) {
        if (startx < endx) {
            if (starty < endy) {
                int x = startx;
                int y = starty;
                while (x <= endx) {
                    map[x][y] ++;
                    x ++;
                    y ++;
                }
            } else { 
                int x = startx;
                int y = starty;
                while (x <= endx) {
                    map[x][y] ++;
                    x ++;
                    y --;
                }
            }
        } else { //(9,9) -> (0,0)
            if (starty < endy) {
                int x = startx;
                int y = starty;
                while (x >= endx) {
                    map[x][y] ++;
                    x --;
                    y ++;
                }
            } else {
                int x = startx;
                int y = starty;
                while (x >= endx) {
                    map[x][y] ++;
                    x --;
                    y --;
                }
            }
        }
    }
}
