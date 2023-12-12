package Dayy12;

import Helper.Input;

import java.util.ArrayList;

public class day12 {
    public static void main(String[] args) {
        String[] lines = Input.readStringLines("Dayy12/input.txt");
        int sum = 0;
        for (String line:lines){

            char[] characters = line.split(" ")[0].toCharArray();
            var secondPart = line.split(" ")[1].split(",");
            int[] numbers = new int[secondPart.length];
            for (int i = 0; i < secondPart.length; i++){
                numbers[i] = Integer.parseInt(secondPart[i]);
            }
            char[] fullLen = new char[5* characters.length +4];
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < characters.length; j++){
                    fullLen[i*characters.length +j+i] = characters[j];
                }
                fullLen[(1+i) * characters.length+i] = '?';
            }
            for (int j = 0; j < characters.length; j++){
                fullLen[4*characters.length +j+4] = characters[j];
            }

            int[] fullNums = new int[5* numbers.length];
            for (int i = 0; i < 5; i++){
                for (int j = 0; j < numbers.length; j++){
                    fullNums[i*numbers.length +j] = numbers[j];
                }
            }
            long longVal = checkSatisfies(fullLen, fullNums);
            System.out.println(longVal);
            sum += longVal;
        }
        System.out.println(sum);
    }

    //

    public static int checkSatisfies(char[] chars, int[]numbers){
        boolean containsQuestionmark = false;
        int index = 0;
        for (char c: chars){
            if (c == '?'){
                chars[index] = '.';
                int a = checkSatisfies(chars, numbers);
                chars[index] = '#';
                int b = checkSatisfies(chars, numbers);
                chars[index] = '?';
                return a+b;
            }
            index ++;
        }
        int  numberindex = 0;
        int routecounter = 0;
        for (char c: chars) {
            if (c == '#'){
                routecounter ++;
            }
            if (c == '.'){
                if (routecounter != 0){
                    int number;
                    try {
                        number = numbers[numberindex];
                    }catch (Exception e){
                        return 0;
                    }
                    if (routecounter != number){
                        return 0;
                    }
                    numberindex ++;
                    routecounter = 0;
                }
            }
        }
        if (numberindex == numbers.length && routecounter == 0){
            return 1;
        }
        else if(numberindex == numbers.length -1 && numbers[numberindex] == routecounter){
            return 1;
        }else {return 0;}



    }
}
