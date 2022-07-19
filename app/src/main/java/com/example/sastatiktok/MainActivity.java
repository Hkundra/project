package com.example.sastatiktok;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager2 viewPager2=findViewById(R.id.viewPager);

        System.out.println("Inside Main activity");

        List<VideoObject> videoObjects=new ArrayList<>();

        VideoObject videoObject1=new VideoObject("https://firebasestorage.googleapis.com/v0/b/colour-mixer-d1f89.appspot.com/o/pexels-cottonbro-7169782.mp4?alt=media&token=19d3d5f7-052c-4326-af3f-d71c3aaa2569","Woman in spacesuit","SPAAACE");
        videoObjects.add(videoObject1);

        VideoObject videoObject2=new VideoObject("https://firebasestorage.googleapis.com/v0/b/colour-mixer-d1f89.appspot.com/o/production%20ID_3796066.mp4?alt=media&token=98bc37d6-b94b-47f2-9c36-1fa826ad3310","Art","Artist painting a picture");
        videoObjects.add(videoObject2);

        VideoObject videoObject3=new VideoObject("https://firebasestorage.googleapis.com/v0/b/colour-mixer-d1f89.appspot.com/o/video.mp4?alt=media&token=386d110d-b5e9-4e3e-b420-9ad791a268df","Night","Just a random guy walking on the sidewalk. Go home mate.");
        videoObjects.add(videoObject3);

        viewPager2.setAdapter(new VideoAdapter(videoObjects));

    }
}