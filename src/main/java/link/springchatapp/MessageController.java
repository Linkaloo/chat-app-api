package link.springchatapp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/message")
    public MessageResponse messageResponse(Message message) throws Exception {
        Thread.sleep(1000);
        return new MessageResponse("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
