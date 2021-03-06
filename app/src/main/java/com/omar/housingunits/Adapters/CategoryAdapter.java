package com.omar.housingunits.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.omar.housingunits.Models.CategoryModel;
import com.omar.housingunits.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private final List<CategoryModel> list;
    private onCategoryListener onCategoryListener;

    public CategoryAdapter(List<CategoryModel> list, onCategoryListener onCategoryListener) {
        this.list = list;
        this.onCategoryListener = onCategoryListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false), onCategoryListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(list.get(position).getTitle());
        holder.no_ads.setText(list.get(position).getNo_ads());
        holder.icon.setImageResource(list.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title, no_ads;
        ImageView icon;
        onCategoryListener onCategoryListener;

        public ViewHolder(@NonNull View itemView, onCategoryListener onCategoryListener) {
            super(itemView);

            title = itemView.findViewById(R.id.item_category_title);
            no_ads = itemView.findViewById(R.id.item_category_no_ads);
            icon = itemView.findViewById(R.id.item_category_image);
            this.onCategoryListener = onCategoryListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onCategoryListener.onCategoryClick(getAdapterPosition());
        }
    }

    public interface onCategoryListener {
        void onCategoryClick(int position);
    }
}
