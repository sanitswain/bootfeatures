package practice.springboot.features;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Sanit
 *
 *         Spring Boot will also register a CommandLinePropertySource with the
 *         Spring Environment. This allows you to also inject single application
 *         arguments using the @Value annotation.
 * 
 *         This example shows how a command line argument can be configured to a
 *         bean with @Value annotation.
 */
@Component
public class CommandLinePropertySourceTest {

	@Autowired
	private Environment env;

	@Value("${user.name}")
	private String username;

	@PostConstruct
	public void start() {
		System.out.println("Environment=" + env);
		// System.out.println("==> " + env.getProperty("user.name"));
		System.out.println("==> username=" + username);
	}
}
