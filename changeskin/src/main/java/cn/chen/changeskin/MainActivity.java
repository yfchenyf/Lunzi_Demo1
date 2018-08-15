package cn.chen.changeskin;

import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import skin.support.SkinCompatManager;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_default_skin)
    Button btnDefaultSkin;
    @BindView(R.id.btn_night_skin)
    Button btnNightSkin;
    private final static String SKIN_DEFAULT = "default", SKIN_NIGHT = "changeskin_skin_black.skin";
    @BindView(R.id.cl_view)
    ConstraintLayout clView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_default_skin, R.id.btn_night_skin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_default_skin:
                //默认皮肤
                changeSkinApk(SKIN_DEFAULT);
                break;
            case R.id.btn_night_skin:
                //夜间模式
                changeSkinApk(SKIN_NIGHT);
                break;
            default:
                break;
        }

    }

    private void changeSkinApk(final String skinTheme) {
        if (skinTheme == null) {
            return;
        }
        if (SKIN_DEFAULT.equals(skinTheme)) {
            SkinCompatManager.getInstance().restoreDefaultTheme();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    SkinCompatManager.getInstance().loadSkin(skinTheme, new SkinCompatManager.SkinLoaderListener() {
                        @Override
                        public void onStart() {

                        }

                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onFailed(String errMsg) {

                        }
                    }, SkinCompatManager.SKIN_LOADER_STRATEGY_ASSETS);
                }
            }, 70);
        }

    }
}
