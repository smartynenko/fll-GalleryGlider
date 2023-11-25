package org.fll38273.galleryglider.ui.scrollingart;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;

import org.fll38273.galleryglider.ArtWorkViewModel;
import org.fll38273.galleryglider.MainActivity;
import org.fll38273.galleryglider.R;

public class ScrollingArtFragment extends Fragment {
    private ArtWorkViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_scrollingart, container, false);


        final WebViewAssetLoader assetLoader = new WebViewAssetLoader.Builder()
                .addPathHandler("/assets/", new WebViewAssetLoader.AssetsPathHandler(this.getContext()))
                .build();

        WebView webView = (WebView) rootView.findViewById(R.id.html_webView);
        webView.setWebViewClient(new WebViewClientCompat() {
            @Override
            @RequiresApi(21)
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return assetLoader.shouldInterceptRequest(request.getUrl());
            }

            @Override
            @SuppressWarnings("deprecation") // for API < 21
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                return assetLoader.shouldInterceptRequest(Uri.parse(url));
            }
        });

        WebSettings webViewSettings = webView.getSettings();
        // Setting this off for security. Off by default for SDK versions >= 16.
        webViewSettings.setAllowFileAccessFromFileURLs(false);
        // Off by default, deprecated for SDK versions >= 30.
        webViewSettings.setAllowUniversalAccessFromFileURLs(false);
        // Keeping these off is less critical but still a good idea, especially if your app is not
        // using file:// or content:// URLs.
        webViewSettings.setAllowFileAccess(false);
        webViewSettings.setAllowContentAccess(false);

        //view.getSettings().setJavaScriptEnabled(true);

        viewModel = new ViewModelProvider(requireActivity()).get(ArtWorkViewModel.class);
        String asset_path = ((MainActivity) requireActivity()).getArtWorks()[viewModel.getSelectedItem().getValue().intValue()].getAssetPath();
        webView.loadUrl("https://appassets.androidplatform.net/assets/" + asset_path);

        return rootView ;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}