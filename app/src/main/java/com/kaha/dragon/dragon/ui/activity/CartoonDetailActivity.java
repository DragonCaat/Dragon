package com.kaha.dragon.dragon.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.kaha.dragon.R;
import com.kaha.dragon.dragon.base.AppConst;
import com.kaha.dragon.framework.ui.activity.BaseActivity;
import com.kaha.dragon.framework.utils.ToastUtil;
import com.kaha.dragon.framework.widget.TopView;

import butterknife.BindView;

/**
 * 卡通详情界面
 *
 * @author Darcy
 * @Date 2019/4/15
 * @package com.kaha.dragon.dragon.ui.activity
 * @Desciption
 */
public class CartoonDetailActivity extends BaseActivity {
    @BindView(R.id.topView)
    TopView vTopView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.webView)
    WebView webView;

    private String urlString;
    private String nameString;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_cartoon_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        urlString = intent.getStringExtra(AppConst.KEY_1);
        nameString = intent.getStringExtra(AppConst.KEY_2);
        vTopView.setTitle(nameString);

        initWebView();
    }
    //初始化webView
    private void initWebView() {
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        if (TextUtils.isEmpty(urlString)) {
            webView.loadUrl("");
            ToastUtil.show(context, "无相关网页信息");
        } else {
            webView.loadUrl(urlString);
        }

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setBuiltInZoomControls(false);//设置不放大
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                }
            }
        });

        webView.getSettings().setSupportZoom(true);//支持缩放
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private void releaseWebView() {
        if (webView != null) {
            webView.stopLoading();
            webView.clearCache(true);
            webView.clearHistory();
            webView.destroy();
            webView = null;
        }
    }

    @Override
    protected void onDestroy() {
        releaseWebView();
        super.onDestroy();
    }
}
