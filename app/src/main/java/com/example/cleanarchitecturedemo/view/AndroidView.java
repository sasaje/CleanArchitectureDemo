package com.example.cleanarchitecturedemo.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cleanarchitecturedemo.R;

public class AndroidView extends AppCompatActivity implements View.OnClickListener {

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

        enterButton.setOnClickListener(AndroidView.this);
    }

    @Override
    public void onClick(View v) {
        String edit = inputText.getEditableText().toString();
        outputView.setText(edit);
    }
}