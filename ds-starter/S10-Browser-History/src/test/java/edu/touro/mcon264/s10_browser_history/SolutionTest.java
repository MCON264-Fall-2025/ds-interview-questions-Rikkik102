package edu.touro.mcon264.s10_browser_history;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

        @Test
        void testVisit() {
            Solution chrome = new Solution("google.com");
            chrome.getFollowing().push("Clearme.com");

            chrome.visit("Hello.com");

            assertEquals("Hello.com", chrome.getCurrentURL());
            assertEquals("google.com", chrome.getPrevious().peek());
            assert(chrome.getFollowing().isEmpty());
        }

        @Test
        void testBack() {
            Solution edge = new Solution("amazon.com");
            edge.getPrevious().push("google.com");
            edge.getPrevious().push("walmart.com");
            edge.getPrevious().push("firefox.com");

            edge.setCurrentURL(edge.back(2));

            assertEquals("walmart.com", edge.getCurrentURL());
            assertEquals("google.com", edge.getPrevious().peek());
            assertEquals("firefox.com", edge.getFollowing().peek());
        }

        @Test
        void testForward() {
            Solution edge = new Solution("amazon.com");
            edge.getFollowing().push("google.com");
            edge.getFollowing().push("walmart.com");
            edge.getFollowing().push("firefox.com");

            edge.forward(2);

            assertEquals("walmart.com", edge.getCurrentURL());
            assertEquals("google.com", edge.getFollowing().peek());
            assertEquals("firefox.com", edge.getPrevious().peek());
        }
    }