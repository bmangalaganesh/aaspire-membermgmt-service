package com.ibm.aaspire.poc.services;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.google.common.collect.Lists.*;
import static java.util.stream.Collectors.*;
import com.ibm.aaspire.poc.entities.Address;
import com.ibm.aaspire.poc.entities.Member;
import static com.ibm.aaspire.poc.entities.MemberStatus.*;
import static com.ibm.aaspire.poc.entities.State.*;
import com.ibm.aaspire.poc.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {

	@Autowired
	private MemberService service;

	@Autowired
	private MemberRepository repo;

	@Before
	public void populateDb() {
		repo.deleteAll();
		repo.save(new Member("uuid1", 
				"Mr", 
				null, 
				"Johnston", 
				null, 
				ACTIVE, 
				null, 
				"jj@gmail.com",
				new Address("1", "Carlton North", null, "Carlton", VIC, null, null), 
				"18800-1"));

		repo.save(new Member("uuid2", 
				"Mr", 
				"Nikolay", 
				"Grozev", 
				null, 
				ACTIVE, 
				null, 
				"nik-g@coolio.com",
				null, 
				"18800-2"));

		repo.save(new Member("uuid3", 
				null, 
				"Peter", 
				"Pan", 
				null, 
				ACTIVE, 
				null, 
				"pp@gmail.com",
				new Address("3", "765 Brunswick", null, "Carlton", VIC, null, null), 
				"18800-3"));	
	}
	
	@Test
	public void testSearchByFirstName() {
		List<String> loadedIds = search("nikol");
		assertEquals(1, loadedIds.size());
		assertEquals("uuid2", loadedIds.get(0));
		
		loadedIds = search("eter");
		assertEquals(1, loadedIds.size());
		assertEquals("uuid3", loadedIds.get(0));
	}
	
	@Test
	public void testSearchBySurname() {
		List<String> loadedIds = search("PaN");
		assertEquals(1, loadedIds.size());
		assertEquals("uuid3", loadedIds.get(0));
		
		loadedIds = search("GROZE");
		assertEquals(1, loadedIds.size());
		assertEquals("uuid2", loadedIds.get(0));
	}
	
	@Test
	public void testSearchByAddress() {
		List<String> loadedIds = search("   Carlto   vic    ");
		assertEquals(2, loadedIds.size());
		assertTrue(loadedIds.contains("uuid1"));
		assertTrue(loadedIds.contains("uuid3"));
	}
	
	@Test
	public void testSearchByEmail() {
		List<String> loadedIds = search("@gmail");
		assertEquals(2, loadedIds.size());
		assertTrue(loadedIds.contains("uuid1"));
		assertTrue(loadedIds.contains("uuid3"));
		
		loadedIds = search("   g@coolio.com ");
		assertEquals(1, loadedIds.size());
		assertTrue(loadedIds.contains("uuid2"));
	}
	
	@Test
	public void testSearchByMultipleCriteria() {
		List<String> loadedIds = search("   Carlto   vic   18800-1    ");
		assertEquals(1, loadedIds.size());
		assertTrue(loadedIds.contains("uuid1"));
		
		loadedIds = search("   uuid   @gmail   18800- ");
		assertEquals(2, loadedIds.size());
		assertTrue(loadedIds.contains("uuid1"));
		assertTrue(loadedIds.contains("uuid3"));
	}
	
	@Test
	public void testSearchNoMatch() {
		List<String> loadedIds = search("never_never_found");
		assertEquals(0, loadedIds.size());
	}
	
	@Test
	public void testSearchNoCriteria() {
		assertEquals(3, search("").size());
		assertEquals(3, search(" \t ").size());
		assertEquals(3, search(null).size());
	}
	
	private List<String> search(String search) {
		List<Member> loaded = newArrayList(service.search(search));
		return loaded.stream().map(Member::getId).collect(toList());
	}
}
