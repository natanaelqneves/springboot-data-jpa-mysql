package course.exercisesb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    //@RequestMapping(method = RequestMethod.GET, path = "/vem")
    @GetMapping(path = {"/bora", "/vem", "/vemtambem"})
    public String ola() {
        return "Vem comigo Spring!";
    }

}
