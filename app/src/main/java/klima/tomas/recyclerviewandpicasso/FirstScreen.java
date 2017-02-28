package klima.tomas.recyclerviewandpicasso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class FirstScreen extends AppCompatActivity {
	@BindView(R.id.searchQuery) EditText searchQuery;
	@BindView(R.id.searchButton) Button searchButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_screen);

		ButterKnife.bind(this);
	}


	@OnClick(R.id.searchButton)
	void clickButton() {
		String query = searchQuery.getText().toString();
		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra("searchQuery", query);
		startActivity(intent);
	}

}
