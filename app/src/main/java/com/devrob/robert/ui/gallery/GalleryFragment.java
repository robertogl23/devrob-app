package com.devrob.robert.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.devrob.robert.R;
import com.devrob.robert.ui.video.ListVideosActivity;


public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private ImageButton btnGoToVideos;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        btnGoToVideos= root.findViewById(R.id.btn_to_videos);
        btnGoToVideos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses buttonStartHome();
                StartVideos();
            }
        });
        return root;
    }
    private void StartVideos(){
        Intent intent = new Intent(getContext(), ListVideosActivity.class);
        startActivity(intent);
    }

}