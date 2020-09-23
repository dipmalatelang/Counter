package com.app.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView TvTime1,TvTime2,TvTime3,TvTime4;

    int flag1=1;
    int flag2 =0;
    int flag3=0;
    int flag4 =0;
    int counter = 0;
    int limit = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TvTime1 =findViewById(R.id.TvTime1);
        TvTime2 =findViewById(R.id.TvTime2);
        TvTime3 =findViewById(R.id.TvTime3);
        TvTime4 =findViewById(R.id.TvTime4);


        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                refresh();
                handler.postDelayed(this, 1000);
            }
        };

        handler.postDelayed(runnable, 1000);

    }

    private void refresh() {
        counter++;

        if (flag1 == 1) {
            TvTime1.setText(String.valueOf(counter));
            if (counter == limit) {
                flag1 = 0;
                flag2 = 1;
                counter = limit -5;
            }
        } else if (flag2 == 1) {
            TvTime2.setText(String.valueOf(counter));
            if (counter == limit) {
                flag2 = 0;
                flag3 = 1;
                counter = limit -5;
            }
        } else if (flag3 == 1) {
            TvTime3.setText(String.valueOf(counter));
            if (counter == limit) {
                flag3 = 0;
                flag4 = 1;
                counter = limit -5;
            }
        } else if (flag4 == 1) {
            TvTime4.setText(String.valueOf(counter));
            if (counter == limit) {
                flag4 = 0;
                flag1 = 1;
                counter = limit;
                limit = limit + 5 ;
            }
        }
    }

}
