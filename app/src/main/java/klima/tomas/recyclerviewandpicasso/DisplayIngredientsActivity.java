package klima.tomas.recyclerviewandpicasso;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import klima.tomas.recyclerviewandpicasso.Models.Recipe;
import klima.tomas.recyclerviewandpicasso.adapter.IngAdapter;


public class DisplayIngredientsActivity extends BaseActivity {
	@BindView(R.id.detailPic) ImageView detailPic;
	@BindView(R.id.ingView) RecyclerView ingView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		ingView.setLayoutManager(new LinearLayoutManager(this));


		Recipe recipe = getIntent().getParcelableExtra("recipe");

		getSupportActionBar().setTitle(recipe.getTitle());
		Picasso.with(this).load(recipe.getThumbnail().isEmpty() ? "https://i.gyazo.com/88d02d711b1be8733bcb52d5050c5457.png" : recipe.getThumbnail()).resize(500, 500).into(detailPic);

		IngAdapter adapter = new IngAdapter(recipe.getIngredients());
		ingView.setAdapter(adapter);

	}

	public static Intent getStartIntent(Context context, Recipe recipe) {
		return new Intent(context, DisplayIngredientsActivity.class)
				.putExtra("recipe", recipe);
	}


	@Override public int getActivityLayout() {
		return R.layout.activity_display_ingredients;
	}

}
