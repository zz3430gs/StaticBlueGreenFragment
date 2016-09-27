package com.example.zz3430gs.staticbluegreenfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements BlueFragment.RandomNumberGeneratedListener{

    public static final String RANDOM_BUNDLE_KEY = "Your random number";

    private GreenFragment greenFragment = new GreenFragment();
    private BlueFragment blueFragment = new BlueFragment();

    private static final String BLUE_TAG = "BLUE";
    private static final String GREEN_TAG = "GREEN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showBlueFragment();

//        updateFragment();
//
//        View v = findViewById(android.R.id.content);
//        v.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                updateFragment();
//            }
//        });
    }
    private void showBlueFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(android.R.id.content, blueFragment, BLUE_TAG);
        ft.commit();
    }
    public void sendRandomNumber(int rnd){
        Bundle arguments = new Bundle();

        arguments.putInt(RANDOM_BUNDLE_KEY, rnd);

        greenFragment.setArguments(arguments);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(android.R.id.content, greenFragment, GREEN_TAG);
        ft.addToBackStack(GREEN_TAG);
        ft.commit();
    }
//    private void updateFragment(){
//        FragmentManager fm = getFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//
//
//        if (fm.findFragmentByTag(BLUE_TAG) != null){
//            ft.replace(android.R.id.content, greenFragment, GREEN_TAG);
//        }
//        else {
//            ft.replace(android.R.id.content, blueFragment, BLUE_TAG);
//        }
//        ft.commit();
//    }
}
