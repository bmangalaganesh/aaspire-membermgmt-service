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

	public Iterable<Member> fetchAllMembers() {
		return repo.findAll();
	}

	public Iterable<Member> search(String queryTxt) {
		String cleanQueryTxt = queryTxt == null ? "" : queryTxt.trim().toLowerCase();

		if (cleanQueryTxt.isEmpty()) {
			return fetchAllMembers();
		} else {
			// The FROM part of the query - a left join of Member and address
			String fromExpression = "select m from Member m left join m.address a where ";
			
			// Construct the query/where clause
			List<String> terms = Arrays.asList(cleanQueryTxt.split("\\s+"));
			List<String> subqueries = IntStream.range(0, terms.size()).mapToObj(i -> termSubquery("term" + i)).collect(Collectors.toList());			
			String queryExpression = String.join(" AND ", subqueries);
			
			// Parametarise and run the query
			TypedQuery<Member> query = em.createQuery(fromExpression + queryExpression, Member.class);
			IntStream.range(0, terms.size()).forEach(i -> query.setParameter("term" + i, "%" + terms.get(i) + "%"));

			return query.getResultList();
		}
	}

	private String termSubquery(String termName) {
		return ("(LOWER(m.id) LIKE :match OR "+
				"LOWER(m.givenName) LIKE :match OR "+
				"LOWER(m.surname) LIKE :match OR "+
				"LOWER(m.email) LIKE :match OR "+
				"LOWER(m.phoneNumber) LIKE :match OR "+
				"LOWER(a.line1) LIKE :match OR "+ 
				"LOWER(a.line2) LIKE :match OR "+ 
				"LOWER(a.postCode) LIKE :match OR "+ 
				"LOWER(a.suburb) LIKE :match OR "+
				"LOWER(a.state) LIKE :match)").replaceAll("match", termName);
	}
}
