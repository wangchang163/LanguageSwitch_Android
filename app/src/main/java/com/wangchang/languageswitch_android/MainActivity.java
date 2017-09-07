package com.wangchang.languageswitch_android;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setTitle(R.string.main_title);
            toolbar.setTitleTextColor(Color.WHITE);
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_menu_black_24dp));
        }
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.menu_search);
        SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //设置搜索框hint内容
        mSearchView.setQueryHint("QueryHint...");
        SearchView.SearchAutoComplete textView = (SearchView.SearchAutoComplete)
                mSearchView.findViewById(R.id.search_src_text);
        //设置搜索框中输入文字的颜色
        textView.setTextColor(Color.BLACK);
        //搜索内容监听
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("onQueryTextSubmit", query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("onQueryTextChange", newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.zh:
                LanguageUtils.switchLanguage(this, 0);
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

                break;
            case R.id.en:
                LanguageUtils.switchLanguage(this, 1);
                Intent intents = new Intent(this, MainActivity.class);
                intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intents);
                break;
            case R.id.defaults:
                LanguageUtils.switchLanguage(this, 2);
                Intent intentss = new Intent(this, MainActivity.class);
                intentss.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intentss);
                break;
            case R.id.menu_notifications:
                Toast.makeText(this, "点击通知按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_search:
                Toast.makeText(this, "点击搜索按钮", Toast.LENGTH_SHORT).show();
                break;
            default:
                LanguageUtils.switchLanguage(this, 2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
