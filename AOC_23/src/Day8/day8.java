package Day8;

import Helper.Input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class day8 {
    public static void main(String[] args) {
        String[] lines = Input.readStringLines("Day8/input.txt");
        Map<String, Node> hashmap = new HashMap<>();
        long product = 1;
        for (String line: lines) {
            var splits = line.split("[=|(|)|,]");
            var node = new Node(splits[0].trim(), splits[2].trim(), splits[3].trim() );
            hashmap.put(node.value, node);
        }
        String current[] = new String[6];
            current[0] =  "MXA";
            current[1] = "VQA";
            current[2] = "CBA";
            current[3] =  "JBA";
            current[4] = "AAA";
            current[5] =  "HSA";

        for (String cur: current) {
            int counter = 0;
            boolean next = false;
            while (!next){
                for (char c: Input.readStringLines("Day8/directions.txt")[0].toCharArray()){
                    if (next) continue;
                    boolean finished = true;
                    /*for (String i: current) {
                        if (i.charAt(2) == 'Z' ){
                            finished = finished & true;
                        }else{
                            finished = false;
                        }
                    }*/
                    finished = cur.charAt(2) == 'Z';
                    if (finished){
                        System.out.println(counter);
                        next = true;
                    }else if (c == 'R'){
                       /* for (int i = 0; i < current.length; i++){
                            current[i] = hashmap.get(current[i]).right;
                        }*/
                        cur = hashmap.get(cur).right;
                        counter ++;
                    } else if (c == 'L') {
                        /* for (int i = 0; i < current.length; i++) {
                            current[i] = hashmap.get(current[i]).left;
                        }*/
                        cur = hashmap.get(cur).left;
                        counter ++;
                    }else {
                        System.out.println("fuuu");
                    }
                }
            }
        }
        // use a bitch ass online LCM solver because otherwise runtime jadiofjaoishfiashdfiuahsdoifhasdiufhaoisdhfiuadhfoiHSADGUIHD
    }
}
