package softjob.softjob;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Diego on 15/11/2017.
 */

public class SoftJobApp extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

    }
}
