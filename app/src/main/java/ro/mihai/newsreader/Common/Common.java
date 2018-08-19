package ro.mihai.newsreader.Common;

import ro.mihai.newsreader.Interface.IconBetterIdeaService;
import ro.mihai.newsreader.Interface.NewsService;
import ro.mihai.newsreader.Remote.IconBetterIdeaClient;
import ro.mihai.newsreader.Remote.RetrofitClient;

public class Common {
    private static final String BASE_URL = "https://newsapi.org/";
    public static final String API_KEY = "0b67a338a6f04a0b8efacd81343c59d7";

    public static NewsService getNewsService(){
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService(){
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }

    public static String getApiUrl(String source, String sortBy, String apiKEY){
        StringBuilder apiUrl = new StringBuilder("https://newsapi.org/v2/top-headlines?sources=");
        return apiUrl.append(source)
                .append("&apiKey=")
                .append(API_KEY)
                .toString();
    }
}
