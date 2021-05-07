package com.example.listviewsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvMenu = findViewById(R.id.lvMenu);
        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }

    //
    private class ListItemClickListener implements AdapterView.OnItemClickListener{//AdapterViewのメンバインターフェースであるOnItemClickListener。
        @Override
        public void onItemClick(AdapterView<?>parent, View view,int position,long id){//onItemClickメソッドの実装
            /*　メモ
                AdapterViewクラス は、ListViewやSpinnerの親クラス
                int position は、タップされた行番号。　例)「唐揚げ定食」＝０、「ハンバーグ定食」＝１
                long id は、SimpleCursorAdapterを利用する場合、DBの主なキー値。それ以外は第3引数のpositionと同じ値が渡される。
             */

            String item = (String)parent.getItemAtPosition(position);//タップされた定食名を取得
            String show ="あなたが選んだ定食"+item;
            Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();//今回はToastで表示
        }
    }
}