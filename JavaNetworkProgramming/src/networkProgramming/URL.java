package networkProgramming;

import java.net.MalformedURLException;

public class URL {

    public static void main(String[] args) {
        String web = "https://en.wikipedia.org/wiki/Template:Cite_web";

        try {
            java.net.URL myURL = new java.net.URL(web); // Fully qualify URL class
            getURL(myURL); // Call the getURL method here
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    static void getURL(java.net.URL url) { // Fully qualify URL class
        System.out.println("HOST = " + url.getHost());
        System.out.println("PATH = " + url.getPath());
        System.out.println("REF = " + url.getRef());
        System.out.println("PORT = " + url.getPort());
    }
}
