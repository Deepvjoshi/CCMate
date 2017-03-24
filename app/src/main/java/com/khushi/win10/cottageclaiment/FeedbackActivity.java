package com.khushi.win10.cottageclaiment;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {
Button dj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        dj=(Button)findViewById(R.id.dj);
        dj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "we care yore order", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i=new Intent(FeedbackActivity.this,HomeActivity.class);
                startActivity(i);
                Toast.makeText(FeedbackActivity.this, " Thank You For FeedBack ", Toast.LENGTH_SHORT).show();
            }

        })
        ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
