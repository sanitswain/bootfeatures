package practice.springboot.features;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author Sanit
 *
 *         ApplicationRunner / CommandLineRunner is used to run specific task
 *         right after SpringApplication is started. This is same as task is
 *         called before run() method completes. The difference between
 *         ApplicationRunner and CommandLineRunner is the way it receives the
 *         arguments passed to start boot application. CommandLineRunner
 *         receives arguments as simple string array where as ApplicationRunner
 *         receives ApplicationArguments object it self. We can also use @Order
 *         to define their order of running.
 */
@Component
@Order(1)
public class CacheLoadingRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("==> Loading gemfire cache.... args= " + Arrays.stream(args).collect(Collectors.toList()));
	}

}
