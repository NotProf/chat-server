package com.chat.chat.DAO;

import com.chat.chat.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RoomDAO extends JpaRepository<Room, Integer> {
    Room getOne(int id);
}
