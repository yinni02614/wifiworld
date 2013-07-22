package com.wifiorg.wifiworld;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private  WebView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.view = (WebView)this.findViewById(R.id.mainWebView);
        this.view.getSettings().setJavaScriptEnabled(true);
        this.view.getSettings().setLoadsImagesAutomatically(true);
        this.view.getSettings().setBuiltInZoomControls(true);
        this.view.loadUrl("http://www.peigong.tk");
        this.view.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.view.canGoBack()) {
            this.view.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
