package klima.tomas.recyclerviewandpicasso.adapter;


import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import klima.tomas.recyclerviewandpicasso.DisplayIngredients;
import klima.tomas.recyclerviewandpicasso.Models.Recipe;
import klima.tomas.recyclerviewandpicasso.R;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.RecHolder> {
	private List<Recipe> listData;

	public RecAdapter(List<Recipe> listData) {
		this.listData = listData;

	}


	@Override public RecHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
		return new RecHolder(view);
	}

	@Override public void onBindViewHolder(final RecHolder holder, int position) {
		final Recipe item = listData.get(position);
		holder.title.setText(item.getTitle());

		Picasso.with(holder.itemView.getContext())
				.load(String.valueOf((item.getThumbnail().isEmpty() ? "https://i.gyazo.com/88d02d711b1be8733bcb52d5050c5457.png" : item.getThumbnail())))
				.into(holder.icon);

		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override public void onClick(View v) {
				Intent intent = new Intent(holder.itemView.getContext(), DisplayIngredients.class);
				intent.putExtra("recipe", item);
				holder.itemView.getContext().startActivity(intent);
			}
		});
	}

	;

	@Override public int getItemCount() {
		return listData.size();
	}

	class RecHolder extends RecyclerView.ViewHolder {

		private TextView title;
		private ImageView icon;

		public RecHolder(View itemView) {
			super(itemView);

			title = (TextView) itemView.findViewById(R.id.txticek);
			icon = (ImageView) itemView.findViewById(R.id.item_icon);
		}
	}


}