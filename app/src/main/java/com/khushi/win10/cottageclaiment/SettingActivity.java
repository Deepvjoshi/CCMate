package com.khushi.win10.cottageclaiment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.khushi.win10.cottageclaiment.AsyncTasks.AsyncResponse;
import com.khushi.win10.cottageclaiment.AsyncTasks.WebserviceCall;
import com.khushi.win10.cottageclaiment.Helper.Utils;
import com.khushi.win10.cottageclaiment.Model.ForgetPasswordModel;
import com.khushi.win10.cottageclaiment.Model.LogOutModel;

public class SettingActivity extends AppCompatActivity {

    private Button btnlogout;
    private Button btnfeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        btnlogout=(Button)findViewById(R.id.setting_btn_logout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[]keys=new String[]{"mode","lg_id"};
                String[]values=new String[]{"logout","2"};
                String jsonRequest= Utils.createJsonRequest(keys,values);

                String URL = "http://findpg.co.nf/admin/webservice.php";
                new WebserviceCall(SettingActivity.this, URL, jsonRequest, "Sending Email", true, new AsyncResponse() {
                    @Override
                    public void onCallback(String response) {
                        Log.d("myapp",response);
                        LogOutModel model = new Gson().fromJson(response,LogOutModel.class);
                        Toast.makeText(SettingActivity.this,model.getMessage() , Toast.LENGTH_SHORT).show();

                        if (model.getStatus()==1)
                        {
                            Intent intent = new Intent(SettingActivity.this,LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }

                    }
                }).execute();
            }
        });

        btnfeedback=(Button)findViewById(R.id.setting_btn_feedback);
        btnfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SettingActivity.this,FeedbackActivity.class);
                startActivity(intent);
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

