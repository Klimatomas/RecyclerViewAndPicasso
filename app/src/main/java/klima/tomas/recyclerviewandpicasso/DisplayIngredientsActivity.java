package klima.tomas.recyclerviewandpicasso;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.Arrays;

import butterknife.BindView;
import klima.tomas.recyclerviewandpicasso.Models.Recipe;
import klima.tomas.recyclerviewandpicasso.adapter.IngAdapter;
import klima.tomas.recyclerviewandpicasso.internal.ParseIngredients;


public class DisplayIngredientsActivity extends BaseActivity {
//	@BindView(R.id.recipeText) TextView recipeText;
	@BindView(R.id.detailPic) ImageView detailPic;
	@BindView(R.id.ingView) RecyclerView ingView;

	private IngAdapter adapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		ingView.setLayoutManager(new LinearLayoutManager(this));


		Recipe recipe = getIntent().getParcelableExtra("recipe");

		getSupportActionBar().setTitle(recipe.getTitle());
		Picasso.with(this).load(recipe.getThumbnail().isEmpty() ? "https://i.gyazo.com/88d02d711b1be8733bcb52d5050c5457.png" : recipe.getThumbnail()).resize(500, 500).into(detailPic);

		adapter = new IngAdapter(ParseIngredients.getIngredients(recipe.getIngredients()));
		ingView.setAdapter(adapter);

	}


	@Override public int getActivityLayout() {
		return R.layout.activity_display_ingredients;
	}
}
