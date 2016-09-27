package com.example.zz3430gs.staticbluegreenfragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


public class BlueFragment extends Fragment {

//    MainActivity hostingActivity;
    RandomNumberGeneratedListener randomListener;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//        return inflater.inflate(R.layout.blue_fragment, container, false);]

        View view = inflater.inflate(R.layout.blue_fragment, container, false);

        Button sendRndToGreen = (Button) view.findViewById(R.id.send_rnd_to_green_button);

        if (getActivity() instanceof RandomNumberGeneratedListener){
            randomListener = (RandomNumberGeneratedListener) getActivity();
        }
        else {
            throw new RuntimeException(getActivity().getClass().toString() + " should implement RandomNumberGeneratedListener");
        }

        sendRndToGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rng = new Random();
                int rnd = rng.nextInt(100);
                randomListener.sendRandomNumber(rnd);

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        if (getActivity() instanceof RandomNumberGeneratedListener){
            randomListener = (RandomNumberGeneratedListener) getActivity();
        }
        else {
            throw new RuntimeException(getActivity().getClass().toString() + " should implement RandomNumberGeneratedListener");
        }

//        randomListener = (MainActivity) getActivity();
    }
    interface RandomNumberGeneratedListener {
        void sendRandomNumber(int rnd);
    }
}
