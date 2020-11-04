package pl.piomin.services.transaction.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@CrossOrigin
    @GetMapping("/schemename")
    public String getSchemeName() {
    	System.out.println("getSchemeName ");
    	return "TestSchemeName";
    }

    @CrossOrigin
    @GetMapping("/schemeamount")
    public String getSchemeAmount() {
    	System.out.println("schemeamount");
    	return "10000";
    }
    
    
}
