package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor // 생성자가 하나면 @RequiredArgsConstructor를 사용하여 생성자 주입을 자동으로 생성합니다.
public class LogDemoController {

    private final LogDemoService logDemoService;
//    private final MyLogger myLogger; // 스프링 뜰 때 MyLogger 주입해야 하는데 request 스코프이므로 생성이 안 되어있음 -> Scope 'request' is not active for the current thread;
//    private final ObjectProvider<MyLogger> myLoggerProvider;
private final MyLogger myLogger; // proxyMode를 사용하여 MyLogger를 주입받습니다.

    @RequestMapping("log-demo")
    @ResponseBody // @ResponseBody 어노테이션은 반환값을 HTTP 응답 본문에 직접 작성하도록 지정합니다.
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();

        System.out.println("myLogger = " + myLogger.getClass()); // myLogger = class hello.core.common.MyLogger$$SpringCGLIB$$0 -> 진짜 MyLogger가 아님.
        myLogger.setRequestURL(requestURL); // MyLogger에 요청 URL을 설정합니다.

        myLogger.log("controller test"); // 로그 메시지를 남깁니다.
        logDemoService.logic("testId");
        return "OK"; // HTTP 응답으로 "OK"를 반환합니다.
    }
}
