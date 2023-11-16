package com.Scaler.BookMy.Show.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;
    private Date starttime;
    private Date endtime;
   // @ManyToOne
   // private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<ScreenFeature> screenFeatureList;
    @OneToMany
    private List<ShowSeat> showSeats;

}
