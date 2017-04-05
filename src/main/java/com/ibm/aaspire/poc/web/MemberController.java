package com.ibm.aaspire.poc.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.aaspire.poc.entities.Member;
import com.ibm.aaspire.poc.repository.MemberRepository;

@RestController
public class MemberController {

	@Autowired
	private MemberRepository repo;

	@GetMapping("/members")
	public Iterable<Member> getMembers() {
	

		List<Member> list = new ArrayList<>();

		return repo.findAll();
		//return Lists.newArrayList(repo.findAll());

	}

}
