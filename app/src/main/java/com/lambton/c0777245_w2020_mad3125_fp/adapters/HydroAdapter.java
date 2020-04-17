package com.lambton.c0777245_w2020_mad3125_fp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lambton.c0777245_w2020_mad3125_fp.R;
import com.lambton.c0777245_w2020_mad3125_fp.models.Hydro;

import java.text.NumberFormat;
import java.util.ArrayList;

public class HydroAdapter extends RecyclerView.Adapter<HydroAdapter.HydroViewHolder> {

    private ArrayList<Hydro> hydroArrayList;
    NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();

    public HydroAdapter(ArrayList<Hydro> hydroArrayList) {
        this.hydroArrayList = hydroArrayList;
    }

    @NonNull
    @Override
    public HydroAdapter.HydroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hydro,
                parent,
                false);
        HydroViewHolder myHydroViewHolder = new HydroViewHolder(mView);

        return myHydroViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HydroAdapter.HydroViewHolder holder, int position) {
        Hydro hydroObject = this.hydroArrayList.get(position);
        holder.cusId.setText(hydroObject.getCustId());
        holder.id.setText(hydroObject.getId());
        holder.date.setText(hydroObject.getDate());
        holder.type.setText(hydroObject.getBillType());
        holder.agencyName.setText(hydroObject.getAgencyName());
        holder.unitsConsumed.setText(hydroObject.getUnitsConsumed() + " Units");
        holder.amount.setText(defaultFormat.format(Double.parseDouble(hydroObject.getBillAmount())));
    }

    @Override
    public int getItemCount() {
        return hydroArrayList.size();
    }


    public class HydroViewHolder extends RecyclerView.ViewHolder{
        TextView cusId;
        TextView id;
        TextView date;
        TextView type;
        TextView agencyName;
        TextView unitsConsumed;
        TextView amount;
        public HydroViewHolder(@NonNull View itemView) {
            super(itemView);
            cusId = itemView.findViewById(R.id.textView13);
            id = itemView.findViewById(R.id.textView14);
            date = itemView.findViewById(R.id.textView15);
            type = itemView.findViewById(R.id.textView16);
            agencyName = itemView.findViewById(R.id.textView17);
            unitsConsumed = itemView.findViewById(R.id.textView18);
            amount = itemView.findViewById(R.id.textView19);
        }
    }
}
