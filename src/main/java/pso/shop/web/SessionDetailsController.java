package pso.shop.web;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/session")
public class SessionDetailsController {

	@RequestMapping("/attributes")
	public String showSessionDetails(Model model, HttpSession session) {
		model.addAttribute("sessionAttributeNames", Collections.list(session.getAttributeNames()));
		return "session/attributeNames";
	}
}
