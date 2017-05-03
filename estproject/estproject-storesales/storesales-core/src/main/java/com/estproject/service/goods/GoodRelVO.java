package com.estproject.service.goods;

import java.io.Serializable;

/**
 * Created by shhdj on 2017/3/19.
 */
public class GoodRelVO implements Serializable,Cloneable{

    private String baseCode;

    private String subCode;

    @Override
    public GoodRelVO clone()  {
        GoodRelVO grv = null;
        try {
            grv = (GoodRelVO) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return grv;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }
}
