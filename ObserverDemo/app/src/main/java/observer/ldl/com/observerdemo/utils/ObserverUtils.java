package observer.ldl.com.observerdemo.utils;

import observer.ldl.com.observerdemo.base.Observable;
import observer.ldl.com.observerdemo.base.Observer;
import observer.ldl.com.observerdemo.imp.ObservableImpl;

/**
 * Created by ${ldl} on 2016/12/16.
 */
public class ObserverUtils<T> {
    private Observable mObservable;
    private static ObserverUtils mInstance=null;

    private ObserverUtils(){
        mObservable=new ObservableImpl();
    }
    public static ObserverUtils getInstance(){
        if(mInstance==null){
            synchronized (ObserverUtils.class){
                if(mInstance==null)
                    mInstance=new ObserverUtils();

            }
        }
    return mInstance;
    }

    /**
     * 注册监听
     * @param observer
     */
    public void registObserver(Observer observer){
        mObservable.addObserver(observer);
    }

    /**
     *反注册
     * @param observer
     */
    public void unRegistObserver(Observer observer){
        mObservable.deleteObserver(observer);

    }
    /**
     * 发送消息通知
     * @param obj
     * @param flag
     */
    public void notifyMessage(T obj,int flag){
        mObservable.notifyObserver(obj,flag);
    }
}
