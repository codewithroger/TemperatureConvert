package com.example.tempconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText inputTemperature;
    private Button convertButton;
    private RadioGroup temperatureGroup;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputTemperature = findViewById(R.id.input_temperature);
        convertButton = findViewById(R.id.convert_button);
        temperatureGroup = findViewById(R.id.temperature_group);
        resultText = findViewById(R.id.result_text);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });

    }
    private void convertTemperature() {
        String input = inputTemperature.getText().toString().trim();

        if (!input.isEmpty()) {
            double temperature = Double.parseDouble(input);

            int selectedId = temperatureGroup.getCheckedRadioButtonId();
            RadioButton selectedRadioButton = findViewById(selectedId);

            if (selectedRadioButton != null) {
                String unit = selectedRadioButton.getText().toString();

                if (unit.equals("Celsius")) {
                    double convertedTemperature = convertToFahrenheit(temperature);
                    resultText.setText(convertedTemperature + " °F");
                } else if (unit.equals("Fahrenheit")) {
                    double convertedTemperature = convertToCelsius(temperature);
                    resultText.setText(convertedTemperature + " °C");
                }
            }
        }
    }

    private double convertToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private double convertToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}