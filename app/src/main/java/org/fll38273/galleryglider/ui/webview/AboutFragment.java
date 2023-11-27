package org.fll38273.galleryglider.ui.webview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import org.fll38273.galleryglider.R;

public class AboutFragment extends WebViewFragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_scrollingart, container, false);
        initWebView(rootView, R.id.html_webView);

        View buttons = rootView.findViewById(R.id.Buttons);
        buttons.setVisibility(View.GONE);

        mWebView.loadUrl("https://appassets.androidplatform.net/assets/about/about.html");

        /*binding = FragmentAboutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/
        return rootView;
    }
}
