package pso.shop.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class CommonController {

	@Value("${vcap.application.instance_id:unknown}")
	private String instanceId;
	
	@Autowired
	private HttpSession httpSession;
	
	@ModelAttribute
	public void setCommonAppAttributes(Model model) {
		model.addAttribute("instanceId", instanceId);
		model.addAttribute("userSessionId", httpSession.getId());
	}
}
