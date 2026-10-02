package de.robv.android.xposed;

public abstract class XC_MethodReplacement extends XC_MethodHook {
    public static final XC_MethodReplacement DO_NOTHING = null;

    public XC_MethodReplacement() {}

    protected abstract Object replaceHookedMethod(MethodHookParam param) throws Throwable;

    public static XC_MethodReplacement returnConstant(Object result) {
        throw new UnsupportedOperationException("Stub!");
    }
}
