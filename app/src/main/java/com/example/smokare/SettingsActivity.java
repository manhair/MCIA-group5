package com.example.smokare;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class SettingsActivity extends AppCompatActivity {
    private String name;
    private String age, year, price;
    private String tar;
    private SharedPreferences info;
    private TextView textUserName, textUserAge, textUserYear, textUserPrice, textUserTar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_menu1: {
                    Intent intent = new Intent(SettingsActivity.this, HomeActivity.class);
                    startActivity(intent);
                    return false;
                }
                case R.id.navigation_menu2: {
                    Intent intent = new Intent(SettingsActivity.this, TimelineActivity.class);
                    startActivity(intent);
                    return false;
                }
                case R.id.navigation_menu3: {
                    Intent intent = new Intent(SettingsActivity.this, ReportActivity.class);
                    startActivity(intent);
                    return false;
                }
                case R.id.navigation_menu4: {
                    Intent intent = new Intent(SettingsActivity.this, SettingsActivity.class);
                    startActivity(intent);
                    return false;
                }
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Global_Variable global = (Global_Variable) getApplication();


        info = getSharedPreferences("user_info", MODE_PRIVATE);
        //load();
        name = global.getName();
        age = global.getAge();
        year = global.getYear();
        price = global.getPrice();
        tar = global.getTar();

        textUserName = findViewById(R.id.textUserName);
        textUserAge = findViewById(R.id.textUserAge);
        textUserYear = findViewById(R.id.textUserYear);
        textUserPrice = findViewById(R.id.textUserPrice);
        textUserTar = findViewById(R.id.textUserTar);

        textUserName.setText("User NickName : " + name);
        textUserAge.setText("User Age : " +age);
        textUserYear.setText("The time User started smoking : " +year);
        textUserPrice.setText("The price of cigarette : " +price);
        textUserTar.setText("The tar of user's cigarette : " +tar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().getItem(3).setChecked(true);
//        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.navigation_menu1: {
//                        Intent intent = new Intent(SettingsActivity.this, HomeActivity.class);
//                        startActivity(intent);
//                        break;
//                    }
//                    case R.id.navigation_menu2: {
//                        Intent intent = new Intent(SettingsActivity.this, TimelineActivity.class);
//                        startActivity(intent);
//                        break;
//                    }
//                    case R.id.navigation_menu3: {
//                        Intent intent = new Intent(SettingsActivity.this, ReportActivity.class);
//                        startActivity(intent);
//                        break;
//                    }
//                    case R.id.navigation_menu4: {
//                        Intent intent = new Intent(SettingsActivity.this, SettingsActivity.class);
//                        startActivity(intent);
//                        break;
//                    }
//                }
//                return true;
//            }
//        });
    }

    protected void onPause() {
        super.onPause();

        // Remove the activity when its off the screen
        finish();
    }

//    private void load(){
//        name = info.getString("name", "");
//        age = info.getInt("age", 0);
//        year = info.getInt("year", 0);
//        price = info.getInt("price", 0);
//        tar = info.getFloat("tar", 0);
//    }


}


