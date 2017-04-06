package com.ibm.aaspire.poc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.aaspire.poc.entities.Member;
import com.ibm.aaspire.poc.repository.MemberRepository;

@Component
public class MemberService {

	@Autowired
	private MemberRepository repo;

	/*
	 * Member aMember = new Member(); aMember.setter
	 * Example<Member>example=Example.of(aMember); List<Member> results =
	 * repo.findAll(example);
	 */

	public Iterable<Member> fetchAllMembers() {
		return repo.findAll();
	}

	// Not an exact match - as long as it contains this is ok
	public Iterable<Member> findByGivenName(String givenName) {
		return repo.findByGivenNameIgnoreCaseContaining(givenName);
		}
	
	public Member findByGivenNameAndLastName(String givenName, String lastName) {
		return repo.findByGivenNameAndSurname(givenName, lastName);
	}

}
