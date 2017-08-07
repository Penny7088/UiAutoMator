package penny.com.ui_auto.helper;

import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;

import java.util.List;

/**
 * Created on 2017/7/6 0006.
 * by penny
 */

public interface Delegate {

    UiObject findByText(UiObject pGrandson, String text) throws UiObjectNotFoundException;

    UiObject findViewPagerChild(String parent, String child, String grandson, String Text);

    List<UiObject2> findByList();

    UiObject2 findList();

    UiObject2 findByHierarchies(int hieeratchies);

    UiObject findByRes(String res);

    List<UiObject2> findViewGronpL();

    UiObject2 findByRes2(UiObject2 u ,String res);

}
