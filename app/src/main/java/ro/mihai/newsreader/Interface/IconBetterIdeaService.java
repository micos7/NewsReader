package ro.mihai.newsreader.Interface;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import ro.mihai.newsreader.Model.IconBetterIdea;

public interface IconBetterIdeaService {
    @GET
    Call<IconBetterIdea> getIconUrl(@Url String url);
}
