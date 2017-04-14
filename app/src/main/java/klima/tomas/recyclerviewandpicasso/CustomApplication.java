package klima.tomas.recyclerviewandpicasso;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;


public class CustomApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		if (BuildConfig.DEBUG) {
			Timber.plant(new Timber.DebugTree());
		} else {
			Fabric.with(this, new Crashlytics());
		}
	}
}
