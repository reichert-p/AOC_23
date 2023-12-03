package Day3;

import Helper.Input;

import java.util.ArrayList;

/** @noinspection DuplicatedCode*/
public class Day3 {
    Position gearposition = null;

    public static void main(String[] args) {
        var tis = new Day3();
        String[] lines = Input.readStringLines("Day3/input.txt");
        int sum = 0;
        ArrayList<Position> positions = new ArrayList<>();
        char[][] chars = new char[lines.length][]; // line, pos
        for (int i = 0 ; i < lines.length; i++){
            chars[i] = lines[i].toCharArray();
        }
        for (int line = 0; line < lines.length; line++) { // get char array
            addPostions(positions, line, lines[line]);
        }
        while (!positions.isEmpty()) {
            var position = positions.remove(0);
            if ( tis.checkIsAdjacent(chars, position.getLine(), position.getPosition(), String.valueOf(position.getNumber()).length(),0)){
                if(tis.gearposition != null){
                    if(chars[tis.gearposition.getLine()][tis.gearposition.getPosition()] == '*'){
                        var copygearposition = tis.gearposition;
                        for (Position otherposition : positions){
                            tis.checkIsAdjacent(chars, otherposition.getLine(), otherposition.getPosition(), String.valueOf(otherposition.getNumber()).length(),0);
                            if(tis.gearposition != null) {
                                if (copygearposition.getPosition() == tis.gearposition.getPosition() && copygearposition.getLine() == tis.gearposition.getLine()) {
                                    sum += position.getNumber() * otherposition.getNumber();
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(sum);
    }

    private static void part1(){
        String[] lines = Input.readStringLines("Day3/input.txt");
        int sum = 0;
        ArrayList<Position> positions = new ArrayList<>();
        char[][] chars = new char[lines.length][]; // line, pos
        for (int i = 0 ; i < lines.length; i++){
            chars[i] = lines[i].toCharArray();
        }

        for (int line = 0; line < lines.length; line++) { // get char array
            addPostions(positions, line, lines[line]);
        }
        for (Position position: positions) {
            if ( checkIsAdjacent(chars, position.getLine(), position.getPosition(), String.valueOf(position.getNumber()).length())){
                System.out.println(position.getNumber());
                sum += position.getNumber();
            }
        }

        System.out.println(sum);
    }

    private static void addPostions(ArrayList<Position> positions, int line, String input) {
        char[] inputCharArray = input.toCharArray();
        int value = 0;
        Position currentPosition = null;
        for (int i = 0; i < input.length(); i++){
            if (isNumberCharacter(inputCharArray, i)){ // it is number
                value = value * 10 + (inputCharArray[i] - '0');
                if( currentPosition == null){
                    currentPosition = new Position(line, i);
                }
            }
            else{
                if( currentPosition != null){
                    currentPosition.setNumber(value);
                    value = 0;
                    positions.add(currentPosition);
                    currentPosition = null;
                }
            }
        }
        if( currentPosition != null){
            currentPosition.setNumber(value);
            value = 0;
            positions.add(currentPosition);
            currentPosition = null;
        }
    }

    private boolean checkIsAdjacent(char[][] chars, int lineNumber, int pos, int length, int overhead) {
        for (int lineOffset = -1; lineOffset < 2; lineOffset = lineOffset + 2 ){
            for(int posOffset = -1; posOffset <= length ; posOffset++){
                if (isSpecialCharacter(chars,lineNumber+lineOffset, pos + posOffset)){
                    this.gearposition = new Position(lineNumber+lineOffset, pos+posOffset);
                    return true;
                }
            }
        }
        if (isSpecialCharacter(chars,lineNumber, pos - 1)){
            gearposition = new Position(lineNumber, pos-1);
            return true;
        }
        if (isSpecialCharacter(chars,lineNumber, pos + length)){

            gearposition = new Position(lineNumber, pos + length);
            return true;
        }
        gearposition = null;
        return false;
    }

    private static boolean checkIsAdjacent(char[][] chars, int lineNumber, int pos, int length) {
        for (int lineOffset = -1; lineOffset < 2; lineOffset = lineOffset + 2 ){
            for(int posOffset = -1; posOffset <= length ; posOffset++){
                if (isSpecialCharacter(chars,lineNumber+lineOffset, pos + posOffset)){
                    return true;
                }
            }
        }
        if (isSpecialCharacter(chars,lineNumber, pos - 1)){
            return true;
        }
        if (isSpecialCharacter(chars,lineNumber, pos + length)){
            return true;
        }
        return false;
    }

    private static boolean isSpecialCharacter(char[][] chars, int lineNumber, int pos){
        try{
            char c = chars[lineNumber][pos];
            if(c == '.')return false;
            if(c == '0')return false;
            if(c == '1')return false;
            if(c == '2')return false;
            if(c == '3')return false;
            if(c == '4')return false;
            if(c == '5')return false;
            if(c == '6')return false;
            if(c == '7')return false;
            if(c == '8')return false;
            if(c == '9')return false;
            return true;
        }catch (ArrayIndexOutOfBoundsException e){
            return  false;
        }
    }

    private static boolean isNumberCharacter(char[] chars, int pos){
        try{
            char c = chars[pos];
            if(c == '0')return true;
            if(c == '1')return true;
            if(c == '2')return true;
            if(c == '3')return true;
            if(c == '4')return true;
            if(c == '5')return true;
            if(c == '6')return true;
            if(c == '7')return true;
            if(c == '8')return true;
            if(c == '9')return true;
            return false;
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
}
