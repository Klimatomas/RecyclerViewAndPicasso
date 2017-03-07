package klima.tomas.recyclerviewandpicasso.remote;

import klima.tomas.recyclerviewandpicasso.Models.Puppy;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RecipeAPI {
	String BASE_URL = "http://www.recipepuppy.com/api/";

	@GET(".")
	Call<Puppy> getResult(
			@Query("q") String searchQuery
	);

	class Factory {
		private static RecipeAPI service;

		public static RecipeAPI getInstance() {
			if (service == null) {
				Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
				service = retrofit.create(RecipeAPI.class);
				return service;

			} else {
				return service;
			}
		}
	}
}
