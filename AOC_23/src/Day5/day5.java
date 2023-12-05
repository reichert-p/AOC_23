package Day5;

import Helper.Input;

public class day5 {
    public static void main(String[] args) {
        String[] lines = Input.readStringLines("Day5/input.txt");
        Long[][] longLines = new Long[lines.length][3];
        for(int i = 0; i < lines.length; i++) {
            var values = lines[i].split(" ");
            try {
                longLines[i][0] = Long.parseLong(values[0]);
                longLines[i][1] = Long.parseLong(values[1]);
                longLines[i][2] = Long.parseLong(values[2]);
            }catch (Exception e){
                longLines[i][0] = (long) -1;
                longLines[i][1] = (long) -1;
                longLines[i][2] = (long) -1;
            }

        }


        String[] seeds = Input.readStringLines("Day5/seeds.txt");
        seeds = seeds[0].split(" ");
        long minTransformed = Integer.MAX_VALUE;
        for (int i = 0; i < seeds.length; i = i+2) {
            var rangeStart = Long.parseLong(seeds[i]);
            var rangeLength = Long.parseLong(seeds[i+1]);
            for (int l = 0; l < rangeLength; l++){
                minTransformed = Math.min(transform(longLines, rangeStart + l), minTransformed);
            }
            System.out.println(i);
        }
        System.out.println(minTransformed);

    }

    public static long transform(Long[][] lines, long seed){
        int linecounter = 0;
        for(int i = linecounter; i < lines.length; i++){
            try {
                long dest_range_start = lines[i][0];
                long source_range_start = lines[i][1];
                long range_length = lines[i][2];

                if (seed >= source_range_start && seed <= source_range_start + range_length){
                    seed -= source_range_start - dest_range_start;
                    boolean nextlinenumber = true;
                    while (nextlinenumber) {
                        if (lines[i][0] != -1) {
                            i++;
                        } else {
                            nextlinenumber = false;
                        }
                    }
                }
            }catch (Exception e){
            }
        }
        return seed;
    }

}
