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

public class adapter extends RecyclerView.Adapter<adapter.BeneficiaryViewHolder>{


    private ArrayList<company_model> listCompany;
    public ImageView overflow;
    private Context mContext;
    private ArrayList<company_model> mFilteredList;
    public RecyclerViewClickListener listener;


    public adapter(ArrayList<company_model> listCompany, Context mContext,RecyclerViewClickListener listener) {
        this.listCompany = listCompany;
        this.mContext = mContext;
        this.mFilteredList = listCompany;
        this.listener = listener;
    }

    public class BeneficiaryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textViewName;
        public TextView textViewState;
        public TextView textViewCity;
        public TextView textViewPhone;
        public  ImageView overflow;

        public BeneficiaryViewHolder(View view) {
            super(view);
            textViewName = (TextView) view.findViewById(R.id.textViewName);
            textViewState = (TextView) view.findViewById(R.id.textViewState);
            textViewCity = (TextView) view.findViewById(R.id.textViewCity);
            textViewPhone = (TextView) view.findViewById(R.id.textViewPhone);
            view.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }
    @NonNull
    @Override
    public BeneficiaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);

        return new BeneficiaryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final BeneficiaryViewHolder holder, int position) {
        holder.textViewName.setText(listCompany.get(position).getName());
        holder.textViewState.setText(listCompany.get(position).getState());
        holder.textViewCity.setText(listCompany.get(position).getCity());
        holder.textViewPhone.setText(listCompany.get(position).getPhone());
    }
    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }


public interface RecyclerViewClickListener{
        void onClick(View v,int position);

}
}