package networkProgramming;

import java.net.URISyntaxException;
import java.net.UnknownHostException;

public class URI {
    public static void main(String[] args) throws UnknownHostException, URISyntaxException {
        String website = "https://techbinz.com/ecu-ecm-power-management/";

        //URI webURI = new URI("https", "techbinz.com", "ecu-ecm-power-management");
        URI webURI = new URI("https", "techbinz.com", "ecu-ecm-power-management");

        getURI(webURI);
    }

    static void getURI(URI myUri) {
        System.out.println(myUri.getAuthority());
        System.out.println(myUri.getPath());
        System.out.println(myUri.getHost());
        System.out.println(myUri.getPort());
        System.out.println(myUri.getScheme());
    }

    private String scheme;
    private String authority;
    private String path;
    private int port;
    private String host;

    public URI(String scheme, String authority, String path) {
        this.scheme = scheme;
        this.authority = authority;
        this.path = path;
    }

    public String getScheme() {
        return scheme;
    }

    public String getAuthority() {
        return authority;
    }

    public String getPath() {
        return path;
    }

    public int getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }
    
    
}
