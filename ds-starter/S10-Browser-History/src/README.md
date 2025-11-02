#  Browser History

##  Problem Statement
Design a Browser History class that implements these methids

- visit()  The browser visits a new URL
- back(k) The browser visits the k number of previous pages
- forward(k) The browser visits the k number of forward pages
---

##  Assumptions

- Each browser session starts at a URL.
- The user may attempt to access a non-existent page.
- Visiting a new URL clears the forward history.
---

##  Conceptual Solution

1. The currentURL variable holds the URL the browser is currently at.
2. Visiting a new URL pushes the currentURL to the previous stack, sets the currentURL to the visit() parameter, and clears the forward stack
3. back(k) moves the k element in the previous stack to the currentURL, pushes the currentURL to the forward stack, and puts all the elements before k in the forward stack.
4. forward(k) moves the k element in the forward stack to currentURL, pushes the currentURL to the previous stack, and puts all the elements before k in the previous stack

##  Example
**Starts a new browser session:**
Solution browser = new Solution("google.com");

**Visits a new URL:**
browser.visit("page1.com");

**Goes back 1 page:**
browser.back(1);     
- The current URL is "google.com"
     
**Goes forward 1 page:**
browser.forward(1);  
- The current URL is "page1.com"