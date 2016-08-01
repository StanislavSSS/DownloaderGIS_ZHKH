import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class Downloader {

	static String fileName = "c:/temp/dom_Gosuslugi.ru.html";
	
    public static void main(String[] args) throws Exception {
        String targetUrl = "http://dom.gosuslugi.ru/#/regulations?userCtgrCode=9";
        System.out.println("Downloader is running...");
        FileOutputStream e = null;
        InputStream in = null;
        Object buffer = null;
        URL connection = new URL(targetUrl);
        HttpURLConnection urlconn = (HttpURLConnection) connection.openConnection();
        urlconn.setRequestMethod("GET");
        urlconn.connect();
        in = urlconn.getInputStream();
        e = new FileOutputStream(fileName);
        byte[] buffer1 = new byte[4096];
        System.out.println("Download began...");
        int count;
        while ((count = in.read(buffer1)) != -1) {
            e.write(buffer1, 0, count);
        }
        e.flush();
        e.close();
        in.close();
        System.out.println("Download ended...");
    }
    
    public static void searcher(String[] args)  throws Exception {
        Scanner s = new Scanner(new File(fileName));
        String st = String.valueOf(s);
        System.out.println(st);
        
    }
}