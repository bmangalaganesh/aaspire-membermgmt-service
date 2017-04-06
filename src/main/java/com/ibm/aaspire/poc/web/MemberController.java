package com.ibm.aaspire.poc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.aaspire.poc.entities.Member;
import com.ibm.aaspire.poc.services.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService memberService;
	

	@GetMapping("/members")
	public Iterable<Member> getMembers(@RequestParam(value = "search", required = false) String search) {
		return memberService.search(search);
	}
}
