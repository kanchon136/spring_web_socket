package websocket.com.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import websocket.com.dto.Greeting;
import websocket.com.dto.Message;

@Controller
public class GreetingController {
	
@MessageMapping("/hello")
@SendTo("/topic/greetings")
public Greeting greting(Message message) throws InterruptedException {
	Thread.sleep(1000);
	return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}



@GetMapping("/index")
public String indexPage() {
	return "index";
}

}
