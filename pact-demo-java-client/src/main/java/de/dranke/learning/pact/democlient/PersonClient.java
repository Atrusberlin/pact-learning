package de.dranke.learning.pact.democlient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import java.util.Collection;

public class PersonClient {

  private final String baseUrl;

  public static void main(String[] args) {
    final PersonClient personClient = new PersonClient(args[0]);
    System.out.println(personClient.getPersons());
  }

  public PersonClient(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public Collection<Person> getPersons() {
    return ClientBuilder.newClient()
        .register(JacksonJsonProvider.class)
        .target(baseUrl + "/persons").request().get().readEntity(new GenericType<Collection<Person>>() {
        });
  }
}
