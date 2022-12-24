package com.example.testgooglebooks.search;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testgooglebooks.R;
import com.example.testgooglebooks.models.AdapterModel;

import java.util.ArrayList;
import java.util.List;

public class RvBookAdapter extends RecyclerView.Adapter<RvBookAdapter.VH> {

    private ArrayList<AdapterModel> models;

    public RvBookAdapter(List<AdapterModel> models) {
        if (models != null) {
            this.models.addAll(models);

        }
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.book_rv_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.onBind(models.get(position));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

//    void initList(List<AdapterModel> models) {
//        this.models.addAll(models);
//        notifyItemRangeInserted(0, models.size());
//    }

    public class VH extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView title;
        private TextView author;
        private ImageView fav;

        public VH(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.book_image);
            title = itemView.findViewById(R.id.book_name);
            author = itemView.findViewById(R.id.book_author);
            fav = itemView.findViewById(R.id.book_fav);
        }

        @SuppressLint("ResourceType")
        public void onBind(AdapterModel model) {
            Glide.with(itemView)
                    .load(model.getImage())
                    .placeholder(R.id.book_image)
                    .error(R.drawable.ic_book)
                    .into(image);

            title.setText(model.getName());
            author.setText(model.getAuthors().get(0));
            if (model.isFav()) fav.setImageResource(R.drawable.star_selector);
            else fav.setImageResource(R.drawable.ic_empty_star);
        }
    }
}
