package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//@Component("musicBean")
@Component
public class RockMusic implements Music{

    private List<String> rockMusicList = new ArrayList<>();

    public RockMusic() {
        this.rockMusicList.add("Wind cries Mary1");
        this.rockMusicList.add("Wind cries Mary2");
        this.rockMusicList.add("Wind cries Mary3");
    }

    @Override
    public String getSong() {
        return rockMusicList.get(new Random().nextInt(rockMusicList.size()));
    }

}
