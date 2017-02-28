package klima.tomas.recyclerviewandpicasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;
import klima.tomas.recyclerviewandpicasso.Models.Recipe;

public class DisplayIngredients extends AppCompatActivity {
	@BindView(R.id.recipeText) TextView recipeText;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_ingredients);

		ButterKnife.bind(this);

		Recipe recipe = getIntent().getParcelableExtra("recipe");

		recipeText.setText(recipe.getIngredients());
	}
}
