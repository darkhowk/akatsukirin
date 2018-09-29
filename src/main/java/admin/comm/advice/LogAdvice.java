package admin.comm.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // ���������� �����ϴ� bean
@Aspect // AOP bean
public class LogAdvice {

 // private : �ܺο��� �α׸� ����ä�� ���ϵ��� �ϱ� ����
 // static final : �α� ������ �ٲ��� �����Ƿ�
 // �α����� ����ϴ� ���� : sysout��ɾ�� IO���ҽ��� ���� ����Ͽ� �ý����� ������ �� �ִ�, �α׸� ���Ϸ� �����Ͽ� �м��� �ʿ䰡 �ִ�.
 private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);

 // PointCut - ���� ����
 // @Before, @After, @Around
 // ��Ʈ�ѷ�, ����, DAO�� ��� method�� ���� ���Ŀ� logPrint method�� �ڵ����� ����ȴ�.
 // .. : ������ ��� ���丮�� �ǹ�
 // *(..) : * - ������ ��� �޼���, (..) - ��� �Ű�����
 @Around("execution(* admin..controller.*Controller.*(..))"
         + " or execution(* admin..service..*Impl.*(..))"
         + " or execution(* admin..dao.*Dao.*(..))")
 public Object logPrinnt(ProceedingJoinPoint joinPoint) throws Throwable{
     // ���� �ð� üũ : ���۽ð�
     long start = System.currentTimeMillis();
     // �ٽɷ������� �̵�
     Object result = joinPoint.proceed();
     // Ŭ���� �̸�
     String type = joinPoint.getSignature().getDeclaringTypeName();
     String name = "";
     if (type.indexOf("Controller") > -1) {
    	 logger.info("");
         name = "Controller:";
     } else if (type.indexOf("Service") > -1) {
    	 logger.info("");
         name = "ServiceImpl:";
     } else if (type.indexOf("Dao") > -1) {
         name = "Dao:";
         logger.info("=====================================================================================================================");
     }
    
     // �޼��� �̸�
     logger.info("1. Method :: >> "+name+type+"."+joinPoint.getSignature().getName()+"()");
     // �Ķ���� �̸�
     logger.info("2. Params :: >> "+Arrays.toString(joinPoint.getArgs()));
     // ���� �ð� üũ : ����ð�
     long end = System.currentTimeMillis();
     // ���� �ð� üũ : ����
     long time = end-start;
     logger.info("3. ���� �ð� :: >> "+time);
     if (type.indexOf("Controller") > -1) {
    	   logger.info("====================================================================================================================="); 
     }
     return result;
 }
}
