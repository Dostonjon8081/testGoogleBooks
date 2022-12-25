package com.example.testgooglebooks.ui.search;

import android.annotation.SuppressLint;
import android.net.Uri;
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

    private final ArrayList<AdapterModel> models = new ArrayList<>();
    private ClickBooksItem iClick;


    public RvBookAdapter(ClickBooksItem clickBooksItem) {
        this.iClick = clickBooksItem;
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

    void initList(List<AdapterModel> models) {
        this.models.clear();
        this.models.addAll(models);
        notifyItemRangeInserted(0, models.size());
    }

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

            fav.setOnClickListener(view -> {
                iClick.clickFavImage(models.get(getAdapterPosition()));
                fav.setImageResource(R.drawable.ic_star);
            });
        }

        @SuppressLint("ResourceType")
        public void onBind(AdapterModel model) {
            Glide.with(itemView)
                    .load(Uri.parse(model.getImage()))
                    .override(86, 108)
                    .placeholder(R.drawable.ic_book)
//                    .error(R.drawable.ic_book)
                    .into(image);

            title.setText(model.getName());
            author.setText(model.getAuthors().toString());
            if (model.isFav()) fav.setImageResource(R.drawable.ic_star);
            else fav.setImageResource(R.drawable.ic_empty_star);
        }
    }
}
