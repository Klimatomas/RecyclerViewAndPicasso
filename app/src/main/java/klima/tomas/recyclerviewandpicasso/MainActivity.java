package klima.tomas.recyclerviewandpicasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import klima.tomas.recyclerviewandpicasso.Models.Puppy;
import klima.tomas.recyclerviewandpicasso.remote.RecipeAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
	@BindView(R.id.txt) TextView txt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ButterKnife.bind(this);

		RecipeAPI.Factory.getInstance().getResult().enqueue(new Callback<Puppy>() {
			@Override public void onResponse(Call<Puppy> call, Response<Puppy> response) {
				txt.setText(response.body().getResults().get(1).getIngredients());
			}

			@Override public void onFailure(Call<Puppy> call, Throwable t) {
				Log.e("Failed", t.getMessage());
			}
		});

	}


}
