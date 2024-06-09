package link.springchatapp.controllers;

import link.springchatapp.models.Message;
import link.springchatapp.models.MessageResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {
    @MessageMapping("/message")
    @SendTo("/topic/message")
    public MessageResponse messageResponse(Message message) throws Exception {
        return new MessageResponse(message.getSender(), message.getMessage());
    }
}
