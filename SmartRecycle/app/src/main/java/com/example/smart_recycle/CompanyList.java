package com.example.smart_recycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CompanyList extends AppCompatActivity {

    private AppCompatActivity activity = CompanyList.this;
    Context context = CompanyList.this;
    private RecyclerView recyclerViewCompany;
    private ArrayList<company_model> listCompany;
    private adapter companyRecyclerAdapter;
    private DBHelper_company databaseHelper;
    SearchView searchBox;
    private ArrayList<company_model> filteredList;
    private adapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        initViews();
        initObjects();


//        if (intentThatStartedThisActivity.hasExtra("NAME")) {
//
//            String name = getIntent().getExtras().getString("NAME");
//            String state = getIntent().getExtras().getString("STATE");
//            String city = getIntent().getExtras().getString("CITY");
//            String phone = getIntent().getExtras().getString("PHONE");
//
//        }else{
//
//            Toast.makeText(this, "No API Data", Toast.LENGTH_SHORT).show();
//
//        }

    }

    private void initObjects() {
        setOnClickListener();
        listCompany = new ArrayList<>();
        companyRecyclerAdapter = new adapter(listCompany, this,listener);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewCompany.setLayoutManager(mLayoutManager);
        recyclerViewCompany.setItemAnimator(new DefaultItemAnimator());
        recyclerViewCompany.setHasFixedSize(true);
        recyclerViewCompany.setAdapter(companyRecyclerAdapter);
        databaseHelper = new DBHelper_company(activity);
        getDataFromSQLite();
    }

    private void setOnClickListener() {
        listener = new adapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),Company.class);
                intent.putExtra("companyname",listCompany.get(position).getName());
                intent.putExtra("state",listCompany.get(position).getState());
                intent.putExtra("city",listCompany.get(position).getCity());
                intent.putExtra("phone",listCompany.get(position).getPhone());
                startActivity(intent);
            }
        };
    }

    private void getDataFromSQLite()
    {
        // create the get Intent object
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
                listCompany.clear();
                listCompany.addAll(databaseHelper.getAllCompanies(str));
                companyRecyclerAdapter.notifyDataSetChanged();
            }



    private void initViews() {
        recyclerViewCompany = (RecyclerView) findViewById(R.id.recyclerViewBeneficiary);
    }

}