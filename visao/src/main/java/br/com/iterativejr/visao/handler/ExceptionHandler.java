/**
 * 
 */
package br.com.iterativejr.visao.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


/**
 * @author edsf
 *
 */
@Aspect
public class ExceptionHandler {

	@Around("execution(* br.com.iterativejr.poc.visao.controller..*(..))")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable
	{
		Object resultado = pjp.proceed();
		
		return resultado;
	}
}
