package ch.beerpro.presentation.ratings;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import ch.beerpro.R;
import ch.beerpro.domain.models.Rating;
import ch.beerpro.domain.models.Wish;
import ch.beerpro.presentation.MainViewModel;
import ch.beerpro.presentation.details.DetailsActivity;
import ch.beerpro.presentation.details.createrating.CreateRatingActivity;
import ch.beerpro.presentation.explore.BeerCategoriesFragment;
import lombok.val;

public class RatingsFragmentAdd extends Fragment {

    private static final String TAG = "RatingsAddFragment";

    private MainViewModel model;
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

        //TODO move all model stuff to the rating frag displaying a rating
        model = ViewModelProviders.of(this).get(MainViewModel.class);

        //Register observer to get notified if any ratings get added
        model.getAllRatingsWithWishes().observe(this, this::updateRating);

        addRatingBar.setOnRatingBarChangeListener(listener::onNewRating);

        return rootView;
    }

    /**
     * Updates the currently displayed rating if a newer rating has been made
     *
     * @param ratings list of ratings which has been updated/modified
     */
    private void updateRating(List<Pair<Rating, Wish>> ratings) {
        if (ratings != null) {
            //TODO update rating displayed
        }
    }

    public interface OnRatingGivenListener {
        void onNewRating(RatingBar ratingBar, float v, boolean b);
    }
}
