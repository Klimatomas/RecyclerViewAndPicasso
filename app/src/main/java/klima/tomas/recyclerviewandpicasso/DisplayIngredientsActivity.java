package klima.tomas.recyclerviewandpicasso;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import butterknife.BindView;
import klima.tomas.recyclerviewandpicasso.Models.Recipe;

public class DisplayIngredientsActivity extends BaseActivity {
	@BindView(R.id.recipeText) TextView recipeText;
	@BindView(R.id.detailPic) ImageView detailPic;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		Recipe recipe = getIntent().getParcelableExtra("recipe");

		getSupportActionBar().setTitle(recipe.getTitle());
		Picasso.with(this).load(recipe.getThumbnail().isEmpty() ? "https://i.gyazo.com/88d02d711b1be8733bcb52d5050c5457.png" : recipe.getThumbnail()).resize(500, 500).into(detailPic);
		recipeText.setText(recipe.getIngredients());

	}

	@Override public int getActivityLayout() {
		return R.layout.activity_display_ingredients;
	}
}
