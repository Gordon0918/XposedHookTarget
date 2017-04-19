package com.example.xposedhooktarget;

import android.util.Log;

/**
 * Created by xlzh on 2017/4/11.
 */

abstract class Animal{
    int anonymoutInt = 500;
    public abstract void eatFunc(String value);
}

public class HookDemo {
    private String Tag = "HookDemo";
    private static  int staticInt = 100;
    public  int publicInt = 200;
    private int privateInt = 300;

    public HookDemo(){
        this("NOHook");
        Log.d(Tag, "HookDemo() was called|||");
    }

    private HookDemo(String str){
        Log.d(Tag, "HookDemo(String str) was called|||" + str);
    }

    public void hookDemoTest(){
        Log.d(Tag, "staticInt = " + staticInt);
        Log.d(Tag, "PublicInt = " + publicInt);
        Log.d(Tag, "privateInt = " + privateInt);
        publicFunc("NOHook");
        Log.d(Tag, "PublicInt = " + publicInt);
        Log.d(Tag, "privateInt = " + privateInt);
        privateFunc("NOHook");
        staticPrivateFunc("NOHook");

        String[][] str = new String[1][2];
        Map map = new HashMap<String, String>();
        map.put("key", "value");
        ArrayList arrayList = new ArrayList();
        arrayList.add("listValue");
        complexParameterFunc("NOHook", str, map, arrayList);

        repleaceFunc();
        anonymousInner(new Animal() {
            @Override
            public void eatFunc(String value) {
                Log.d(Tag, "eatFunc(String value)  was called|||" + value);
                Log.d(Tag, "anonymoutInt =  " + anonymoutInt);
            }
        }, "NOHook");

        InnerClass innerClass = new InnerClass();
        innerClass.InnerFunc("NOHook");
    }

    public void publicFunc(String value){
        Log.d(Tag, "publicFunc(String value) was called|||" + value);
    }

    private void privateFunc(String value){
        Log.d(Tag, "privateFunc(String value) was called|||" + value);
    }

    static private void staticPrivateFunc(String value){
        Log.d("HookDemo", "staticPrivateFunc(Strin value) was called|||" + value);
    }

    private void complexParameterFunc(String value, String[][] str, Map<String,String> map, ArrayList arrayList)
    {
        Log.d("HookDemo", "complexParameter(Strin value) was called|||" + value);
    }

    private void repleaceFunc(){
        Log.d(Tag, "repleaceFunc will be replace|||");
    }

    public void anonymousInner(Animal dog, String value){
        Log.d(Tag, "anonymousInner was called|||" + value);
        dog.eatFunc("NOHook");
    }

    private void hideFunc(String value){
        Log.d(Tag, "hideFunc was called|||" + value);
    }

    class InnerClass{
        public int innerPublicInt = 10;
        private int innerPrivateInt = 20;
        public InnerClass(){
            Log.d(Tag, "InnerClass constructed func was called");
        }
        public void InnerFunc(String value){
            Log.d(Tag, "InnerFunc(String value) was called|||" + value);
            Log.d(Tag, "innerPublicInt = " + innerPublicInt);
            Log.d(Tag, "innerPrivateInt = " + innerPrivateInt);
        }
    }
}

