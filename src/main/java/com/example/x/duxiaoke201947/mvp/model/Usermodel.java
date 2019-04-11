package com.example.x.duxiaoke201947.mvp.model;

/**
 * @Author：x
 * @E-mail：
 * @Date：2019/4/7 14:23
 * @Description：描述信息
 */
public interface Usermodel {
    interface Callbaselisenter{
        void success(String url,String data);
        void fail(String url,String data);

    }
   void doshopcall(String url,String data,Callbaselisenter callbaselisenter);


}

