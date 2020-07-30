package com.example.deepa.flyhigh;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean ismute=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        findViewById(R.id.play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Gameactivity.class));
            }
        });
        TextView highscoretxt = findViewById(R.id.highscore);
        final SharedPreferences sharedPreferences= getSharedPreferences("game",MODE_PRIVATE);
        highscoretxt.setText("Highscore : "+sharedPreferences.getInt("highscore",0));
        ismute = sharedPreferences.getBoolean("ismute",false);

        final ImageView volumecontrol = findViewById(R.id.volumecontrol);

        if(ismute)
        {
            volumecontrol.setImageResource(R.drawable.ic_volume_off_black_24dp);
        }
        else
        {
            volumecontrol.setImageResource(R.drawable.ic_volume_up_black_24dp);
        }

        volumecontrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ismute= !ismute;
                if(ismute)
                {
                    volumecontrol.setImageResource(R.drawable.ic_volume_off_black_24dp);
                }
                else
                {
                    volumecontrol.setImageResource(R.drawable.ic_volume_up_black_24dp);
                }

                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putBoolean("ismute",ismute);
                editor.apply();
            }
        });
    }
}

