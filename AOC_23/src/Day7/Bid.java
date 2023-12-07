package Day7;

import java.util.Arrays;

public class Bid {
    private char[] cards;
    private int cardOrder;
    private int value;

    public char[] getCards() {
        return cards;
    }

    @Override
    public String toString() {
        String output = "";
        for (char c: cards) {
            output = output + c;
        }
        return output;
    }

    public int getValue() {
        return value;
    }

    public int getCardOrder(){
        return cardOrder;
    }

    public Bid(char[] cards, int value) {
        this.cards = cards;
        this.value = value;
        int sum = 0;
        for(int i = 0; i < cards.length; i++){
            int val;
            //A, K, Q, J, T, 9, 8, 7, 6, 5, 4, 3, or 2
            switch (cards[i]) {
                case 'A':
                    val = 14;
                    break;
                case 'K':
                    val = 13;
                    break;
                case 'Q':
                    val = 12;
                    break;
                case 'J':
                    val = 1; // val = 11 for part a
                    break;
                case 'T':
                    val = 10;
                    break;
                default:
                    val = cards[i] - '0';
                    break;
            }
            sum += Math.pow(18, 5-i) * val;
        }
        cardOrder = sum;
    }

}
