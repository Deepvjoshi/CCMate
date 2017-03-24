package com.khushi.win10.cottageclaiment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;
import com.khushi.win10.cottageclaiment.AsyncTasks.AsyncResponse;
import com.khushi.win10.cottageclaiment.AsyncTasks.WebserviceCall;
import com.khushi.win10.cottageclaiment.Helper.Utils;
import com.khushi.win10.cottageclaiment.Model.ForgetPasswordModel;
import com.khushi.win10.cottageclaiment.Model.UpdateProfileModel;

import static com.khushi.win10.cottageclaiment.SignUp.isValidEmail;

public class UpdateAccountActivity extends AppCompatActivity {
     private Button btnupdate,btncancle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_account);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        final EditText ETfirstname = (EditText) findViewById(R.id.update_et_firstname);
        final EditText ETlastname = (EditText) findViewById(R.id.update_et_lastname);
        final EditText ETaddress= (EditText) findViewById(R.id.update_et_address);
        final Spinner spinnerstate = (Spinner) findViewById(R.id.update_state_spinner);
        final Spinner spinnercity = (Spinner) findViewById(R.id.update_city_spinner);
        final Spinner spinnerarea = (Spinner) findViewById(R.id.update_area_spinner);
        final EditText ETemail = (EditText) findViewById(R.id.update_et_email);
        final EditText ETcontactnumber = (EditText) findViewById(R.id.update_et_contactnumber);



        btnupdate = (Button) findViewById(R.id.btn_update);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strfn = ETfirstname.getText().toString();
                String strln = ETlastname.getText().toString();
                String straddress = ETaddress.getText().toString();
                String stremail = ETemail.getText().toString();
                String strcontactno = ETcontactnumber.getText().toString();
                int areaspinnerStr = spinnerarea.getSelectedItemPosition();
                Log.d("myapp","selected area Spinner: "+areaspinnerStr);
                int statespinnerStr = (spinnerstate.getSelectedItemPosition());
                Log.d("myapp","selected state Spinner: "+statespinnerStr);
                int cityspinnerStr = (spinnercity.getSelectedItemPosition());
                Log.d("myapp","selected state Spinner: "+cityspinnerStr);

                if (strfn.isEmpty()) {
                    Toast.makeText(UpdateAccountActivity.this, "Firstname cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (strln.isEmpty()) {
                    Toast.makeText(UpdateAccountActivity.this, "Lastname cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (straddress.isEmpty()) {
                    Toast.makeText(UpdateAccountActivity.this, "address cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (stremail.isEmpty()) {
                    Toast.makeText(UpdateAccountActivity.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(stremail)) {
                    Toast.makeText(UpdateAccountActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                } else if (strcontactno.isEmpty()) {
                    Toast.makeText(UpdateAccountActivity.this, "Please enter pass", Toast.LENGTH_SHORT).show();
                }
                else if (areaspinnerStr==0)
                {
                    Toast.makeText(UpdateAccountActivity.this, "Please Select Area", Toast.LENGTH_SHORT).show();
                }
                else if (statespinnerStr==0)
                {
                    Toast.makeText(UpdateAccountActivity.this, "Please Select State", Toast.LENGTH_SHORT).show();
                }
                else if (cityspinnerStr==0)
                {
                    Toast.makeText(UpdateAccountActivity.this, "Please Select City", Toast.LENGTH_SHORT).show();
                }
                else {



                    String[]keys=new String[]{"mode","r_id","f_name","l_name","address","state_id","city_id","area_id","email","ph_no"};
                    String[]values=new String[]{"update_profile","25",strfn,strln,straddress,stremail,strcontactno};
                    String jsonRequest= Utils.createJsonRequest(keys,values);

                    String URL = "http://findpg.co.nf/admin/webservice.php";
                    new WebserviceCall(UpdateAccountActivity.this, URL, jsonRequest, "Updating Profile", true, new AsyncResponse() {
                        @Override
                        public void onCallback(String response) {
                            Log.d("myapp",response);
                            UpdateProfileModel model = new Gson().fromJson(response,UpdateProfileModel.class);
                            Toast.makeText(UpdateAccountActivity.this,model.getMessage() , Toast.LENGTH_SHORT).show();

                            if (model.getStatus()==1)
                            {
                                Intent intent=new Intent(UpdateAccountActivity.this,HomeActivity.class);
                                startActivity(intent);
                            //    Toast.makeText(UpdateAccountActivity.this, "Update Successfull!!", Toast.LENGTH_SHORT).show();

                            }


                        }
                    }).execute();



                }
            }
        });

        btncancle=(Button)findViewById(R.id.btn_cancel);
        btncancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(UpdateAccountActivity.this,HomeActivity.class);
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