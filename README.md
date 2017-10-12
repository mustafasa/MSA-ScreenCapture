# MSA-ScreenCapture
An Android library to capture current Activity screenshot and meta-data/UI element along with it's sub-view or any 
window(Dialog-box, Pop-up window, Toaster etc).

## Getting Started
```
1.Download the library (using Git, or a zip archive)
2.Unzip folder and copy the path
3.Open your project in Android Studio
4.Go to File > New > Import Module > \your path\MSA-ScreenCapture-master\Capturelibrary\
5.Now go to File > project structure > Select your app module > click on dependencies tab > Click '+' 
6.Select Module Dependency > select :CaptureLibrary
7.Wait for build to complete.
Tada!! Library is ready to use.
8.Add these permission in manifest in order to store screenshots in sdcard.
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>

```
## Usage in Activity
Finally exciting part, Let's utilied library in activity.
```
//Must be called after view is ready, it doesn't make sense to call these methods before view is ready.
//If called before the view is ready result's as false.

//This method will create screenshot of current view, returns boolean.
  boolean success= MSA.CaptureScreenShot(this);
  
//This method will create screenshot of current view with desire name.
//Note: If used repeated name,results in overriding existing images.
  boolean success=MSA.CaptureScreenShot(this,"desirename");   
  
//This method capture meta-data of UI elemnts and return back with arraylist of screenIdentifier.
 ArrayList<ScreenIdentifier> identifier= MSA.CaptureScreenIdentifier(this);
 
//if you loop through arraylist, it provide each element information
//eg:
 ScreenIdentifier firstUIElement= dd.get(0);
 firstUIElement.getUiIdentifier();
 firstUIElement.getUiHeight();
///and many more attributes are available..... 

```
## Usage in Instrument testActivity
The main purpose of this library is to ease capture screenshot while testing and capture meta data of each UI element, 
which can be utilized for numerous task eg: diagnosting,Linguistic to cross check with different languages.
Sky is the limit it can be utilize in many ways.
  
```
//In Instrument test case
@Rule
  public IntentsTestRule<someActivity> intentsTestRule = new IntentsTestRule<>(
      someActivity.class);
@Test
  public void test() {
      //Recommend to add sleep thread,Expresso thread is asyn to UI thread result improper capturation 
       Thread.sleep(750);.

      //This method will create screenshot of current view, returns boolean.
        boolean success= MSA.CaptureScreenShot(intentsTestRule.getActivity());

      //This method will create screenshot of current view with desire name.
      //Note: If used repeated name,results in overriding existing images.
        boolean success=MSA.CaptureScreenShot(intentsTestRule.getActivity(),"desirename");   

       //This method capture meta-data of UI elemnts and return back with arraylist of screenIdentifier.
        ArrayList<ScreenIdentifier> identifier= MSA.CaptureScreenIdentifier(intentsTestRule.getActivity());
  }
    
```
## Sample App

Yes, I've created sample application utilzing screenCapture library in both activity and UI test case.
Please check sample code, after fetching soure code.


## License

Copyright 2017 MUSTAFA SYED ARIF

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
