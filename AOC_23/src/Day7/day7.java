package Day7;

import Helper.Input;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class day7 {
    public static void main(String[] args) {
        String[] lines = Input.readStringLines("Day7/input.txt");
        List<Bid>[] bids = new List[7];
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            bids[i] = new ArrayList<>();
        }
        for (String line : lines) {
            var splits = line.split(" ");
            var cards = splits[0].toCharArray();
            int[] stack = new int[5];
            int amount_jokers = 0;
            for (int i = 0; i < 5; i++) {
                boolean handled = false;
                if(cards[i] == 'J'){
                    amount_jokers ++;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (cards[j] == cards[i] && !handled) {
                        stack[j]++;
                        handled = true;
                    }
                }
                if (!handled) {
                    stack[i]++;
                }
            }
            int max = 0, secondmax = 0;
            for (int i: stack ) {
                if (max < i){
                    secondmax = max;
                    max = i;
                } else if (secondmax < i) {
                    secondmax = i;
                }
            }
            var thisbid = new Bid(cards, Integer.parseInt(splits[1]));
            /**
             * bids[0] fiveling
             * bids[1] fourling
             * bid[2] fullhouse
             * bid[3] trilling
             * bid[4] two pairs
             * bid[5] pair
             * bid[6] highcard
             */
            if (max == 5){
                bids[0].add(thisbid);
            } else if (max == 4) {
                if (amount_jokers == 1){
                    bids[0].add(thisbid);
                }else if(amount_jokers == 0){
                    bids[1].add(thisbid);
                }else{
                    System.out.println("shit");
                }
            } else if (max == 3 && secondmax == 2){
                bids[2].add(thisbid);
            } else if (max == 3 && secondmax == 1){
                if (amount_jokers == 1){
                    bids[1].add(thisbid);
                }else if (amount_jokers == 0){
                    bids[3].add(thisbid);
                }else System.out.println("shit");
            } else if (max == 2 && secondmax == 2){
                if (amount_jokers == 1){
                    bids[2].add(thisbid);
                }else if (amount_jokers == 0){
                    bids[4].add(thisbid);
                } else {
                    System.out.println("shit");
                }
            } else if (max == 2 && secondmax == 1){
                if (amount_jokers == 2){
                    bids[1].add(thisbid);
                }else if( amount_jokers == 1){
                    bids[3].add(thisbid);
                }else if(amount_jokers == 0){
                    bids[5].add(thisbid);
                }else System.out.println("shit");
            } else{
                if (amount_jokers == 4 || amount_jokers == 5){
                    bids[0].add(thisbid);
                }else if( amount_jokers == 3) {
                    if (max == 2){
                        bids[0].add(thisbid);
                    }else{
                        bids[1].add(thisbid);
                    }
                }else if( amount_jokers == 2) {
                    if (max == 3){
                        bids[0].add(thisbid);
                    }
                    if (max == 2){
                        bids[1].add(thisbid);
                    }
                    if (max == 1){
                        bids[3].add(thisbid);
                    }
                }else if( amount_jokers == 1) {
                    if (max == 4){
                        bids[0].add(thisbid);
                    }
                    if (max == 3){
                        bids[1].add(thisbid);
                    }
                    if (max == 2){
                        bids[3].add(thisbid);
                    }
                    if (max == 1){
                        bids[5].add(thisbid);
                    }
                }else if(amount_jokers == 0){
                    bids[6].add(thisbid);
                }else {
                    System.out.println("shit");
                }
            }
        }
        int card = 1;
        for (int i = bids.length -1; i >= 0;i--){
            var bidlist = bids[i];
            bidlist = bidlist.stream().map(Bid.class::cast).sorted(Comparator.comparing(e -> e.getCardOrder())).collect(Collectors.toList());

            for (Bid b:bidlist) {
                System.out.println("cards: " + b.toString() +" value: "+b.getValue() );
                sum += card * b.getValue();
                card ++;
            }
        }
        System.out.println(sum);

    } // 346036752 too high
    // 249464529 too low
}

