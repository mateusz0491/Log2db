package app.badsoft.android.log2db.sample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.badsoft.android.log2db.entityservice.LogService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnInfo)
    Button btnInfo;
    @BindView(R.id.btnDebug)
    Button btnDebug;
    @BindView(R.id.btnError)
    Button btnError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        LogService.init(getApplicationContext());
    }

    @OnClick(R.id.btnInfo)
    public void onClickBtnInfo(View v) {
        LogService.i("Hello info");
    }

    @OnClick(R.id.btnDebug)
    public void onClickBtnDebug(View v) {
        LogService.d("Hello debug");
    }

    @OnClick(R.id.btnError)
    public void onClickBtnError(View v) {
        LogService.e("EXC123456", new NullPointerException());
    }
}
