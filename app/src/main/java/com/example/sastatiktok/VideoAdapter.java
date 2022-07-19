package com.example.sastatiktok;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    private List<VideoObject> videoObjects;

    public VideoAdapter(List<VideoObject> videoObjects) {
        this.videoObjects=videoObjects;

        System.out.println("Setting adapter constructor");
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println("onCreateViewHolder");

        return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.video_container,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        System.out.println("onBindViewHolder");

        //holder.setVideoObjects(videoObjects.get(position));
        VideoObject videoObject=videoObjects.get(position);

        //void setVideoObjects(final VideoObject videoObjects){

            System.out.println("Setting video objects");

            holder.videoTitle.setText(videoObject.getVideoTitle());
            holder.videoDescription.setText(videoObject.getVideoDescription());
            holder.videoView.setVideoPath(videoObject.getVideoURL());

            holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                @Override
                public void onPrepared(MediaPlayer mp) {
                    System.out.println("Progress bar setting");
                    holder.progressBar.setVisibility(View.GONE);
                    mp.start();
                }
            });

            //For play and pause
            holder.videoView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    System.out.println("On or off");

                    if (holder.videoView.isPlaying()){
                        holder.videoView.pause();
                        return false;
                    }
                    else{
                        holder.videoView.start();
                        return false;
                    }
                }
            });
        //}


    }

    @Override
    public int getItemCount() {
        return videoObjects.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{

        VideoView videoView;
        TextView videoTitle, videoDescription;
        ProgressBar progressBar;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            System.out.println("Finiding view");

            videoView=itemView.findViewById(R.id.videoView);
            videoTitle=itemView.findViewById(R.id.videoTitle);
            videoDescription=itemView.findViewById(R.id.videoDescription);
            progressBar=itemView.findViewById(R.id.progressBar);
        }

       // @SuppressLint("ClickableViewAccessibility")
//        void setVideoObjects(final VideoObject videoObjects){
//
//            System.out.println("Setting video objects");
//
//            videoTitle.setText(videoObjects.getVideoTitle());
//            videoDescription.setText(videoObjects.getVideoDescription());
//            videoView.setVideoPath(videoObjects.getVideoURL());
//
//            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//
//                @Override
//                public void onPrepared(MediaPlayer mp) {
//                    System.out.println("Progress bar setting");
//                    progressBar.setVisibility(View.GONE);
//                    mp.start();
//                }
//            });
//
//            //For play and pause
//            videoView.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    System.out.println("On or off");
//
//                    if (videoView.isPlaying()){
//                        videoView.pause();
//                        return false;
//                    }
//                    else{
//                        videoView.start();
//                        return false;
//                    }
//                }
//            });
//        }

    }
}
