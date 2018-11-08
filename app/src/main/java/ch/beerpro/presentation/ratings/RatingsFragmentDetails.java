package ch.beerpro.presentation.ratings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import ch.beerpro.GlideApp;
import ch.beerpro.R;
import ch.beerpro.domain.models.Rating;
import lombok.Setter;

public class RatingsFragmentDetails extends Fragment {

    private static final String TAG = "RatingsAddFragment";

    @BindView(R.id.photo)
    ImageView photo;

    @BindView(R.id.ratingBar)
    RatingBar ratingBar;

    @BindView(R.id.avatar)
    ImageView avatar;

    @BindView(R.id.ratingText)
    TextView ratingText;

    @BindView(R.id.ratingPlace)
    TextView ratingPlace;

    @BindView(R.id.bitternessValue)
    TextView bitternessValue;

    @BindView(R.id.headacheValue)
    TextView headacheValue;

    @BindView(R.id.aromaValue)
    TextView aromaValue;

    @Setter
    private Rating rating;

    public RatingsFragmentDetails() {
    }

    @Override
    public void onResume() {
        super.onResume();

        photo.setBackgroundResource(R.drawable.no_image_icon);
        GlideApp.with(this).load(rating.getPhoto()).apply(new RequestOptions().centerInside()).into(photo);
        ratingBar.setRating(rating.getRating());
        GlideApp.with(this).load(rating.getUserPhoto()).apply(new RequestOptions().centerInside()).into(avatar);
        ratingText.setText(rating.getComment());
        if(rating.getPlaceName() != null && !rating.getPlaceName().isEmpty()) {
            ratingPlace.setText(rating.getPlaceName());
        }
        if(rating.getBitterness() > 0) {
            bitternessValue.setText("" + rating.getBitterness());
        }
        if(rating.getHeadacheFactor() > 0) {
            headacheValue.setText("" + rating.getHeadacheFactor());
        }
        if(rating.getAroma() != null && !rating.getAroma().isEmpty()) {
            aromaValue.setText("" + rating.getAroma());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_ratings_details, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }
}
