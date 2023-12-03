package org.fll38273.galleryglider.ui.webview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import org.fll38273.galleryglider.ArtWorkViewModel;
import org.fll38273.galleryglider.MainActivity;
import org.fll38273.galleryglider.R;

public class ScrollingArtFragment extends WebViewFragment {
    private ArtWorkViewModel mViewModel;
    int mPosition;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_scrollingart, container, false);

        initWebView(rootView, R.id.html_webView);

        mViewModel = new ViewModelProvider(requireActivity()).get(ArtWorkViewModel.class);
        loadContent();

        Button btnNext = rootView.findViewById(R.id.Next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPosition = mPosition == ((MainActivity) requireActivity()).getArtWorks().length - 1 ? 0 : mPosition + 1;
                refreshContent(nextPosition);
            }
        });

        Button btnPrevious = rootView.findViewById(R.id.Prev);
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextPosition = mPosition == 0 ? ((MainActivity) requireActivity()).getArtWorks().length - 1 : mPosition - 1;
                refreshContent(nextPosition);
            }
        });

        return rootView ;
    }

    private void refreshContent(int nextPosition) {
        mViewModel.selectItem(nextPosition);
        loadContent();
    }

    private void loadContent() {
        mPosition = mViewModel.getSelectedItem().getValue().intValue();
        String asset_path = ((MainActivity) requireActivity()).getArtWorks()[mPosition].getAssetPath();
        mWebView.loadUrl("https://appassets.androidplatform.net/assets/" + asset_path);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}