package practice.boot.features;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

@Component
public class MyAppExitStatus implements ExitCodeGenerator {

	public MyAppExitStatus() {
	}

	@Override
	public int getExitCode() {
		System.out.println("MyAppExitStatus retuning exit code -1");
		return -1;
	}

}
