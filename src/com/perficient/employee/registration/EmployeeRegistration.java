package com.perficient.employee.registration;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.perficient.employee.registration.entity.Employee;
import com.perficient.employee.validator.EmployeeValidator;

@Controller
@RequestMapping("/employeereg")
public class EmployeeRegistration {
	
	private Map<Integer, Employee> emps = null;
	@Autowired
	@Qualifier("employeeValidator")
	private Validator validator;
/*
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}*/
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(new EmployeeValidator());
	}
	public EmployeeRegistration() {
		emps = new HashMap<Integer, Employee>();
	}
	
	@ModelAttribute("employee")
	public Employee createEmployeeModel() {
		// ModelAttribute value should be same as used in the empSave.jsp
		return new Employee();
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String displayRegister(ModelMap model) {
		model.addAttribute("employee", new Employee());
		System.out.println("Coming to index()");
		return "register";
	}

	/*working code
	 * @RequestMapping (value = "/add", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody Employee addEmployee(@RequestBody String data, @Valid Employee employee, Errors errors) throws IOException {
		System.out.println("Inside the add method");
		System.out.println("Emp data: " + data.toString());
		
		ObjectMapper mapper = new ObjectMapper();
		String[] dataArr = data.split("&");
		JSONArray array = new JSONArray(Arrays.asList(dataArr));
		System.out.println(array.toString());
//		mapper.readValue(array.toString(), Employee.class);
		return employee;
	}*/
	
	@RequestMapping (value = "/add", method = RequestMethod.POST)
	 @Produces("application/json") 
     
	public  String addEmployee(@Validated @RequestBody Employee employee, Errors errors,Model model) throws IOException {
		System.out.println("Inside the add method");
		//System.out.println("Emp data: " + data.toString());
		model.addAttribute("employee", employee);
		System.out.println(employee.toString());
		if(errors.hasErrors())
		{
			System.out.println(errors.toString());
			model.addAttribute("employee", employee);
	//System.out.println(ValidationErrorBuilder.fromBindingErrors(errors));
			return "register";
			
		}
		else{
		//ObjectMapper mapper = new ObjectMapper();
		//String[] dataArr = data.split("&");
		//JSONArray array = new JSONArray(Arrays.asList(dataArr));
		//System.out.println(array.toString());
//		mapper.readValue(array.toString(), Employee.class);
		
		return "registerSuccess";
		}
	}
	
}
