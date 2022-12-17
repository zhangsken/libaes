package com.github.zhangsken.aes.fragments;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import com.github.zhangsken.aes.R;
import com.github.zhangsken.libaes.AButton;
import android.widget.Toast;


public class AButtonFragment extends Fragment {
    public static final String TAG = "AButtonFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_abutton, container, false);
        AButton aButton = view.findViewById(R.id.fragmentabuttonAButton1);
        aButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "AButton", Toast.LENGTH_SHORT).show();
                }
            
        });
        return view;
    }
    
    
    
}
