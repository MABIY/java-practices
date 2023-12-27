package com.example.messagingstompwebsocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

/**
 * @author lh
 */
@Controller
public class GreetingController {

    @Autowired
    public SimpMessageSendingOperations messagingTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @MessageMapping("/hello")
    public void greeting(@Header("simpSessionId") String sessionId, HelloMessage message) throws Exception {
        String responseMessage = objectMapper.writeValueAsString(new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!"));
        messagingTemplate.convertAndSendToUser(sessionId, "/queue/something", responseMessage, createHeaders(sessionId));
    }

    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }
}
