package com.lambton.c0777245_w2020_mad3125_fp.adapters;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lambton.c0777245_w2020_mad3125_fp.models.Bill;
import com.lambton.c0777245_w2020_mad3125_fp.models.Hydro;
import com.lambton.c0777245_w2020_mad3125_fp.models.Internet;
import com.lambton.c0777245_w2020_mad3125_fp.models.Mobile;

import java.util.ArrayList;

public class BillsAdapter extends RecyclerView.Adapter<CustomersAdapter.CustomerViewHolder>
{
    private ArrayList<Bill> billArrayList;
    private ArrayList<Mobile> mobileArrayList;
    private ArrayList<Internet> internetArrayList;
    private ArrayList<Hydro> hydroArrayList;

    @NonNull
    @Override
    public CustomersAdapter.CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomersAdapter.CustomerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
