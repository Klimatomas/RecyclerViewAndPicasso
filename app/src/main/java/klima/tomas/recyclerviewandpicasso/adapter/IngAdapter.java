package klima.tomas.recyclerviewandpicasso.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import klima.tomas.recyclerviewandpicasso.R;

public class IngAdapter extends RecyclerView.Adapter<IngAdapter.IngHolder> {
	private List<String> ingredientList;

	public IngAdapter(List<String> ingredientList) {
		this.ingredientList = ingredientList;

	}
	@Override public IngAdapter.IngHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ingredients, parent, false);
		return new IngHolder(view);
	}

	@Override public void onBindViewHolder(IngAdapter.IngHolder holder, int position) {
		final String item = ingredientList.get(position);
		holder.ingredient.setText(item.trim());

	}

	@Override public int getItemCount() {
		System.out.print(ingredientList.size());
		return ingredientList.size();
	}

	class IngHolder extends RecyclerView.ViewHolder {
		private TextView ingredient;

		IngHolder(View itemView) {
			super(itemView);

			ingredient = (TextView) itemView.findViewById(R.id.ingredient);
		}
	}
}
