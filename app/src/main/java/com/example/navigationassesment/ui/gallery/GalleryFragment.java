package com.example.navigationassesment.ui.gallery;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.navigationassesment.R;

public class GalleryFragment extends Fragment implements View.OnClickListener {

    private GalleryViewModel galleryViewModel;
    private Button btnAreaOfCircle;
    private EditText etRadius;
    private TextView tvArea;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        etRadius=root.findViewById(R.id.etRadius);
        tvArea=root.findViewById(R.id.tvArea);
        btnAreaOfCircle=root.findViewById(R.id.btncalculate);
        btnAreaOfCircle.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        if(TextUtils.isEmpty(etRadius.getText()))
        {
            etRadius.setError("Enter radius of circle");
            return;
        }
        else{
            float radius = Float.parseFloat(etRadius.getText().toString());
            float cArea;

            cArea =  cArea = (float)(Math.PI*radius*radius);

            tvArea.setText("Area of Circle :" + cArea + " cm");

            Toast.makeText(getActivity(),"Area of Circle :"+cArea,Toast.LENGTH_LONG).show();
        }
    }
}