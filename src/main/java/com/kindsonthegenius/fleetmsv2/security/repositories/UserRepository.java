package com.kindsonthegenius.fleetmsv2.security.repositories;

import com.kindsonthegenius.fleetmsv2.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

   Optional <User> findByUsername(String username);

}
