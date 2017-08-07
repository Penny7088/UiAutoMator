package penny.com.ui_auto.helper;

import android.support.test.uiautomator.By;
import android.support.test.uiautomator.BySelector;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

/**
 * Created by penny on 2017/7/6 0006.
 */

public class SimulateDelegate implements Delegate {
    public static final String TAG = "SimulateDelegate";

    private static UiDevice mDevice;

    private static class SingletonHolder {
        private static SimulateDelegate sInstance = new SimulateDelegate();
    }

    private SimulateDelegate() {

    }

    public static SimulateDelegate getInstance(UiDevice device) {
        mDevice = device;
        return SingletonHolder.sInstance;
    }

    @Override
    public UiObject findByText(UiObject pGrandson, String text) {
        UiObject lUiObject = null;
        try {
            lUiObject = pGrandson.getChild(new UiSelector().text(text));
        } catch (UiObjectNotFoundException pE) {
            pE.printStackTrace();
        }
        return lUiObject;
    }

    @Override
    public List<UiObject2> findByList() {
        UiObject2 lObject = mDevice.findObject(By.clazz(ListView.class));
        List<UiObject2> lObjects = lObject.findObjects(By.clazz(View.class));
        return lObjects;
    }

    @Override
    public UiObject2 findList() {
        UiObject2 lObject = mDevice.findObject(By.clazz(ListView.class));
        return lObject;
    }

    @Override
    public UiObject2 findByHierarchies(int hieeratchies) {
        UiObject2 ui = mDevice.findObject(By.depth(hieeratchies));
        return ui;
    }

    @Override
    public UiObject findByRes(String res) {
        UiObject lUiObject = mDevice.findObject(new UiSelector().resourceId(res));
        return lUiObject;
    }

    @Override
    public List<UiObject2> findViewGronpL() {
        UiObject2 viewGrounp = mDevice.findObject(By.clazz(ViewGroup.class));
        List<UiObject2> ViewG = viewGrounp.findObjects(By.clazz(LinearLayout.class));
        return ViewG;
    }

    @Override
    public UiObject2 findByRes2(UiObject2 u ,String res) {
        UiObject2 lObject = u.findObject(By.res(res));
        return lObject;
    }

    @Override
    public UiObject findViewPagerChild(String parent,String child,String grandson,String text) {
        UiObject lGrandson = null;
        try {
            UiObject lSuperView = findByRes(parent);
            UiObject lChild = lSuperView.getChild(new UiSelector().resourceId(child));
            lGrandson = lChild.getChild(new UiSelector().className(grandson));
            UiObject lObject = findByText(lGrandson, text);
            return lObject;
        } catch (UiObjectNotFoundException pE) {
            pE.printStackTrace();
            return null;
        } finally {
            return findByText(lGrandson, text);
        }
    }

}
