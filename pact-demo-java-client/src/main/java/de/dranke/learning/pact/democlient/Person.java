package de.dranke.learning.pact.democlient;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {

  private String vorname;
  private String nachname;

  @JsonGetter("firstname")
  public String getVorname() {
    return vorname;
  }

  @JsonGetter("lastname")
  public String getNachname() {
    return nachname;
  }

  @Override
  public String toString() {
    return "Person{" +
           "vorname='" + vorname + '\'' +
           ", nachname='" + nachname + '\'' +
           '}';
  }
}
