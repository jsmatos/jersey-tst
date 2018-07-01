package com.jsmatos.jersey.tst;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String someId = System.currentTimeMillis()+"";
        for (int i = 0; i < 1; i++) {
            String responseMsg = target.path("myresource").path("no_validation_needed").path(someId).request().get(String.class);
//            assertThat(responseMsg, JUnitMatchers.containsString(someId));
        }

        for (int i = 0; i < 1; i++) {
            String responseMsg = target.path("myresource").path("it").path(someId).request().get(String.class);
            assertThat(responseMsg, JUnitMatchers.containsString(someId));
        }

    }
}
