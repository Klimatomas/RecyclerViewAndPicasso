package klima.tomas.recyclerviewandpicasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import klima.tomas.recyclerviewandpicasso.Models.Puppy;
import klima.tomas.recyclerviewandpicasso.adapter.RecAdapter;
import klima.tomas.recyclerviewandpicasso.remote.RecipeAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
	private RecAdapter adapter;

	@BindView(R.id.recView) RecyclerView recView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);

		String searchQuery = getIntent().getStringExtra("searchQuery");
		System.out.println("Query = " + searchQuery);
		recView.setLayoutManager(new LinearLayoutManager(this));

		RecipeAPI.Factory.getInstance()
				.getResult(searchQuery)
				.enqueue(new Callback<Puppy>() {
							 @Override public void onResponse(Call<Puppy> call, Response<Puppy> response) {

								 adapter = new RecAdapter(response.body().getResults());
								 recView.setAdapter(adapter);


							 }

							 @Override public void onFailure(Call<Puppy> call, Throwable t) {
								 Log.e("Failed", t.getMessage());
							 }

						 }
				);

	}

}
