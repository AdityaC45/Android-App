package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;


import adapter.VerticalRecyclerViewAdapter;
import adapter.models.HorizontalModel;
import adapter.models.VerticalModel;

public class MainActivity extends AppCompatActivity {

    long backPressedTime;
    Toast backPressedToast;
    //here we created an instance of VerticalRecyclerView
    //VerticalModel to store an arrayList of Horizontal items and title
    RecyclerView verticalRecyclerView;
    VerticalRecyclerViewAdapter adapter;
    ArrayList<VerticalModel>arrayListVertical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayListVertical = new ArrayList<>();
        verticalRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        verticalRecyclerView.setHasFixedSize(true);
        verticalRecyclerView.setLayoutManager( new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new VerticalRecyclerViewAdapter(this,arrayListVertical);
        verticalRecyclerView.setAdapter(adapter);
        SetData();
        //to set data
    }

    @Override
    public void onBackPressed() {
        if(backPressedTime + 2000>System.currentTimeMillis())
        {
            backPressedToast.cancel();
            super.onBackPressed();
            return;
        }
        else
        {
            backPressedToast = Toast.makeText(this,"Press back again to exit",Toast.LENGTH_SHORT);
            backPressedToast.show();
        }
        backPressedTime =System.currentTimeMillis();
    }

    private void SetData() {
        for(int i=1;i<=5;i++)
        {
            VerticalModel mverticalModel = new VerticalModel();
            mverticalModel.setTitle("Title: "+i);
            ArrayList<HorizontalModel>arrayListHorizontal = new ArrayList<>();

            for(int j=0;j<=5;j++)
            {
                HorizontalModel horizontalModel = new HorizontalModel();
                horizontalModel.setDesciption("Description: "+j);
                horizontalModel.setName("Name: "+j);

                arrayListHorizontal.add(horizontalModel);
            }
            mverticalModel.setArrayList(arrayListHorizontal);
            arrayListVertical.add(mverticalModel);
        }
        adapter.notifyDataSetChanged();
    }


}
