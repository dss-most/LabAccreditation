package th.go.dss.labaccreditation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PublicWebController {
	
	public static Logger logger = LoggerFactory.getLogger(PublicWebController.class);
	
	@RequestMapping("/web/")
	public String home() {
		logger.error("home is called");
		
		return "home";
	}
	
	@RequestMapping("/web/faq")
	public String faq() {
		return "faq";
	}
	
	@RequestMapping("/web/{pageName}")
	public String genericPage(@PathVariable String pageName) {
		
		logger.debug("genericPage with pageName: " + pageName);
		
		return pageName;
	}
	
}
