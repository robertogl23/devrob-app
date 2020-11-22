package com.devrob.robert.ui.video;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.devrob.robert.R;

public class ListVideosActivity extends AppCompatActivity {
    public static final String EXTRA_URI = "com.devrob.ListVideosActivity.URI";
    private ListView listView;
    private String videos [] = {"video 1","video 2","video 3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_videos);
       createList();
    }

    private void createList(){
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,videos);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedVideo(position);
            }
        });
    }

    private void selectedVideo(int i){
        String uri;
        Intent intent = new Intent(this, VideoPlayerActivity.class);
        switch (i) {
            case 0:
                //uri = "android.resource://" + getPackageName() + "/" + R.raw.video2;
                uri = "uri-video";
                intent.putExtra(EXTRA_URI, uri);
                startActivity(intent);
                break;
            default:
                System.out.println("no existe video");
        }
    }
}