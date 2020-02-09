package com.chat.chat.Controllers;

import com.chat.chat.DAO.RoomDAO;
import com.chat.chat.DAO.UserDAO;
import com.chat.chat.Models.Room;
import com.chat.chat.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    private UserDAO userDAO;
    private RoomDAO roomDAO;
    @Autowired
    public RoomController(UserDAO userDAO, RoomDAO roomDAO) {
        this.userDAO = userDAO;
        this.roomDAO = roomDAO;
    }

    @GetMapping("/getAll")
    public List<Room> getAllRoom (){
        String current = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userDAO.loadByUsername(current);
        return user.getRooms();
    }
}
