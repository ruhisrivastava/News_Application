package com.example.android.news_application_with_tabs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.util.List;

import com.example.android.news_application_with_tabs.model.Item;
import com.example.android.news_application_with_tabs.model.MainData;
import com.example.android.news_application_with_tabs.utils.AppConstants;

/**
 * Created by Ruhi on 1/30/2018.
 */
public class TabFragment extends Fragment{

    private List<Item> item;
    private int position;
    private ProgressDialog progressBar;
    private StringRequest strReq;

    private static final String TAG = TabFragment.class.getName();
    private String URL ="http://la-ios.trb.com/v1/content/?market_id=1&content_profile=22&structure=full&section_id=543&include_embedded_items=true&include_related=false&include_child=true&child_count=1";
    private RecyclerView recyclerView;
    private ArticleAdapter adapter;
    private static MainData mMainData;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // hideProgressBar();
        View view = inflater.inflate(R.layout.layout_tab, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        return view;

    }

    static TabFragment newInstance(int position) {
        TabFragment fragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);
        return fragment;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        getNetworkData();

    }

    /*  public static MainData toPoJo(String response) {
        Gson gson = new Gson();
        mMainData = gson.fromJson(response, MainData.class);
        return mMainData;
    }*/

    private void toPoJo(String response) {
        Gson gson = new Gson();
        mMainData = gson.fromJson(response, MainData.class);
    }

    private void getNetworkData(){
        if(position==1)
            URL ="http://la-ios.trb.com/v1/content/?market_id=1&content_profile=22&structure=full&section_id=606&include_embedded_items=false&include_related=false&include_child=true&child_count=1";
        else
            URL = "http://la-ios.trb.com/v1/content/?market_id=1&content_profile=22&structure=full&section_id=543&include_embedded_items=true&include_related=false&include_child=true&child_count=1";
        showProgressBar();

        strReq = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "response " + response);
                        toPoJo(response);
                        item = mMainData.getItems();
                        adapter = new ArticleAdapter(getActivity(),item, TabFragment.this);
                        recyclerView.setAdapter(adapter);
                        hideProgressBar();
                        Log.d(TAG,mMainData.getItems().get(0).getCredit());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "error " + error+", "+error.getLocalizedMessage());
                        {
                            Toast.makeText(getContext(), "error loading data", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
        VolleySingleton.getInstance(getActivity()).addToRequestQueue(strReq);

    }




    private void showProgressBar() {
        if (progressBar == null) {
            progressBar = new ProgressDialog(getContext());
        }
        if (R.string.loading != -1) {
            progressBar.setTitle(R.string.loading);
        }
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setIndeterminate(true);
        progressBar.setCancelable(true);
        progressBar.show();
    }

    private void hideProgressBar() {
        if (progressBar != null) {
            progressBar.dismiss();
        }
    }


    public void articleClicked(String id, String title, String desc)
    {
        Intent intent = new Intent(getActivity(), ArticleActivity.class);
        intent.putExtra(AppConstants.ARTICLE_ID,id);
        intent.putExtra(AppConstants.ARTICLE_TITLE,title);
        intent.putExtra(AppConstants.ARTICLE_DESC,desc);
        startActivity(intent);
    }

}
