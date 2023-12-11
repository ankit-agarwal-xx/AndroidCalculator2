package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonPlus, buttonMinus, buttonMultiply, buttonEquals, buttonAC;
    private double val1 = Double.NaN;
    private double val2;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private char CURRENT_ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the buttons and the display
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonEquals = findViewById(R.id.button_equals);
        buttonAC = findViewById(R.id.button_ac);
        display = findViewById(R.id.display);

        // Set up the button click listeners
        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString() + "0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display.setText(display.getText().toString() + "9");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                display.setText(null);
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                display.setText(null);
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                display.setText(null);
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                computeCalculation();
                display.setText(String.valueOf(val1));
                val1 = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });

        buttonAC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(display.getText().length() > 0) {
                    CharSequence currentText = display.getText();
                    display.setText(currentText.subSequence(0, currentText.length()-1));
                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    display.setText("");
                }
            }
        });
    }

    private void computeCalculation() {
        if(!Double.isNaN(val1)) {
            val2 = Double.parseDouble(display.getText().toString());
            display.setText(null);

            if(CURRENT_ACTION == ADDITION)
                val1 = this.val1 + val2;
            else if(CURRENT_ACTION == SUBTRACTION)
                val1 = this.val1 - val2;
            else if(CURRENT_ACTION == MULTIPLICATION)
                val1 = this.val1 * val2;
        }
        else {
            try {
                val1 = Double.parseDouble(display.getText().toString());
            }
            catch (Exception e){}
        }
    }
}
