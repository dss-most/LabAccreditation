package th.go.dss.labaccreditation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicWebController {

	@RequestMapping("/web/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/web/faq")
	public String faq() {
		return "faq";
	}
	
}
