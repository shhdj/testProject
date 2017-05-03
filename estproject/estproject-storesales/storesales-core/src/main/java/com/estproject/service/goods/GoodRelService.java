package com.estproject.service.goods;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shhdj on 2017/3/19.
 */
public class GoodRelService {

    public static void main(String[] args){
        long mil = System.currentTimeMillis();
        List<GoodRelVO> voList = new LinkedList();
        GoodRelVO vo = new GoodRelVO();
        for(int i=0;i<500;i++){

            GoodRelVO tmp = vo.clone();
            tmp.setBaseCode("343");
            tmp.setSubCode("34");
            voList.add(tmp);
        }
        long mil2 = System.currentTimeMillis();
        System.out.println("=================================="+(mil2-mil));
    }
}
