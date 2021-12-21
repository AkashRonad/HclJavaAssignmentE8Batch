package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Student;
import com.app.model.StudentManger;

@Controller
public class MangeController {

	@Autowired
	Student student;
	
	@Autowired
	StudentManger manger;

	@RequestMapping("/")
	public String mainPage() {
		return "index";
	}

	@RequestMapping("/showForm")
	public String showForm() {
		return "showForm";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "processForm";
	}

	/*
	 * @RequestMapping("/processFormVersionTwo") public String
	 * letsShoutDude(HttpServletRequest httpServletRequest, Model model) {
	 * 
	 * // read the request parameter from the html form String theName =
	 * httpServletRequest.getParameter("name"); String sapId =
	 * httpServletRequest.getParameter("sapid"); // convert the data to all caps
	 * theName.toUpperCase();
	 * 
	 * // create the message
	 * 
	 * String result = "Yo!" + theName + " " + "(" + sapId + ")";
	 * 
	 * // add the message to model model.addAttribute("message", result);
	 * 
	 * return "processFormOne";
	 * 
	 * }
	 */

	// annoation used read it
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(@RequestParam("username") String theName, @RequestParam("sapid") String sapId,
			@RequestParam("password") String password, Model model) {

		// read the request parameter from the html form

		// convert the data to all caps
		String name = theName.toUpperCase();
		student.setUserName(name);
		student.setId(Integer.parseInt(sapId));
		student.setPassword(password);
		// create the message

		String result = "Yo!" + theName + " " + "(" + sapId + ")";

		// add the message to model
		model.addAttribute("message", result);

		return "processFormOne";

	}

	@RequestMapping("/login")
	public String login() {

		return "login";

	}

	@RequestMapping("/processSucess")
	public String sucess(@RequestParam("username") String theName, @RequestParam("password") String password,
			Model model) {

		if (student.getUserName().equalsIgnoreCase(theName) && student.getPassword().equalsIgnoreCase(password)) {
			List<Student> students=manger.getAllStudents();
			model.addAttribute("studentlist", students);
			return "sucess";
		} else {
			return "failure";
		}

	}

}
