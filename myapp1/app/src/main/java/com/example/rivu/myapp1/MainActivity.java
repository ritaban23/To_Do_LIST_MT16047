package com.example.rivu.myapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText title;
    private  List<Data> data;
    private String title1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        title = (EditText)findViewById(R.id.Title);
        data = new ArrayList<>();
//        title.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
  //              title.setVisibility(View.VISIBLE);
                title1 = title.getText().toString();
                title.setText("");
                data.add(new Data(title1,"",R.drawable.ic_action_movie));
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
                Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplication());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
              /*  RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
                itemAnimator.setAddDuration(1000);
                itemAnimator.setRemoveDuration(1000);
                recyclerView.setItemAnimator(itemAnimator);  */
            }
        });

     /*   RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        Recycler_View_Adapter adapter = new Recycler_View_Adapter(data, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setAddDuration(1000);
        itemAnimator.setRemoveDuration(1000);
        recyclerView.setItemAnimator(itemAnimator); */


    }
    public List<Data> fill_with_data(String title1) {

        List<Data> data = new ArrayList<>();
        data.add(new Data(title1,"",R.drawable.check));
        return data;
    }
}
