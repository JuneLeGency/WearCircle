package june.legency.wearmenu;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.TextView;

import june.legency.wearmenu.view.CircleLayout;

public class MainActivity extends Activity {

    private String[] mItemTexts = new String[]{"安全中心 ", "特色服务", "投资理财",
            "转账汇款", "我的账户", "信用卡"};
    private int[] mItemImgs = new int[]{R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,};
    private CircleLayout mCircleMenuLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mCircleMenuLayout = (CircleLayout) stub.findViewById(R.id.id_menulayout);
                mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);
                mCircleMenuLayout.setC(new CircleLayout.CurrentItem() {
                    @Override
                    public void setCurrentItem(View v) {
                        TextView t = (TextView) mCircleMenuLayout.findViewById(R.id.currentItem);
                        t.setText(((TextView)v.findViewById(R.id.id_circle_menu_item_text)).getText());
                    }
                });
            }
        });
    }
}
