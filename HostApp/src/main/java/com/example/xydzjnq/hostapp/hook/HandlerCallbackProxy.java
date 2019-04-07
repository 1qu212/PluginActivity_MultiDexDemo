package com.example.xydzjnq.hostapp.hook;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.example.xydzjnq.hostapp.util.RefInvoke;

public class HandlerCallbackProxy implements Handler.Callback {

    Handler mHandler;

    public HandlerCallbackProxy(Handler handler) {
        mHandler = handler;
    }

    @Override
    public boolean handleMessage(Message msg) {

        switch (msg.what) {
            // ActivityThread里面 "LAUNCH_ACTIVITY" 这个字段的值是100
            // 本来使用反射的方式获取最好, 这里为了简便直接使用硬编码
            case 100:
                handleLaunchActivity(msg);
                break;
        }

        mHandler.handleMessage(msg);
        return true;
    }

    private void handleLaunchActivity(Message msg) {
        // 这里简单起见,直接取出TargetActivity;

        Object obj = msg.obj;

        // 把替身恢复成真身
        Intent raw = (Intent) RefInvoke.getFieldObject(obj, "intent");

        Intent target = raw.getParcelableExtra(HookHelper.EXTRA_TARGET_INTENT);
        raw.setComponent(target.getComponent());
    }
}