package com.example.bionic_leg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.ViewHolder> {
    private ArrayList<RecyclerListItem> RecyclerListItem;

    public CardRecyclerAdapter(ArrayList<RecyclerListItem> RecyclerListItem, Context context) {
        this.RecyclerListItem = RecyclerListItem;
        this.context = context;
    }

    private Context context;


    @NonNull
    @Override
    public CardRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardRecyclerAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(RecyclerListItem.get(position).getImage());
        holder.textView.setText(RecyclerListItem.get(position).getText());

        holder.cardView.setOnClickListener(e -> {
            Intent newIntent = null;
            switch (position) {
                case 0:
                    newIntent = new Intent(holder.itemView.getContext(), SettingActiivty.class);
                case 1:
                    newIntent = new Intent(holder.itemView.getContext(), DeviceActivity.class);
                case 2:
                    newIntent = new Intent(holder.itemView.getContext(), BatterieActivity.class);

            }

            context.startActivity(newIntent);

        });
    }

    @Override
    public int getItemCount() {
        return RecyclerListItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
