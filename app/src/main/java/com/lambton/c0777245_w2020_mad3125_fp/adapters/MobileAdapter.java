package com.lambton.c0777245_w2020_mad3125_fp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lambton.c0777245_w2020_mad3125_fp.R;
import com.lambton.c0777245_w2020_mad3125_fp.models.Mobile;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.MobileViewHolder> {

    private ArrayList<Mobile> mobileArrayList;
    NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
    public MobileAdapter(ArrayList<Mobile> mobileArrayList){
        this.mobileArrayList = mobileArrayList;
    }
    @NonNull
    @Override
    public MobileAdapter.MobileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mobile,
                parent,
                false);
        MobileViewHolder myMobileViewHolder = new MobileViewHolder(mView);
        return myMobileViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MobileAdapter.MobileViewHolder holder, int position) {
    Mobile mobileObject = this.mobileArrayList.get(position);
    holder.cusId.setText(mobileObject.getCustId());
    holder.id.setText(mobileObject.getId());
    holder.date.setText(mobileObject.getDate());
    holder.type.setText(mobileObject.getBillType());
    holder.manufacturerName.setText(mobileObject.getMobileManufacturer());
    holder.planName.setText(mobileObject.getPlanName());
    holder.mobileNumber.setText(mobileObject.getMobileNumber());
    holder.internetGBUsed.setText(mobileObject.getInternetGb() + " GB");
    holder.minutesUsed.setText(mobileObject.getMinutes() + " minutes");
    holder.amount.setText(defaultFormat.format(Double.parseDouble(mobileObject.getBillAmount())));

    }

    @Override
    public int getItemCount() {
        return mobileArrayList.size();
    }
    public class MobileViewHolder extends RecyclerView.ViewHolder{

        TextView cusId;
        TextView id;
        TextView date;
        TextView type;
        TextView manufacturerName;
        TextView planName;
        TextView mobileNumber;
        TextView internetGBUsed;
        TextView minutesUsed;
        TextView amount;
        public MobileViewHolder(@NonNull View itemView) {
            super(itemView);
            cusId = itemView.findViewById(R.id.textView3);
            id = itemView.findViewById(R.id.textView4);
            date = itemView.findViewById(R.id.textView5);
            type = itemView.findViewById(R.id.textView6);
            manufacturerName = itemView.findViewById(R.id.textView7);
            planName = itemView.findViewById(R.id.textView8);
            mobileNumber = itemView.findViewById(R.id.textView9);
            internetGBUsed = itemView.findViewById(R.id.textView10);
            minutesUsed = itemView.findViewById(R.id.textView11);
            amount = itemView.findViewById(R.id.textView12);
        }
    }
}
