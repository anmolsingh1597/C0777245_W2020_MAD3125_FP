package com.lambton.c0777245_w2020_mad3125_fp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lambton.c0777245_w2020_mad3125_fp.R;
import com.lambton.c0777245_w2020_mad3125_fp.models.Internet;

import java.util.ArrayList;

public class InternetAdapter extends RecyclerView.Adapter<InternetAdapter.InternetViewHolder> {

    private ArrayList<Internet> internetArrayList;

    public InternetAdapter(ArrayList<Internet> internetArrayList) {
        this.internetArrayList = internetArrayList;
    }

    @NonNull
    @Override
    public InternetAdapter.InternetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_internet,
                parent,
                false);
        InternetViewHolder myInternetViewHolder = new InternetViewHolder(mView);
        return myInternetViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull InternetAdapter.InternetViewHolder holder, int position) {
        Internet internetObject = this.internetArrayList.get(position);
        holder.cusId.setText("Customer Id: " + internetObject.getCustId());
        holder.id.setText("Bill Id: " + internetObject.getId());
        holder.date.setText("Date: " + internetObject.getDate());
        holder.type.setText("Bill Type: " + internetObject.getBillType());
        holder.internetGb.setText("Internet GB used: " + internetObject.getInternetGb() + " GB");
        holder.providerName.setText("Provider Name: " + internetObject.getProviderName());
        holder.amount.setText("Amount: $" + internetObject.getBillAmount());

    }

    @Override
    public int getItemCount() {
        return internetArrayList.size();
    }
    public class InternetViewHolder extends RecyclerView.ViewHolder{

        TextView cusId;
        TextView id;
        TextView date;
        TextView type;
        TextView internetGb;
        TextView providerName;
        TextView amount;

        public InternetViewHolder(@NonNull View itemView) {
            super(itemView);
            cusId = itemView.findViewById(R.id.textView34);
            id = itemView.findViewById(R.id.textView35);
            date = itemView.findViewById(R.id.textView36);
            type = itemView.findViewById(R.id.textView37);
            internetGb = itemView.findViewById(R.id.textView38);
            providerName = itemView.findViewById(R.id.textView39);
            amount = itemView.findViewById(R.id.textView40);
        }
    }

}
