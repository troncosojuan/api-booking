package com.grupo13.bookingdigital.auth.repository;

import com.grupo13.bookingdigital.auth.model.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long>{

  Optional<UserEntity> findByEmail(String email);

}
