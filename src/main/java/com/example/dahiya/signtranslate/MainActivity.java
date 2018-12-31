package com.example.dahiya.signtranslate;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    CardView tts,stt,dict;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);

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
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView t1=(TextView)findViewById(R.id.text1);
        t1.setTypeface(null, Typeface.BOLD|Typeface.ITALIC);
        TextView t2=(TextView)findViewById(R.id.text2);
        t2.setTypeface(null, Typeface.BOLD|Typeface.ITALIC);
        TextView t3=(TextView)findViewById(R.id.text3);
        t3.setTypeface(null, Typeface.BOLD|Typeface.ITALIC);

        tts=(CardView) findViewById(R.id.text_to_sign);
        stt=(CardView) findViewById(R.id.sign_to_text);
        dict=(CardView) findViewById(R.id.dictionary);

        tts.setOnClickListener(this);
        stt.setOnClickListener(this);
        dict.setOnClickListener(this);
    }

    @Override
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
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
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
            i = new Intent(this, Text_to_sign.class);;i.putExtra("alphabet2","No_way");startActivity(i);
        } else if (id == R.id.sign_to_text) {
            i = new Intent(this, Sign_to_text.class);;startActivity(i);
        } else if (id == R.id.dictionary) {
            i = new Intent(this, Dictionary_alphabets.class);;startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        Intent i;
        switch (v.getId()) {
            case R.id.text_to_sign:
                i = new Intent(this, Text_to_sign.class);i.putExtra("alphabet2","No_way");startActivity(i);break;
            case R.id.sign_to_text:
                i = new Intent(this, Sign_to_text.class);startActivity(i);break;
            case R.id.dictionary:
                i = new Intent(this, Dictionary_alphabets.class);startActivity(i);break;
            default:break;
        }
    }
}
