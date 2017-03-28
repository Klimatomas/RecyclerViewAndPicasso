package klima.tomas.recyclerviewandpicasso;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import com.crashlytics.android.Crashlytics;

import butterknife.BindView;
import butterknife.OnClick;
import io.fabric.sdk.android.Fabric;


public class SearchActivity extends BaseActivity {
	@BindView(R.id.searchQuery) EditText searchQuery;
	@BindView(R.id.searchButton) Button searchButton;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Fabric.with(this, new Crashlytics());


		searchQuery.setOnEditorActionListener((v, actionId, event) -> {
			if (actionId == EditorInfo.IME_ACTION_DONE) {
				searchButton.performClick();
				return true;
			}
			return false;
		});
	}

	@Override public int getActivityLayout() {
		return R.layout.activity_search;
	}


	@OnClick(R.id.searchButton)
	void clickButton() {

		String query = searchQuery.getText().toString();
		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra("searchQuery", query);
		startActivity(intent);
	}

}

