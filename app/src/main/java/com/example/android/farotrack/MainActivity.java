package com.example.android.farotrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //******
    //  showResults() lets us save our EditText fields into string variables, as well as
    //creates a new intent object, a NewDeckOrder object, and an OutFaro Object.
    //It also contains some business logic that lets us find out if the chosen
    //card exists in the deck and if so, at which position it exists after the shuffles
    //have taken place. It then displays this position data in a new activity using our
    //intent object and invoking the putExtra method.
    //*******

    public void showResults(View view) {

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText inputCard = findViewById(R.id.inputCard);
        String choosenCard = inputCard.getText().toString();
        EditText inputShuffles = findViewById(R.id.inputShuffles);
        String choosenShuffles = inputShuffles.getText().toString();

        //this variable will hold the position value after the deck has been
        //shuffled x amount of times.
        int cardAfterShuffles = 0;

        //Creating a new deck order in an American playing card order.
        NewDeckOrder newDeckOrder = new NewDeckOrder();
        newDeckOrder.setBicycleDeckOrder(NewDeckOrder.americanNewDeckOrder());

        int numberOfFaros = Integer.valueOf(choosenShuffles);


//        int cardsPosition = 0;
//
//        if (newDeckOrder.americanNewDeckOrder().contains(choosenCard)) {
//            cardsPosition += newDeckOrder.americanNewDeckOrder().indexOf(choosenCard) + 1;
//        }
//        System.out.println("\n" + choosenCard + " starting position is " + cardsPosition + ".");

        //creating new OutFaro object and passing in our new deck order and chosen number
        //of shuffles as arguments.
        OutFaro outFaro = new OutFaro();
        outFaro.outFaro(newDeckOrder.getBicycleDeckOrder(), numberOfFaros);


        //this statement handles the capitalization of suites or values.
        choosenCard = choosenCard.toLowerCase();

        //if the card is found, we save the result to cardAfterShuffles
        if (outFaro.results().contains(choosenCard)) {
            cardAfterShuffles += outFaro.results().indexOf(choosenCard) + 1;

        }


        //calling our intent object and invoking the putExtra method to display
        //the value to our DisplayMessageActivity.
        intent.putExtra(EXTRA_MESSAGE, String.valueOf(cardAfterShuffles));
        //displaying the secondary activity
        startActivity(intent);
    }
}
