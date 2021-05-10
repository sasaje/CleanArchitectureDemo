package com.example.cleanarchitecturedemo.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cleanarchitecturedemo.R;
import com.example.cleanarchitecturedemo.model.Model;

public class AndroidView extends AppCompatActivity implements View.OnClickListener {

    Button enterButton;
    TextView outputView;
    EditText inputText;

    Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputView = (TextView)findViewById(R.id.outputView);
        outputView.setText(model.getData());

        inputText = (EditText)findViewById(R.id.inputText);
        inputText.setText(model.getData());

        enterButton = findViewById(R.id.enterButton);
        enterButton.setOnClickListener(AndroidView.this);

        // Inner class call
        model.addModelObserver(new MyModelObserver());
    }

    @Override
    public void onClick(View v) {
        outputView = (TextView)findViewById(R.id.outputView);
        inputText = (EditText)findViewById(R.id.inputText);

        model.setData(inputText.getText().toString());
        Log.d("CONSOLE", "Adding ModelObserver from Model.");
    }

    // Inner class for handling updates from Model
    private class MyModelObserver implements Model.ModelObserver{
        @Override
        public void update() {
            Log.d("CONSOLE", "Update received. Replacing data.");
            outputView.setText(wrapModelClassToLowerCase(model.getData()));
        }
    }

    public String wrapModelClassToLowerCase(String inputString){
        inputString = inputText.getEditableText().toString();
        String inputStringLowerCase = inputString.toLowerCase();
        Log.d("CONSOLE" , "inputStringLowerCase: " + inputStringLowerCase);
        return inputStringLowerCase;
    }
}