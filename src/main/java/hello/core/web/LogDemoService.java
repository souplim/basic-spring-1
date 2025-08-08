package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

//    private final MyLogger myLogger;
//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger; // proxyMode를 사용하여 MyLogger를 주입받습니다.
    public void logic(String id) {
//        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.log("service id = " + id); // MyLogger를 사용하여 로그 메시지를 남깁니다.
    }
}
