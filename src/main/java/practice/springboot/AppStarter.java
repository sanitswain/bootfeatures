package practice.springboot;

import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import practice.springboot.service.MyService;

/**
 * @author Sanit
 *
 */
@Controller
@SpringBootApplication
@PropertySource({ "classpath:project.properties" })
public class AppStarter {

	@Autowired
	private MyService service;

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return service.invokeService();
	}

	public static void main(String[] args) {
		// SpringApplication.run(AppStarter.class, args);

		SpringApplication app = new SpringApplication(AppStarter.class);
		app.setBanner(new TextBanner());
		app.run(args);
	}

	public static class TextBanner implements Banner {

		@Override
		public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
			out.println("*****\t\t*****\t\t****\t\t******\t\t******");
			out.println("*\t Starting my boot application to explore boot features  *");
			out.println("*****\t\t*****\t\t****\t\t******\t\t******");
		}

	}
}
