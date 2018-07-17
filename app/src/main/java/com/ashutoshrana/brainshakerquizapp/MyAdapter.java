package com.ashutoshrana.brainshakerquizapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    ArrayList<Score> arrayList;

    public MyAdapter(Context context, ArrayList<Score> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Score score=arrayList.get(position);
        holder.ca.setText(score.getCorrectAnswer());
        holder.ia.setText(score.getIncorrectAnswer());
        holder.sc.setText(score.getScore());
        holder.per.setText(score.getPercentage());
        holder.tqa.setText(score.getTotalQuestionAnswered());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ca,ia,sc,per,tqa;
        public ViewHolder(View itemView) {
            super(itemView);

            ca=itemView.findViewById(R.id.correctanswer);
            ia=itemView.findViewById(R.id.incorrectanswer);
            sc=itemView.findViewById(R.id.score1);
            per=itemView.findViewById(R.id.percentage);
            tqa=itemView.findViewById(R.id.totalquesanswer);
        }
    }
}
