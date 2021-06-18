package com.example.smart_recycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{


    private ArrayList<PostModel> listPost;
    public ImageView overflow;
    private Context mContext;
    private ArrayList<PostModel> mFilteredList;
    public RecyclerViewClickListener listener;


    public PostAdapter(ArrayList<PostModel> listPost, Context mContext,RecyclerViewClickListener listener) {
        this.listPost = listPost;
        this.mContext = mContext;
        this.mFilteredList = listPost;
        this.listener = listener;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewTitle;

        public PostViewHolder(View view) {
            super(view);
            textViewTitle= (TextView) view.findViewById(R.id.PostTitle);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_post, parent, false);

        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PostViewHolder holder, int position) {
        holder.textViewTitle.setText(listPost.get(position).getpTitle());
    }
    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v,int position);

    }
}