package com.example.project155.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.project155.Domain.ItemsSlider;
import com.example.project155.R;

import java.util.List;

public class SliderAdapters extends RecyclerView.Adapter<SliderAdapters.SliderViewHolder> {

    private List<ItemsSlider> itemSliders;
    private ViewPager2 viewPager2;
    private Context context;

    public SliderAdapters(List<ItemsSlider> itemSliders, ViewPager2 viewPager2) {
        this.itemSliders = itemSliders;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(itemSliders.get(position));
        if (position == itemSliders.size() - 2) {
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return itemSliders.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageSlide);
        }

        void setImage(ItemsSlider itemsSlider) {

            RequestOptions requestOptions = new RequestOptions();
            requestOptions = requestOptions.transforms(new CenterCrop(), new RoundedCorners(60));
            Glide.with(context)
                    .load(itemsSlider.getImage())
                    .apply(requestOptions)
                    .into(imageView);
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            itemSliders.addAll(itemSliders);
            notifyDataSetChanged();
        }
    };

}
