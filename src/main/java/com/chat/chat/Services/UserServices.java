package com.chat.chat.Services;

import com.chat.chat.DAO.RoomDAO;
import com.chat.chat.DAO.UserDAO;
import com.chat.chat.Models.Message;
import com.chat.chat.Models.Room;
import com.chat.chat.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServices {
    private UserDAO userDAO;
    private RoomDAO roomDAO;
     @Autowired
    public UserServices(UserDAO userDAO,  RoomDAO roomDAO) {
        this.userDAO = userDAO;
        this.roomDAO = roomDAO;
    }

    private String currentUser;
    public void saveMsg(String textMsg, Integer roomID) {
        Message message = new Message();
        message.setTextMsg(textMsg);
        message.setSenderName(currentUser);
        System.out.println(currentUser);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        message.setDate(new Date(System.currentTimeMillis()));
        message.setSenderName(currentUser);
        Room room = roomDAO.getOneWithMsg(roomID);
        List<Message> messages = room.getMessages();
        messages.add(message);
        message.setRoom(room);
        room.setMessages(messages);
        roomDAO.save(room);


    }

    public Room getRoom(String fromId, String forName) {
        User current = userDAO.loadByUsername(fromId);
        User recipient = userDAO.loadByUsername(forName);
        List<Room> rooms = current.getRooms();
        for (Room room : rooms) {
            for (User user : room.getUsers()) {
                if (user.getUsername().equals(forName)) {
                    System.out.println("FIND ROOM");
                    return room;
                }
            }
        }
        List<User> users = new ArrayList<>();
        users.add(recipient);
        users.add(current);
        Room newRoom = new Room();
        newRoom.setUsers(users);
        System.out.println("CREATE ROOM");
        newRoom = roomDAO.save(newRoom);
        setNewRoom(recipient, newRoom);
        setNewRoom(current, newRoom);
        return newRoom;
    }

    public void setNewRoom(User user, Room room) {
        List<Room> rooms = user.getRooms();
        rooms.add(room);
        user.setRooms(rooms);
        userDAO.save(user);
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }
}
