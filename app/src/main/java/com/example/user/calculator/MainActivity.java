package com.example.user.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static String Expression = new String(), fstExpression, secExpression = null;
    static protected int index;
    static protected TextView mainTextView;
    static boolean isPointUsed = false;
    static char calSymbol;


    protected double Calculate(String a, String b, char x) {
        double res = 0;
        if (x == '＋') {
            res = (Double.parseDouble(a) + Double.parseDouble(b));
        }
        return res;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = (TextView)findViewById(R.id.mainTV);
        Button btnList[] = new Button[12], btnBackspace = (Button)findViewById(R.id.btnBackspace), btnPlus = (Button)findViewById(R.id.btnPlus), btnEqual = (Button)findViewById(R.id.btnequal);
        btnList[0] = (Button)findViewById(R.id.btn0);
        btnList[1] = (Button)findViewById(R.id.btn1);
        btnList[2] = (Button)findViewById(R.id.btn2);
        btnList[3] = (Button)findViewById(R.id.btn3);
        btnList[4] = (Button)findViewById(R.id.btn4);
        btnList[5] = (Button)findViewById(R.id.btn5);
        btnList[6] = (Button)findViewById(R.id.btn6);
        btnList[7] = (Button)findViewById(R.id.btn7);
        btnList[8] = (Button)findViewById(R.id.btn8);
        btnList[9] = (Button)findViewById(R.id.btn9);
        btnList[10] = (Button)findViewById(R.id.btnpoint);
        btnBackspace.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Expression.length() != 0) {
                    if (Expression.charAt(Expression.length() - 1) == '.') {
                        isPointUsed = false;
                    }
                    Expression = Expression.substring(0, Expression.length() - 1);
                    mainTextView.setText(Expression);
                }
            }
        });
        btnBackspace.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Expression = Expression.substring(0, 0);
                mainTextView.setText(Expression);
                return false;
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (secExpression == null) {
                    fstExpression = Expression;
                }

                else {
                    Double a = new Double(Calculate(fstExpression, secExpression, calSymbol));
                    fstExpression = a.toString();
                }

                Expression = Expression.substring(0, 0);
                mainTextView.setText(Expression);
                calSymbol = '＋';
            }
        });
        for (int i = 0; i < 10; i++) {
            btnList[i].setOnClickListener(this);
        }
        btnList[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPointUsed) {
                    return;
                }
                isPointUsed = true;
                Expression += '.';
                mainTextView.setText(Expression);
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (secExpression == null)
                    return;
                else {
                    
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        String buttonText = b.getText().toString();
        Expression += buttonText;
        mainTextView.setText(Expression);
    }
}
