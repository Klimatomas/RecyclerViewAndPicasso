package klima.tomas.recyclerviewandpicasso;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

	@BindView(R.id.toolbar) Toolbar toolbar;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		int activityLayout = getActivityLayout();
		if (activityLayout != 0) {
			setContentView(activityLayout);
			ButterKnife.bind(this);

		}
		setSupportActionBar(toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		toolbar.setNavigationOnClickListener(v -> onBackPressed());

	}

	public abstract @LayoutRes int getActivityLayout();

}
