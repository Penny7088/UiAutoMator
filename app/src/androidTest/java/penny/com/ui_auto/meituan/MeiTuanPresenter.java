package penny.com.ui_auto.meituan;

import android.content.Context;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.StaleObjectException;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.UiWatcher;
import android.util.Log;

import org.junit.Test;

import java.util.List;

import penny.com.ui_auto.Base.BasePresenter;
import penny.com.ui_auto.global.Constans;
import penny.com.ui_auto.helper.SimulateDelegate;
import penny.com.ui_auto.util.FileUtil;

/**
 * Created on 2017/7/6 0006.
 * by penny
 */

public class MeiTuanPresenter extends BasePresenter implements MeiTuanIml {

    protected final UiDevice mUiDevice;
    private final Context mContext;
    protected SimulateDelegate mDelegate;
    private final StringBuffer mBuffer;
    private UiObject2 mListView;
    private MeiTuanApp mMeiTuanApp;

    public MeiTuanPresenter(UiDevice pUiDevice, Context pContext) {
        mUiDevice = pUiDevice;
        mBuffer = new StringBuffer();
        mContext = pContext;
        mDelegate = getSimulateDelegate(pUiDevice);
    }


    @Override
    public void enterCate() {
        UiObject lCate = mDelegate.findViewPagerChild(
                "com.sankuai.meituan:id/pager",
                "com.sankuai.meituan:id/category_layout",
                Constans.LINEAR_LAYOUT,
                "美食");
        click(lCate);
        UiObject lByRes = mDelegate.findByRes("com.sankuai.meituan:id/food_list_cover_hongbao_close");
        if (lByRes != null) {
            click(lByRes);
        }
        findCateList();
    }

    private void findCateList() {
        sleep(2000);
        mListView = mDelegate.findList();
        List<UiObject2> lChildren = mListView.getChildren();
        for (UiObject2 o : lChildren) {
            UiObject2 lUiObject2 = o.findObject(By.text("全部"));
            if (lUiObject2 != null) {
                Log.e("==", "======" + lUiObject2.getText());
                click(lUiObject2);
                sleep(1000);
                pressBack();
                try {
                    getScreenList(mDelegate.findList(), Constans.LINEAR_LAYOUT);
                } catch (StaleObjectException pE) {
                    pE.printStackTrace();
                    Log.e("error", pE.toString());
                }
                break;
            }
        }
    }

    private void getDetailInfo() {
        sleep(2000);
        Log.e("==", "getDetailInfo");
//        UiObject seach = mDelegate.findByRes("com.sankuai.meituan:id/hot_words_title");
//        if (seach != null) {
//            String lText = null;
//            try {
//                lText = seach.getText();
//            } catch (UiObjectNotFoundException pE) {
//                pE.printStackTrace();
//            }finally {
//                if (lText != null) {
//                    pressBack();
//                }
//
//                if (lText.equals("热门搜索")) {
//                    Log.e("====", "进入搜索页面");
//                    pressBack();
//                    pressBack();
//                }
//            }
//        }
//        UiObject lByRes = mDelegate.findByRes("com.sankuai.meituan:id/filter_header");
//        lByRes.
//        Log.e("===", "=======getDetailInfo========");
//        String phone = null;
//        MeiTuanEntity lEntity = new MeiTuanEntity();
//        try {
//            String shopName = mDelegate.findByRes("com.sankuai.meituan:id/title").getText();
//            String address = mDelegate.findByRes("com.sankuai.meituan:id/addr").getText();
//            Log.e("===", shopName + "==" + address);
//            UiObject phoneUI = mDelegate.findByRes("com.sankuai.meituan:id/phone");
//            click(phoneUI);
//            UiObject lphoneUI = mDelegate.findByRes("com.android.contacts:id/digits");
//            if (lphoneUI != null) {
//                phone = lphoneUI.getText();
//                Log.e("===", phone);
//            }
//            UiObject dialogUi = mDelegate.findByRes("android:id/parentPanel");
//            if (dialogUi != null) {
//                List<UiObject2> lByList = mDelegate.findByList();
//                phone = lByList.get(0) != null ? lByList.get(0).getText() : "";
//                String mobile = lByList.get(1) != null ? lByList.get(1).getText() : "";
//            }
//            pressBack();
//            pressBack();
//            lEntity.setAddress(address);
//            lEntity.setPhone(phone);
//            lEntity.setShopName(shopName);
//            mBuffer.append(lEntity.toString() + "\n");
//        } catch (UiObjectNotFoundException pE) {
//            pE.printStackTrace();
//            Log.e("=====", "getDetailInfo is error");
//        }
    }


    @Override
    public void loopEnd() {
//        boolean lIsWrite = FileUtil.writeFile(mBuffer.toString());
//        if (lIsWrite) {
//            Log.e("data", "===" + "已写入，开始滑动");
            mListView.scroll(Direction.DOWN, 1.1f, 500);
//            mListView.scroll(Direction.DOWN,1.2f,500);

            UiObject2 lList = mDelegate.findList();
            getScreenList(lList, Constans.LINEAR_LAYOUT);
//        List<UiObject2> lChildren = lList.getChildren();
//        Log.e("loop", "list" + lList.getChildCount());
//        for (UiObject2 o : lChildren) {
//            UiObject2 lObject = o.findObject(By.res("com.sankuai.meituan:id/poi_layout"));
//            if (lObject == null) {
//                Log.e("ppp", "poi_layout is null ");
//            } else {
//                Log.e("ppp", "poi_layout not null ");
//                click(lObject);
//                pressBack();
//                    getDetailInfo();
//            }
//                int lChildCount = o.getChildCount();
//                List<UiObject2> lChildren1 = o.getChildren();
//                UiObject2 lParent = o.getParent();
//                String lParentClassName = lParent.getClassName();
//                String oClassName = o.getClassName();
//                Log.e("ppp", "count:--" + lChildCount);
//                Log.e("ppp", "className:--" + oClassName);
//                Log.e("ppp", "parentClassName:--" + lParentClassName);
//                if (lParentClassName.equals("android.widget.ListView")) {
//                    click(o);
//                    pressBack();
//                }
//        }
//            Log.e("loop","list"+lChildren.toString());

//        }

    }

    @Override
    protected void layoutEquals(int pLayout, UiObject2 pO) {
        if (super.LIST_HAVE == pLayout) {
            click(pO);
            getDetailInfo();
        } else if (super.LIST_NO == pLayout) {

        }
    }
}
