package com.example.dwiprasetya.smartrefrige.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dwiprasetya.smartrefrige.Adapter.TrasactionAdapter;
import com.example.dwiprasetya.smartrefrige.Helper.RetrofitHelper;
import com.example.dwiprasetya.smartrefrige.Model.Transactions;
import com.example.dwiprasetya.smartrefrige.R;
import com.example.dwiprasetya.smartrefrige.RetrofitServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogFragment extends Fragment {

    public LogFragment() {
        // Required empty public constructor
    }

    RetrofitServices retrofitServices = RetrofitHelper.getRetrofit("http://http://10.0.2.2:8000/api/").create(RetrofitServices.class);
//    RetrofitServices retrofitServices = RetrofitHelper.getRetrofit("http://http://127.0.0.1:8000/api/").create(RetrofitServices.class);

    RecyclerView transaksiRecyclerview;
    TrasactionAdapter trasactionAdapter;
    ArrayList<Transactions> transactionsList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState
    ) {
        View view = inflater.inflate(R.layout.fragment_log, container, false);

        transaksiRecyclerview = view.findViewById(R.id.transaksiRecyclerview);
        trasactionAdapter     = new TrasactionAdapter(transactionsList,getContext());

        transaksiRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        transaksiRecyclerview.setAdapter(trasactionAdapter);

        loadTransactions();

        final Handler handler =  new Handler();
        Runnable runnable =  new Runnable() {
            @Override
            public void run() {
                loadTransactions();
                handler.postDelayed(this,10000);
            }
        };

        handler.postDelayed(runnable,10000);
        return view;
    }

    public void loadTransactions(){
        retrofitServices
                .loadTransactions("Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6ImJjNDA5N2Q0ZDFkYzVkNzI0M2JjYjVmOTVjZWRiMTUwNTgxZjBmNTBjNDJlNWRhYjAwMTA0MzE0ZTcyZDJmMTc3MWVmZTk0Njk2MDVjMjcwIn0.eyJhdWQiOiIxIiwianRpIjoiYmM0MDk3ZDRkMWRjNWQ3MjQzYmNiNWY5NWNlZGIxNTA1ODFmMGY1MGM0MmU1ZGFiMDAxMDQzMTRlNzJkMmYxNzcxZWZlOTQ2OTYwNWMyNzAiLCJpYXQiOjE1NTg2OTE4NDIsIm5iZiI6MTU1ODY5MTg0MiwiZXhwIjoxNTkwMzE0MjQyLCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.W8l9cejfScVBCXJGZ2QeSxeE4kSCIBum1t41eil4iNNCckaVo5Ru9xa7Uz6IGDfsPEJyjc2RJo09u5VJVL9UXjF0KS_BxipqkipGqQAv2DCRrLWiSG92GNj05EQ-akYlz-8yqDbH5ngfA2eji85igToTPC2ujxnz3cZCLMkgV8pzjImDyG0RnPHFQAwUxKgwPghqzjTNMNlCH3r1naNoD5Wq2F9NothOobUrCfsdXLyxrUVLMkCEyaNwNV4-JUKntOpaGjKhGjLr41kL-40eb1JH4dY7w0BSC9F-LC4E8dlWfcIT5ybX4NwVEsj2EtKIbkC8aQBwTB4Plqm4uAkBfPcMWzTGmiGvJUAua-7RgQEwoQCSDttW4puoOkrpqhIvUbKLNls6vQBO1kB-f-MFxo-dm1mXY7aR-UloR8KFh9U5ZJncD7X6RuWlcupYgTyE_LkVv4u0zJXeU4bCp7tgXNJiRx7r1Q5uOdglf2MFYP40n1yPRE5ltaTvX3slcyU51x3ULQX1LojXrJwCTUEemQoFlNmgQF_otfdc6X0p6H7TYMtHu9zVeoXIgm-q8q2gHVKn4GI5V7uW5itIWR0rgOzkpWKJK1dsvgI1-bMGtieWo6prGefQcmKhlrvidLmGmd0dPbtziF0ZIWp_u0q4Kvlt4Lx6RUZVzRT9XYPhGPc","prasetyaputraa@gmail.com", "admindwik", 1)
                .enqueue(new Callback<List<Transactions>>()
                {
            @Override
            public void onResponse(Call<List<Transactions>> call, Response<List<Transactions>> response) {
                transactionsList.clear();
                List<Transactions> list = response.body();

                transactionsList.addAll(list);
                trasactionAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Transactions>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("retrofit error: ",t.getMessage());
            }
        });
    }



}
