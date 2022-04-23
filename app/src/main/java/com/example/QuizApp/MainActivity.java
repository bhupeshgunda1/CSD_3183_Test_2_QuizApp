package com.example.QuizApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView queid;
    TextView que;
    TextView ans;
    Button add;
    Button update;
    Button delete;
    Button submit;
    Button preview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queid = (TextView)findViewById(R.id.textView);
        que   = (TextView)findViewById(R.id.textView2);
        ans   = (TextView)findViewById(R.id.textView3);
        add = (Button) findViewById(R.id.button2);
        update = (Button) findViewById(R.id.button3);
        delete = (Button) findViewById(R.id.button4);
        submit = (Button) findViewById(R.id.button5);
        preview = (Button) findViewById(R.id.button6);
    }

}