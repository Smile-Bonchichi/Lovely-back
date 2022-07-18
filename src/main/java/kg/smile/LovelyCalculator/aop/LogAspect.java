package kg.smile.LovelyCalculator.aop;

import kg.smile.LovelyCalculator.entity.Log;
import kg.smile.LovelyCalculator.exception.BaseException;
import kg.smile.LovelyCalculator.service.database.LogService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogAspect {
    final LogService logService;

    @Autowired
    public LogAspect(LogService logService) {
        this.logService = logService;
    }

    @Pointcut(value = "(within(@org.springframework.stereotype.Repository *)" +
            " || within(@org.springframework.stereotype.Service *)" +
            " || within(@org.springframework.web.bind.annotation.RestController *))")
    public void springBeanPointcut() {
    }

    @Pointcut(value = "(within(kg.smile.LovelyCalculator..*) || within(kg.smile.LovelyCalculator.controller..*))")
    public void applicationPackagePointcut() {
    }

    @Around("applicationPackagePointcut() && springBeanPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Log log = logService.saveOrUpdate(
                Log.builder()
                        .controllerName(joinPoint.getSignature().getDeclaringTypeName())
                        .requestBody("Enter: {" +
                                joinPoint.getSignature().getDeclaringTypeName() +
                                "}.{" +
                                joinPoint.getSignature().getName() +
                                "}() with argument[" +
                                joinPoint.getArgs().length +
                                "] = {" +
                                Arrays.toString(joinPoint.getArgs()) +
                                "}"
                        )
                        .build()
        );
        try {
            Object result = joinPoint.proceed();
            log.setHttpResponseCode(200L);
            log.setResponseBody("Exit: {" +
                    joinPoint.getSignature().getDeclaringTypeName() +
                    "}.{" +
                    joinPoint.getSignature().getName() +
                    "}() with result = {" +
                    result +
                    "}"
            );
            logService.saveOrUpdate(log);

            return result;
        } catch (BaseException e) {
            log.setResponseBody("Exception in {" +
                    joinPoint.getSignature().getDeclaringTypeName() +
                    "}.{" +
                    joinPoint.getSignature().getName() +
                    "}() with cause = {" +
                    (e.getMessage() != null ? e.getMessage() : "NULL") +
                    "}"
            );
            log.setHttpResponseCode((long) e.getHttpStatus().value());
            logService.saveOrUpdate(log);

            throw e;
        }
    }
}
