package com.example.restservice;

import com.example.restservice.enums.Sex;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testEnum() {
		String v = "2";

		Sex sex = Sex.valueOf(v);
		System.out.println(sex);
	}
}
