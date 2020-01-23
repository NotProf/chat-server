package com.chat.chat.DAO;

import com.chat.chat.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDAO extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username=:name")
    User loadByUsername(@Param("name") String name);
}
