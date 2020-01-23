package com.chat.chat.Controllers;

import com.chat.chat.Models.InputModel;
import com.chat.chat.Models.OutputModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class ChatController {
    private SimpMessagingTemplate template;
    @Autowired
    ChatController(SimpMessagingTemplate template){
        this.template = template;
    }
     @MessageMapping("/send/message/{id}") // /allowDestinationPrefix/msg
     @SendTo("/chat/{id}")
     public OutputModel greeting(String message,
                                 @RequestHeader("chatID") String chatId,
                                 @DestinationVariable String id) throws Exception {
//         this.template.convertAndSend("/chat/" + chatId, new SimpleDateFormat("HH:mm:ss").format(new Date())
//                     + "-" + message);
         return new OutputModel(message);
         }
}
