package com.grupo13.bookingdigital.repository;

import com.grupo13.bookingdigital.model.BookingEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository <BookingEntity, Long> {

  List<BookingEntity> findAllByProductId(Long id);
}
