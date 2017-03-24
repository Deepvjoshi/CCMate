package com.khushi.win10.cottageclaiment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.khushi.win10.cottageclaiment.AsyncTasks.AsyncResponse;
import com.khushi.win10.cottageclaiment.AsyncTasks.WebserviceCall;
import com.khushi.win10.cottageclaiment.Helper.Utils;
import com.khushi.win10.cottageclaiment.Model.ForgetPasswordModel;
import com.khushi.win10.cottageclaiment.Model.LogOutModel;
import com.khushi.win10.cottageclaiment.Model.PgModel;
import com.khushi.win10.cottageclaiment.Model.UpdateProfileModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView;
    List<PgModel.PgAppListBean>pgList=new ArrayList<PgModel.PgAppListBean>();
   // ListView listViewnews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


       // ArrayList<RentDemoModel> arrayList=new ArrayList<>();
      //  listViewnews=(ListView)findViewById(R.id.news_listview);

       /* ObjectHolder.newsModel=new ArrayList<>();

        NewsModel model2=new NewsModel();
        model2.setTitle("Property News");
        model2.setContent("This is a Property news Activity");
        model2.setTitle("Second news");
        model2.setContent("This is a listview");
        ObjectHolder.newsModel.add(model2);*/


        String[]keys=new String[]{"mode","state_id","city_id","area_id","cat_id","subcat_id"};
        String[]values=new String[]{"findpg","1","1","1","9","1"};
        String jsonRequest= Utils.createJsonRequest(keys,values);

        String URL = "http://findpg.co.nf/admin/webservice.php";
        new WebserviceCall(HomeActivity.this, URL, jsonRequest, "Updating Profile", true, new AsyncResponse() {
            @Override
            public void onCallback(String response) {
                Log.d("myapp",response);
                PgModel model = new Gson().fromJson(response,PgModel.class);
              //  Toast.makeText(HomeActivity.this,model.getMessage() , Toast.LENGTH_SHORT).show();




            }
        }).execute();
// String dj= pgList.get(0).getE_price();
       // Log.d("dj",dj);
        listView=(ListView)findViewById(R.id.home_listview);
        ObjectHolder.rentDemoModel=new ArrayList<>();
        RentDemoModel model1=new RentDemoModel();
        model1.setImageViewCottage(R.drawable.mybg1);
        model1.setName("Krishna Cottage");
        model1.setLocation("Ahemdabad,Gujrat,India");
        model1.setRating("rating");
        model1.setRank("4.6/5");
        model1.setPrice("Rs.10000");
        RentDemoModel model12=new RentDemoModel();
        model1.setImageViewCottage(R.drawable.mybg1);
        model1.setName("Krishna Cottage");
        model1.setLocation("Ahemdabad,Gujrat,India");
        model1.setRating("rating");
        model1.setRank("4.6/5");
        model1.setPrice("Rs.10000");
        //arrayList.add(model);
        ObjectHolder.rentDemoModel.add(model12);
        ObjectHolder.rentDemoModel.add(model1);

        CustomRentAdapter adapter = new CustomRentAdapter(this,ObjectHolder.rentDemoModel);
        listView.setAdapter(adapter);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            this.finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
           // return true;
            Intent intent=new Intent(HomeActivity.this,SearchPropertyActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_manageaccount) {
            Intent intent = new Intent(HomeActivity.this, ManageAccountActivity.class);
            startActivity(intent);
        }  else if (id == R.id.nav_prnews) {
            Intent intent=new Intent(HomeActivity.this,PropertyNewsActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings) {
            Intent intent=new Intent(HomeActivity.this,SettingActivity.class);
            startActivity(intent);




        } else if (id == R.id.nav_logout) {

            getSharedPreferences("testpref",MODE_PRIVATE).edit().clear().apply();
            Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }
}
