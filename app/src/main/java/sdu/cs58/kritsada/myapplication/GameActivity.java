package sdu.cs58.kritsada.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class GameActivity extends AppCompatActivity {
    //Explicit
    Button btn1,btn2,btn3, btn4;
    ImageView questionImageView;
    MediaPlayer mediaPlayer; //เล่นไฟล์เสียง
    ImageButton volumnImageButton;
    int questionCount = 1; //ตัวแปรเก็บจำนวนข้อคำถาม
    ArrayList<Integer> qID = new ArrayList<Integer>(); //ตัวแปรสุ่มคำถาม เป็นชนิดarray
    String answer;//เก็บคำตอบที่userตอบ
    int score = 0;//ค่าเริ่มต้นที่0<รวมคะแนน>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //ผูก element บน java
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        questionImageView = findViewById(R.id.imvQuestion);
        volumnImageButton = findViewById(R.id.imbVolumn);

        //แสดงคำถามบนหน้าจอ
        for (int i = 1; i <= questionCount; i++) {
            qID.add(i);
        }
        Collections.shuffle(qID);//กำหนดให้ random คำถาม
        setQuestion(qID.remove(0));
    }//end onCreate

    private void setQuestion(Integer qID) {//ใช้สำหรับกำหนดข้อคำถามและเฉลยในแต่ละข้อ
        if (qID == 1) {
            answer = "นก";
            questionImageView.setImageResource(R.drawable.bird);
            mediaPlayer = MediaPlayer.create(this, R.raw.bird);

            ArrayList<String> choice = new ArrayList<String>();//กำหนดการrandom choice
            choice.add("นก");
            choice.add("ช้าง");
            choice.add("แมว");
            choice.add("ยุง");
            Collections.shuffle(choice);//random choice
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));
        }
    }//end setQuestion

    public void playSound(View view) {
        mediaPlayer.start();

    }
}
