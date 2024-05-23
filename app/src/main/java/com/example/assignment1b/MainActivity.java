package com.example.assignment1b;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        inputTemperature = findViewById(R.id.inputTemperature);
        convertedTemperature = findViewById(R.id.convertedTemperature);
    }

    private void calculateAndShowResult(double temperature) {
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedButton = findViewById(selectedId);
        conversionType = selectedButton.getText().toString();
        double convertedTemperature;
        if (conversionType.equals("C to F")) {
            convertedTemperature = (temperature * 9 / 5) + 32;
        } else {
            convertedTemperature = (temperature - 32) * 5 / 9;
        }
        this.convertedTemperature.setText(String.format("%.2f", convertedTemperature));
    };
}