package ro.mihai.newsreader.Common;

import ro.mihai.newsreader.Interface.NewsService;
import ro.mihai.newsreader.Remote.RetrofitClient;

public class Common {
    private static final String BASE_URL = "https://newsapi.org/";
    public static final String API_KEY = "0b67a338a6f04a0b8efacd81343c59d7";

    public static NewsService getNewsService(){
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }
}
