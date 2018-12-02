package com.example.anton.lab2_edited;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameinput;
    EditText surnameinput;
    EditText middlenameinput;
    EditText facultyinput;
    EditText groupnumberinput;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameinput=(EditText)findViewById(R.id.nameinput);
        surnameinput=(EditText)findViewById(R.id.surnameinput);
        middlenameinput=(EditText)findViewById(R.id.middlenameinput);
        groupnumberinput=(EditText)findViewById(R.id.groupnumberinput);
        facultyinput=(EditText)findViewById(R.id.facultyinput);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(R.string.info)
                        .setMessage(surnameinput.getText().toString() + "\n" + nameinput.getText().toString() + "\n" +middlenameinput.getText().toString() + "\n" + groupnumberinput.getText().toString() + "\n" + facultyinput.getText().toString())
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                }
                        );
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

    }
}


