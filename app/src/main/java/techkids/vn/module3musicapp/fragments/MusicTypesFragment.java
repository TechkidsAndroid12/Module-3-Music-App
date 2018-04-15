package techkids.vn.module3musicapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techkids.vn.module3musicapp.R;
import techkids.vn.module3musicapp.network.MusicService;
import techkids.vn.module3musicapp.network.MusicTypesResponse;
import techkids.vn.module3musicapp.network.RetrofitInstance;


/**
 * A simple {@link Fragment} subclass.
 */
public class MusicTypesFragment extends Fragment {
    private static final String TAG = "MusicTypesFragment";
    public MusicTypesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        loadData();

        return inflater.inflate(R.layout.fragment_music_types, container, false);
    }

    private void loadData() {
        MusicService musicService = RetrofitInstance.getRetrofitInstance()
                .create(MusicService.class);
        musicService.getListMusicTypes().enqueue(new Callback<MusicTypesResponse>() {
            @Override
            public void onResponse(Call<MusicTypesResponse> call, Response<MusicTypesResponse> response) {
                Log.d(TAG, "onResponse: " + response.body().subgenres.toString());
            }

            @Override
            public void onFailure(Call<MusicTypesResponse> call, Throwable t) {

            }
        });
    }

}
