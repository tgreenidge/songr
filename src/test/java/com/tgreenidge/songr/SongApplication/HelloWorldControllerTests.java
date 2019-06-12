package com.tgreenidge.songr.SongApplication;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldControllerTests {

    @Test
    public void testHelloWorldRouteResponse() {
        HelloWorldController helloWorld = new HelloWorldController();
        String response = helloWorld.helloWorld();
        assertEquals("Reponse should be hello", "hello", response);
    }

    @Test
    public void testCapitalizeRoute() {
        HelloWorldController helloWorld = new HelloWorldController();
        String response = helloWorld.capitalizeWords("hello");
        assertEquals("Reponse should be HELLO", "HELLO", response);
    }

    @Test
    public void testReverseRoute() {
        HelloWorldController helloWorld = new HelloWorldController();
        String response = helloWorld.reverseWords("hello world");
        assertEquals("Reponse should be world hello", "world hello", response);
    }
}
