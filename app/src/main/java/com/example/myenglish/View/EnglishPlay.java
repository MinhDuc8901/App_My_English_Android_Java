package com.example.myenglish.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myenglish.Model.GameEnglish;
import com.example.myenglish.R;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class EnglishPlay extends AppCompatActivity implements View.OnClickListener {

    private final int TIME_PLAY_EACH_LEVEL =5000;

    private String [] arrColor ={"#FA8072","#DC143C","#B22222","#FF4500","FF8C00"};

    private TextView lblFomular, lblResult, lblScore;
    private ImageView btnCorrect,btnWrong,btnPlayGame,btnOut;
    private RelativeLayout layoutPlay;

    private Timer timer;
    private TimerTask timerTask;

    private int score =0;
    private Random rand;

    private ArrayList<GameEnglish> arr = new ArrayList<>();

    private GameEnglish mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_play);

        update();

        lblFomular= (TextView) findViewById(R.id.lbl_formular);
        lblResult = (TextView) findViewById(R.id.lbl_result);
        lblScore = (TextView) findViewById(R.id.lbl_socre);

        btnCorrect = (ImageView) findViewById(R.id.btn_correct);
        btnWrong = (ImageView) findViewById(R.id.btn_wrong);
        btnPlayGame= (ImageView) findViewById(R.id.btn_play_game);
        btnOut = (ImageView) findViewById(R.id.btn_out_game);


        btnCorrect.setOnClickListener(this);
        btnWrong.setOnClickListener(this);
        btnPlayGame.setOnClickListener(this);
        btnOut.setOnClickListener(this);

        //layoutPlay = (RelativeLayout) findViewById(R.id.Layout_play);

        lblScore.setText(String.valueOf(score));
        btnPlayGame.setEnabled(false);
        btnPlayGame.setVisibility(View.INVISIBLE);
        btnOut.setEnabled(false);
        btnOut.setVisibility(View.INVISIBLE);

        rand = new Random();
        int count = rand.nextInt(arr.size());
         mode = arr.get(count);
        displayNewLevel(mode);
        createTimerTask();


    }

    private void displayNewLevel(GameEnglish model){
        lblFomular.setText(model.getAnh());
        lblResult.setText(model.getViet());
//        int indexColor = rand.nextInt(arrColor.length);
//        layoutPlay.setBackground(arrColor[indexColor]);
    }

    private void update(){
        arr.add(new GameEnglish("Hello","Xin Chao",true));
        arr.add(new GameEnglish("Hello","Tạm biệt",false));
        arr.add(new GameEnglish("Me","Tôi",true));
        arr.add(new GameEnglish("My","Của tôi",true));
        arr.add(new GameEnglish("My Crush","Người yêu của tôi",false));
        arr.add(new GameEnglish("people","Người",true));
        arr.add(new GameEnglish("History","Lịch sử",true));
        arr.add(new GameEnglish("way","Đường",true));
        arr.add(new GameEnglish("art","Nghệ thuật",true));
        arr.add(new GameEnglish("World","Thế giới",true));
        arr.add(new GameEnglish("information","thông tin",true));
        arr.add(new GameEnglish("Two","Ba",false));
        arr.add(new GameEnglish("Map","Bản đồ",true));
        arr.add(new GameEnglish("Family","Gia đình ",true));
        arr.add(new GameEnglish("Health","Sức khỏe ",true));
        arr.add(new GameEnglish("System","Hệ thống ",true));
        arr.add(new GameEnglish("Computer","Máy tính",true));
        arr.add(new GameEnglish("Data","Dữ liệu",true));
        arr.add(new GameEnglish("Science","Khoa học",true));

    }

    private void createTimerTask(){
        // tao timer
        timer = new Timer();

        // create time task
        timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showGameover(score);
                    }
                });
            }
        };
        timer.schedule(timerTask,TIME_PLAY_EACH_LEVEL);
    }

    private void showGameover(final int score){

        btnWrong.setEnabled(false);
        btnCorrect.setEnabled(false);
        btnCorrect.setVisibility(View.INVISIBLE);
        btnWrong.setVisibility(View.INVISIBLE);

        cancelTimer();

        lblScore.setEnabled(false);
        lblScore.setVisibility(View.INVISIBLE);
        lblFomular.setText("Game Over");
        lblResult.setText(String.valueOf(score));
        btnPlayGame.setEnabled(true);
        btnPlayGame.setVisibility(View.VISIBLE);
        btnOut.setEnabled(true);
        btnOut.setVisibility(View.VISIBLE);
        btnPlayGame.setOnClickListener(this);



    }

    private void cancelTimer(){
        timerTask.cancel();
        timer.cancel();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id==R.id.btn_correct){
            if(mode.isCheck()==true){
                score+=1;
                nextLevel(score);
            }
            else {
                showGameover(score);
            }
        }
        if(id==R.id.btn_wrong){
            if(mode.isCheck()==false){
                score+=1;
                nextLevel(score);
            }
            else {
                showGameover(score);
            }
        }
        if(id==R.id.btn_play_game){
            Intent intent = new Intent(this, English.class);
            startActivity(intent);
        }
        if(id==R.id.btn_out_game){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
    private void nextLevel(int score)
    {
        // update score
        lblScore.setText(String.valueOf(score));

        // cancel timer
        cancelTimer();

        // set new time for next level
        createTimerTask();

        // update ui
        int count = rand.nextInt(arr.size());
        mode = arr.get(count);
        displayNewLevel(mode);
    }
}