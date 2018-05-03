package techkids.vn.module3musicapp.utils;

import android.content.Context;
import android.util.Log;

import hybridmediaplayer.HybridMediaPlayer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techkids.vn.module3musicapp.databases.TopSongModel;
import techkids.vn.module3musicapp.network.LocationResponse;
import techkids.vn.module3musicapp.network.MusicService;
import techkids.vn.module3musicapp.network.RetrofitInstance;
import techkids.vn.module3musicapp.network.SearchSongResponse;

public class MusicHandle {
    private static final String TAG = "MusicHandle";

    public static void getSearchSong(TopSongModel topSongModel, final Context context) {
        MusicService musicService = RetrofitInstance.getRetrofitInstance()
                .create(MusicService.class);
        musicService.getSearchSong(topSongModel.song
                + " " + topSongModel.artist).enqueue(new Callback<SearchSongResponse>() {
            @Override
            public void onResponse(Call<SearchSongResponse> call, Response<SearchSongResponse> response) {
                String url = response.body().data.url;
                getLocationSong(url, context);
            }

            @Override
            public void onFailure(Call<SearchSongResponse> call, Throwable t) {

            }
        });
    }

    public static void getLocationSong(String url, final Context context) {
        MusicService musicService = RetrofitInstance.getRetrofitXMLInstance()
                .create(MusicService.class);
        musicService.getLocation(url.split("=")[1]).enqueue(new Callback<LocationResponse>() {
            @Override
            public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {
                HybridMediaPlayer hybridMediaPlayer = HybridMediaPlayer.getInstance(context);
                hybridMediaPlayer.setDataSource(response.body().trackXML.location.trim());
                hybridMediaPlayer.prepare();
                hybridMediaPlayer.setOnPreparedListener(new HybridMediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(HybridMediaPlayer hybridMediaPlayer) {
                        hybridMediaPlayer.play();
                    }
                });
            }

            @Override
            public void onFailure(Call<LocationResponse> call, Throwable t) {

            }
        });
    }
}
