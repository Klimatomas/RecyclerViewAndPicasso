package klima.tomas.recyclerviewandpicasso;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;


public class CustomApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Fabric.with(this, new Crashlytics());

	}
}
