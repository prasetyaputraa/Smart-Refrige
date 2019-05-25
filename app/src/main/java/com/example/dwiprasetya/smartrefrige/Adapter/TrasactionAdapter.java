package com.example.dwiprasetya.smartrefrige.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dwiprasetya.smartrefrige.Model.Transactions;
import com.example.dwiprasetya.smartrefrige.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TrasactionAdapter extends RecyclerView.Adapter<TrasactionAdapter.ViewHolder>{

    ArrayList<Transactions> transactionsList = new ArrayList<Transactions>();
    ArrayList<String> itemList =  new ArrayList<String>();

    ItemAdapter itemAdapter;


    Context context;

    public TrasactionAdapter(ArrayList<Transactions> transactionsList, Context context) {
        this.transactionsList = transactionsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_log,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        itemAdapter = new ItemAdapter(itemList,context);
        viewHolder.itemRecyclerView.setAdapter(itemAdapter);

        viewHolder.dateText.setText(transactionsList.get(i).getDate());
        itemList.clear();
        for(int j=0;j<transactionsList.get(i).getItems().size();j++){
            if(transactionsList.get(i).getItems().get(j).getAmount()<0){
                itemList.add(transactionsList.get(i).getItems().get(j).getName()+
                        " diambil sebanyak "+
                        Math.abs(transactionsList.get(i).getItems().get(j).getAmount())
                );
            }else{
                itemList.add(transactionsList.get(i).getItems().get(j).getName()+
                        " ditaruh sebanyak "+
                        Math.abs(transactionsList.get(i).getItems().get(j).getAmount())
                );
            }
            itemAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public int getItemCount() {
        return transactionsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView dateText;
        RecyclerView itemRecyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.dateText);
            itemRecyclerView = itemView.findViewById(R.id.itemRecyclerView);
        }
    }
}

