package Day6;

import Helper.Input;

public class day6 {

    public static void main(String[] args) {
        String[] lines = Input.readStringLines("Day6/input.txt");
        String[] temp1 = lines[0].split(":")[1].split(" ");
        String[] temp2 = lines[1].split(":")[1].split(" ");
        long time,toBeat;
        time = Long.parseLong(temp1[0]);
        toBeat = Long.parseLong(temp2[0]);
        long sum = time;
        for (long i = 0; i < time; i++){ //from down
            var dist = (time - i) * i;
            if(dist <= toBeat){
                sum --;
            }else break;
        }
        for (long i = time -1; i >= 0; i--){ //from down
            var dist = (time - i) * i;
            if(dist <= toBeat){
                sum --;
            }else break;
        }
        System.out.println(sum);
    }

    public static void part1(String[] args) {
        String[] lines = Input.readStringLines("Day6/input.txt");
        String[] temp1 = lines[0].split(":")[1].split(" ");
        String[] temp2 = lines[1].split(":")[1].split(" ");
        int[] times = new int[temp1.length];
        int[] dists = new int[temp2.length];
        for(int i = 0; i < times.length; i++){
            times[i] = Integer.parseInt(temp1[i]);
            dists[i] = Integer.parseInt(temp2[i]);
        }
        long factor = 1;
        for(int i = 0; i < times.length; i++){
            int sum = 0;
            int[] possibleDists = getPossibleDists(times[i]);
            for (int k : possibleDists){
                if( k > dists[i]){
                    sum ++;
                }
            };
            System.out.println(sum);
            factor = factor * sum;
        }
        System.out.println(factor);


    }

    private static int[] getPossibleDists(int time) {
        int[] output = new int[time];
        for (int i = 0; i < time; i++){
            output[i] = (time - i) * i;
        }
        return output;
    }
}
