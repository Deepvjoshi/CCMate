
package com.khushi.win10.cottageclaiment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class PropertyNewsActivity extends AppCompatActivity {


    ListView listView;
    int[] imageView=new int[]{R.drawable.news1};
    String title[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertynews);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ObjectHolder.newsModel=new ArrayList<>();
        NewsModel model1=new NewsModel();
        model1.setImagepropertnews(R.drawable.news1);
        model1.setTitle("Ahemdabad is Up-to-date on Infrastructure.");

        NewsModel model2=new NewsModel();
        model2.setImagepropertnews(R.drawable.news3);
        model2.setTitle("The Real Healthy Homes.");

        NewsModel model3=new NewsModel();
        model3.setImagepropertnews(R.drawable.news2);
        model3.setTitle("Mumbai ahead of Washington,Toronto in super-rich population.");


        listView=(ListView)findViewById(R.id.listview_propertynews);
        ObjectHolder.newsModel.add(model1);
        ObjectHolder.newsModel.add(model2);
        ObjectHolder.newsModel.add(model3);


        CustomNewsAdapter adapter = new CustomNewsAdapter(this,ObjectHolder.newsModel);
        listView.setAdapter(adapter);



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
