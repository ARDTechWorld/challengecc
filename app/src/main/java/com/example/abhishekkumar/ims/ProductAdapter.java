package com.example.abhishekkumar.ims;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
       // ProductViewHolder holder = new ProductViewHolder(view); inline in next line...
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Product product = productList.get(position);

        holder.tvheading.setText(product.getHeading());
        holder.tvdescription.setText(product.getDescription());
        holder.tvid.setText(String.valueOf(product.getId()));
        holder.tvdate.setText(String.valueOf(product.getDate()));
        holder.tvsign.setText(product.getSign());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView tvheading, tvdescription, tvsign, tvdate, tvid;
        public ProductViewHolder(View itemView) {
            super(itemView);

            tvheading = itemView.findViewById(R.id.textViewTitle);
            tvdescription = itemView.findViewById(R.id.textViewDesc);
            tvid = itemView.findViewById(R.id.textViewid);
            tvsign = itemView.findViewById(R.id.textViewSign);
            tvdate = itemView.findViewById(R.id.textViewdate);


        }
    }

}
