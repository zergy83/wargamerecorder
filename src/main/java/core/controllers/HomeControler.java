package core.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

@RestController
public class HomeControler {

    /**Logger for this class*/
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeControler.class);

    @Autowired
    private ServletContext context;

    @PostConstruct
    public void init() {
        LOGGER.info("HomeController initiated: {}", context.getContextPath());
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    @ResponseBody
    public String testHome(){
        LOGGER.info(context.getContextPath());
        System.out.println(context.getContextPath());
        return "Welcome to Wargame Recorder";
    }
}
