package practice.boot.aop;

import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {

	@Before("showAdvice()")
	public void showServiceAdvice(JoinPoint jp) {
		System.out.println("Before advice for show service: " + jp.getSignature().getName());
	}

	@Pointcut("execution(* practice.boot.aop.AppService.show*())")
	public void showAdvice() {
	}

	// @Before("args(person)")
	public void setPersonAdvice(String person) {
		System.out.println("setNameAdvice person=" + person);
	}

	@AfterReturning(pointcut = "execution(public java.util.UUID createUUID())", returning = "uuid")
	public void afterAdvice(UUID uuid) {
		System.out.println("afterAdvice :: Generated UUID: " + uuid);
	}

	@AfterThrowing(pointcut = "within(practice.boot.aop.AppService)", throwing = "java.lang.IllegalAccessException")
	public void exceptionAdvice() {
		System.out.println("exceptionAdvice :: Exception raised");
	}

	@Around("execution(* getLowestInterestRate())")
	public Object aroundAdvice(ProceedingJoinPoint pjp) {
		System.out.println("\nLogging into server with token");
		Object value = null;
		try {
			value = pjp.proceed();
			System.out.println("value= " + value);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Session invalidated.\n");
		return value;
	}

	@Before("@annotation(practice.boot.aop.Loggable)")
	public void loggableAdvice(JoinPoint jp) {
		System.out.printf("%s service invoked.\n", jp.getSignature().getName());
	}

}
