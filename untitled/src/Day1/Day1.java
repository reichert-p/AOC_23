package Day1;

import Helper.Input;

import java.util.Arrays;
import java.util.OptionalInt;

public class Day1 {
    public static void main(String[] args) {
        String[] lines = Input.readStringLines("Day1/input.txt");
        int sum = 0;
        for (String line: lines) {
            var newString = replacewithDigits(line); // for part 1 comment this lne
            var tochars = newString.toCharArray();
            sum += getFirstNumber(tochars) * 10;
            sum += getLastNumber(tochars);
        }
        System.out.println(sum);
    }

    private static String replacewithDigits(String string){
        string = string.replaceAll("one", "one1one");
        string =string.replaceAll("two", "two2two");
        string =string.replaceAll("three", "three3three");
        string =string.replaceAll("four", "four4four");
        string =string.replaceAll("five", "five5five");
        string =string.replaceAll("six", "six6six");
        string =string.replaceAll("seven", "seven7seven");
        string = string.replaceAll("eight", "eight8eight");
        string =string.replaceAll("nine", "nine9nine");
        return string;
    }

    private static int getFirstNumber(char[] chars) {
        for (int i = 0; i < chars.length; i++){
            int c = chars[i];
            if(c - 48 > -1 && c - 48 < 10){
                return c-48;
            }
        }

        throw new RuntimeException("no number found");
    }

    private static int getLastNumber(char[] chars) {
        for (int i = chars.length-1; i >=0; i--){
            int c = chars[i];
            if(c - 48 > -1 && c - 48 < 10){
                return c-48;
            }
        }
        System.out.println("help");
        throw new RuntimeException("no number found");
    }
}
