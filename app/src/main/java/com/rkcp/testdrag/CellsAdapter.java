package com.rkcp.testdrag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CellsAdapter extends RecyclerView.Adapter<CellsAdapter.Holder> {

    private final List<Cell> mDataList;
    private Context mContext;

    public CellsAdapter(Context context, List<Cell> dataList) {
        mDataList = dataList;
        mContext = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cell, parent, false);
        return new Holder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Cell cell = mDataList.get(position);
        holder.tvText.setText(cell.position + "号");
        holder.itemView.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext, "haha", Toast.LENGTH_SHORT).show();
        }
    };

    public static class Holder extends RecyclerView.ViewHolder {
        TextView tvText;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_text);
        }
    }
}
