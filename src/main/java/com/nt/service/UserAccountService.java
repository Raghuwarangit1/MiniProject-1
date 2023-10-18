package com.nt.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.UserAccount;
import com.nt.repository.IUserAccountLRepository;


@Service
public class UserAccountService implements IUserAccountService {
     @Autowired
	private IUserAccountLRepository repo;
	@Override
	public List<UserAccount> findAllUsers() {
		
		return repo.findAll();
	}

	@Override
	public UserAccount findUserById(int id) throws EntityNotFoundException {
		Optional<UserAccount> findById = repo.findById(id);
		if(findById.isPresent())
			return findById.get();
		throw new EntityNotFoundException("invalid id");
	}

	@Override
	public String upsert(UserAccount ua) {
		String reslt=ua.getId()==null?"your acount is created ":"your acount is updated on Id"+ua.getId();
		  repo.save(ua);
		return reslt;
	}

	

	@Override
	public String hordDeleteById(int id) throws EntityNotFoundException {
		
		boolean existsById = repo.existsById(id);
		if(existsById) {
			repo.deleteById(id);
			return "account is deleted with id no:"+id;
		}
		throw new EntityNotFoundException("invalid idno:"+id);
	}

	@Override
	public String udateStatus(int id,String status)throws EntityNotFoundException {
		boolean existsById = repo.existsById(id);
		if(existsById) {
	Integer count=	repo.udateStatus(id,status);
	if(count>0)
			return "status is updated on id"+id ;
		}
		throw new EntityNotFoundException("invalid id no:"+id);
	}

}
