package org.fll38273.galleryglider.ui.webview;

import android.net.Uri;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.IdRes;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;

public class WebViewFragment extends Fragment {
    WebView mWebView;

    public void initWebView(View rootView, @IdRes int id) {
        final WebViewAssetLoader assetLoader = new WebViewAssetLoader.Builder()
                .addPathHandler("/assets/", new WebViewAssetLoader.AssetsPathHandler(this.getContext()))
                .build();

        mWebView = (WebView) rootView.findViewById(id);
        mWebView.setWebViewClient(new WebViewClientCompat() {
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

        WebSettings webViewSettings = mWebView.getSettings();
        // Setting this off for security. Off by default for SDK versions >= 16.
        // webViewSettings.setAllowFileAccessFromFileURLs(false);
        // Off by default, deprecated for SDK versions >= 30.
        // webViewSettings.setAllowUniversalAccessFromFileURLs(false);
        // Keeping these off is less critical but still a good idea, especially if your app is not
        // using file:// or content:// URLs.
        webViewSettings.setAllowFileAccess(false);
        webViewSettings.setAllowContentAccess(false);

        //view.getSettings().setJavaScriptEnabled(true);
    }
}
