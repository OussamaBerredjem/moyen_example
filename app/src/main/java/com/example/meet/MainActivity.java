package com.example.meet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



        TextView total,index;
        LinearLayout parent;


        int current = 0;
        String[] reponse = new String[]{
               "2",
               "4",
               "5",
               "8",

        };

        int result = 0;

        Button button;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total = findViewById(R.id.total);
        index = findViewById(R.id.index);

        total.setText("/ "+reponse.length);
        index.setText(""+(current+1));

        parent = findViewById(R.id.parent_groupe);
        button = findViewById(R.id.next);



        View question1 = getLayoutInflater().inflate(R.layout.question_model,parent,false);

        RadioGroup radioGroup1 = setQuestion(question1,"How much 1+1 ?",new String[]{"2","4","5"});
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton1 = question1.findViewById(checkedId);
                if(radioButton1.getText().toString().equals(reponse[current])){
                    result = result+5;
                }else{
                    result = result -5;
                }
            }
        });

        parent.addView(question1);

        View question2 = getLayoutInflater().inflate(R.layout.question_model,parent,false);

        RadioGroup radioGroup2 = setQuestion(question2,"How much 2+2 ?",new String[]{"3","4","9"});
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton2 = question2.findViewById(checkedId);
                if(radioButton2.getText().toString().equals(reponse[current])){
                    result = result+5;
                }else{
                    result = result -5;
                }
            }
        });
 View question3 = getLayoutInflater().inflate(R.layout.question_model,parent,false);

        RadioGroup radioGroup3 = setQuestion(question3,"How much 4+1 ?",new String[]{"6","4","5"});
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton3 = question3.findViewById(checkedId);
                if(radioButton3.getText().toString().equals(reponse[current])){
                    result = result+5;
                }else{
                    result = result -5;
                }
            }
        });
 View question4 = getLayoutInflater().inflate(R.layout.question_model,parent,false);

        RadioGroup radioGroup4 = setQuestion(question4,"How much 6+2 ?",new String[]{"8","4","5"});
        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton4 = question4.findViewById(checkedId);
                if(radioButton4.getText().toString().equals(reponse[current])){
                    result = result+5;
                }else{
                    result = result -5;
                }
            }
        });




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(result);
                current++;
                index.setText(String.valueOf((current+1)));
                switch (current){
                    case 0:
                        parent.addView(question1);
                        break;
                    case 1:
                        parent.removeView(question1);
                        parent.addView(question2);
                        break;
                    case 2:
                        parent.removeView(question2);
                        parent.addView(question3);
                        break;
                    case 3:
                        parent.removeView(question3);
                        parent.addView(question4);
                        break;
                    case 4:
                        Intent intent = new Intent(MainActivity.this,Result.class);
                        intent.putExtra("result",result);
                        startActivity(intent);

                        break;
                }
            }
        });



    }

    RadioGroup setQuestion(View question,String qst,String [] reponse){
        TextView qst1 = question.findViewById(R.id.qst);
        qst1.setText(qst);
        RadioGroup radioGroup = question.findViewById(R.id.radio_groupe1);
        RadioButton radioButton1 = question.findViewById(R.id.reponse1);
        RadioButton radioButton2 = question.findViewById(R.id.reponse2);
        RadioButton radioButton3 = question.findViewById(R.id.reponse3);

        radioButton1.setText(reponse[0]);
        radioButton2.setText(reponse[1]);
        radioButton3.setText(reponse[2]);

        return  radioGroup;
    }






}





