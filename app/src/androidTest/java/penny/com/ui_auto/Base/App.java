package penny.com.ui_auto.Base;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;

/**
 * 创建日期：2017/7/5 0005 on 18:27
 * 作者:penny
 */
public abstract class App<P extends BasePresenter> {

    private static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 10;
    protected UiDevice mUIDevice;
    protected Context mContext;
    protected P mPresenter;
    protected Context mTargetContext;

    @Before
    public void setUp() throws Exception {
        mUIDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());  //获得device对象
        mContext = InstrumentationRegistry.getContext();
        mTargetContext = InstrumentationRegistry.getTargetContext();
        if (!mUIDevice.isScreenOn()) {  //唤醒屏幕
            mUIDevice.wakeUp();
        }
        mUIDevice.pressHome();  //按home键
        this.mPresenter = onCreatePresenter();
    }

    protected abstract P onCreatePresenter();

    protected UiDevice getmUIDevice() {
        return mUIDevice;
    }

    protected Context getmContext() {
        return mContext;
    }

    protected void startApp(String pkg) {
        Intent myIntent = mContext.getPackageManager().getLaunchIntentForPackage(pkg);  //启动app
        mContext.startActivity(myIntent);
        mUIDevice.waitForWindowUpdate(pkg,5000);
    }

}
