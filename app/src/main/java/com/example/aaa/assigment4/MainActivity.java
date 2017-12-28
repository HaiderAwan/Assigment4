package com.example.aaa.assigment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    int finalValue= -1;
    EditText editText;
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        Integer a = event.getTrigger();
        tv1.setText(a.toString());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv);
        EventBus.getDefault().register(this);

        Button button = (Button) findViewById(R.id.startActivity);
        editText = (EditText) findViewById(R.id.limit);

        //final String a = editText.getText().toString();
//        finalValue=Integer.parseInt(editText.getText().toString());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText.getText().toString().length() > 0){
                    finalValue=Integer.parseInt(editText.getText().toString());
                }
                Intent intent = new Intent(MainActivity.this, MyIntentService.class);
                intent.putExtra("Value",finalValue+1);
                startService(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.stopActivity);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //stopService(new Intent(MainActivity.this, MyIntentService.class));
           MyIntentService.shouldContinue=false;
            }

        });

    }


}
