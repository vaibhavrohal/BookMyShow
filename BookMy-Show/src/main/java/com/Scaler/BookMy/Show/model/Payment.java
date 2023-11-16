package com.Scaler.BookMy.Show.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private int refNo;
    private double amount;
    @Enumerated(EnumType.ORDINAL)
   private PaymentStatus paymentStatus;
    @Enumerated(EnumType.ORDINAL)
   private PaymentType paymentType;

}
