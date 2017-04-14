package klima.tomas.recyclerviewandpicasso;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import klima.tomas.recyclerviewandpicasso.Models.Puppy;
import klima.tomas.recyclerviewandpicasso.adapter.RecAdapter;
import klima.tomas.recyclerviewandpicasso.remote.RecipeAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


public class MainActivity extends BaseActivity {
	private RecAdapter adapter;

	@BindView(R.id.recView) RecyclerView recView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		String searchQuery = getIntent().getStringExtra("searchQuery");
		recView.setLayoutManager(new LinearLayoutManager(this));

		RecipeAPI.Factory.getInstance()
				.getResult(searchQuery)
				.enqueue(new Callback<Puppy>() {
							 @Override public void onResponse(Call<Puppy> call, Response<Puppy> response) {

								 adapter = new RecAdapter(response.body().getResults());
								 recView.setAdapter(adapter);


							 }

							 @Override public void onFailure(Call<Puppy> call, Throwable t) {
								 Timber.wtf(t, "Failed");
							 }

						 }
				);

	}

	@Override public int getActivityLayout() {
		return R.layout.activity_main;
	}

}
