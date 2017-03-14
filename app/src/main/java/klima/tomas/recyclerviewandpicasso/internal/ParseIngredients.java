package klima.tomas.recyclerviewandpicasso.internal;


import java.util.Arrays;
import java.util.List;

public class ParseIngredients {
	public static List<String> getIngredients(String ingredients) {
		return Arrays.asList(ingredients.split(","));
	}
}
