package com.woori.childasset;

import org.springframework.boot.SpringApplication;

public class TestChildAssetServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ChildAssetServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
