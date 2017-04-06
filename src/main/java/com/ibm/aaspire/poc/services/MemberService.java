package com.ibm.aaspire.poc.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.aaspire.poc.entities.Member;
import com.ibm.aaspire.poc.repository.MemberRepository;

@Component
public class MemberService {

	@Autowired
	private MemberRepository repo;
	
	@PersistenceContext
  	private EntityManager em;

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
	

	public Iterable<Member> search(String queryTxt) {
		String cleanQueryTxt = queryTxt == null? "" : queryTxt.trim().toLowerCase();
		
		if(cleanQueryTxt.isEmpty()) {
			return fetchAllMembers();
		} else {
			List<String> terms = Arrays.asList(cleanQueryTxt.split("\\s+"));
			List<String> subqueries = IntStream.range(0, terms.size()).mapToObj(i -> termSubquery(terms.get(i), i)).collect(Collectors.toList());
			
			String queryExpression = String.join(" AND ", subqueries);
			TypedQuery<Member> query = em.createQuery("select m from Member m where " + queryExpression, Member.class);
			IntStream.range(0, terms.size()).forEach(i -> query.setParameter("term" + i, "%"+ terms.get(i) + "%"));
			
			return query.getResultList();	
		}
	}
	
	private String termSubquery(String term, int i) {
		return String.format("LOWER(CONCAT(m.id, "
				+ "m.givenName, "
				+ "m.surname, "
				+ "m.email, "
				+ "m.phoneNumber, "
				+ "m.address.line1, "
				+ "m.address.line2, "
				+ "m.address.postCode, "
				+ "m.address.suburb, "
				+ "m.address.state)) LIKE :%s", "term" + i);
	}
}
