package com.stonks.StonksArt.repositories;

import com.stonks.StonksArt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
