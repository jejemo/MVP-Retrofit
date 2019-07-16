package com.example.mvp_retofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_retofit.MainActivity;
import com.example.mvp_retofit.Model.ResultsItem;
import com.example.mvp_retofit.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainRVAdapter extends RecyclerView.Adapter<MainRVAdapter.mainHolder> {
    private List<ResultsItem> resultsItemList;
    Context mCtx;

    public MainRVAdapter(List<ResultsItem> resultsItemList) {
        this.resultsItemList = resultsItemList;
    }

    public MainRVAdapter(Context mCtx) {
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public mainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.main_row, parent,false);
        return new  mainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull mainHolder holder, int position) {
        ResultsItem data = resultsItemList.get(position);

        holder.txtNama.setText(data.getName().getFullName());
        holder.txtNohp.setText(data.getCell());
        holder.txtEmail.setText(data.getEmail());

        Picasso.with(mCtx).load(data.getPicture().getThumbnail()).into(holder.imgPeople);
    }

    @Override
    public int getItemCount() {
        return resultsItemList.size();
    }

    public void setContext(MainActivity mainActivity) {
    }

    class mainHolder extends RecyclerView.ViewHolder{
        ImageView imgPeople;
        TextView txtNama, txtNohp, txtEmail;

        public mainHolder(@NonNull View itemView) {
            super(itemView);

            imgPeople = itemView.findViewById(R.id.imgPeople);
            txtNama = itemView.findViewById(R.id.txtPeople);
            txtNohp = itemView.findViewById(R.id.txtNohp);
            txtEmail = itemView.findViewById(R.id.txtEmail);
        }
    }
}
