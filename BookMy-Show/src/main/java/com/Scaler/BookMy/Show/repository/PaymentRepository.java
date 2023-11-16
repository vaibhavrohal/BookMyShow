package com.Scaler.BookMy.Show.repository;

import com.Scaler.BookMy.Show.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    @Override
    Optional<Payment> findById(Long paymentId);

    Optional<Payment> findByrefNo(int paymentrefNo);
    @Override

    Payment save(Payment payment);

}
