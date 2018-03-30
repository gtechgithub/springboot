package com.javapoint;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WelcomeController {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@Autowired
	//private ApplicationProperties app;
	private ApplicationPropertiesPrefix app;
	
	@Autowired
	private GlobalProperties global;
	

		@RequestMapping(value= "/", method = RequestMethod.GET)
	    public ModelAndView welcome() {

		   ModelAndView modelDisplay =  new ModelAndView();
	        String appProperties = app.toString();
	        logger.debug("Welcome App{}", app);
	        
	        appProperties = appProperties + " " + global.toString();
	        logger.debug("Welcome Global{}", global);

	        
	        modelDisplay.addObject("message", appProperties);
	        modelDisplay.setViewName("welcome");

	        return modelDisplay;
	    }
}
