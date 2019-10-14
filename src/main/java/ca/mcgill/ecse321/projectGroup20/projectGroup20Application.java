package ca.mcgill.ecse321.projectGroup20;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class projectGroup20Application {

  public static void main(String[] args) {
    SpringApplication.run(projectGroup20Application.class, args);
  }

  @RequestMapping("/")
  public String greeting(){
    return "Hello world, this is group 20's backend! "
    		+ "There is nothing for the moment but we are testing the CRUD operations "
    		+ "to make sure that everything is up to date!";
  }

}