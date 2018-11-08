package ch.beerpro.presentation.ratings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import ch.beerpro.R;

public class RatingsFragmentAdd extends Fragment {

    private static final String TAG = "RatingsAddFragment";

    private OnRatingGivenListener listener;

    @BindView(R.id.addRatingBar)
    RatingBar addRatingBar;

    public RatingsFragmentAdd() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRatingGivenListener) {
            listener = (OnRatingGivenListener) context;
        } else {
            throw new UnsupportedOperationException(context.getClass().getSimpleName()
                                                  + " must implement "
                                                  + OnRatingGivenListener.class.getSimpleName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_ratings_add, container, false);
        ButterKnife.bind(this, rootView);

        addRatingBar.setOnRatingBarChangeListener(listener::onNewRating);

        return rootView;
    }

    public interface OnRatingGivenListener {
        void onNewRating(RatingBar ratingBar, float v, boolean b);
    }
}
