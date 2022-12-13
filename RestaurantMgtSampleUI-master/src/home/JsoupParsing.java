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
            Connection conn = Jsoup.connect(URL); // URL에 연결한다

            Document document = conn.get(); //해당 페이지의 소스를 가져오고

            Element Weather = document.getElementsByClass("temperature_text").get(0); // HTML Class Name "temperature_text" 를 가져온다
            String PrintWeather = Weather.text(); // 해당값을 text값으로 가져옴

            Element Summary  = document.getElementsByClass("summary").get(0); //
            String PrintSummary = Summary.text(); // 위와 마찬가지

            String[] MyList = PrintSummary.split(" "); //현재 날씨를 표시해주기 위함

            String Result = PrintWeather + MyList[MyList.length-1]; // 현재 온도 + 날씨를 더해서 Result에 저장
            Session.setWeather(Result); // 세션에 저장
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
