package com.khushi.win10.cottageclaiment;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RentDetailActivity extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_detail);
        btn=(Button)findViewById(R.id.djbtn);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Snackbar.make(v, "we care yore order", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        Intent i=new Intent(RentDetailActivity.this,HomeActivity.class);
        startActivity(i);
        Toast.makeText(RentDetailActivity.this, " Order sucessfully ", Toast.LENGTH_SHORT).show();
    }
});
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
