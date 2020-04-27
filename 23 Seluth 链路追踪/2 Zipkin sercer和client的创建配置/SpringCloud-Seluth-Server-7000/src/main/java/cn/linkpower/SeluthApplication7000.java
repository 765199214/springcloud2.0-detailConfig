package cn.linkpower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer   //表示为Zipkin Server 端
public class SeluthApplication7000 {
	public static void main(String[] args) {
		SpringApplication.run(SeluthApplication7000.class, args);
	}
}	
