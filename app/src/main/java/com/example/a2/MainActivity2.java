package com.example.a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    int activeplayer = 0;
    boolean gameactive=true;
    int[] gamestate ={2,2,2,2,2,2,2,2,2};
    int[][] winPosition ={    {0,1,2} , {3,4,5} , {6,7,8},
            {0,3,6} , {1,4,7} , {2,5,8},
            {0,4,8} , {2,4,6}
    };
    public void playertap(View view)
    {
        ImageView img = (ImageView) view;
        TextView status;

        int tag = Integer.parseInt(img.getTag().toString());
        if(!gameactive)
        {
            reset(view);
        }
        if (gamestate[tag] == 2 && gameactive)
        {
            gamestate[tag] = activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer == 0)
            {
                img.setImageResource(R.drawable.o);
                activeplayer = 1;
                status = findViewById(R.id.status);
                status.setText("X's Turn Tap To Play");
            }
            else
            {
                img.setImageResource(R.drawable.x);
                activeplayer = 0;
                status = findViewById(R.id.status);
                status.setText("O's Turn Tap To Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        else
        {
            Toast.makeText(this, "Position Already Taken", Toast.LENGTH_SHORT).show();
        }
        for(int[] winPosition: winPosition)
        {
            String winner = null;
            if(gamestate[winPosition[0]]==gamestate[winPosition[1]] &&
                    gamestate[winPosition[1]]==gamestate[winPosition[2]]
                    && gamestate[winPosition[0]]!=2) {
                gameactive=false;
                if (gamestate[winPosition[0]] == 0) {
                    winner = "O Has Won (Tap To reset)";
                } else {
                    winner = "X Has Won (Tap To reset)";
                }
                TextView status1 = findViewById(R.id.status);
                status1.setText(winner);
            }
        }
        int flag=0;
        for(int i=0;i<9;i++)
        {
            if(gamestate[i]==2)
                flag=1;
        }
        if(flag==0 && gameactive==true)
        {
            TextView status1 = findViewById(R.id.status);
            status1.setText("Its a Draw (Tap To Play Again)");
            reset(view);
        }
    }
    public void reset(View view)
    {
        gameactive=true;
        activeplayer=0;
        for(int i=0;i<9;i++)
            gamestate[i]=2;
        ((ImageView)findViewById(R.id.imageView)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}