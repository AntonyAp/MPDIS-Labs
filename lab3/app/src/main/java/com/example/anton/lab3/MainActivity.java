package com.example.anton.lab3;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

RelativeLayout screenLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenLayout = (RelativeLayout) findViewById(R.id.screenLayout);
    }

    public void goGreen(View v) {
        screenLayout.setBackgroundColor(Color.GREEN);
    }

    public void goRed(View v) {
        screenLayout.setBackgroundColor(Color.RED);
    }

    public void goBlue(View v) {
        screenLayout.setBackgroundColor(Color.BLUE);
    }

    public void goYellow(View v)
    {
        screenLayout.setBackgroundColor(Color.YELLOW);
    }
    public void goPic(View v)
    {
        screenLayout.setBackgroundResource(R.drawable.abv);
    }
    public void aboutdev(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.info)
                .setMessage("Developed by Alekseeva and Dishuk")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        }
                );
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
