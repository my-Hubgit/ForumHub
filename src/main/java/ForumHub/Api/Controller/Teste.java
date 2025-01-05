package ForumHub.Api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class Teste {

    @GetMapping
    public String OlaMundo (){
        System.out.println("Ola mundo");
        return "Hello Word";

    }
}
