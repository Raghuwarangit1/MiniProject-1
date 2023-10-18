package com.nt.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.UserAccount;

public interface IUserAccountLRepository extends JpaRepository<UserAccount, Integer> {
	
	@Modifying
	@Transactional
	@Query("UPDATE UserAccount SET status=:stat WHERE id=:uid")
	public Integer udateStatus(int uid,String stat);

}
