package com.example.rivu.myapp1;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class View_Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

    CardView cv;
    TextView title;
    TextView description;
    ImageView imageView;
    @Override
    public void onClick(View v) {
       // Toast.makeText(this,"Hi",Toast.LENGTH_SHORT).show();
    }
    View_Holder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
    }
}