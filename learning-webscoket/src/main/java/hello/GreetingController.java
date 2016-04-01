package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@MessageMapping("/hello/{id}")
	@SendTo("/topic/greetings/{id}")
	public Greeting greeting(HelloMessage message, @PathVariable("id") String id) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello (" + id + "), " + message.getName() + "!");
	}
	
	@RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
	public String view(@PathVariable("username") String username) {
		return "username : " + username;
	}
	

}
