package com.chat.chat.Controllers;

import com.chat.chat.Models.InputModel;
import com.chat.chat.Models.OutputModel;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
     @MessageMapping("/app") // /allowDestinationPrefix/msg
         @SendTo("/chanelName/outPoint")
         public OutputModel greeting(InputModel message) throws Exception {
             return null;
         }
}
