package com.example.diceroller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsetsAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int userIp;
    EditText userInput;
    Button rollButton;
    private ImageButton dice;
    private Random roll = new Random();

    /* Variables for shared preferences */

    private TextView resultOne;
    private TextView resultTwo;
    private TextView resultThree;

    public static final String Shared_Preferences = "shared_prefs";
    public static final String Text1 = "Result One";
    public static final String Text2 = "Result Two";
    public static final String Text3 = "Result Three";

    private String TextOne;
    private String TextTwo;
    private String TextThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.user_input);
        rollButton = (Button) findViewById(R.id.btn_roll);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userIp = Integer.valueOf(userInput.getText().toString());
                rollDice(userIp);
                saveData();
            }
        });


        dice = findViewById(R.id.four_side);
        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(4);
            }
        });

        dice = findViewById(R.id.six_side);
        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(6);
            }
        });

        dice = findViewById(R.id.eight_side);
        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(8);
            }
        });

        dice = findViewById(R.id.ten_side);
        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(10);
            }
        });

        dice = findViewById(R.id.twelve_side);
        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(12);
            }
        });

        dice = findViewById(R.id.twenty_side);
        dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(20);
            }
        });

    }
    private void rollDice(int inputSize){

        int randomNumber = roll.nextInt(inputSize) + 1;

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Your Result is" + " " + randomNumber);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
            }
        });
        alert.create().show();
    }
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(Shared_Preferences,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(Text1, userInput.getText().toString());
        editor.putString(Text2, userInput.getText().toString());
        editor.putString(Text3, userInput.getText().toString());
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(Shared_Preferences,MODE_PRIVATE);
        TextOne = sharedPreferences.getString(Text1, "");
        TextTwo = sharedPreferences.getString(Text2, "");
        TextThree = sharedPreferences.getString(Text3, "");
    }

    public void updateData(){
        userInput.setText(Text1);
        userInput.setText(Text2);
        userInput.setText(Text3);
    }
}