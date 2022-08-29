package com.websarva.wings.android.menU;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuResultActivity extends AppCompatActivity {
    private static int sum_of_price = 0;
    private static double sum_of_cal = 0.0;
    private static double sum_of_red = 0.0;
    private static double sum_of_green = 0.0;
    private static double sum_of_yellow = 0.0;

    private ListView _lvResult;
    private static List<Map<String, Object>> _resultList = new ArrayList<>();

    private static final String[] FROM
            = {"name", "price", "cal", "red", "green", "yellow"};
    // SimpleAdapterの第4引数from用の定数フィールド
    private static final int[] TO
            = {R.id.tvMenuName, R.id.tvMenuPrice, R.id.tvMenuCal,
            R.id.tvMenuRed, R.id.tvMenuGreen, R.id.tvMenuYellow};
    // SimpleAdapterの第5引数to用の定数フィールド

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_result);

        Intent intent = getIntent();

        String menuName = intent.getStringExtra("menuName");
        Integer menuPrice = intent.getIntExtra("menuPrice", 0);
        Double menuCal = intent.getDoubleExtra("menuCal", 0.0);
        Double menuRed = intent.getDoubleExtra("menuRed", 0.0);
        Double menuGreen = intent.getDoubleExtra("menuGreen", 0.0);
        Double menuYellow = intent.getDoubleExtra("menuYellow", 0.0);

        sum_of_price += menuPrice;
        sum_of_cal += menuCal;
        sum_of_red += menuRed;
        sum_of_green += menuGreen;
        sum_of_yellow += menuYellow;

        TextView tvSumOfPrice = findViewById(R.id.tvSumOfPrice);
        TextView tvSumOfCal = findViewById(R.id.tvSumOfCal);
        TextView tvSumOfRed = findViewById(R.id.tvSumOfRed);
        TextView tvSumOfGreen = findViewById(R.id.tvSumOfGreen);
        TextView tvSumOfYellow = findViewById(R.id.tvSumOfYellow);

        tvSumOfPrice.setText(String.valueOf(sum_of_price));
        tvSumOfCal.setText(String.valueOf(sum_of_cal));
        tvSumOfRed.setText(String.valueOf(sum_of_red));
        tvSumOfGreen.setText(String.valueOf(sum_of_green));
        tvSumOfYellow.setText(String.valueOf(sum_of_yellow));

        Map<String, Object> menu = new HashMap<>();
        menu.put("name", menuName);
        menu.put("price", menuPrice);
        menu.put("cal", menuCal);
        menu.put("red", menuRed);
        menu.put("green", menuGreen);
        menu.put("yellow", menuYellow);
        _resultList.add(menu);

        _lvResult = findViewById(R.id.lvResult);
        SimpleAdapter adapter = new SimpleAdapter(MenuResultActivity.this, _resultList,
                R.layout.row, FROM, TO);
        _lvResult.setAdapter(adapter);
        _lvResult.setOnItemClickListener(new ListItemClickListener());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            DeleteConfirmDialogFragment dialogFragment = new DeleteConfirmDialogFragment(parent, position);
            dialogFragment.show(getSupportFragmentManager(), "DeleteConfirmDialogFragment");
        }
    }

    public void onDialogPositiveButtonClick(AdapterView<?> parent, int position){
        Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);

        Integer menuPrice = (Integer) item.get("price");
        Double menuCal = (Double) item.get("cal");
        Double menuRed = (Double) item.get("red");
        Double menuGreen = (Double) item.get("green");
        Double menuYellow = (Double) item.get("yellow");

        sum_of_price -= menuPrice;
        sum_of_cal -= menuCal;
        sum_of_red -= menuRed;
        sum_of_green -= menuGreen;
        sum_of_yellow -= menuYellow;

        TextView tvSumOfPrice = findViewById(R.id.tvSumOfPrice);
        TextView tvSumOfCal = findViewById(R.id.tvSumOfCal);
        TextView tvSumOfRed = findViewById(R.id.tvSumOfRed);
        TextView tvSumOfGreen = findViewById(R.id.tvSumOfGreen);
        TextView tvSumOfYellow = findViewById(R.id.tvSumOfYellow);

        tvSumOfPrice.setText(String.valueOf(sum_of_price));
        tvSumOfCal.setText(String.valueOf(sum_of_cal));
        tvSumOfRed.setText(String.valueOf(sum_of_red));
        tvSumOfGreen.setText(String.valueOf(sum_of_green));
        tvSumOfYellow.setText(String.valueOf(sum_of_yellow));

        _resultList.remove(position);
        SimpleAdapter adapter = new SimpleAdapter(MenuResultActivity.this, _resultList,
                R.layout.row, FROM, TO);
        _lvResult.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        boolean returnVal = true;
        int itemId = item.getItemId();

        if(itemId == android.R.id.home){
            finish();
        } else{
            returnVal = super.onOptionsItemSelected(item);
        }

        return returnVal;
    }
}