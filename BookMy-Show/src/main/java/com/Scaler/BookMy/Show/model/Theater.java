package com.Scaler.BookMy.Show.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    private String name;
  //  @ManyToOne
   // private List<Region> regionList;
  //  @OneToMany
  //  private List<Screen> screens;
}
