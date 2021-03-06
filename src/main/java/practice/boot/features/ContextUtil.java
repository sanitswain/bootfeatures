package practice.boot.features;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Sanit
 * 
 *         Alternate approach to just autowire @ApplicationContext which will
 *         automatically inject ApplicationContext bean.
 *
 */
@Component
public class ContextUtil implements ApplicationContextAware {

	private ApplicationContext ctx;
	
	//@Autowired private ApplicationContext applicationCtx;

	@Autowired
	private Environment env;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
		System.out.println("application context created... evn=" + env);
		// System.out.println("==> " + env.getProperty("user.name"));
	}

	public ApplicationContext getApplicationContext() {
		return this.ctx;
	}

}
