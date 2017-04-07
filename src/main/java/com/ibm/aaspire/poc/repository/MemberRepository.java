package com.ibm.aaspire.poc.repository;

import org.springframework.data.repository.CrudRepository;

import com.ibm.aaspire.poc.entities.Member;

public interface MemberRepository extends CrudRepository<Member, String> {
}
