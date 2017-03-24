package com.khushi.win10.cottageclaiment;




import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.khushi.win10.cottageclaiment.AsyncTasks.AsyncResponse;
import com.khushi.win10.cottageclaiment.AsyncTasks.WebserviceCall;
import com.khushi.win10.cottageclaiment.Helper.Utils;
import com.khushi.win10.cottageclaiment.Model.ForgetPasswordModel;
import com.khushi.win10.cottageclaiment.Model.LoginModel;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private TextView tvsignup;
    private Button btnlogin;
    private TextView tvforgotpassword;
    View dialogView;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvsignup = (TextView) findViewById(R.id.main_tv_signup);
        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUp.class);

                startActivity(intent);


            }
        });

        tvforgotpassword = (TextView) findViewById(R.id.main_tv_forgotpassword);
        tvforgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showForgetPwdDialog();

            }
        });
//

        final EditText usernameET = (EditText) findViewById(R.id.main_et_username);
        final EditText passET = (EditText) findViewById(R.id.main_et_password);
        btnlogin = (Button) findViewById(R.id.main_btn_login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strusername = usernameET.getText().toString();
                String strpass = passET.getText().toString();





                if (strusername.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
                }// else if (!isValidEmail(stremail)) {
                    //Toast.makeText(LoginActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show()}
                else if (strpass.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast.makeText(LoginActivity.this, "Login Successfull!!", Toast.LENGTH_SHORT).show();

                   /* JSONObject object = new JSONObject();
                    try {
                        object.put("email",stremail);
                        object.put("password",strpass);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }*/

                   // String jsonRequest = String.valueOf(object);

                    String[]keys=new String[]{"mode","u_name","psd"};
                    String[]values=new String[]{"login",strusername,strpass};
                    String jsonRequest=Utils.createJsonRequest(keys,values);

                    String URL =  "http://vnurture.in/00findpg/admin/webservice.php";
                   new WebserviceCall(LoginActivity.this, URL, jsonRequest, "Logging in", true, new AsyncResponse() {
                       @Override
                       public void onCallback(String response) {
                           Log.d("myapp",response);
                           LoginModel model = new Gson().fromJson(response,LoginModel.class);
                           Toast.makeText(LoginActivity.this,model.getMessage() , Toast.LENGTH_SHORT).show();
                           if (model.getStatus()==1)
                           {
                               Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                               startActivity(intent);
                           }

                       }
                   }).execute();
                }
            }
        });


          }

    private void showForgetPwdDialog() {
        dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_forget_pwd, null);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Your email")
                .setView(dialogView)
                .setPositiveButton("Verify", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        handleTextDialog();
//                        Intent intent = new Intent(LoginActivity.this, ForgotPassActivity.class);
//                        startActivity(intent);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
                .create();
        dialog.show();
        final EditText emailET = (EditText) findViewById(R.id.main_et_username);
        String emailstr = emailET.getText().toString();
//        JSONObject object = new JSONObject();
//        try {
//            object.put("email",emailstr);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        String jsonRequest = String.valueOf(object);
//        String URL = "http://www.vnurture.in/pro/mailtest.php";

    }

    private void handleTextDialog() {
        if (dialogView != null) {
            EditText editText = (EditText) dialogView.findViewById(R.id.forget_et_email);
            String str = editText.getText().toString();

            String[]keys=new String[]{"mode","email"};
            String[]values=new String[]{"forgot_psd",str};
            String jsonRequest=Utils.createJsonRequest(keys,values);

            String URL = "http://vnurture.in/00findpg/admin/webservice.php";
            new WebserviceCall(LoginActivity.this, URL, jsonRequest, "Sending Email", true, new AsyncResponse() {
                @Override
                public void onCallback(String response) {
                    Log.d("myapp",response);
                    ForgetPasswordModel model = new Gson().fromJson(response,ForgetPasswordModel.class);
                    Toast.makeText(LoginActivity.this,model.getMessage() , Toast.LENGTH_SHORT).show();

                }
            }).execute();
          //  Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        }
    }

   /* public static boolean isValidEmail(CharSequence target) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(target);
        return matcher.matches();
    }*/

  }