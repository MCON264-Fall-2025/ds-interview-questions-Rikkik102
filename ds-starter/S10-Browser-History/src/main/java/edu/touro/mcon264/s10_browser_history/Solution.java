package edu.touro.mcon264.s10_browser_history;
import java.util.Stack;

public class Solution {


    private Stack<String> previous = new Stack<>();
    private Stack<String> following = new Stack<>();
    private String currentURL;

    public Solution(String currentURL) {
        this.currentURL = currentURL;
    }

    public String getCurrentURL() {
        return currentURL;
    }

    public void setCurrentURL(String url) {
        currentURL = url;
    }

    public Stack<String> getPrevious() {
        return previous;
    }

    public Stack<String> getFollowing() {
        return following;
    }


    public void visit(String url) {
        previous.push(currentURL);
        following.clear(); // O(n) complexity
        currentURL = url;
    }

    public String back(int k) { // O(k) complexity
        for (int i = 0; i < k; i++) {
            if (previous.isEmpty()) {
                return null;
            }
            following.push(currentURL);
            currentURL = previous.pop();
        }
        return currentURL;
    }

    public String forward(int k) { // O(k) complexity
        for (int i = 0; i < k; i++) {
            if (following.isEmpty()) {
                return null;
            }
            previous.push(currentURL);
            currentURL = following.pop();
        }
        return currentURL;
    }
}