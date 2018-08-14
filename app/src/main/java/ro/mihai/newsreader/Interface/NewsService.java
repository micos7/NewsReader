package ro.mihai.newsreader.Interface;

import retrofit2.Call;
import retrofit2.http.GET;
import ro.mihai.newsreader.Common.Common;
import ro.mihai.newsreader.Model.WebSite;

public interface NewsService {
    @GET("v2/sources?apiKey="+ Common.API_KEY)
    Call<WebSite> getSources();
}
