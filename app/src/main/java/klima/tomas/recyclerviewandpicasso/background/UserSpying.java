package klima.tomas.recyclerviewandpicasso.background;


import android.Manifest;
import android.app.IntentService;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


public class UserSpying extends IntentService implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {
	GoogleApiClient mGoogleApiClient;

	public UserSpying() {
		super("UserSpying");
	}

	@Override protected void onHandleIntent(Intent workIntent) {
		mGoogleApiClient.connect();

	}

	@Override public void onStart(Intent intent, int startId) {
		if (mGoogleApiClient == null) {
			mGoogleApiClient = new GoogleApiClient.Builder(this)
					.addConnectionCallbacks(this)
					.addOnConnectionFailedListener(this)
					.addApi(LocationServices.API)
					.build();
		}
		super.onStart(intent, startId);


	}


	@Override public void onConnected(@Nullable Bundle bundle) {
		LocationRequest mLocationRequest = LocationRequest.create();
		mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
		mLocationRequest.setInterval(1000);
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			// request permissions?
			return;
		}
		LocationServices.FusedLocationApi.requestLocationUpdates(
				mGoogleApiClient, mLocationRequest, this);

	}

	@Override public void onConnectionSuspended(int i) {

	}

	@Override public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

	}

	@Override public void onLocationChanged(Location location) {
		System.out.println("LOCATION CHANGED");
		System.out.println("Location received: " + location.toString());
	}
}
