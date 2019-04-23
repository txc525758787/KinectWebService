package com.txc.kinect.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.txc.kinect.server.mapper")
public class KinectServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KinectServerApplication.class, args);
	}

}
