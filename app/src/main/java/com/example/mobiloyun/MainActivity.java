package com.example.mobiloyun;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView computer_img, user_img;
    Button stone_btn, paper_btn, scissors_btn;
    TextView ScoreText;

    int ComputerScore=0;
    int UserScore=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        computer_img = findViewById(R.id.computer_img);
        user_img = findViewById(R.id.user_img);
        stone_btn = findViewById(R.id.stone_btn);
        paper_btn = findViewById(R.id.paper_btn);
        scissors_btn = findViewById(R.id.scissors_btn);
        ScoreText = findViewById(R.id.ScoreText);

        stone_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_img.setImageResource(R.drawable.stone);
                Results result = calculateResult(Choises.STONE,ComputerChoice());
                updateScore(result);

            }
        });

        paper_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_img.setImageResource(R.drawable.paper);
                Results result = calculateResult(Choises.PAPER,ComputerChoice());
                updateScore(result);

            }
        });
        scissors_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_img.setImageResource(R.drawable.scissors);
                Results result = calculateResult(Choises.SCISSORS,ComputerChoice());
                updateScore(result);

            }
        });

    }

    public void updateScore(Results result){
        if (result.equals(Results.WIN)){
            UserScore++;
        }
        else if (result.equals(Results.LOST)) {
            ComputerScore+=1;

        }
        ScoreText.setText("ComputerScore: "+UserScore+" UserScore: "+ComputerScore+"");
    }

    public Results calculateResult(Choises userChoice,Choises computerChoice){
        if(userChoice.equals(computerChoice)){
            return Results.DRAW;
        }
        else if ( (userChoice.equals(Choises.STONE) && computerChoice.equals(Choises.SCISSORS)) ||
                (userChoice.equals(Choises.PAPER) && computerChoice.equals(Choises.STONE)) ||
                (userChoice.equals(Choises.SCISSORS) && computerChoice.equals(Choises.PAPER))) {
            return Results.WIN;
        }
        else{
            return Results.LOST;
        }


    }


    public Choises ComputerChoice(){
        int random = new Random().nextInt(3); /* 0-stone 1-paper 2-scissors (3almaz)*/
        if(random==0){
            computer_img.setImageResource(R.drawable.stone);
            return Choises.STONE;
        }
        else if(random==1){
            computer_img.setImageResource(R.drawable.paper);
            return Choises.PAPER;
        }
        else{
            computer_img.setImageResource(R.drawable.scissors);
            return Choises.SCISSORS;
        }
    }

}