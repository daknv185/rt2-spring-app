package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jp.co.sss.crud.bean.LoginResultBean;
import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.LoginForm;
import jp.co.sss.crud.service.LoginService;
import jp.co.sss.crud.service.SearchForEmployeesByEmpIdService;

@Controller
public class IndexController {

	@Autowired
	LoginService loginService;
	SearchForEmployeesByEmpIdService searchForEmployeesByEmpIdService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(@ModelAttribute LoginForm loginForm) {
		return "index";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			return "index";
		}
		 
		LoginResultBean loginResultBean = loginService.execute(loginForm);
		Employee emp = new Employee();
		
		if(loginResultBean == null) {
			model.addAttribute("errMessage", loginResultBean.getErrorMsg());
			return "index";
		}
		else if (loginResultBean.isLogin()) {
			session.setAttribute("loginUser", loginResultBean.getLoginUser());
			//session.setAttribute("Aut", emp.getAuthority()); でAutにAuthority情報を移す
			return "redirect:/list";
		} else {
			model.addAttribute("errMessage", loginResultBean.getErrorMsg());
			return "index";
		}

	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.invalidate();
		return "redirect:/";
	}

}
