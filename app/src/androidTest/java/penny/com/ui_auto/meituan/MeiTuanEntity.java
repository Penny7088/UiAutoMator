package penny.com.ui_auto.meituan;

import penny.com.ui_auto.Base.BaseEntity;

/**
 * Created on 2017/7/8 0008.
 * by penny
 */

public class MeiTuanEntity extends BaseEntity{
    String address;
    String shopName;
    String phone;
    String mobile;

    public String getAddress() {
        return address;
    }

    public void setAddress(String pAddress) {
        address = pAddress;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String pShopName) {
        shopName = pShopName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String pPhone) {
        phone = pPhone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String pMobile) {
        mobile = pMobile;
    }

    @Override
    public String toString() {
        return "MeiTuanEntity{" +
                "address='" + address + '\'' +
                ", shopName='" + shopName + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
