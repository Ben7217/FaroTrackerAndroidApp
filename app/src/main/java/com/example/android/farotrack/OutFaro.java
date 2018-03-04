package com.example.android.farotrack;
import java.util.ArrayList;

/**
 *  This is the OutFaro class where the shuffle takes place.
 *  This is done recursively, from new deck order. In this case,
 *  it is shuffling from an American style order, that the United
 *  States Playing Card Company Uses.
 */

public class OutFaro {
    private ArrayList<String> shuffleResults;
    private int shuffleCounter;


    public ArrayList<String> results() {
        return shuffleResults;
    }

    public ArrayList<String> outFaro(ArrayList<String> newDeckOrder, int numberOfFaros) {

        shuffleResults = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        while (shuffleCounter != numberOfFaros) {

            for (int i = 0; i < newDeckOrder.size() - 26; i++) {
                for (int j = 26; j < newDeckOrder.size(); j++) {
                    temp.add(newDeckOrder.get(i));
                    temp.add(newDeckOrder.get(j));
                    i++;
                }
            }

            shuffleCounter++;
            if (shuffleCounter == numberOfFaros) {
                shuffleResults = temp;
            } else {
                outFaro(temp, numberOfFaros);
            }

        }
        return shuffleResults;
    }

    @Override
    public String toString() {
        return "OutFaro{" +
                "oneShuffle=" + shuffleResults +
                '}';
    }
}
