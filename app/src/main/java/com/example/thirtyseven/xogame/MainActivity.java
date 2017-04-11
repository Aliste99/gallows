package com.example.thirtyseven.xogame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView gallowsView;
    private TextView wordView;
    private TextView lettersView;
    private EditText guessView;
    private Button submitButton;
    private HangManController hangManController;
    private HangManView hangManView;
    private HangManModel hangManModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        hangManController.setWord("zagadka");

    }

    private void update() {
        hangManController.acceptGuess(guessView.getText().charAt(0));
        hangManView.update(hangManModel);
        gallowsView.setText(hangManView.getGallows());
        wordView.setText(hangManView.getRiddle());
        lettersView.setText(hangManView.getLetters());

    }

    private void init() {
        gallowsView = (TextView)findViewById(R.id.textViewGallows);
        wordView = (TextView)findViewById(R.id.textViewWord);
        lettersView = (TextView)findViewById(R.id.textViewLetters);
        guessView = (EditText)findViewById(R.id.editTextGuess);
        submitButton = (Button)findViewById(R.id.buttonSubmit);

        hangManModel = new HangManModel();
        hangManController = new HangManController(hangManModel);
        hangManView = new HangManView();
    }
}