package com.android.praktikum.pariwisata;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class ActivityWeb extends AppCompatActivity {
    private ProgressBar spinner;
    private WebView webnya;

    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        webnya = findViewById(R.id.webview1);
        spinner = findViewById(R.id.progressBar1);

        Pantai pantai = getIntent().getParcelableExtra(ITEM_EXTRA);

        if(pantai != null){
            webnya.setWebViewClient(new CustomWebViewClient());

            webnya.getSettings().setJavaScriptEnabled(true);
            webnya.getSettings().setDomStorageEnabled(true);
            webnya.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
            webnya.loadUrl(pantai.getWebsite());
        }


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

   public void openwhatapp(View view){
        try {
            String text = "Hallo Selamat Datang di Destinasi Pariwisata Pantai Bali, apakah ada yang bisa dibantu";

            String toNumber = "+62895360426592";

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
   }

    private class CustomWebViewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView webnya, String url, Bitmap favicon){
            webnya.setVisibility(webnya.INVISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url){
            spinner.setVisibility(View.GONE);

            view.setVisibility(webnya.VISIBLE);
            super.onPageFinished(view, url);
        }
    }
}
