package practice.boot.errorhandling;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class SampleRestController {

	/**
	 * This is demonstrating how to use <i>Error Handing</> for Controller /
	 * RestController. For testing hit the below url.
	 * 
	 * "http://localhost:8080/rest/greet/sanit0827"
	 * 
	 * @see SampleControllerAdvise.class
	 */
	@RequestMapping(value = "/greet/{username}")
	public String greeting(@PathVariable("username") String user) {
		System.out.printf("greeting :: username=%s\n", user);
		boolean containsDigit = user.matches("\\p{Alpha}+");
		if (!containsDigit) {
			throw new IllegalArgumentException("Username '" + user + "' is illegal.");
		}
		return "Hello " + user;
	}

}
