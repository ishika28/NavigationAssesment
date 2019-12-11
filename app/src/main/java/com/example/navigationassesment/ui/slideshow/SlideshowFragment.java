package com.example.navigationassesment.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.navigationassesment.R;

import javax.microedition.khronos.egl.EGLDisplay;

public class SlideshowFragment extends Fragment implements View.OnClickListener {
  //  private EditText tvintrest;
    private EditText etpriciple, etTime, etrate;
    private Button btnIntrest;
    private TextView tvInterest;

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        etpriciple=root.findViewById(R.id.etprinciple);
        etTime=root.findViewById(R.id.etTime);
        etrate=root.findViewById(R.id.etrate);
        btnIntrest=root.findViewById(R.id.btninterest);
        tvInterest=root.findViewById(R.id.tvintrest);

        btnIntrest.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {

        float principle = Float.parseFloat(etpriciple.getText().toString());
        float rate = Float.parseFloat(etrate.getText().toString());
        float time = Float.parseFloat(etTime.getText().toString());
        float result;


        result = principle*rate*time;
        tvInterest.setText(Float.toString(result));
    }
}