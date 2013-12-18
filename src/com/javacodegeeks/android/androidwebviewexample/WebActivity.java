package com.javacodegeeks.android.androidwebviewexample;

//import net.blogjava.mobile.R;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;


public class WebActivity extends Activity {

//	private WebView webView;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.webcontent);

		WebView webView = (WebView) findViewById(R.id.webview);  
		webView.getSettings().setJavaScriptEnabled(true);
		
		webView.loadUrl("file:///android_asset/TestPage.html");
		
		/*
		String customHtml = "<html><body>" +	
				"<h2>This is a test webpage.</h2>" +					
				"</body></html>";		
		webView.loadDataWithBaseURL("TestPage", customHtml, "text/html", "utf-8", null);
		*/
		 webView.setWebChromeClient(new WebChromeClient());		
		 
	}
}
