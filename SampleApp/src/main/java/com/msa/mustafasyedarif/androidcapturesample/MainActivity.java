package com.msa.mustafasyedarif.androidcapturesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.msa.mustafasyedarif.screenshotlibrary.MSA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MSA.CaptureScreenShot(this);
    }
}
