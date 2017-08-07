package penny.com.ui_auto.meituan;

import android.util.Log;
import org.junit.Test;
import penny.com.ui_auto.Base.App;
import penny.com.ui_auto.global.Constans;

/**
 * Created on 2017/7/6 0006.
 * by penny
 */

public class MeiTuanApp extends App {

    public MeiTuanIml mMeiTuanIml;
    private MeiTuanPresenter mPresenter;

    @Test
    public void start() {
        Log.e("===start===","============");
        startApp(Constans.APP_PKG_MRITUAN);
        mPresenter.enterCate();
    }

    @Override
    protected MeiTuanPresenter onCreatePresenter() {
        Log.e("===onCreatePresenter===","============");
        return mPresenter == null ?
                mPresenter = new MeiTuanPresenter(getmUIDevice(),getmContext()) :
                mPresenter;
    }
}
