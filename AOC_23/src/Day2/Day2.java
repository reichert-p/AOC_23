package Day2;

import Helper.Input;

public class Day2 {
    public static void main(String[] args) {
        String[] lines = Input.readStringLines("Day2/input.txt");
        int sum = 0;
        for (int id = 1; id <= lines.length; id ++) {
            String game = lines[id -1];
            var removeFirst = game.split(":")[1];
            var sets = removeFirst.split(";");
            //boolean possible = true; // uncomment these lines for part one
            int maxRed = 0;
            int maxGreen = 0;
            int maxBlue = 0;
            for (String set: sets) {
                for (String colorCombinaton: set.split(",")) {
                    colorCombinaton = colorCombinaton.trim();
                    String numberString = colorCombinaton.split(" ")[0];
                    int number = Integer.valueOf(numberString);

                    if (colorCombinaton.contains("red")){
                       // possible = possible && number <= 12;
                        maxRed = Math.max(number, maxRed);
                    }
                    else if (colorCombinaton.contains("green")){
                        //possible = possible && number <= 13;
                        maxGreen = Math.max(number, maxGreen);
                    }
                    else if (colorCombinaton.contains("blue")){
                       // possible = possible && number <= 14;
                        maxBlue = Math.max(number, maxBlue);
                    }
                }
            }
            System.out.println(maxRed * maxGreen * maxBlue);
            sum += maxRed * maxGreen * maxBlue;
        }
        System.out.println(sum);
    }
}
