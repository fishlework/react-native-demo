package com.reatnativedemo;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import javax.annotation.Nonnull;

public class DebugModule extends ReactContextBaseJavaModule {

    private static final String NAME ="DebugModule";

    public DebugModule(@Nonnull ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Nonnull
    @Override
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void reloadJs(){
        getCurrentActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MainApplication.getReactApplication().getReactNativeHost().getReactInstanceManager().getDevSupportManager().handleReloadJS();
            }
        });

    }

    @ReactMethod
    public void log(){
        Log.i("DebugModule","hello world");
    }
}
