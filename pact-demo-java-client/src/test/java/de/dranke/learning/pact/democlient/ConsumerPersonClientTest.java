package de.dranke.learning.pact.democlient;

import au.com.dius.pact.consumer.ConsumerPactTest;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactFragment;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

public class ConsumerPersonClientTest extends ConsumerPactTest {

  @Override
  protected PactFragment createFragment(PactDslWithProvider builder) {
    return builder.uponReceiving("Request")
        .method("GET")
        .path("/persons")
        .willRespondWith()
        .status(200)
        .body("[{\"firstname\":\"Max\", \"lastname\":\"Mustermann\"}]", ContentType.APPLICATION_JSON)
        .toFragment();
  }

  @Override
  protected String providerName() {
    return "Person Resource";
  }

  @Override
  protected String consumerName() {
    return "Person Client";
  }

  @Override
  protected void runTest(String url) throws IOException {
    final PersonClient client = new PersonClient(url);
    final Collection<Person> persons = client.getPersons();
    assertEquals(persons.size(), 1);
    final Person first = persons.stream().findFirst().get();
    assertEquals(first.getVorname(), "Max");
  }
}