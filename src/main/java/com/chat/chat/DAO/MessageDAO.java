package com.chat.chat.DAO;

import com.chat.chat.Models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface MessageDAO extends JpaRepository<Message, Integer> {
             Message findTopByOrderByIdDesc();

}
