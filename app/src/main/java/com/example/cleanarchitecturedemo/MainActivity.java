package com.example.cleanarchitecturedemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button enterButton;
    TextView outputView;
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterButton = findViewById(R.id.enterButton);
        outputView = findViewById(R.id.outputView);
        inputText = findViewById(R.id.inputText);

        enterButton.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        String edit = inputText.getEditableText().toString();
        outputView.setText(edit);
    }
}