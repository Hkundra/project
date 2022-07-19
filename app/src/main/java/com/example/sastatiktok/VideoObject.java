package com.example.sastatiktok;

public class VideoObject {

    public String videoURL, videoTitle, videoDescription;

    public VideoObject(String videoURL, String videoTitle, String videoDescription) {
        this.videoURL = videoURL;
        System.out.println(this.videoURL);
        this.videoTitle = videoTitle;
        System.out.println(this.videoTitle);
        this.videoDescription = videoDescription;
        System.out.println(this.videoDescription);

        System.out.println("Object constructor called");
    }

    public String getVideoURL() {
        System.out.println("getVideoURL");
        return videoURL;
    }

    public String getVideoTitle() {
        System.out.println("getVideoTitle");
        return videoTitle;
    }

    public String getVideoDescription() {
        System.out.println("getVideoDescription");
        return videoDescription;
    }
}
