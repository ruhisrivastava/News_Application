package com.example.android.news_application_with_tabs;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.android.news_application_with_tabs.databinding.ActivityArticleBinding;
import com.example.android.news_application_with_tabs.utils.AppConstants;

public class ArticleActivity extends AppCompatActivity {

    @NonNull
    private ActivityArticleBinding articleBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        articleBinding = DataBindingUtil.setContentView(this, R.layout.activity_article);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initialiseData(getIntent());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    private void initialiseData(@NonNull Intent intent) {
        String title = intent.getStringExtra(AppConstants.ARTICLE_TITLE);
        String desc = intent.getStringExtra(AppConstants.ARTICLE_DESC);
        Spanned spannable = Html.fromHtml(desc);
        articleBinding.title.setText(title);
        articleBinding.desc.setText(spannable);
        // articleBinding.desc.setText(desc);
    }
}
