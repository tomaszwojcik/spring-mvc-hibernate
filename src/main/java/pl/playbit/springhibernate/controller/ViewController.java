package pl.playbit.springhibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.playbit.springhibernate.model.Person;
import pl.playbit.springhibernate.service.PersonService;

import java.util.List;

@Controller
public class ViewController {

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

}
