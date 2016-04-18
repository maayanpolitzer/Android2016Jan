package com.example.hackeru.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        button = (Button) findViewById(R.id.button);
        webView = (WebView) findViewById(R.id.web_view);
        WebSettings settings = webView.getSettings();
        settings.setBuiltInZoomControls(true);
        webView.clearCache(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        //String html = "<h1>hello, World!</h1><p>sdlvnsfdl knd lk fndl kns lskvnsl kn</p>";

        //webView.loadDataWithBaseURL("",html, "text/html", "UTF-8", "");

        webView.loadUrl("http://www.ynet.com");
    }
}
