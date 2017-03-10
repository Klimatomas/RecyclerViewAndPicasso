package klima.tomas.recyclerviewandpicasso;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SearchActivity extends AppCompatActivity {
	@BindView(R.id.searchQuery) EditText searchQuery;
	@BindView(R.id.searchButton) Button searchButton;




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_screen);
		ButterKnife.bind(this);


		searchQuery.setOnEditorActionListener(new EditText.OnEditorActionListener() {
			@Override public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_DONE) {
					searchButton.performClick();
					return true;
				}
				return false;
			}
		});
	}


	@OnClick(R.id.searchButton)
	void clickButton() {
		String query = searchQuery.getText().toString();
		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra("searchQuery", query);
		startActivity(intent);
	}

}

