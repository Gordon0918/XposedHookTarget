package com.example.xposedhooktarget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = (Button)findViewById(R.id.bt_1);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HookDemo hookdemo = new HookDemo();
                if(hookdemo == null){
                    Log.d("HookDemo", "new HookDemo() failed");
                }
                hookdemo.hookDemoTest();
            }
        });
    }
}
