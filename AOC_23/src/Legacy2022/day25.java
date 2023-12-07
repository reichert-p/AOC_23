package Legacy2022;

import Helper.Input;

import java.util.ArrayList;

public class day25 {
    public static void main(String[] args) {
        var charlines = "2----0=--1122=0=0021".toCharArray();
        //should be 33383508717511
        long wholeValue = 0;
        for( int i = charlines.length- 1; i >= 0; i--){
            long digit = getDigit(charlines[i]);
            long stelle = charlines.length - i - 1;
            long value = (long) Math.pow(5, stelle) * digit;
            wholeValue += value;
        }
        System.out.println(wholeValue);
      //  part1();
    }

    private static void part1(){
        String[] lines = Input.readStringLines("Legacy2022/input.txt");
        long sum = 0;
        for (String line : lines){
            var charlines = line.toCharArray();
            long wholeValue = 0;
            for( int i = charlines.length- 1; i >= 0; i--){
                int digit = getDigit(charlines[i]);
                int stelle = charlines.length - i - 1;
                long value = (long) Math.pow(5, stelle) * digit;
                wholeValue += value;
            }
            sum += wholeValue;
        }
        System.out.println(sum);
        writeinquint(sum);
    }

    private static void writeinquint(long sum) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Character> output = new ArrayList<>();
        while(sum > 0){
            long intSum = sum;
            while (intSum > Integer.MAX_VALUE){
                intSum = intSum - 2147483645;
            }
            int representation = (int)intSum;
            list.add(representation % 5);
            sum = sum / 5;
        }
        System.out.println(list.reversed());
        for (int i = 0; i < list.size(); i++) {
            switch (list.get(i)){
                case 0:
                    output.add('0');
                    break;
                case 1:
                    output.add('1');
                    break;
                case 2:
                    output.add('2');
                    break;
                case 3:
                    output.add('=');
                    try {
                        list.set(i + 1, list.get(i + 1) + 1);
                    } catch (Exception e){
                        list.add(1);
                    }
                    break;
                case 4:
                    output.add('-');
                    try {
                        list.set(i + 1, list.get(i + 1) + 1);
                    } catch (Exception e){
                        list.add(1);
                     }
                    break;
                case 5:
                    output.add('0');
                    try{
                        list.set(i+1, list.get(i+1) +1);
                    } catch (Exception e){
                        list.add(1);
                    }
                    break;
                default:
                    System.out.println("hahahahhadidfhiaidfh");
            }
        }
        String s = String.valueOf(output.reversed());
        String formatted = 1 + s;
        System.out.println(formatted);
        System.out.println(output.reversed());
    }

    private static int getDigit(char charline) {
        switch (charline){
            case '2':
                return 2;
            case '1':
                return 1;
            case '0':
                return 0;
            case '-':
                return -1;
            case '=':
                return -2;
            default:
                throw new RuntimeException("unexpected char : " + charline);
        }
    }
}
