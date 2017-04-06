package com.ibm.aaspire.poc.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.aaspire.poc.entities.Member;
import com.ibm.aaspire.poc.services.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping("/members")
	public Iterable<Member> getMembers() {

		List<Member> list = new ArrayList<>();

		return memberService.fetchAllMembers();
		// return Lists.newArrayList(repo.findAll());

	}

	@GetMapping("/members/testgivenname")
	public Member findMemberBasedOnName() {

		String firstName = "Grigor";
		String lastName = "Dimitrov";

		return memberService.findByGivenNameAndLastName(firstName, lastName);
		// return Lists.newArrayList(repo.findAll());

	}

}
