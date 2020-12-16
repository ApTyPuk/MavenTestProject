package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ClassicalMusic implements Music{

    private List<String> classicMusicList = new ArrayList<>();

    public ClassicalMusic() {
        this.classicMusicList.add("Hungarian Rhapsody1");
        this.classicMusicList.add("Hungarian Rhapsody2");
        this.classicMusicList.add("Hungarian Rhapsody3");
    }

    @Override
    public String getSong() {
        return classicMusicList.get(new Random().nextInt(classicMusicList.size()));
    }
}
