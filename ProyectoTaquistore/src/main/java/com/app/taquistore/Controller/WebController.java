package com.app.taquistore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
        
    @GetMapping({"/index", "/"})
    public String paginainicio(){
        return "index.html";
    }
    
}
