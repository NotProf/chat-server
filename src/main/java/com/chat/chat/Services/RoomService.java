package com.chat.chat.Services;

import com.chat.chat.DAO.RoomDAO;
import com.chat.chat.Models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    private RoomDAO roomDAO;

}
