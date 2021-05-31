package com.eureka.member.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class EurekaMemberApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaMemberApplication.class, args);
	}
}

@RestController
class MemberRestController{
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = "application/json")
	public List<Member> getMembers(){
		List<Member> members = Arrays.asList(
			new Member(1, "Nguyen Van A"),
				new Member(2, "Nguyen Van B"),
				new Member(3, "Nguyen Van C")
		);

		return members;
	}
}

class Member{
	private Integer id;
	private String name;

	public Member(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
