package pl.playbit.springhibernate.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.playbit.springhibernate.model.Person;
import pl.playbit.springhibernate.service.PersonService;

import java.io.IOException;
import java.util.List;

@Controller
public class ViewController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewController.class);

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/add/{firstname},{lastname}", method = RequestMethod.POST)
    public ModelAndView add(@PathVariable String firstname, @PathVariable String lastname) {
        ModelAndView mav = new ModelAndView("add");

        mav.addObject("firstname", firstname);
        mav.addObject("lastname", lastname);

        Person person = new Person();
        person.setFirstname(firstname);
        person.setLastname(lastname);
        personService.addPerson(person);

        return mav;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listAll(@RequestParam(value = "lastname", required = false) String lastname) {
        ModelAndView mav = new ModelAndView("list");
        List<Person> persons;
        if (lastname == null) {
            persons = personService.getAllPersons();
        } else {
            persons = personService.getAllPersonsWithLastname(lastname);
        }
        mav.addObject("persons", persons);
        return mav;
    }


    @RequestMapping(value = "/addHeader", method = RequestMethod.POST)
    public ModelAndView addHeader(@RequestHeader(value = "lastname", required = true) String firstname, @RequestHeader(value = "firstname", required = true) String lastname) {
        ModelAndView mav = new ModelAndView("add");
        mav.addObject("firstname", firstname);
        mav.addObject("lastname", lastname);

        Person person = new Person();
        person.setFirstname(firstname);
        person.setLastname(lastname);
        personService.addPerson(person);

        return mav;
    }

    @RequestMapping(value = "/addBody", method = RequestMethod.POST, headers = "Accept=application/json")
    public ModelAndView addBody(@RequestBody String json) {
        ModelAndView mav = new ModelAndView("add");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Person person = mapper.readValue(json, Person.class);
            personService.addPerson(person);
            mav.addObject("firstname", person.getFirstname());
            mav.addObject("lastname", person.getLastname());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return mav;
    }

}
