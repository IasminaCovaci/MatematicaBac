
package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz extends AppCompatActivity implements View.OnClickListener {


    List<ModelClass> list;
    ModelClass modelclass;
    int index=1;
    TextView question, option_one,option_two,option_three,option_four, qcount;
    int correctCount = 0;
    int wrongCount = 0;
    int score = 0;
    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question= findViewById(R.id.tv_question);
        qcount = findViewById(R.id.number_question);
        option_one= findViewById(R.id.tv_option_one);
        option_two = findViewById(R.id.tv_option_two);
        option_three = findViewById(R.id.tv_option_three);
        option_four = findViewById(R.id.tv_option_four);

        next = findViewById(R.id.next);

        option_one.setOnClickListener(this);
        option_two.setOnClickListener(this);
        option_three.setOnClickListener(this);
        option_four.setOnClickListener(this);
        
        getQuestionList();

        modelclass=list.get(index);

        next.setClickable(false);
        
        setQuestion();

    }

    private void getQuestionList() {

        list = new ArrayList<>();
        list.add(new ModelClass("Se consideră matricea A= ⎛ 0 , 1 , 1 ⎞\n                                                ⎪ 1 , 0 , 1 ⎪\n                                                ⎝ 1, 1 , 0  ⎠. Să se determine a, b astefel încăt aA^2 + bA + 2I3 = O3","a = -2 și b = 2","a = 1 și b = -1","a = -1 și b = 1","a = -2/3 și b = 2/3",3));
        list.add(new ModelClass("Se consideră sistemul liniar\n ⎰ (1 + m)x + y + z = 1\n   x + (1 + m)y + z = m\n ⎱ x + y + (1 + m)z = m^2 . Să se scrie matricea A a sistemului și să se calculeze det(A).","det(A) = 0","det(A) = m(m^2 - 2)","det(A) = m^2 - 2","det(A) = m - 2",1));
        list.add(new ModelClass("Se consideră punctele A(1,1) , B(2,3) , C(3,-1). Să se determine aria triunghiului format de cele trei puncte","-3","11","1/3","3",4));
        list.add(new ModelClass("Să se verifice dacă matricea\n A= ⎛-1 , 2 , 1⎞\n       ⎪ 3 , 0 , 1⎪\n       ⎝-1, 1 , -2⎠ este inversabilă, iar în caz afirmativ să se calculeze matricea inversabilă și determinantul acesteia.","det(A^-1) = 0","det(A^-1) = 196","nu este inversabilă","det(A^-1) = 14",2));
        list.add(new ModelClass("⎧ 10,24,15⎫\n⎪ 9 , 5 ,20 ⎪\n⎩11, 7 , 20⎭\n?","2","6","11","4",1));
        list.add(new ModelClass("⎧ 10,24,15⎫\n⎪ 9 , 5 ,20 ⎪\n⎩11, 7 , 20⎭\n?","2","6","11","4",1));
        //list.add(new ModelClass("⎧ 10,24,15⎫\n⎪ 9 , 5 ,20 ⎪\n⎩11, 7 , 20⎭\n?","2","6","11","4",1));
        //list.add(new ModelClass("⎧ 10,24,15⎫\n⎪ 9 , 5 ,20 ⎪\n⎩11, 7 , 20⎭\n?","2","6","11","4",1));
        //list.add(new ModelClass("⎧ 10,24,15⎫\n⎪ 9 , 5 ,20 ⎪\n⎩11, 7 , 20⎭\n?","2","6","11","4",1));
    
        setQuestion();
    }

    private void setQuestion() {

        question.setText(list.get(0).getQuestion());
        option_one.setText(list.get(0).getOptionOne());
        option_two.setText(list.get(0).getOptionTwo());
        option_three.setText(list.get(0).getOptionThree());
        option_four.setText(list.get(0).getOptionFour());

        qcount.setText(String.valueOf(1)+ "/" + String.valueOf(list.size()));
    }

    @Override
    public void onClick(View v) {

        int selectedOption = 0;

        switch (v.getId())
        {
            case R.id.tv_option_one :
                selectedOption = 1;
                break;
            case R.id.tv_option_two:
                selectedOption = 2;
                break;
            case R.id.tv_option_three:
                selectedOption = 3;
                break;
            case R.id.tv_option_four:
                selectedOption = 4;
                break;
            default:
        }

        checkAnswer(selectedOption,v);

    }
    private  void checkAnswer(int selectedOption,View view)
    {
        if(selectedOption ==  list.get(index).getCorrectOption())
        {
            correctCount++;
            score = score+20;
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));

        }else
        {
            wrongCount++;
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            switch (list.get(index).getCorrectOption())
            {
                case 1:
                    option_one.setBackgroundTintList(ColorStateList.valueOf((Color.GREEN)));
                    break;
                case 2:
                    option_two.setBackgroundTintList(ColorStateList.valueOf((Color.GREEN)));
                    break;
                case 3:
                    option_three.setBackgroundTintList(ColorStateList.valueOf((Color.GREEN)));
                    break;
                case 4:
                    option_four.setBackgroundTintList(ColorStateList.valueOf((Color.GREEN)));
                    break;
            }
        }
        changeQuestion();
    }

    

    private void changeQuestion() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(index < list.size()-1){
                    index++;
                    playAnim(question,0,0);
                    playAnim(option_one,0,1);
                    playAnim(option_two,0,2);
                    playAnim(option_three,0,3);
                    playAnim(option_four,0,4);

                    qcount.setText(String.valueOf(index) + "/" + String.valueOf(list.size()));

                }else {
                    Intent intent = new Intent (Quiz.this,WonActivity.class);
                    intent.putExtra("score_points",String.valueOf(score) + " puncte");
                    intent.putExtra("score",String.valueOf(score) );
                    intent.putExtra("correct",String.valueOf(correctCount));
                    intent.putExtra("wrong",String.valueOf(wrongCount));
                    startActivity(intent);
                    Quiz.this.finish();

                }

            }

        });
    }

    private void playAnim(View view, final int value, int viewNum) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                        if (value == 0)
                        {
                            switch (viewNum){
                                case 0:
                                    ((TextView) view).setText(list.get(index).getQuestion());
                                    break;
                                case 1:
                                    ((Button) view).setText(list.get(index).getOptionOne());
                                    break;
                                case 2:
                                    ((Button) view).setText(list.get(index).getOptionTwo());
                                    break;
                                case 3:
                                    ((Button) view).setText(list.get(index).getOptionThree());
                                    break;
                                case 4:
                                    ((Button) view).setText(list.get(index).getOptionFour());
                                    break;
                            }
                            if(viewNum != 0)
                            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.WHITE));
                            playAnim(view,1,viewNum);
                        }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }

}