package com.Scaler.BookMy.Show.model;


import jakarta.persistence.*;

import java.util.List;


public class Screen extends BaseModel{
    private String name;
    @ManyToOne
    private Theater theater;
    @OneToMany
    private List<Seat> seatList;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // when relationship is one to many.. use this annotation to ceate maping table in DB
    private List<ScreenFeature> screenFeatureList;
}
