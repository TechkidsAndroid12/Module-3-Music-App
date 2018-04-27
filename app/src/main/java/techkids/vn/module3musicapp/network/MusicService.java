package techkids.vn.module3musicapp.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by qklahpita on 4/15/18.
 */

public interface MusicService {
    @GET("api")
    Call<MusicTypesResponse> getListMusicTypes();

    @GET("https://itunes.apple.com/us/rss/topsongs/limit=50/genre={idMusicType}/explicit=true/json")
    Call<TopSongResponse> getTopSongs(@Path("idMusicType") String idMusicType);

}
