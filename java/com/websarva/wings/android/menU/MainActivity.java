package com.websarva.wings.android.menU;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView _lvMenu;
    private List<Map<String, Object>> _menulist;
    // ListViewに表示するリストデータ
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
        setContentView(R.layout.activity_main);

        _lvMenu = findViewById(R.id.lvMenu);
        _menulist = createStaplelist();
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _menulist,
                R.layout.row, FROM, TO);
        _lvMenu.setAdapter(adapter);
        _lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);

            String menuName = (String) item.get("name");
            Integer menuPrice = (Integer) item.get("price");
            Double menuCal = (Double) item.get("cal");
            Double menuRed = (Double) item.get("red");
            Double menuGreen = (Double) item.get("green");
            Double menuYellow = (Double) item.get("yellow");

            Intent intent = new Intent(MainActivity.this, MenuResultActivity.class);
            intent.putExtra("menuName", menuName);
            intent.putExtra("menuPrice", menuPrice);
            intent.putExtra("menuCal", menuCal);
            intent.putExtra("menuRed", menuRed);
            intent.putExtra("menuGreen", menuGreen);
            intent.putExtra("menuYellow", menuYellow);

            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_options_menu_list, menu);
        // オプションメニュー用.xmlファイルをinflate
        return true;
    }

    // オプションメニュー選択時処理メソッド
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        boolean returnVal = true;

        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.menuListOptionStaple:
                _menulist = createStaplelist();
                break;
            case R.id.menuListOptionsMain:
                _menulist = createMainList();
                break;
            case R.id.menuListOptionsSide:
                _menulist = createSideList();
                break;
            case R.id.menuListOptionsDessert:
                _menulist = createDessertList();
                break;
            default:
                returnVal = super.onOptionsItemSelected(item);
                break;
        }

        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, _menulist,
                R.layout.row, FROM, TO);
        _lvMenu.setAdapter(adapter);

        return returnVal;
    }

    private List<Map<String, Object>> createStaplelist(){
        List<Map<String, Object>> menulist = new ArrayList<>();

        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "ライスS");
        menu.put("price", 94);
        menu.put("cal", 0.0);
        menu.put("red", 0.0);
        menu.put("green", 0.0);
        menu.put("yellow", 0.0);
        menulist.add(menu);

        // menu = new HashMap<>();
        // menu.put("name", "ライスM");
        // menu.put("price", );
        // menu.put("cal", );
        // menu.put("red", );
        // menu.put("green", );
        // menu.put("yellow", );
        // menulist.add(menu);

        return menulist;
    }

    private List<Map<String, Object>> createMainList(){
        List<Map<String, Object>> menulist = new ArrayList<>();

        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "鯖生姜煮");
        menu.put("price", 176);
        menu.put("cal", 0.0);
        menu.put("red", 0.0);
        menu.put("green", 0.0);
        menu.put("yellow", 0.0);
        menulist.add(menu);

        return menulist;
    }

    private List<Map<String, Object>> createSideList(){
        List<Map<String, Object>> menulist = new ArrayList<>();

        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "味噌汁");
        menu.put("price", 33);
        menu.put("cal", 0.0);
        menu.put("red", 0.0);
        menu.put("green", 0.0);
        menu.put("yellow", 0.0);
        menulist.add(menu);

        menu = new HashMap<>();
        menu.put("name", "豚汁");
        menu.put("price", 110);
        menu.put("cal", 0.0);
        menu.put("red", 0.0);
        menu.put("green", 0.0);
        menu.put("yellow", 0.0);
        menulist.add(menu);

        // menu = new HashMap<>();
        // menu.put("name", "冷奴");
        // menu.put("price", 44);
        // menu.put("cal", );
        // menu.put("red", );
        // menu.put("green", );
        // menu.put("yellow", );
        // menulist.add(menu);

        // menu = new HashMap<>();
        // menu.put("name", "ポテトサラダ");
        // menu.put("price", 66);
        // menu.put("cal", );
        // menu.put("red", );
        // menu.put("green", );
        // menu.put("yellow", );
        // menulist.add(menu);

        // menu = new HashMap<>();
        // menu.put("name", "ミニサラダ");
        // menu.put("price", );
        // menu.put("cal", );
        // menu.put("red", );
        // menu.put("green", );
        // menu.put("yellow", );
        // menulist.add(menu);

        return menulist;
    }

    private List<Map<String, Object>> createDessertList(){
        List<Map<String, Object>> menulist = new ArrayList<>();

        Map<String, Object> menu = new HashMap<>();
        menu.put("name", "フルーツヨーグルト");
        menu.put("price", 110);
        menu.put("cal", 0.0);
        menu.put("red", 0.0);
        menu.put("green", 0.0);
        menu.put("yellow", 0.0);
        menulist.add(menu);

        return menulist;
    }
}