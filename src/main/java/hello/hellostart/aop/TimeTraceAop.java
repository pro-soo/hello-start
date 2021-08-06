package hello.hellostart.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component //SpringConfig bean 등록과 동일
public class TimeTraceAop { // 공통으로 적용되는 코드(공통 관심사항)를 따로 빼서 원하는 곳에만 적용가능 -> AOP

    @Around("execution(* hello.hellostart..*(..))") // 적용범위 설정, 전부 적용
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START : "+joinPoint.toString());
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : "+joinPoint.toString()+" "+timeMs+"ms");
        }
    }
}
