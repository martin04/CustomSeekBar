package com.example.root.customseekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeverityBar bar = new SeverityBar(this);
        bar.setDotsSize(25);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        bar.setLayoutParams(params);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.idid);
        rl.addView(bar);
    }
}
