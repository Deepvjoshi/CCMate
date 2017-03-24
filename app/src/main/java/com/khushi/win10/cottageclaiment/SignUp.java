package com.khushi.win10.cottageclaiment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.gson.Gson;
import com.khushi.win10.cottageclaiment.AsyncTasks.AsyncResponse;
import com.khushi.win10.cottageclaiment.AsyncTasks.WebserviceCall;
import com.khushi.win10.cottageclaiment.Helper.Utils;
import com.khushi.win10.cottageclaiment.Model.AreaModel;
import com.khushi.win10.cottageclaiment.Model.ForgetPasswordModel;
import com.khushi.win10.cottageclaiment.Model.StateModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Win10 on 09-02-2017.
 */

public class SignUp extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    List<StateModel.CityListBean> CityList=new ArrayList<StateModel.CityListBean>();
    List<AreaModel.AreaListBean> AreaList=new ArrayList<AreaModel.AreaListBean>();
    // String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);



        // getActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        final EditText fnET = (EditText) findViewById(R.id.ET_fn_ET);
        final EditText lnET = (EditText) findViewById(R.id.ET_ln_ET);
        final EditText addressET = (EditText) findViewById(R.id.ET_address_ET);
        final Spinner statespinner = (Spinner) findViewById(R.id.spinner_state_spinner);
        final Spinner cityspinner = (Spinner) findViewById(R.id.spinner_city_spinner);
        final Spinner areaspinner = (Spinner) findViewById(R.id.spinner_area_spinner);
        final EditText unET = (EditText) findViewById(R.id.ET_un_ET);
        final EditText emailET = (EditText) findViewById(R.id.ET_email_ET);
        final EditText passwordET = (EditText) findViewById(R.id.ET_password_ET);
        //final EditText cpET = (EditText) findViewById(R.id.ET_cp_ET);
        // final TextView genderTV = (TextView) findViewById(R.id.TV_gender_TV);
        // final RadioButton femaleRB = (RadioButton) findViewById(R.id.RB_female_RB);
        //final RadioButton maleRB = (RadioButton) findViewById(R.id.RB_male_RB);
        final EditText contactnoET = (EditText) findViewById(R.id.ET_contactno_ET);
        final Spinner typespinner = (Spinner) findViewById(R.id.spinner_type_spinner);
        final Spinner questionspinner = (Spinner) findViewById(R.id.spinner_securityquestion_spinner);
        final EditText answerET = (EditText) findViewById(R.id.ET_answer_ET);


      ArrayAdapter<CharSequence> adaptertype = ArrayAdapter.createFromResource(this, R.array.Select_State, android.R.layout.simple_spinner_item);
       adaptertype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       statespinner.setAdapter(adaptertype);

        statespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
final int dj= (int) parent.getItemIdAtPosition(position);
Log.d("tag", String.valueOf(parent.getItemIdAtPosition(position)));




                String[] keys = new String[]{"mode","state_id"};
                String[] values = new String[]{"cityViewByState", String.valueOf(dj)};
                final String jsonRequest = Utils.createJsonRequest(keys, values);
                final String URL =  "http://vnurture.in/00findpg/admin/webservice.php";
//                new WebserviceCall(SignUp.this, URL, jsonRequest, "Sending Email", true, new AsyncResponse() {
//                    @Override
//                    public void onCallback(String response) {
//                        Log.d("myapp",response);
//                        StateModel model = new Gson().fromJson(response,StateModel.class);
//                      //  Toast.makeText(SignUp.this,model.getMessage() , Toast.LENGTH_SHORT).show();
//
//                    }
//                }).execute();
//                String djs[] = new String[CityList.size()];
//                for (int i=0;i<CityList.size();i++){
//                    djs[i]=CityList.get(i).getCity_name();
//                    Log.d("dj","djj"+djs[i]);
//
//                }
                new WebserviceCall(SignUp.this, URL, jsonRequest, "Sending Email", true, new AsyncResponse() {
                    @Override
                    public void onCallback(String response) {
                        Log.d("myapp",response);

                        StateModel model = new Gson().fromJson(response,StateModel.class);
                        CityList=model.getCityList();


                        if(model.getStatus()==1)
                        {
                            String djs[] = new String[CityList.size()];
                            for (int i=0;i<CityList.size();i++){
                                djs[i]=CityList.get(i).getCity_name();
                                Log.d("tag","djj"+djs[i]);

                            }
                            ArrayAdapter<CharSequence> adaptertype =  new ArrayAdapter(SignUp.this,android.R.layout.simple_list_item_1,djs);
                            adaptertype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            cityspinner.setAdapter(adaptertype);
                            //  Toast.makeText(SignUp.this,model.getMessage() , Toast.LENGTH_SHORT).show();

                        }

                    }
                }).execute();
cityspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int djs= (int) parent.getItemIdAtPosition(position);

        String[] keys = new String[]{"mode","state_id","city_id"};
        String[] values = new String[]{"areaViewByStateCity", String.valueOf(dj),String.valueOf(djs)};
        String jsonRequest = Utils.createJsonRequest(keys, values);
        String URL =  "http://vnurture.in/00findpg/admin/webservice.php";

        new WebserviceCall(SignUp.this, URL, jsonRequest, "Sending Email", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("myappArea",response);

                AreaModel model = new Gson().fromJson(response,AreaModel.class);
                AreaList=model.getAreaList();


                if(model.getStatus()==1)
                {
                    String djs[] = new String[AreaList.size()];
                    for (int i=0;i<AreaList.size();i++){
                        djs[i]=AreaList.get(i).getArea_name();
                        Log.d("tag","djj"+djs[i]);

                    }
                    ArrayAdapter<CharSequence> adaptertype =  new ArrayAdapter(SignUp.this,android.R.layout.simple_list_item_1,djs);
                    adaptertype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    areaspinner.setAdapter(adaptertype);
                    //  Toast.makeText(SignUp.this,model.getMessage() , Toast.LENGTH_SHORT).show();

                }

            }
        }).execute();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});
                areaspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        int djsa= (int) parent.getItemIdAtPosition(position);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
//                ArrayAdapter<String> adaptertype =  new ArrayAdapter(SignUp.this,android.R.layout.simple_list_item_1,djs);
//                adaptertype.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                cityspinner.setAdapter(adaptertype);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Button btnsignup = (Button) findViewById(R.id.btn_signup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fnstr = fnET.getText().toString();
                Log.d("myapp","selected area fnstr: "+fnstr);

                String lnstr = lnET.getText().toString();
                Log.d("myapp","selected area lnstr: "+lnstr);

                String addressstr = addressET.getText().toString();
                Log.d("myapp","selected area addressstr: "+addressstr);

                String unstr = unET.getText().toString();
                Log.d("myapp","selected area unstr: "+unstr);

                String emailstr = emailET.getText().toString();
                Log.d("myapp","selected area emailstr: "+emailstr);

                String passwordstr = passwordET.getText().toString();
                Log.d("myapp","selected area passwordstr: "+passwordstr);

                String contactnostr = contactnoET.getText().toString();
                Log.d("myapp","selected area Spinner: "+contactnostr);

                String answerstr = answerET.getText().toString();
                String areaspinnerStr = String.valueOf(areaspinner.getSelectedItemId());
                Log.d("myapp","selected area Spinner: "+areaspinnerStr);
                String statespinnerStr = String.valueOf(statespinner.getSelectedItemId());
                Log.d("myapp","selected state Spinner: "+statespinnerStr);
                String cityspinnerStr = String.valueOf(cityspinner.getSelectedItemId());
                Log.d("myapp","selected city Spinner: "+cityspinnerStr);
                String typespinnerStr = String.valueOf(typespinner.getSelectedItem());
                Log.d("myapp","selected type: "+typespinnerStr);
                String questionspinnerStr = String.valueOf(questionspinner.getSelectedItemId());
                Log.d("myapp","selected state Spinner: "+questionspinnerStr);

                String answer = answerET.getText().toString();
String djdjdj=getFile(R.drawable.common_full_open_on_phone);
//                String cpstr = cpET.getText().toString();
//                String genderstr = genderTV.getText().toString();
//                {
//                    if (femaleRB.isChecked()) {
//                        femaleRB.getText().toString();
//                    } else {
//                        maleRB.getText().toString();
//                    }
//                }

                // String usertypstr=utypeET.getText().toString();
                if (fnstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Firstname cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (lnstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Lastname cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (addressstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "address cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (unstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (emailstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Email cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(emailstr)) {
                    Toast.makeText(SignUp.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                } else if (passwordstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }
//                 else if (cpstr.isEmpty()) {
//                    Toast.makeText(SignUp.this, "Please enter confirm password", Toast.LENGTH_SHORT).show();
//                } else if (genderstr.isEmpty()) {
//                    Toast.makeText(SignUp.this, "Please select your gender", Toast.LENGTH_SHORT).show();}
                else if (contactnostr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Please enter contact no", Toast.LENGTH_SHORT).show();
                } else if (answerstr.isEmpty()) {
                    Toast.makeText(SignUp.this, "Answer cannot be empty", Toast.LENGTH_SHORT).show();
                }

//                else if (!cpstr.equals(passwordstr)) {
//                    Toast.makeText(SignUp.this, "Password dont match", Toast.LENGTH_SHORT).show();
//                }
                else {
                  /*  JSONObject object = new JSONObject();
                    try {
//                        object.put("mode","register");
                        object.put("firstname",fnstr);
//
                        object.put("email", emailstr);
                        object.put("password", passwordstr);
                        object.put("dob","");
                       // object.put("username",strname);
                        object.put("phone",contactnostr);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }*/
                    //String jsonRequest = String.valueOf(object);

                    String[] keys = new String[]{"mode", "f_name", "l_name","address","state_id","city_id","area_id","u_name","email","psd","ph_no","u_type","sec_id","ans","user_profile"};
                    String[] values = new String[]{"cust_register",fnstr,lnstr,addressstr,statespinnerStr,cityspinnerStr,areaspinnerStr,unstr,emailstr,passwordstr,contactnostr,typespinnerStr,questionspinnerStr,answerstr,djdjdj};
                    String jsonRequest = Utils.createJsonRequest(keys, values);
                    String URL =  "http://vnurture.in/00findpg/admin/webservice.php";
                    new WebserviceCall(SignUp.this, URL, jsonRequest, "Sending Email", true, new AsyncResponse() {
                        @Override
                        public void onCallback(String response) {
                            Log.d("myapp",response);
                            ForgetPasswordModel model = new Gson().fromJson(response,ForgetPasswordModel.class);
                            Toast.makeText(SignUp.this,model.getMessage() , Toast.LENGTH_SHORT).show();

                        }
                    }).execute();


                    //                   String URL = "http://development.ifuturz.com/core/FLAT_TEST/stone_galary/admin/webservice.php";

                }


            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    public   static String getFile(int path){
        Bitmap bm = null;
        ByteArrayOutputStream baos = null;
        byte[] b = null;
        String encodeString = null;
        try{
            bm = BitmapFactory.decodeFile(String.valueOf(path));
            baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            b = baos.toByteArray();
            encodeString = Base64.encodeToString(b, Base64.DEFAULT);
        }catch (Exception e){
            e.printStackTrace();
        }
        return encodeString;
    }
    public static boolean isValidEmail(CharSequence target) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(target);
        return matcher.matches();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("SignUp Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}




