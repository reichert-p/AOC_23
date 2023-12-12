package Dayy11;

import Day3.Position;
import Helper.Input;

import java.util.ArrayList;

public class day11 {
    public static void main(String[] args) {
        String[] lines = Input.readStringLines("Dayy11/input.txt");
        boolean[] galaxyRows = new boolean[lines.length];
        boolean[] galaxyColumns = new boolean[lines[0].length()];

        int rowIndex = 0;
        for (String line: lines) {
            int colIndex = 0;
            for (char c: line.toCharArray()){
                if (c != '.'){
                    galaxyRows[rowIndex] = true;
                    galaxyColumns[colIndex] = true;
                }
                colIndex ++;
            }
            rowIndex ++;
        }

        // check all positions into array
        ArrayList<Position> galaxyPositions= new ArrayList<>();
        int rowcounter = 0;
        for (var row: lines) {
            var poscounter = 0;
            for (var position : row.toCharArray()){
                if (position == '#'){
                    galaxyPositions.add(new Position(rowcounter, poscounter));
                }
                poscounter ++;
            }
            rowcounter ++;
        }

        // calculate distances between all positions
        long sum = 0;
        for (Position p: galaxyPositions) {
            for (Position q: galaxyPositions) {
                for (int i = Math.min(p.getLine(), q.getLine()); i < Math.max(p.getLine(), q.getLine()); i++){
                    if (galaxyRows[i]){
                        sum ++;
                    }else {
                        sum += 1000000;
                    }
                }
                for (int i = Math.min(p.getPosition(), q.getPosition()); i < Math.max(p.getPosition(), q.getPosition()); i++){
                    if (galaxyColumns[i]){
                        sum ++;
                    }else {
                        sum += 1000000;
                    }
                }
            }
        }
        System.out.println(sum/2);

    }

    public static void part1(){
        String[] lines = Input.readStringLines("Dayy11/input.txt");
        boolean[] galaxyRows = new boolean[lines.length];
        boolean[] galaxyColumns = new boolean[lines[0].length()];

        int rowIndex = 0;
        for (String line: lines) {
            int colIndex = 0;
            for (char c: line.toCharArray()){
                if (c != '.'){
                    galaxyRows[rowIndex] = true;
                    galaxyColumns[colIndex] = true;
                }
                colIndex ++;
            }
            rowIndex ++;
        }

        //expand matrix
        ArrayList<ArrayList<Character>> matrix= new ArrayList<>();
        for (int row = 0; row < lines.length; row ++){
            var rowlist = new ArrayList<Character>();
            for (int col = 0; col < lines[0].length(); col ++) {
                rowlist.add(lines[row].charAt(col));
                if (!galaxyColumns[col]){
                    rowlist.add('.');
                }
            }
            matrix.add(rowlist);
            if (!galaxyRows[row]){
                var emptyRow = new ArrayList<Character>();
                for (var a: rowlist) {
                    emptyRow.add('.');
                }
                matrix.add(emptyRow);
            }
        }
        // check all positions into array
        ArrayList<Position> galaxyPositions= new ArrayList<>();
        int rowcounter = 0;
        for (var row: matrix) {
            var poscounter = 0;
            for (var position : row){
                if (position == '#'){
                    galaxyPositions.add(new Position(rowcounter, poscounter));
                }
                poscounter ++;
            }

            rowcounter ++;
        }

        // calculate distances between all positions
        long sum = 0;
        for (Position p: galaxyPositions) {
            for (Position q: galaxyPositions) {
                sum += Math.abs(p.getLine() - q.getLine());
                sum += Math.abs(p.getPosition() - q.getPosition());
            }
        }
        System.out.println(sum/2);
    }
}
