package com.ibm.aaspire.poc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;
import com.ibm.aaspire.poc.entities.Address;
import com.ibm.aaspire.poc.entities.Member;
import com.ibm.aaspire.poc.repository.MemberRepository;
import com.ibm.aaspire.poc.services.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberRepository repo;
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/members")
	public Iterable<Member> getMembers(@RequestParam(value = "search", required = false) String search) {
		return memberService.search(search);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/members/{id}")
	public @ResponseBody ResponseEntity  getAMemberInfo(@PathVariable(value = "id", required=true) String memberId) {
		
		Member theMember =  memberService.getAMemberInfo(memberId);
		
		if (theMember == null){
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		else{
			return new ResponseEntity(theMember, HttpStatus.OK);
		}
	}
	
	
	
	@RequestMapping(value = "/members/{id}", method = RequestMethod.PUT)
	public @ResponseBody Member updateMember(@RequestBody Member member, @PathVariable(value = "id", required=true) String id) {
		Preconditions.checkArgument(member.getId() == null || member.getId() == id, "Id should either be missing or match the URL.");
		Preconditions.checkNotNull(repo.findOne(id), "Use POST if an entity with the Id exists.");
		
		member.setId(id);
		return repo.save(member);
	}

	@RequestMapping(value = "/members", method = RequestMethod.POST)
	public @ResponseBody Member addMember(@RequestBody Member member) {
		return repo.save(member);
	}
	
	@RequestMapping(value = "/members/{id}/address", method = RequestMethod.PUT)
	public @ResponseBody Member updateAddress(@RequestBody Address address, @PathVariable(value = "id", required=true) String id) {
		Member member = repo.findOne(id);
		Preconditions.checkNotNull(repo.findOne(id), "Unknown member.");
		
		member.setAddress(address);
		return repo.save(member);
	}
}
