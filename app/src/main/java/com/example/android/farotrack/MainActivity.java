package com.example.android.farotrack;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private Button trackerButton;
    private TextView shuffleResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showResults(View view) {

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText inputCard = findViewById(R.id.inputCard);
        String choosenCard = inputCard.getText().toString();
        EditText inputShuffles = findViewById(R.id.inputShuffles);
        String choosenShuffles = inputShuffles.getText().toString();

        int cardAfterOneShuffle = 0;


        NewDeckOrder newDeckOrder = new NewDeckOrder();
        newDeckOrder.setBicycleDeckOrder(newDeckOrder.americanNewDeckOrder());

        // User input
        System.out.println("\nPlease enter the card you wish to track: ");

        System.out.println("\nHow many out Faro's would you like to shuffle?");
        int numberOfFaros = Integer.valueOf(choosenShuffles);


//        int cardsPosition = 0;
//
//        if (newDeckOrder.americanNewDeckOrder().contains(choosenCard)) {
//            cardsPosition += newDeckOrder.americanNewDeckOrder().indexOf(choosenCard) + 1;
//        }
//        System.out.println("\n" + choosenCard + " starting position is " + cardsPosition + ".");

        OutFaro outFaro = new OutFaro();

        outFaro.outFaro(newDeckOrder.getBicycleDeckOrder(), numberOfFaros);


        if (outFaro.getOneShuffle().contains(choosenCard)) {
            cardAfterOneShuffle += outFaro.getOneShuffle().indexOf(choosenCard) + 1;

        }


        intent.putExtra(EXTRA_MESSAGE, String.valueOf(cardAfterOneShuffle));
        startActivity(intent);
    }
}
