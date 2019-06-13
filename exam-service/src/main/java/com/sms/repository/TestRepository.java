package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sms.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
