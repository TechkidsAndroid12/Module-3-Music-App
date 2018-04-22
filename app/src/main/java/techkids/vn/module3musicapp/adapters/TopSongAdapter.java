package techkids.vn.module3musicapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import techkids.vn.module3musicapp.R;
import techkids.vn.module3musicapp.databases.TopSongModel;

/**
 * Created by qklahpita on 4/22/18.
 */

public class TopSongAdapter extends RecyclerView.Adapter<TopSongAdapter.TopSongViewHolder> {
    List<TopSongModel> topSongModels = new ArrayList<>();

    public TopSongAdapter(List<TopSongModel> topSongModels) {
        this.topSongModels = topSongModels;
    }

    @Override
    public TopSongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_list_topsong,
                parent, false);
        return new TopSongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TopSongViewHolder holder, int position) {
        holder.setData(topSongModels.get(position));
    }

    @Override
    public int getItemCount() {
        return topSongModels.size();
    }

    public class TopSongViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_top_song)
        ImageView ivTopSong;
        @BindView(R.id.tv_song)
        TextView tvSong;
        @BindView(R.id.tv_artist)
        TextView tvArtist;

        public TopSongViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setData(TopSongModel topSongModel) {
            Transformation transformation = new CropCircleTransformation();

            Picasso.get()
                    .load(topSongModel.image)
                    .transform(transformation)
                    .into(ivTopSong);
            tvSong.setText(topSongModel.song);
            tvArtist.setText(topSongModel.artist);
        }
    }
}
