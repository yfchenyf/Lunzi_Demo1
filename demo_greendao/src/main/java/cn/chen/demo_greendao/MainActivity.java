package cn.chen.demo_greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.chen.demo_greendao.dao.DbManager;
import cn.chen.demo_greendao.entity.Normal;
import cn.chen.demo_greendao.entity.Person;
import cn.chen.demo_greendao.entity.User;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_add)
    Button btn_add;
    @BindView(R.id.btn_delete)
    Button btn_delete;
    @BindView(R.id.btn_edit)
    Button btn_edit;
    @BindView(R.id.btn_select)
    Button btn_select;
    @BindView(R.id.btn_delete_all)
    Button btn_delete_all;
    @BindView(R.id.tv_content)
    TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tv_content.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @OnClick({R.id.btn_add, R.id.btn_delete, R.id.btn_edit, R.id.btn_select, R.id.btn_delete_all})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                addUserData();
                break;
            case R.id.btn_delete:
                deleteUserData();
                break;
            case R.id.btn_edit:
                editUserData();
                break;
            case R.id.btn_select:
                selectUserData();
                break;
            case R.id.btn_delete_all:
                deleteAllUserData();
                break;
            default:
                break;
        }
    }


    private void addUserData() {
        for (int i = 0; i < 20; i++) {
            User user = new User();
            int Id = i + 1;
            user.setId(Long.valueOf(Id));
            user.setName("测试数据" + Id);
            user.setSex("测试性别" + Id);
            DbManager.getDaoSession(this).getUserDao().insertOrReplace(user);
        }
        for (int i = 0; i < 20; i++) {
            Person user = new Person();
            int Id = i + 1;
            user.setId(Long.valueOf(Id));
            user.setName("测试数据" + Id);
            DbManager.getDaoSession(this).getPersonDao().insertOrReplace(user);
        }

        for (int i = 0; i < 20; i++) {
            Normal normal = new Normal();
            int Id = i + 1;
            normal.setId(Long.valueOf(Id));
            normal.setName("测试数据" + Id);
            normal.setD(3);
            DbManager.getDaoSession(this).getNormalDao().insertOrReplace(normal);
        }
        showUserContent();
    }


    private void deleteUserData() {
        //删除第一个数据
        List<User> userList = DbManager.getDaoSession(this).getUserDao().loadAll();
        if (userList != null && userList.size() > 0) {
            DbManager.getDaoSession(this).getUserDao().deleteByKey(1L);
            showUserContent();
        } else {
            Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
        }
    }

    private void editUserData() {
        //编辑第一个数据
        List<User> userList = DbManager.getDaoSession(this).getUserDao().loadAll();
        if (userList != null && userList.size() > 0) {
            User user = new User();
            user.setId(1L);
            user.setName("修改数据");
            DbManager.getDaoSession(this).getUserDao().insertOrReplace(user);
            showUserContent();
        } else {
            Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
        }
    }

    private void selectUserData() {
        //选择第一个数据
        List<User> userList = DbManager.getDaoSession(this).getUserDao().loadAll();
        if (userList != null && userList.size() > 0) {
            User user = userList.get(0);
            showUserContent(user);
        } else {
            Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
        }
    }


    private void deleteAllUserData() {
        DbManager.getDaoSession(this).getUserDao().deleteAll();
        showUserContent();
    }

    private void showUserContent() {
        List<User> userList = DbManager.getDaoSession(this).getUserDao().loadAll();
        String content = "";
        if (userList != null) {
            for (int i = 0; i < userList.size(); i++) {
                User user = userList.get(i);
                content = content + user.toString();
            }
            tv_content.setText(content);
        } else {
            Toast.makeText(this, "没有User数据", Toast.LENGTH_SHORT).show();
        }

        List<Person> personList = DbManager.getDaoSession(this).getPersonDao().loadAll();
        if (userList != null) {
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                content = content + person.toString();
            }
            tv_content.setText(content);
        } else {
            Toast.makeText(this, "没有Person数据", Toast.LENGTH_SHORT).show();
        }
    }

    private void showUserContent(User user) {
        tv_content.setText(user.toString());
    }

}
