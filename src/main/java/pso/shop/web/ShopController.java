package pso.shop.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pso.shop.service.CategoryRepository;
/**
 * Main controller of the Shop. 
 * 
 * @author Biju Kunjummen
 */

@Controller
@RequestMapping("/shop")
public class ShopController {
	private CategoryRepository categoryRepository;

	@Value("${server.port:unknown}")
	private String serverPort;
	
	@Autowired
	public ShopController(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Autowired
	private HttpSession httpSession;
	

	@ModelAttribute
	public void commonModelAttributes(Model model) {
		model.addAttribute("categories", this.categoryRepository.findAll());
		model.addAttribute("userSessionId", httpSession.getId());
		model.addAttribute("serverPort", serverPort);
	}

	@RequestMapping("/home")
	public String home() {
		return "products/home";
	}	

		
	@RequestMapping(value="/partialsHome", method=RequestMethod.GET)
	public String partialsHome() {
		return "products/partialsHome::content";
	}
	
	

}
