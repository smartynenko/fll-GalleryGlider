package org.fll38273.galleryglider.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import org.fll38273.galleryglider.MainActivity;
import org.fll38273.galleryglider.R;

public class GalleryFragment extends Fragment {
    GridView artworkGV;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
        artworkGV = (GridView) rootView.findViewById(R.id.idGVGallery);

        ArtWorkGVAdapter adapter = new ArtWorkGVAdapter(this.getContext(), this, ((MainActivity) requireActivity()).getArtWorks());
        artworkGV.setAdapter(adapter);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void activateScrollingArt() {
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.action_nav_gallery_to_nav_scrollingart);
    }
}