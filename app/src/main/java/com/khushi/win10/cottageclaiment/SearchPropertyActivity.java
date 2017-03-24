package com.khushi.win10.cottageclaiment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SearchPropertyActivity extends AppCompatActivity {
   // private Spinner spinnerbhk;
    private Button category;
    private Button place;
    private Button price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_property);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

//        spinnerbhk=(Spinner)findViewById(R.id.data_spinner_bhk);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Select_BHK, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerbhk.setAdapter(adapter);

        category=(Button)findViewById(R.id.search_btn_category);
        place=(Button)findViewById(R.id.search_btn_place);
        price=(Button)findViewById(R.id.search_btn_price);

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchPropertyActivity.this, SearchByCategoryActivity.class);
                startActivity(intent);
            }
        });
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchPropertyActivity.this,SearchByPlaceActivity.class);
                startActivity(intent);
            }
        });
        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchPropertyActivity.this, SearchByPriceActivity.class);
                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
