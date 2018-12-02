package com.example.anton.lab7;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if ( checkSelfPermission(Manifest.permission.WRITE_CONTACTS)
                != PackageManager.PERMISSION_GRANTED&&checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.READ_SMS) !=PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.WRITE_CONTACTS,Manifest.permission.CAMERA,Manifest.permission.READ_CONTACTS,Manifest.permission.READ_SMS},1000);
        }

    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1000:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED
                        &&grantResults[3] == PackageManager.PERMISSION_GRANTED ) {
                    Toast.makeText(this, "Permisson granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permisson denied", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }
    }
}
