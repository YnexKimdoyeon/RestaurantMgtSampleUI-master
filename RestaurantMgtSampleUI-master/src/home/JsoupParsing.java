package home;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class JsoupParsing {
    public JsoupParsing(){
        try{
            String URL = "https://search.naver.com/search.naver?sm=tab_hty.top&where=nexearch&query=%EC%95%84%EC%82%B0+%EB%82%A0%EC%94%A8&oquery=java+jsoup&tqi=hGjp2lp0J1sssEbZz68sssssssd-095890";
            Connection conn = Jsoup.connect(URL);

            Document document = conn.get();

            Element Weather = document.getElementsByClass("temperature_text").get(0);
            String PrintWeather = Weather.text();

            Element Summary  = document.getElementsByClass("summary").get(0);
            String PrintSummary = Summary.text();

            String[] MyList = PrintSummary.split(" ");

            String Result = PrintWeather + MyList[MyList.length-1];
            Session.setWeather(Result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
