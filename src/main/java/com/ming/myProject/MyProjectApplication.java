package com.ming.myProject;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyProjectApplication {

	// Springboot대신 javaFx를 실행(TextApplication)
	// 두개의 별도 애플리케이션 클래스가 필요한 이유: javafx가 java모듈을 사용하는것이므로(?)
	public static void main(String[] args) {
		Application.launch(TextApplication.class, args);
	}

}
