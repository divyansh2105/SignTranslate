package com.example.dahiya.signtranslate;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Dictionary_alphabets extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    CardView tv[]=new CardView[26];
    TextView text[]=new TextView[26];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain_dictionary_alphabets);

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

        tv[0]=(CardView) findViewById(R.id.a);
        tv[1]=(CardView) findViewById(R.id.b);
        tv[2]=(CardView) findViewById(R.id.c);
        tv[3]=(CardView) findViewById(R.id.d);
        tv[4]=(CardView) findViewById(R.id.e);
        tv[5]=(CardView) findViewById(R.id.f);
        tv[6]=(CardView) findViewById(R.id.g);
        tv[7]=(CardView) findViewById(R.id.h);
        tv[8]=(CardView) findViewById(R.id.i);
        tv[9]=(CardView) findViewById(R.id.j);
        tv[10]=(CardView) findViewById(R.id.k);
        tv[11]=(CardView) findViewById(R.id.l);
        tv[12]=(CardView) findViewById(R.id.m);
        tv[13]=(CardView) findViewById(R.id.n);
        tv[14]=(CardView) findViewById(R.id.o);
        tv[15]=(CardView) findViewById(R.id.p);
        tv[16]=(CardView) findViewById(R.id.q);
        tv[17]=(CardView) findViewById(R.id.r);
        tv[18]=(CardView) findViewById(R.id.s);
        tv[19]=(CardView) findViewById(R.id.t);
        tv[20]=(CardView) findViewById(R.id.u);
        tv[21]=(CardView) findViewById(R.id.v);
        tv[22]=(CardView) findViewById(R.id.w);
        tv[23]=(CardView) findViewById(R.id.x);
        tv[24]=(CardView) findViewById(R.id.y);
        tv[25]=(CardView) findViewById(R.id.z);

        text[0]=(TextView) findViewById(R.id.ta);
        text[1]=(TextView) findViewById(R.id.tb);
        text[2]=(TextView) findViewById(R.id.tc);
        text[3]=(TextView) findViewById(R.id.td);
        text[4]=(TextView) findViewById(R.id.te);
        text[5]=(TextView) findViewById(R.id.tf);
        text[6]=(TextView) findViewById(R.id.tg);
        text[7]=(TextView) findViewById(R.id.th);
        text[8]=(TextView) findViewById(R.id.ti);
        text[9]=(TextView) findViewById(R.id.tj);
        text[10]=(TextView) findViewById(R.id.tk);
        text[11]=(TextView) findViewById(R.id.tl);
        text[12]=(TextView) findViewById(R.id.tm);
        text[13]=(TextView) findViewById(R.id.tn);
        text[14]=(TextView) findViewById(R.id.to);
        text[15]=(TextView) findViewById(R.id.tp);
        text[16]=(TextView) findViewById(R.id.tq);
        text[17]=(TextView) findViewById(R.id.tr);
        text[18]=(TextView) findViewById(R.id.ts);
        text[19]=(TextView) findViewById(R.id.tt);
        text[20]=(TextView) findViewById(R.id.tu);
        text[21]=(TextView) findViewById(R.id.tv);
        text[22]=(TextView) findViewById(R.id.tw);
        text[23]=(TextView) findViewById(R.id.tx);
        text[24]=(TextView) findViewById(R.id.ty);
        text[25]=(TextView) findViewById(R.id.tz);

        tv[0].setOnClickListener(this);
        tv[1].setOnClickListener(this);
        tv[2].setOnClickListener(this);
        tv[3].setOnClickListener(this);
        tv[4].setOnClickListener(this);
        tv[5].setOnClickListener(this);
        tv[6].setOnClickListener(this);
        tv[7].setOnClickListener(this);
        tv[8].setOnClickListener(this);
        tv[9].setOnClickListener(this);
        tv[10].setOnClickListener(this);
        tv[11].setOnClickListener(this);
        tv[12].setOnClickListener(this);
        tv[13].setOnClickListener(this);
        tv[14].setOnClickListener(this);
        tv[15].setOnClickListener(this);
        tv[16].setOnClickListener(this);
        tv[17].setOnClickListener(this);
        tv[18].setOnClickListener(this);
        tv[19].setOnClickListener(this);
        tv[20].setOnClickListener(this);
        tv[21].setOnClickListener(this);
        tv[22].setOnClickListener(this);
        tv[23].setOnClickListener(this);
        tv[24].setOnClickListener(this);
        tv[25].setOnClickListener(this);


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
            i = new Intent(this, Text_to_sign.class);i.putExtra("alphabet2","No_way");;startActivity(i);
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
        i = new Intent(this, Dictionary_words.class);
        switch (v.getId()) {
            case R.id.a:
                i.putExtra("alphabet",text[0].getText().toString());startActivity(i);break;
            case R.id.b:
                i.putExtra("alphabet",text[1].getText().toString());startActivity(i);break;
            case R.id.c:
                i.putExtra("alphabet",text[2].getText().toString());startActivity(i);break;
            case R.id.d:
                i.putExtra("alphabet",text[3].getText().toString());startActivity(i);break;
            case R.id.e:
                i.putExtra("alphabet",text[4].getText().toString());startActivity(i);break;
            case R.id.f:
                i.putExtra("alphabet",text[5].getText().toString());startActivity(i);break;
            case R.id.g:
                i.putExtra("alphabet",text[6].getText().toString());startActivity(i);break;
            case R.id.h:
                i.putExtra("alphabet",text[7].getText().toString());startActivity(i);break;
            case R.id.i:
                i.putExtra("alphabet",text[8].getText().toString());startActivity(i);break;
            case R.id.j:
                i.putExtra("alphabet",text[9].getText().toString());startActivity(i);break;
            case R.id.k:
                i.putExtra("alphabet",text[10].getText().toString());startActivity(i);break;
            case R.id.l:
                i.putExtra("alphabet",text[11].getText().toString());startActivity(i);break;
            case R.id.m:
                i.putExtra("alphabet",text[12].getText().toString());startActivity(i);break;
            case R.id.n:
                i.putExtra("alphabet",text[13].getText().toString());startActivity(i);break;
            case R.id.o:
                i.putExtra("alphabet",text[14].getText().toString());startActivity(i);break;
            case R.id.p:
                i.putExtra("alphabet",text[15].getText().toString());startActivity(i);break;
            case R.id.q:
                i.putExtra("alphabet",text[16].getText().toString());startActivity(i);break;
            case R.id.r:
                i.putExtra("alphabet",text[17].getText().toString());startActivity(i);break;
            case R.id.s:
                i.putExtra("alphabet",text[18].getText().toString());startActivity(i);break;
            case R.id.t:
                i.putExtra("alphabet",text[19].getText().toString());startActivity(i);break;
            case R.id.u:
                i.putExtra("alphabet",text[20].getText().toString());startActivity(i);break;
            case R.id.v:
                i.putExtra("alphabet",text[21].getText().toString());startActivity(i);break;
            case R.id.w:
                i.putExtra("alphabet",text[22].getText().toString());startActivity(i);break;
            case R.id.x:
                i.putExtra("alphabet",text[23].getText().toString());startActivity(i);break;
            case R.id.y:
                i.putExtra("alphabet",text[24].getText().toString());startActivity(i);break;
            case R.id.z:
                i.putExtra("alphabet",text[25].getText().toString());startActivity(i);break;
            default:break;
        }

    }
}
