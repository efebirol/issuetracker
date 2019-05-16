package data.webservice;


import data.entity.Developer;
import data.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeveloperController {
    @Autowired
    private DeveloperRepository repository;

    @RequestMapping(value="/developers", method= RequestMethod.GET)
    List<Developer> findAll(@RequestParam(required=false) String name){
       List<Developer> developers = new ArrayList<>();
        if(null==name){
            Iterable<Developer> results = this.repository.findAll();
            results.forEach(developer-> {developers.add(developer);});
        }else{
            Developer developer = this.repository.findByNumber(name);
            if(null!=developer) {
                developers.add(developer);
            }
        }
        return developers;
    }
}