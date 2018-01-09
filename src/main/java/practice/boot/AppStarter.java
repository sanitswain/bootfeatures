package practice.boot;

import java.io.PrintStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import practice.boot.service.MyService;

/**
 * @author Sanit
 *
 */
@Controller
@SpringBootApplication
@PropertySource({ "classpath:project.properties" })
@EnableScheduling
@ServletComponentScan
@PropertySource("classpath:application.properties")
public class AppStarter {

	@Autowired
	private MyService service;

	@Value("${some.prop}")
	private static String descr;

	@Autowired
	private static Environment env;

	@ResponseBody
	@RequestMapping("/")
	public String home() {
		return service.invokeService();
	}

	public static void main(String[] args) throws Exception {
		// SpringApplication.run(AppStarter.class, args);

		// SpringApplication app = new SpringApplication(AppStarter.class);
		// app.setBanner(new TextBanner());
		ConfigurableApplicationContext ctx = SpringApplication.run(AppStarter.class, args);
		String str = ctx.getEnvironment().getProperty("some.prop");
		// String str = app.run(args).getEnvironment().getProperty("some.prop");
		System.out.println("==============>>>> " + str);

		System.out.println("===>>>> env = " + env);
		System.out.println("===>>>> descr = " + descr);
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
