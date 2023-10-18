package com.nt.validationes;




import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nt.entity.UserAccount;

//@Component
public class UserValidationes implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return clazz.isAssignableFrom(UserAccount.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserAccount account=(UserAccount)target;
		String name=account.getName();
		if(name==null)
			
			errors.rejectValue("name","user.name.required");
		else if(name.length()>10&&name.length()<3)
			errors.rejectValue("name","user.name.length");
		
		if(account.getEmail()==null)
			errors.rejectValue("email","user.email.required");
		Integer size=String.valueOf(account.getPhNo()).length();
		if(account.getPhNo()==null)
			errors.rejectValue("phNo","user.phNo.required");
		else if(size>10&&size<10)
			errors.rejectValue("phNo","user.phNo.length");
		if(account.getGender()==null)
			errors.rejectValue("gender", "user.gender.required");
		
		
	}

	

}
