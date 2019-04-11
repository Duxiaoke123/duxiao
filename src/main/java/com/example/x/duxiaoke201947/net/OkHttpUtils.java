package com.example.x.duxiaoke201947.net;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/**
 * @Author：x
 * @E-mail：
 * @Date：2019/4/7 14:12
 * @Description：描述信息
 */

public class OkHttpUtils {

    private int HTTP_SUCCESS=1000;

    private int HTTP_FAIL=1001;

    private HttpListener mHttpListener;



    public OkHttpUtils get(String url) {
        doHttp(url, 0,null);
        return this;
    }

    public OkHttpUtils post(String url,FormBody.Builder bodyBuilder) {
        doHttp(url, 1,bodyBuilder);
        return this;
    }

    //网络请求
    private void doHttp(String url, int i,FormBody.Builder bodyBuilder) {
        OkHttpClient client = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        builder.url(url);
        if (i == 0) {
            builder.get();
        } else {
            RequestBody body=bodyBuilder.build();
            builder.post(body);
        }
        Request request = builder.build();

       final Message message=Message.obtain();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                message.what=HTTP_FAIL;
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                message.obj=response.body().string();
                message.what=HTTP_SUCCESS;
                handler.sendMessage(message);
            }
        });
    }

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==HTTP_SUCCESS){
                String data= (String) msg.obj;
                mHttpListener.success(data);
            }else{
                mHttpListener.fail();
            }
        }
    };


    //通过方法传递接口
    public void result(HttpListener mHttpListener){
        this.mHttpListener=mHttpListener;
    }


    public interface HttpListener{
        void success(String data);
        void fail();
    }

}
