package Day1;

import Helper.Input;

public class Day1 {
    public static void main(String[] args) {
        String[] test = Input.readStringLines("Day1/input.txt");
        for (String s: test) {
            var splits = s.split(",");
            for (String t: splits) {
                System.out.println(t);
            }
            System.out.println();
        }
    }
}
