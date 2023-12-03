package org.fll38273.galleryglider.ui.gallery;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import org.fll38273.galleryglider.ArtWorkModel;
import org.fll38273.galleryglider.ArtWorkViewModel;
import org.fll38273.galleryglider.R;

public class ArtWorkGVAdapter extends ArrayAdapter<ArtWorkModel> {

    private GalleryFragment mGallery;
    private ArtWorkViewModel viewModel;
    public ArtWorkGVAdapter(@NonNull Context context, GalleryFragment gallery, ArtWorkModel[] artWorkModels) {
        super(context, 0, artWorkModels);
        mGallery = gallery;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.gallery_item, parent, false);
        }

        ArtWorkModel artworkModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.idTArt);
        ImageButton artworkIB = listitemView.findViewById(R.id.idBIArt);

        courseTV.setText(artworkModel.getArtworkName());
        artworkIB.setImageResource(artworkModel.getImgId());
        if(artworkModel.getAssetPath() == "") {
            artworkIB.setEnabled(false);
            artworkIB.setColorFilter(Color.argb(150,200,200,200));
        }
        viewModel = new ViewModelProvider(mGallery.requireActivity()).get(ArtWorkViewModel.class);

        artworkIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),artworkModel.getArtworkName(), Toast.LENGTH_LONG).show();
                viewModel.selectItem(position);
                mGallery.activateScrollingArt();
            }
        });
        return listitemView;
    }
}
