package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // request 스코프로 지정. HTTP 요청 당 하나씩 생성, HTTP 요청이 끝나는 시점에 소멸.
                                                                    // proxyMode = ScopedProxyMode.TARGET_CLASS를 사용하여 프록시 객체를 생성합니다.
public class MyLogger {

    private String uuid;
    @Setter
    private String requestURL;

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean created: " + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close: " + this);
        // 로그를 남기거나 리소스를 해제하는 작업을 수행할 수 있습니다.
        // 예: 로그 파일에 남기기, 데이터베이스 연결 해제 등
    }
}
