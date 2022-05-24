package com.example.fithub.main.prototypes.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ExerciseData {
  @PrimaryKey public int id;
  public String name;
  public String instruction;
  public String imageUrl;
  public String videoUrl;

  public ExerciseData(int id, String name, String instruction, String imageUrl, String videoUrl) {
    this.id = id;
    this.name = name;
    this.instruction = instruction;
    this.imageUrl = imageUrl;
    this.videoUrl = videoUrl;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInstruction() {
    return instruction;
  }

  public void setInstruction(String instruction) {
    this.instruction = instruction;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getVideoUrl() {
    return videoUrl;
  }

  public void setVideoUrl(String videoUrl) {
    this.videoUrl = videoUrl;
  }
}