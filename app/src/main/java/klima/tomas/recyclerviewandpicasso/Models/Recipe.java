package klima.tomas.recyclerviewandpicasso.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class Recipe implements Parcelable {

	@SerializedName("title")
	private String title;
	@SerializedName("ingredients")
	private String ingredients;
	@SerializedName("thumbnail")
	private String thumbnail;

	public String getTitle() {
		return title;
	}


	public List<String> getIngredients() {
		return Arrays.asList(ingredients.split(","));
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public Recipe(Parcel in) {
		title = in.readString();
		ingredients = in.readString();
		thumbnail = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(title);
		dest.writeString(ingredients);
		dest.writeString(thumbnail);
	}

	@SuppressWarnings("unused")
	public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
		@Override
		public Recipe createFromParcel(Parcel in) {
			return new Recipe(in);
		}

		@Override
		public Recipe[] newArray(int size) {
			return new Recipe[size];
		}
	};
}