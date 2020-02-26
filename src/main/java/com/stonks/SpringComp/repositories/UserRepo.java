package com.stonks.SpringComp.repositories;

import com.stonks.SpringComp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    //public void validadeUserEmail(String email);
    //@Query("SELECT u FROM User u "+
    //            "WHERE u.email = :userEmail")


    public Optional<User> findByEmail(@Param("userEmail") String email);
    public User getByEmail(@Param("userEmail") String email);
}
