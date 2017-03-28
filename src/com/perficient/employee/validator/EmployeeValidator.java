package com.perficient.employee.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.perficient.employee.registration.entity.Employee;


public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Employee.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		/*Employee emp = (Employee) obj;
		if(emp.getName().length() <=0){
			errors.rejectValue("name", "negativeValue", new Object[]{"'name'"}, "name cant be empty");
		}	*/	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "sex.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "dob.required");
		
	}

	
}
