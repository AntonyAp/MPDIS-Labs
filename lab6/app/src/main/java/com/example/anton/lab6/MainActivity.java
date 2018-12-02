package com.example.anton.lab6;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends Activity {
    EditText et_name,et_content,et_read;
    Button b_save,b_read;
    TextView result;
    FileOutputStream fos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1000);
        }

et_name=(EditText)findViewById(R.id.et_name);
        et_content=(EditText)findViewById(R.id.et_content);
        b_save=(Button) findViewById(R.id.b_save);
        b_read=(Button) findViewById(R.id.b_read);
        result=(TextView) findViewById(R.id.result);
        et_read=(EditText)findViewById(R.id.et_read);
b_save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
String fileName = et_name.getText().toString();
String content = et_content.getText().toString();
saveTextAsFile(fileName,content);
    }
});
b_read.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String filename = et_read.getText().toString();
readFile(filename);
    }
});
}
public void readFile(String fileName)
{

    String file=fileName+".txt";
    StringBuilder sb =new StringBuilder();
    try {
File textFile=new File(Environment.getExternalStorageDirectory(),file);
FileInputStream fis =new FileInputStream(textFile);
        InputStreamReader isr=new InputStreamReader(fis);
        BufferedReader buff=new BufferedReader(isr);
        String line=null;
        while((line=buff.readLine())!=null)
            sb.append(line+"\n");
fis.close();
result.setText(sb);

    } catch (FileNotFoundException e) {
        e.printStackTrace();
        Toast.makeText(this, "file not found", Toast.LENGTH_SHORT).show();
    }catch(IOException t){
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
        t.printStackTrace();
    }

}
public void saveTextAsFile(String filename,String content){
        String fileName=filename+".txt";
      File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath(),fileName);
    try {
          fos = new FileOutputStream(file,true);
       fos.write(content.getBytes());
       fos.write(System.getProperty("line.separator").getBytes());
        fos.close();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
    }catch(IOException e){
        e.printStackTrace();
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }
}
    @Override
    public void onRequestPermissionsResult(int requestCode,  @NonNull String[] permissions,  @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case 1000 :
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"Permisson granted",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "Permisson denied", Toast.LENGTH_SHORT).show();
                    finish();
                }
        }

    }
}

