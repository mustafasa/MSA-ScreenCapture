package com.msa.mustafasyedarif.androidcapturesample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.msa.mustafasyedarif.screenshotlibrary.MSA;
import com.msa.mustafasyedarif.screenshotlibrary.ScreenIdentifier;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String TAG = "MSA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void takeScreenshot(View view) {

        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
            return;
        }
        //This method will create screenshot of current view, returns boolean.
        boolean success = MSA.CaptureScreenShot(this);
        Log.d(TAG, String.valueOf(success));
        //This method will create screenshot of current view with desire name.
        //Note: If used repeated name,results in overriding existing images.
        boolean successAgain = MSA.CaptureScreenShot(this, "desirename");
        Log.d(TAG, String.valueOf(successAgain));

        //This method capture meta-data of UI elemnts and return back with arraylist of
        // screenIdentifier.
        ArrayList<ScreenIdentifier> identifier = MSA.CaptureScreenIdentifier(this);

        //if you loop through arraylist, it provide each element information
        //eg:
        ScreenIdentifier firstUIElement = identifier.get(0);
        Log.d(TAG, firstUIElement.getUiIdentifier());
        Log.d(TAG, firstUIElement.getUiType());
        ///and many more attributes are available.....


    }
}
