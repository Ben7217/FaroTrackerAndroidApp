package com.example.android.farotrack;
import java.util.ArrayList;

/**
 * This class sets up a deck in brand new, unshuffled order.
 * This could be modified for different deck orders if needed.
 */

public class NewDeckOrder {

    private static ArrayList<String> bicycleDeckOrder;

  public static ArrayList<String> americanNewDeckOrder() {

        String[] suitesFirstHalf = {"hearts", "clubs"};
        String[] valuesFirstHalf = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

        String[] suitesSecondHalf = {"diamonds", "spades"};
        String[] valuesSecondHalf = {"king", "queen", "jack", "10", "9", "8", "7", "6", "5", "4", "3", "2", "ace"};

        bicycleDeckOrder = new ArrayList<>();

        for (String deckFirstSuites : suitesFirstHalf) {
            for (String deckFirstValues : valuesFirstHalf) {
                bicycleDeckOrder.add(deckFirstValues + " of " + deckFirstSuites);
            }
        }

        for (String deckSecondSuites : suitesSecondHalf) {
            for (String deckSecondValues : valuesSecondHalf) {
                bicycleDeckOrder.add(deckSecondValues + " of " + deckSecondSuites);
            }
        }
        return bicycleDeckOrder;
    }


    public ArrayList<String> getBicycleDeckOrder() {
        return bicycleDeckOrder;
    }

    public void setBicycleDeckOrder(ArrayList<String> bicycleDeckOrder) {
        this.bicycleDeckOrder = bicycleDeckOrder;
    }

    @Override
    public String  toString() {
        return "New Deck Order " + bicycleDeckOrder;
    }
}
