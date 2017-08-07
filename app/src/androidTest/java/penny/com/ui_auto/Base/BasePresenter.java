package penny.com.ui_auto.Base;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.EventCondition;
import android.support.test.uiautomator.StaleObjectException;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.Until;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

import penny.com.ui_auto.helper.SimulateDelegate;

/**
 * Created on 2017/7/6 0006.
 * by penny
 */

public abstract class BasePresenter implements SuperView {

    private UiDevice mUiDevice;
    protected static final int LIST_HAVE = 0x02;
    protected static final int LIST_NO = 0x01;

    @Override
    public SimulateDelegate getSimulateDelegate(UiDevice pUiDevice) {
        mUiDevice = pUiDevice;
        return SimulateDelegate.getInstance(pUiDevice);
    }

    @Override
    public boolean equals(String a, String b) {
        if (TextUtils.equals(a, b)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void pressBack() {
        sleep(500);
        mUiDevice.pressBack();
    }

    @Override
    public void click(UiObject2 o) {
        sleep(1000);
        try {
            o.click();
        } catch (StaleObjectException pE) {
            pE.printStackTrace();
            Log.e("error", pE.toString());
        }
    }

    @Override
    public void click(UiObject o) {
        try {
            o.clickAndWaitForNewWindow();
        } catch (UiObjectNotFoundException pE) {
            pE.printStackTrace();
        }
    }

    @Override
    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException pE) {
            pE.printStackTrace();
        }
    }

    protected void getScreenList(UiObject2 pUiObject2, String layout) throws StaleObjectException {
        if (pUiObject2 != null) {
            List<UiObject2> lChildren = pUiObject2.getChildren();
            if (lChildren != null && lChildren.size() > 0) {
                Log.e("===", "ooo" + lChildren.size());
                for (UiObject2 o : lChildren) {
                    if (layout != null) {
                        String lClassName = o.getClassName();
                        int lCount = o.getChildCount();
                        Log.e("===", lClassName + "==count:" + lCount);
                        if (lClassName.equals(layout) && lCount == 4) {
                            UiObject2 lObject = o.findObject(By.res("com.sankuai.meituan:id/poi_layout"));
                            if (lObject != null) {
                                layoutEquals(LIST_HAVE, lObject);
                            }
                        }
                    } else {
                        layoutEquals(LIST_NO, o);
                    }
                }
                //do something
                loopEnd();
                Log.e("===", "getScreenList 循环结束");
            }
        }
    }

    protected abstract void loopEnd();

    protected abstract void layoutEquals(int pLayout, UiObject2 pO);
}
