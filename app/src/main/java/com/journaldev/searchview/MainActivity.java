package com.journaldev.searchview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;

import com.journaldev.searchview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    ListAdapter adapter;

    List<String> arrayList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        arrayList.add("Fisio 0");
        arrayList.add("Fisio 1");
        arrayList.add("Fisio 2");
        arrayList.add("Fisio 3");
        arrayList.add("Fisio 4");
        arrayList.add("Fisio 5");
        arrayList.add("Fisio 6");
        arrayList.add("Fisio 7");
        arrayList.add("Fisio 8");
        arrayList.add("Fisio 9");
        arrayList.add("Fisio 10");
        arrayList.add("Fisio 11");

        adapter= new ListAdapter(arrayList);
        activityMainBinding.listView.setAdapter(adapter);

        activityMainBinding.search.setActivated(true);
        activityMainBinding.search.setQueryHint("Pesquisar Fisioterapeuta");
        activityMainBinding.search.onActionViewExpanded();
        activityMainBinding.search.setIconified(false);
        activityMainBinding.search.clearFocus();

        activityMainBinding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return false;
            }
        });
    }
}
