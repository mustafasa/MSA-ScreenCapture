package com.msa.mustafasyedarif.androidcapturesample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.msa.mustafasyedarif.screenshotlibrary.MSA;
import com.msa.mustafasyedarif.screenshotlibrary.ScreenIdentifier;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Created by arifm2 on 10/18/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private MainActivity activity;

    @Rule
    public ActivityTestRule<MainActivity> intentsTestRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void test() throws InterruptedException {
        //Recommend to add sleep thread,Expresso thread is asyn to UI thread result improper capturation
        Thread.sleep(750);

        //This method will create screenshot of current view, returns boolean.
        boolean success= MSA.captureScreenShot(intentsTestRule.getActivity());

        //This method will create screenshot of current view with desire name.
        //Note: If used repeated name,results in overriding existing images.
        boolean success2=MSA.captureScreenShot(intentsTestRule.getActivity(),"desirename");

        //This method capture meta-data of UI elemnts and return back with arraylist of screenIdentifier.
        List<ScreenIdentifier> identifier= MSA.captureScreenIdentifier(intentsTestRule.getActivity());
    }

}
