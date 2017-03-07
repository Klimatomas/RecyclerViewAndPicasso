package klima.tomas.recyclerviewandpicasso;

import android.os.Bundle;
import android.widget.TextView;


import butterknife.BindView;
import klima.tomas.recyclerviewandpicasso.Models.Recipe;

public class DisplayIngredientsActivity extends BaseActivity {
	@BindView(R.id.recipeText) TextView recipeText;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Recipe recipe = getIntent().getParcelableExtra("recipe");

		recipeText.setText(recipe.getIngredients());
	}

	@Override public int getActivityLayout() {
		return R.layout.activity_display_ingredients;
	}
}
