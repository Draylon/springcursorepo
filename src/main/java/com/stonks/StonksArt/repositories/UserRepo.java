package com.stonks.StonksArt.repositories;

import com.stonks.StonksArt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    //public void validadeUserEmail(String email);
    //@Query("SELECT u FROM User u "+
    //            "WHERE u.email = :userEmail")


    public User findByEmail(@Param("userEmail") String email);
}
