package klima.tomas.recyclerviewandpicasso;


import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

	@BindView(R.id.toolbar) Toolbar toolbar;
	private int activityLayout;


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

		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				onBackPressed();
			}
		});

	}

	public abstract @LayoutRes int getActivityLayout();

}
