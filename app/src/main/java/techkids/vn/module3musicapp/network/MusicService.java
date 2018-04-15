package techkids.vn.module3musicapp.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by qklahpita on 4/15/18.
 */

public interface MusicService {
    @GET("api")
    Call<MusicTypesResponse> getListMusicTypes();
}
