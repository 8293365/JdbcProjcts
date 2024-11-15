package WebCrawler.src.main.java.org.example;

import java.io.IOException;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.http.*;
import java.time.Duration;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;


public class Crawler {
public HttpClient client;
public ArrayList<String> visited;//visited websites
public static String address = "";
//you have to use.useragent()


    public void conn() {
 this.client = HttpClient.newBuilder().build()
         .version(HttpClient.Version.HTTP_1_1)
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(20))
            .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 80)))
            .authenticator(Authenticator.getDefault())
            .build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.statusCode());
    System.out.println(response.body());
}

//in theory the web crawler is a recursive class to make
    public static void crawl(int depth, int level, String url, ArrayList<String> visited){
    if(level <= depth){
        Document doc = request(url, visited);
        if (doc!= null) {
            for (Element link : doc.select("a[href]")) {
                String next_link = link.absUrl("href");
                if(visited.contains(next_link) == false) {
                    crawl(level++, next_link, visited);
                }
            }
        }

    }
    }
    //this should do the call to the website and the check for all of references 'href'
    public static void request(String url, ArrayList<String> ArrList){
        //Connection conn you have to use the jsoup methods
    }
}
