package pso.shop.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class CommonController {

	@Value("${vcap.application.host:unknown}")
	private String vcaphost;

	@Value("${vcap.application.port:unknown}")
	private String vcapport;
	
	@Autowired
	private HttpSession httpSession;
	
	@ModelAttribute
	public void setCommonAppAttributes(Model model) {
		model.addAttribute("vcaphost", vcaphost);
		model.addAttribute("vcapport", vcapport);
		model.addAttribute("userSessionId", httpSession.getId());
	}
}
