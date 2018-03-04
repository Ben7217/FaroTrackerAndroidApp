package com.example.android.farotrack.test;

import com.example.android.farotrack.NewDeckOrder;
import com.example.android.farotrack.OutFaro;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BenMorrisRains on 3/4/18.
 */
public class OutFaroTest {
    @Test
    public void buildDeck() {
        NewDeckOrder newDeckOrder = new NewDeckOrder();
        newDeckOrder.setBicycleDeckOrder(NewDeckOrder.americanNewDeckOrder());
        assertEquals(NewDeckOrder.americanNewDeckOrder(), newDeckOrder.getBicycleDeckOrder());
        System.out.println("Deck was built in new deck order!");
    }
    @Test
    public void results() throws Exception {
        int cardAfterShuffles = 0;

        //Creating a new deck order in an American playing card order.
        NewDeckOrder newDeckOrder = new NewDeckOrder();
        newDeckOrder.setBicycleDeckOrder(NewDeckOrder.americanNewDeckOrder());

        int numberOfFaros = 3;
        String choosenCard = "6 of Hearts";
        boolean cardWasFound = false;

        //creating new OutFaro object and passing in our new deck order and chosen number
        //of shuffles as arguments.
        OutFaro outFaro = new OutFaro();
        outFaro.outFaro(newDeckOrder.getBicycleDeckOrder(), numberOfFaros);


        //this statement handles the capitalization of suites or values.
        choosenCard = choosenCard.toLowerCase();

        //if the card is found, we save the result to cardAfterShuffles
        if (outFaro.results().contains(choosenCard)) {
            cardAfterShuffles += outFaro.results().indexOf(choosenCard) + 1;
            cardWasFound = true;
        }

        assertTrue(cardWasFound);
        System.out.println("The chosen card " + choosenCard + " was found at position " + cardAfterShuffles);

    }



}