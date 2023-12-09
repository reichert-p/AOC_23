package Day9;

import Helper.Input;

import java.util.Arrays;

public class day9 {
    public static void main(String[] args) {
        String[] lines = Input.readStringLines("Day9/input.txt");
        long sum = 0;
        for (String line: lines) {
            Integer[] numbers = Arrays.stream(line.split(" ")).map(e -> Integer.parseInt(e)).toArray(Integer[]::new);
            Long[][] matrix = new Long[numbers.length][numbers.length +1];
            int k = 0;
            for (int i: numbers) {
                matrix[0][k] = Long.valueOf(i);
                k++;
            }
            for (int depth = 1; depth < numbers.length; depth ++){
                for (int index = 0; index < numbers.length - depth; index ++)
                matrix[depth][index] = matrix[depth-1][index +1] - matrix[depth-1][index];
            }
            //long addition = 0; (for part 1)
            long substraction = 0;
            for (int depth = numbers.length -2; depth > 0; depth --){
                long a = matrix[depth][0]; //[numbers.length-depth -1];
                long b = substraction; //addition;
                long newValue = a - b; // a+b;
                substraction = newValue; // addition =
            }
            sum += matrix[0][0] - substraction; // [numbers.length -1] + addition;
            System.out.println(matrix[0][0] - substraction); // addition);
        }
        System.out.println(sum);
    }
}
