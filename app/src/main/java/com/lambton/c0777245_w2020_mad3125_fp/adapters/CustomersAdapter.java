package com.lambton.c0777245_w2020_mad3125_fp.adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lambton.c0777245_w2020_mad3125_fp.R;
import com.lambton.c0777245_w2020_mad3125_fp.ShowBillDetailsActivity;
import com.lambton.c0777245_w2020_mad3125_fp.models.Customer;

import java.io.Serializable;
import java.util.ArrayList;

public class CustomersAdapter extends RecyclerView.Adapter<CustomersAdapter.CustomerViewHolder>
{
    private ArrayList<Customer> customerArrayList;
    public CustomersAdapter(ArrayList<Customer> customerArrayList){
        this.customerArrayList = customerArrayList;
    }
    @NonNull
    @Override
    public CustomersAdapter.CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer,
                parent,
                false);
        CustomerViewHolder myCustomerViewHolder = new CustomerViewHolder(mView);
        return myCustomerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomersAdapter.CustomerViewHolder holder, final int position) {
        Customer customerObject = this.customerArrayList.get(position);
        holder.customerNameText.setText(customerObject.fullName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer name  = customerArrayList.get(position);
                Bundle customerBundle = new Bundle();
                customerBundle.putSerializable("customerObject",(Serializable) name);
                Intent billDetails = new Intent(holder.itemView.getContext(), ShowBillDetailsActivity.class);
                billDetails.putExtra("cusObject", customerBundle);
                holder.itemView.getContext().startActivity(billDetails);

            }
        });

    }

    @Override
    public int getItemCount() {
        return customerArrayList.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder{

        TextView customerNameText;
        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            customerNameText = itemView.findViewById(R.id.customerText);
        }
    }
}
