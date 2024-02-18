package com.ming.myProject.javaFx;

import com.ming.myProject.TextApplication.StageReadyEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

// javaFx 스테이지 설정하는 클래스
// ApplicationListener: StageReadyEvent를 수신함
@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {
    @Value("classpath:/chart.fxml")
    private Resource chartResource;
    @Value("classpath:/text.fxml")
    private Resource textResource;
    private String applicationTitle;
    private ApplicationContext applicationContext;

    public StageInitializer(@Value("${spring.application.ui.title}") String applicationTitle, ApplicationContext applicationContext) {
        this.applicationTitle = applicationTitle;
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        //getUrl은 exception을 일으키므로 try/catch로 묶어줌
        try {
            // 사용자 인터페이스에 어떤 요소가 있는지 정의
            FXMLLoader fxmlLoader = new FXMLLoader(textResource.getURL());
            Parent parent = fxmlLoader.load();
            fxmlLoader.setControllerFactory(aClass -> applicationContext.getBean(aClass));

            // StageReadyEvent에서 javaFx스테이지를 가져옴
            Stage stage = event.getStage();
            // 스테이지에 대한 설정
            stage.setScene(new Scene(parent, 600, 300));
            stage.setTitle(applicationTitle);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
