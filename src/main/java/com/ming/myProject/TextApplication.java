package com.ming.myProject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

// javafx graphics
public class TextApplication extends Application {

    // ConfigurableApplicationContext: spring 애플리케이션의 실행 컨텍스트.
    // spring bean의 라이프사이클을 관리하고 애플리케이션의 구성을 로드하는 데 사용됨
    private ConfigurableApplicationContext applicationContext;

    // 애플리케이션 초기화 메서드
    // spring의 SpringApplicationBuilder를 사용해 MyProjectApplication을 실행함
    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(MyProjectApplication.class).run();
    }

    // javaFX 애플리케이션을 시작하는 메서드
    // Stage객체를 받아와서 StageReadyEvent를 발행
    // Stage: 우리가 보여주려는 화면을 의미하는 것 같다....
    @Override
    public void start(Stage stage) {
        applicationContext.publishEvent(new StageReadyEvent(stage));
    }

    //애플리케이션 컨텍스트를 닫고 javafx 애플리케이션 종료
    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    // javaFx의 ApplicationEvent를 확장하여 정의된 내부 클래스
    // Stage 객체를 포함하여 스테이지가 준비되었음을 나타냄
    public static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return ((Stage) getSource());
        }
    }
}
