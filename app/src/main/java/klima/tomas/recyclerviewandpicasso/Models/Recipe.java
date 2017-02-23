
package klima.tomas.recyclerviewandpicasso.Models;

import com.google.gson.annotations.SerializedName;

public class Recipe {

	@SerializedName("title")
	private String title;
	@SerializedName("ingredients")
	private String ingredients;
	@SerializedName("thumbnail")
	private String thumbnail;

	public String getTitle() {
		return title;
	}


	public String getIngredients() {
		return ingredients;
	}


	public String getThumbnail() {
		return thumbnail;
	}

}
