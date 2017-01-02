package de.dranke.learning.pact.demoserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("persons")
public class PersonController {

  private static final Collection<Person> persons = new ArrayList();

  static {
    persons.add(Person.create("John", "Doe", LocalDate.parse("2000-01-01")));
    persons.add(Person.create("Jane", "Doe", LocalDate.parse("2000-07-31")));
  }

  @RequestMapping(value = "", produces = "Application/json")
  public Collection<Person> getAll() {
    return persons;
  }

  public static class Person {

    public String lastname;
    public String firstname;
    public LocalDate birthday;

    static Person create(String firstname, String lastname, LocalDate birthday) {
      final Person person = new Person();
      person.firstname = firstname;
      person.lastname = lastname;
      person.birthday = birthday;
      return person;
    }
  }
}

