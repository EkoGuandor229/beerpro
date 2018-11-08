package ch.beerpro.presentation.profile.myfridge;

import android.widget.ImageView;

import ch.beerpro.domain.models.Beer;
import ch.beerpro.domain.models.Fridge;

public interface OnFirdgelistItemInteractionListener {

    void onMoreClickedListener(ImageView photo, Beer beer);

    void onSaveClickedListener(Fridge fridge, int amount);
}
