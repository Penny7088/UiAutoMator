package penny.com.ui_auto.Base;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;

import penny.com.ui_auto.helper.SimulateDelegate;

/**
 * Created on 2017/7/6 0006.
 * by penny
 */

public interface SuperView {
    SimulateDelegate getSimulateDelegate(UiDevice pUiDevice);

    boolean equals(String a, String b);

    void pressBack();

    void click(UiObject2 o);

    void click(UiObject o);

    void sleep(int time);
}
