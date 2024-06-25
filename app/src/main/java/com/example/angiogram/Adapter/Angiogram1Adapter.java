package com.example.angiogram.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.angiogram.Model.Angiogram1Model;
import com.example.angiogram.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Angiogram1Adapter extends RecyclerView.Adapter<Angiogram1Adapter.ViewHolder>{

    Context context;
    List<Angiogram1Model> angiogram1List;

    public Angiogram1Adapter(Context context, List<Angiogram1Model> angiogram1List) {
        this.context = context;
        this.angiogram1List = angiogram1List;
    }

    @NonNull
    @Override
    public Angiogram1Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.angiogram1item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Angiogram1Adapter.ViewHolder holder, int position) {
        Angiogram1Model angiogram1 = angiogram1List.get(position);

        holder.tvuserId.setText(angiogram1.getUserId());
        holder.tvangiogram1.setText(angiogram1.getAngiogram1());
        holder.date.setText(angiogram1.getDate());

        String angiogram1Image = null;
        angiogram1Image = angiogram1.getAngiogram1Image();
        Picasso.get().load(angiogram1Image).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return angiogram1List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView tvuserId, tvangiogram1, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_recyclerview_id);
            tvuserId = itemView.findViewById(R.id.tvuserid);
            tvangiogram1 = itemView.findViewById(R.id.tvangiogram1);
            date = itemView.findViewById(R.id.tvdate);
        }
    }
}
