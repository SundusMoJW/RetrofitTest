package com.twins.osama.retrofittest.Activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.twins.osama.retrofittest.Adapter.MenuAdapter;
import com.twins.osama.retrofittest.Models.Response;
import com.twins.osama.retrofittest.Models.WorcipeAppItem;
import com.twins.osama.retrofittest.R;
import com.twins.osama.retrofittest.Remote.OnDrawerItemClickListener;
import com.twins.osama.retrofittest.Remote.SOService;
import com.twins.osama.retrofittest.Utility.ApiUtils;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private ArrayList<WorcipeAppItem> menuList = new ArrayList<>();
    private MenuAdapter melsadapter;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout mySwipeRefreshLayout;
    private SOService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rvmenu);
        mySwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        mService = ApiUtils.getSOService();

        loadAnswers();
    }

    public void loadAnswers() {
        Call<Response> call = mService.getAnswers();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                menuList = (ArrayList<WorcipeAppItem>) response.body().getWorcipeApp();

//                Response response1=response.body().getWorcipeApp();
                melsadapter = new MenuAdapter(MainActivity.this, menuList, new OnDrawerItemClickListener() {
                    @Override
                    public void onClick(int postition) {
                        Toast.makeText(MainActivity.this, "Post id is" + postition, Toast.LENGTH_SHORT).show();
                        menuList.get(postition).getCid();
//                        showAnswers();
                    }
                });

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(melsadapter);
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(MainActivity.this, "on Failure", Toast.LENGTH_SHORT).show();

            }
        });
    }

//    public void showAnswers() {
//        Call<WorcipeAppItem> call = mService.getAnswersWorcipeAppItem();
//        call.enqueue(new Callback<WorcipeAppItem>() {
//            @Override
//            public void onResponse(Call<WorcipeAppItem> call, retrofit2.Response<WorcipeAppItem> response) {
//                WorcipeAppItem response1 = response.body();
//                Toast.makeText(MainActivity.this, response1.getCategoryName() + "   " + response1.getCategoryImage(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<WorcipeAppItem> call, Throwable t) {
//
//            }
//
//        });
//    }
}



