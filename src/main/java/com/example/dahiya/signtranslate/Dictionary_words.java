package com.example.dahiya.signtranslate;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class Dictionary_words extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public Dictionary_words()
    {

    }

    TextView text;
    String alpha;
    Databasehandler databasehandler;
    Cursor cur;
    int n;
    String arr[];
    ListView ls;




    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dict_words);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Bundle extra=getIntent().getExtras();
        alpha=extra.getString("alphabet");

        text=(TextView)findViewById(R.id.text);
        text.setText(alpha);
        alpha=alpha.toLowerCase();

        databasehandler=new Databasehandler(this,null,null,1);
        cur=databasehandler.getcursorAlphabets(alpha);
        n=cur.getCount();
        arr=new String[n];
        for(int j=0;j<n;j++)
        {
            arr[j]=new String();
        }
        getinput();

//        View view=inflater.inflate(R.layout.dictionary_words, container, false);

        ls=findViewById(R.id.mylistview);
        Custom_adapter customadapter=new Custom_adapter(this,arr);
        ls.setAdapter(customadapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Dictionary_words.this, Text_to_sign.class);

                i.putExtra("alphabet2",arr[position]);


                startActivity(i);            }
        });


    }

    public void getinput()
    {
        int i=0;

        while(cur.moveToNext()) {

            arr[i]=cur.getString(0);

            ++i;
        }
    }


    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent i;
        int id = item.getItemId();

        if (id == R.id.home) {
            i = new Intent(this, MainActivity.class);;startActivity(i);
        } else if (id == R.id.text_to_sign) {
            i = new Intent(this, Text_to_sign.class);i.putExtra("alphabet2","No_way");startActivity(i);
        } else if (id == R.id.sign_to_text) {
            i = new Intent(this, Sign_to_text.class);;startActivity(i);
        } else if (id == R.id.dictionary) {
            i = new Intent(this, Dictionary_alphabets.class);;startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
