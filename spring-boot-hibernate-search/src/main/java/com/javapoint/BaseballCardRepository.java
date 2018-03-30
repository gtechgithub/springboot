package com.javapoint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface BaseballCardRepository extends JpaRepository<BaseballCard, Integer> 	 {
	 
}
