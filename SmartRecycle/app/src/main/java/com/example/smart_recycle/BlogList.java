package com.example.smart_recycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BlogList extends AppCompatActivity {

    private AppCompatActivity activity = BlogList.this;
    Context context = BlogList.this;
    private RecyclerView recyclerViewPost;
    private ArrayList<PostModel> listPost;
    private PostAdapter PostRecyclerAdapter;
    private DBHelper_blog databaseHelper;
    private ArrayList<PostModel> filteredList;
    private PostAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blog_list);
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
        listPost = new ArrayList<>();
        PostRecyclerAdapter = new PostAdapter(listPost, this,listener);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewPost.setLayoutManager(mLayoutManager);
        recyclerViewPost.setItemAnimator(new DefaultItemAnimator());
        recyclerViewPost.setHasFixedSize(true);
        recyclerViewPost.setAdapter(PostRecyclerAdapter);
        databaseHelper = new DBHelper_blog(activity);
        getDataFromSQLite();
    }

    private void setOnClickListener() {
        listener = new PostAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),article_page.class);
                intent.putExtra("title",listPost.get(position).getpTitle());
                intent.putExtra("desc",listPost.get(position).getpDescription());
                startActivity(intent);
            }
        };
    }

    private void getDataFromSQLite()
    {

        listPost.clear();
        listPost.addAll(databaseHelper.getAllPosts());
        PostRecyclerAdapter.notifyDataSetChanged();
    }



    private void initViews() {
        recyclerViewPost = (RecyclerView) findViewById(R.id.recyclerViewPost);
    }

}