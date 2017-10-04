package ma.company.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class Logger {

	@Around("snapMethod()")
	public String roundMethod(ProceedingJoinPoint p) {
		System.out.println("Before round");
		try {
			p.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After round");
		return "around";
	}
	@Before("snapMethod()")
	public void aboutToTakePhoto() {
		System.out.println("About to take a photo...");
	}
	
	@Pointcut("execution(* ma.company.spring.aop.Camera.*(..))")
	public void snapMethod() {
		
	}

}
