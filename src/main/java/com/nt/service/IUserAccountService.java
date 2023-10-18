package com.nt.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.nt.entity.UserAccount;

public interface IUserAccountService {
public List<UserAccount> findAllUsers();
public UserAccount findUserById(int id) throws EntityNotFoundException;
public String upsert(UserAccount ua);
public String udateStatus(int id,String status)throws EntityNotFoundException;
public String hordDeleteById(int id)throws EntityNotFoundException;
}
