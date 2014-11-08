package com.app.whatsthere.data;


import org.joda.time.LocalDateTime;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guyk on 11/5/14.
 */

@Entity
@Table(name = "image")
@Resource
public class Image {

    @Id
    @Column(name = "id")
    private int id;
    @Column
    private String url;
    @Column
    private List<String> imageHashTags;
    @Column
    private String user;
    @Column
    private  LocalDateTime timeOfCapture;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLocalDateTime(LocalDateTime timeOfCapture) {
        this.timeOfCapture = timeOfCapture;
    }
    public LocalDateTime getTimeOfCapture() {
        return timeOfCapture;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setImageHashTags(String imageHashTags) {
        this.imageHashTags = new ArrayList<String>();
        this.imageHashTags.add(imageHashTags);
    }
    public List<String> getImageHashTags() {
        return imageHashTags;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

}
