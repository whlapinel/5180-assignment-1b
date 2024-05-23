package com.example.assignment1b;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputTemperature;
    TextView convertedTemperature;
    String conversionType;
    Button convertButton;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        inputTemperature = findViewById(R.id.inputTemperature);
        convertedTemperature = findViewById(R.id.convertedTemperature);
        convertButton = findViewById(R.id.convertButton);
        resetButton = findViewById(R.id.resetButton);
        convertButton.setOnClickListener(v -> {
            String input = inputTemperature.getText().toString();
            if (input.isEmpty()) {
                convertedTemperature.setText("Please enter a temperature");
            } else {
                calculateAndShowResult(Double.parseDouble(input));
            }
        });
        resetButton.setOnClickListener(v -> {
            inputTemperature.setText("");
            convertedTemperature.setText("");
            RadioGroup radioGroup = findViewById(R.id.radioGroup);
            radioGroup.check(R.id.radioButton);
        });
    }

    private void calculateAndShowResult(double temperature) {
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedButton = findViewById(selectedId);
        conversionType = selectedButton.getText().toString();
        double convertedTemperature;
        try {
            if (conversionType.equals("C to F")) {
                convertedTemperature = (temperature * 9 / 5) + 32;
            } else {
                convertedTemperature = (temperature - 32) * 5 / 9;
            }
            this.convertedTemperature.setText(String.format("%.2f", convertedTemperature));
        } catch (NumberFormatException e) {
            this.convertedTemperature.setText("Invalid input");
        }
    };
}