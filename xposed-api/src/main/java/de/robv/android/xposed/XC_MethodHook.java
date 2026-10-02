package de.robv.android.xposed;

import java.lang.reflect.Member;

import de.robv.android.xposed.callbacks.XCallback;

public abstract class XC_MethodHook extends XCallback {
    public XC_MethodHook() {}

    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {}

    protected void afterHookedMethod(MethodHookParam param) throws Throwable {}

    public static final class MethodHookParam extends XCallback.Param {
        public Member method;
        public Object thisObject;
        public Object[] args;

        public Object getResult() {
            throw new UnsupportedOperationException("Stub!");
        }

        public void setResult(Object result) {
            throw new UnsupportedOperationException("Stub!");
        }
    }

    public class Unhook {
        public void unhook() {
            throw new UnsupportedOperationException("Stub!");
        }
    }
}
