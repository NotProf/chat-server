package com.chat.chat.Controllers;

import com.chat.chat.DAO.MessageDAO;
import com.chat.chat.DAO.UserDAO;
import com.chat.chat.Models.InputModel;
import com.chat.chat.Models.Message;
import com.chat.chat.Models.OutputModel;
import com.chat.chat.Models.Room;
import com.chat.chat.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ChatController {
    private SimpMessagingTemplate template;
    @Autowired
    ChatController(SimpMessagingTemplate template){
        this.template = template;
    }
    @Autowired
    UserServices userService;
    @Autowired
    UserDAO userDAO;
    @Autowired
    MessageDAO messageDAO;
    @GetMapping("/")
    public void test () {
    }
     @MessageMapping("/send/message/{id}") // /allowDestinationPrefix/msg
     @SendTo("/chat/{id}")
     public Message mainMsg(String message,
                                 @DestinationVariable int id) throws Exception {

         userService.saveMsg(message, id);
         return messageDAO.findTopByOrderByIdDesc();
         }

         @GetMapping("/openRoom/{name}")
         public Room openRoom (@PathVariable String name) {
             String current = SecurityContextHolder.getContext().getAuthentication().getName();
             return userService.getRoom(current, name);
         }
}
