package com.grupo13.bookingdigital.repository;

import com.grupo13.bookingdigital.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

  long countByDeletedFalse();


  Integer countByCategoryIdAndDeletedFalse(Long id);
}
