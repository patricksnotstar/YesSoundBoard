package com.example.yessoundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int sound1;

    int operand1, operand2;
    float numResult;
    TextView result;
    EditText op1, op2;
    Button plus, minus, multiply, divide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                                                .setContentType(AudioAttributes.CONTENT_TYPE_MOVIE).build();

        soundPool = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(audioAttributes).build();

        sound1 = soundPool.load(this, R.raw.no, 1);

        result = (TextView)findViewById(R.id.result);
        op1 = (EditText)findViewById(R.id.operand1);
        op2 = (EditText)findViewById(R.id.operand2);

        plus = (Button)findViewById(R.id.button1_soundNO);
        minus = (Button)findViewById(R.id.button2_soundNO);
        multiply = (Button)findViewById(R.id.button3_soundNO);
        divide = (Button)findViewById(R.id.button4_soundNO);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operand1 = Integer.parseInt(op1.getText().toString());
                operand2 = Integer.parseInt(op2.getText().toString());
                numResult = operand1 + operand2;
                result.setText(String.valueOf(numResult));
                soundPool.play(sound1,1, 1, 3, 0, 1);
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operand1 = Integer.parseInt(op1.getText().toString());
                operand2 = Integer.parseInt(op2.getText().toString());
                numResult = operand1 - operand2;
                result.setText(String.valueOf(numResult));
                soundPool.play(sound1,1, 1, 3, 0, 1);
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operand1 = Integer.parseInt(op1.getText().toString());
                operand2 = Integer.parseInt(op2.getText().toString());
                numResult = operand1 * operand2;
                result.setText(String.valueOf(numResult));
                soundPool.play(sound1,1, 1, 3, 0, 1);
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operand1 = Integer.parseInt(op1.getText().toString());
                operand2 = Integer.parseInt(op2.getText().toString());
                numResult = operand1 / operand2;
                result.setText(String.valueOf(numResult));
                soundPool.play(sound1,1, 1, 3, 0, 1);
            }
        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}
