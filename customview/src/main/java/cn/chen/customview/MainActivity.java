package cn.chen.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import cn.chen.customview.widget.FoldTextView;
import cn.chen.customview.widget.SpannableFoldTextView;

public class MainActivity extends AppCompatActivity {
    private SpannableFoldTextView spanTV1,spanTV2;
    private FoldTextView foldTV1,foldTV2;
    private FrameLayout fl1,fl2;
    private String mString = "测试测试测试测试1234567890测试测试测试测试1234567890测试测试测试测试1234567890测试测试测试测试1234567890测试测试测试测试1234567890测试测试测试测试1234567890测试测试测试测试1234567890测试测试测试测试1234567890测试测试测试测试1234567890测试测试测试测试1234567890测试测试测试测试1234567890测试测试测试测试1234567890";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewAndData();
    }

    private void initViewAndData() {
        spanTV1 = findViewById(R.id.spanTV1);
        spanTV2 = findViewById(R.id.spanTV2);
        foldTV1 = findViewById(R.id.foldTV1);
        foldTV2 = findViewById(R.id.foldTV2);
        spanTV1.setText(mString);
        spanTV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "textview点击事件", Toast.LENGTH_SHORT).show();
            }
        });
        spanTV2.setText(mString);
        spanTV2.setParentClick(true);
        fl1 = findViewById(R.id.parent1);
        fl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "父view点击事件", Toast.LENGTH_SHORT).show();
            }
        });
        foldTV1.setText(mString);
        foldTV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "textview点击事件", Toast.LENGTH_SHORT).show();
            }
        });
        fl2 = findViewById(R.id.parent3);
        foldTV2.setText(mString);
        fl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "父view点击事件", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
