package com.example.myapplication2;


import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Input extends AppCompatActivity {
    private ArrayList<String>[][] data = new ArrayList[13][32];
    private int[] monthly = new int[12];
    private final Calendar today = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void readFile(String filename, Context context) {
        for(int i = 1; i <= 12; i++)
            for(int j = 1; j <= 31; j++)
                data[i][j] = new ArrayList<>();

        AssetManager am = null;
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String line = "";

        try {
            am = context.getResources().getAssets();
            is = am.open("sample_data.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            while ((line = br.readLine()) != null) {
                String[] line2 = line.split("\\.");
                int year = Integer.parseInt(line2[0]);
                int month = Integer.parseInt(line2[1]);
                int day = Integer.parseInt(line2[2]);
                int hour = Integer.parseInt(line2[3]);
                int minute = Integer.parseInt(line2[4]);
                int second = Integer.parseInt(line2[5]);

                data[month][day].add(line);

                monthly[month-1]++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                if (isr != null){
                    isr.close();
                }
                if(is != null){
                    is.close();
                }
                if(br != null){
                    br.close();
                }
            } catch(Exception e2){
                e2.getMessage();
            }
        }
    }


    public ArrayList<String>[][] getData() {
        return data;
    }

    public int getMonth() {
        return today.get(Calendar.MONTH) + 1; // 0(January) ~ 11
    }

    public int getDay() {
        return today.get(Calendar.DATE); // 1 ~ 31
    }

    public int getDayOfWeek() {
        return today.get(Calendar.DAY_OF_WEEK); // 1(Sunday) ~ 7
    }

    public int countToday() {
        int month = today.get(Calendar.MONTH) + 1;
        int day = today.get(Calendar.DATE);
        List<String> list = data[month][day];

        return list.size();
    }

<<<<<<< HEAD
    public int countThisWeek(){
=======
    public int countThisWeek() {
>>>>>>> a40a6e92ffab6ec4caa4fb77e5e2ce058467b979
        int month = today.get(Calendar.MONTH) + 1;
        int day = today.get(Calendar.DATE);
        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);
        List<String> list = data[month][day];

        int sum = 0;
        for(int i = dayOfWeek; i >= 2 ; i--) {
            sum += list.size();
            if(day == 1) {
                month--;
                day = today.getActualMaximum(Calendar.DATE);
            }
            else {
                day--;
            }
            list = data[month][day];
        }
        return sum;
    }

    public List<Integer> countMonthly() {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(i, monthly[i]);
        }
        return list;
    }
}