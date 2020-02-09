package com.chat.chat.DAO;

import com.chat.chat.Models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RoomDAO extends JpaRepository<Room, Integer> {
    Room getOne(Integer id);
    @Query("select r from Room r where r.id=:id")
     Room getOneWithMsg(@Param("id") int id);
}
