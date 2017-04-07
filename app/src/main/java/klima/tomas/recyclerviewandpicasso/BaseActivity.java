package klima.tomas.recyclerviewandpicasso;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import klima.tomas.recyclerviewandpicasso.background.UserSpying;

public abstract class BaseActivity extends AppCompatActivity {


	@Nullable @BindView(R.id.toolbar) Toolbar toolbar;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		Intent mServiceIntent = new Intent(this, UserSpying.class);
		startService(mServiceIntent);

		super.onCreate(savedInstanceState);
		int activityLayout = getActivityLayout();
		if (activityLayout != 0) {
			setContentView(activityLayout);
			ButterKnife.bind(this);

		}

		if (toolbar != null) {
			setSupportActionBar(toolbar);
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);

			toolbar.setNavigationOnClickListener(v -> onBackPressed());
		}
	}


	public abstract @LayoutRes int getActivityLayout();


}
