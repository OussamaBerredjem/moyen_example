package com.example.meet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button calculer;
    TextView result;
    EditText thl,bdd,daw,reseaux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        calculer = findViewById(R.id.btn);
        result = findViewById(R.id.result);
        thl = findViewById(R.id.thl);
        bdd = findViewById(R.id.bdd);
        daw = findViewById(R.id.daw);
        reseaux = findViewById(R.id.resaux);

        calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double total = Double.parseDouble(thl.getText().toString()) +
                               Double.parseDouble(bdd.getText().toString()) +
                               Double.parseDouble(daw.getText().toString()) +
                               Double.parseDouble(reseaux.getText().toString());

                double moyen = total /4;

                result.setText("votre moyen : "+moyen);

            }
        });
    }
}