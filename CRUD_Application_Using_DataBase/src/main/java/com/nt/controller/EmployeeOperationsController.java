package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgmtService empService;
	
	@GetMapping("/")
	public String showHomePage() {
		//Return LVN
		return "home";
	}
	
	@GetMapping("/report")
	public String showReport(Map<String,Object> map) {
		System.out.println("EmployeeOperationsController.showReport()");
		//use service
		List<Employee> list = empService.showAllEmployees();
		//keep the results in Model attributes
		map.put("listEmps", list);
		//return LVN
		return "show_report";
	}
	
	@GetMapping("/add_employee")
	public String showAddEmployeeFormPage(@ModelAttribute("emp")Employee emp) {
		//return LVN
		return "register_employee_form";
	}
	
	/*@PostMapping("/add_employee")
	public String processAddEmployeeFormSubmission(@ModelAttribute("emp")Employee emp,
																	Map<String,Object> map) {
		//use service
		String msg=empService.registerEmployee(emp);
		List<Employee> list = empService.showAllEmployees();
		//keep the result is model attribute
		map.put("resultMsg", msg);
		map.put("listEmps", list);	
		//return LVN
		return "show_report";
	}*/
	
	@PostMapping("/add_employee")
	public String processAddEmployeeFormSubmission(@ModelAttribute("emp")Employee emp,
																	RedirectAttributes attrs) {
		System.out.println("EmployeeOperationsController.processAddEmployeeFormSubmission()");
		//use service
		String msg=empService.registerEmployee(emp);
		//keep the result is model attribute
		attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
		return "redirect:report";
	}
	
	@GetMapping("/edit_employee")
	public String showEditEmployeeFormPage(@RequestParam("no")int no,
										   @ModelAttribute("emp")Employee emp){
		//use service
		Employee emp1=empService.fetchEmployeeByNo(no);
		//copy emp1 object data to emp
		BeanUtils.copyProperties(emp1, emp);
		//return LVN
		return "edit_employee_form";
     }
	
	@PostMapping("/edit_employee")
	public String processUpdateEmployeeFormSubmission(@ModelAttribute("emp")Employee emp,
													   Map<String,Object> map) {
		//use service
		String msg = empService.modifyEmployeeByNo(emp);
		List<Employee> list = empService.showAllEmployees();
		//keep the result in Model attributes
		map.put("resultMsg", msg);
		map.put("listEmps", list);
		//return LVN
		return "show_report";
	}
	
	@GetMapping("/delete_employee")
	public String fireEmployee(@RequestParam("no")int no, 
								Map<String, Object> map) {
		//use service
		String msg = empService.removeEmployeeByNo(no);
		List<Employee> list = empService.showAllEmployees();
		//keep the result in model attributes
		map.put("listEmps", list);
		//return LVN
		return "show_report";
	}
}
