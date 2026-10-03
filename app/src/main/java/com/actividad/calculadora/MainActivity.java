package com.actividad.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private EditText entradaEditText;
    private TextView resultadoTextView;
    private Button calcularButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entradaEditText = findViewById(R.id.editTextNumberDecimal);
        resultadoTextView = findViewById(R.id.textView2);
        calcularButton = findViewById(R.id.button16);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado();
            }
        });
    }

    private void calcularResultado() {
        String expresion = entradaEditText.getText().toString();

        try {
            double resultado = evaluarExpresion(expresion);
            resultadoTextView.setText("Resultado: " + resultado);
        } catch (Exception e) {
            resultadoTextView.setText("Error: Expresión inválida");
        }
    }

    private double evaluarExpresion(String expresion) {
        Expression expression = new ExpressionBuilder(expresion).build();
        return expression.evaluate();
    }
}