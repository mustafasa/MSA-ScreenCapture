# MSA-ScreenCapture
An Android library to capture current Activity screenshot and meta-data/UI element along with it's sub-view or any 
window(Dialog-box, Pop-up window, Toaster etc).

## Getting Started
```
1.Download the library (using Git, or a zip archive)
2.Unzip folder and copy the path
3.In your project in Android Studio
4.Go to File > New > Import Module > \your path\MSA-ScreenCapture-master\Capturelibrary\
5.Again go to File > project structure > Select your app module > click on dependencies tab > Click '+' 
6.select Module Dependency > select :CaptureLibrary
7.Wait for build to complete.
Tada!! Library is ready to use.
8.you need to add these permission in manifest in order to image file in sdcard.
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>

```
## Usage in Activity
So this is exciting part, we need to call a method in your testcase or in activity and rest is done by ScreenCapture library.
```
//Let's start in activity
//Must be called after view is ready, it doesn't make sense to call if the view is not ready, if you try to call before is view ready
//it result as false.

//This method will create screenshot of current view, return true or false.
  boolean success= MSA.CaptureScreenShot(this);
  
//This method will create screenshot of current view with desire name.Note:do not use same name it will override existing images.
  boolean success=MSA.CaptureScreenShot(this,"desirename");   
  
//This method result back with screenIdentifiers 
ArrayList<ScreenIdentifier> identifier= MSA.CaptureScreenIdentifier(this);
 
//if you loop through arraylist, it provide each element information
//eg:
ScreenIdentifier firstUIElement= dd.get(0);
firstUIElement.getUiIdentifier();
firstUIElement.getUiHeight();
//////////////////////////////soo on

```
## Usage in Instrument testActivity
The main purpose of this library is to capture screenshot while testing and capture meta data of each UI element, which can be utilized
for diagnosting and most important it can be benefit for Linguistic to cross check with different languages.
  
```
//In Instrument test case
@Rule
  public IntentsTestRule<someActivity> intentsTestRule = new IntentsTestRule<>(
      someActivity.class);
@Test
  public void test() {
  //I recommend to add sleep thread, because it run really fast can capture unreliable capture
  Thread.sleep(750);
  
//This method will create screenshot of current view, return true or false.
  boolean success= MSA.CaptureScreenShot(intentsTestRule.getActivity());
  
//This method will create screenshot of current view with desire name.Note:do not use same name it will override existing images.
  boolean success=MSA.CaptureScreenShot(intentsTestRule.getActivity(),"desirename");   
  
 //This method result back with screenIdentifiers 
  ArrayList<ScreenIdentifier> identifier= MSA.CaptureScreenIdentifier(intentsTestRule.getActivity());
  }
    
```
