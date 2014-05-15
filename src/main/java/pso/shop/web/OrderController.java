package pso.shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/orders")
public class OrderController {

	@RequestMapping(value="/partialsOrder", method=RequestMethod.GET)
	public String partialsOrder() {
		return "orders/partialsOrder::content";
	}	

}
