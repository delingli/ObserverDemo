package observer.ldl.com.observerdemo.imp;

import java.util.ArrayList;
import java.util.List;

import observer.ldl.com.observerdemo.base.Observable;
import observer.ldl.com.observerdemo.base.Observer;

/**
 * Created by ${ldl} on 2016/12/16.
 */
public class ObservableImpl implements Observable{
    /**
     * 存放观察者数据
     */
    private List<Observer> mObserver=new ArrayList<>();
    @Override
    public void addObserver(Observer observer) {
    synchronized (ObservableImpl.class){
        if(null==observer)
            throw new NullPointerException("Observable is null");
        if(!mObserver.contains(observer))
            mObserver.add(observer);
    }
    }

    @Override
    public void deleteObserver(Observer observer) {
      synchronized (ObservableImpl.class){
       if(mObserver!=null&&mObserver.size()>0){
        mObserver.remove(observer);
    }
}
    }

    @Override
    public void notifyObserver(Object obj, int flag) {
        if(mObserver!=null&&mObserver.size()>0){
            for(Observer obs:mObserver){
                obs.reseiveMes(obj,flag);
            }
        }
    }

//    @Override
//    public void notifyObserver(T obj, int flag) {
//
//    }
}
