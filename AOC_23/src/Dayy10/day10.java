package Dayy10;

import Helper.Input;

import java.util.Arrays;

public class day10 {
    public static void main(String[] args) {
        String[] lines = Input.readStringLines("Dayy10/input.txt");
        char[][] grid = new char[lines.length][];
        for( int i = 0; i < lines.length; i++){
            grid[i] = lines[i].toCharArray();
        }
        // get starting position
        int lStart = 0;
        int pStart = 0;
        int lineIdx = 0;
        for (char[] line: grid) {
            int pos = 0;
            for (char position:line) {
                if(position == 'S'){
                    lStart = lineIdx;
                    pStart = pos;
                    break;
                }
                pos ++;
            }
            lineIdx ++;
        }
        boolean[][] inPath = new boolean[grid.length][grid[0].length];
        inPath[lStart][pStart] = true;
        var p1 = "right";
        int[] p1coords = new int[]{lStart, pStart};
        var p2 = "up"; //up
        int[] p2coords = new int[]{lStart, pStart};
        int steps = 0;
        do {
            p1 = makeStep(p1coords, p1, grid);
            inPath[p1coords[0]][p1coords[1]] = true;
         //   System.out.print ("p1: " + p1coords[0] + "," + p1coords[1]+ " char:"+ grid[p1coords[0]][p1coords[1]] + "   ");
            p2 = makeStep(p2coords, p2, grid);
            inPath[p2coords[0]][p2coords[1]] = true;
         //   System.out.println("p2: " + p2coords[0] + "," + p2coords[1] + " char:"+ grid[p2coords[0]][p2coords[1]]);
            steps ++;

        } while (p1coords[0] != p2coords[0] || p1coords[1] != p2coords[1]);
        System.out.println(steps);
        int sumIn = 0;
        int lineindex = 0;
        int xind = 0;
        for (boolean[] boolLine: inPath){
            int yind = 0;
            boolean inside = false;
            char storage = '.';
            for (boolean tile : boolLine){
                if (tile){
                    switch (grid[xind][yind]){
                        case '|':
                            inside = !inside;
                            break;
                        case 'F', 'L':
                            storage = grid[xind][yind];
                            break;
                        case 'S':
                            storage = 'L'; //TODO
                            break;
                        case 'J':
                            if (storage == 'F'){
                                inside = !inside;
                            }
                            break;
                        case '7':
                            if (storage == 'L'){
                                inside = !inside;
                            }
                            break;
                    }
                }
                if (!tile && inside){
                    sumIn ++;
                }
                yind ++;
            }
            xind ++;
        }
        System.out.println(sumIn);
    }


    //1562 too high
    private static String makeStep(int[] coords, String p1, char[][] grid) {
        switch (p1){
            case "up":
                coords[0]--;
                break;
            case "down":
                coords[0]++;
                break;
            case "left":
                coords[1]--;
                break;
            case "right":
                coords[1]++;
                break;
            default: throw new RuntimeException(" wtf");
        }
        switch (grid[coords[0]][coords[1]]){
            case '|':
                return p1;
            case '-':
                return p1;
            case 'L':
                if (p1.equals("left")){
                    return "up";
                }
                if (p1.equals("down")){
                    return "right";
                }
                throw new RuntimeException("wtf");
            case 'J':
                if (p1.equals("right")){
                    return "up";
                }
                if (p1.equals("down")){
                    return "left";
                }
                throw new RuntimeException("wtf");
            case '7':
                if (p1.equals("right")){
                    return "down";
                }
                if (p1.equals("up")){
                    return "left";
                }
                throw new RuntimeException("wtf");
            case 'F':
                if (p1.equals("left")){
                    return "down";
                }
                if (p1.equals("up")){
                    return "right";
                }
                throw new RuntimeException("wtf");
            default:
                throw new RuntimeException("found " + grid[coords[0]][coords[1]]);
        }
    }
}
