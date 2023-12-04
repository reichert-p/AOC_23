package Day4;

import Helper.Input;

public class Day4 {
    public static void main(String[] args) {
        String[] lines = Input.readStringLines("Day4/input.txt");
        int[] lineMatchings = new int[lines.length] ;
        int index = 0;
        for (String line:lines){
            var tem = line.split(":")[1].split("\\|");
            var winningStrings = tem[0].split(" ");
            int[] winningNumbers = new int[winningStrings.length];
            for (int i = 0; i < winningStrings.length; i ++){
                try {
                    winningNumbers[i] = Integer.parseInt(winningStrings[i]);
                } catch (NumberFormatException e){
                    winningNumbers[i] = -1;
                }

            }
            var havingStrings = tem[1].split(" ");
            int[] havingNumbers = new int[havingStrings.length];
            for (int i = 0; i < havingStrings.length; i ++){
                try{
                    havingNumbers[i] = Integer.parseInt(havingStrings[i]);
                } catch (NumberFormatException e){
                    havingNumbers[i] = -2;
                }
            }
            int matchcounter = 0;

            for (int n: havingNumbers) {
                for (int m: winningNumbers){
                    if (n == m) matchcounter ++;
                }
            }
           lineMatchings[index] = matchcounter;
            index ++;
        }
        int[] instances = new int[lines.length];

        int totalsum = 0;
        for (int i = 0; i < instances.length; i++){
            instances[i] = 1;
            totalsum ++;
        }
        for  (int instancenumber = 0; instancenumber < instances.length; instancenumber++){
            for (int instanceoccurrence = 0; instanceoccurrence < instances[instancenumber]; instanceoccurrence++ ){
                for (int j = 0; j < lineMatchings[instancenumber]; j++){
                    totalsum ++;
                    instances[instancenumber + j + 1] += 1;
                }
            }
        }
        System.out.println(totalsum);
    }
    public static void part1() {
        String[] lines = Input.readStringLines("Day4/input.txt");
        int sum = 0;
        for (String line:lines){
            var tem = line.split(":")[1].split("\\|");
            var winningStrings = tem[0].split(" ");
            int[] winningNumbers = new int[winningStrings.length];
            for (int i = 0; i < winningStrings.length; i ++){
                try {
                    winningNumbers[i] = Integer.parseInt(winningStrings[i]);
                } catch (NumberFormatException e){
                    winningNumbers[i] = -1;
                }

            }
            var havingStrings = tem[1].split(" ");
            int[] havingNumbers = new int[havingStrings.length];
            for (int i = 0; i < havingStrings.length; i ++){
                try{
                havingNumbers[i] = Integer.parseInt(havingStrings[i]);
            } catch (NumberFormatException e){
                havingNumbers[i] = -2;
            }
            }
            int matchcounter = 0;

            for (int n: havingNumbers) {
                for (int m: winningNumbers){
                    if (n == m) matchcounter ++;
                }
            }
            if (matchcounter == 0){
                sum += 0;
            }else{
                sum += Math.pow(2,matchcounter -1);
            }
        }
        System.out.println(sum);
    }

}
