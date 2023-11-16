package com.Scaler.BookMy.Show.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @CreatedDate  //tells .date need to be created automatically.
    @Temporal(value=TemporalType.TIMESTAMP)  // to present , Date or time or time stamp with date +time.
    private Date createdAt;
    @LastModifiedDate
    @Temporal (value=TemporalType.DATE)
    private Date updatedAt;
}
