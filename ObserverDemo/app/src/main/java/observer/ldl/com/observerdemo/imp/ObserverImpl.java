package observer.ldl.com.observerdemo.imp;


import android.os.Handler;
import android.os.Message;

import observer.ldl.com.observerdemo.MainActivity;
import observer.ldl.com.observerdemo.base.Observer;

/**
 * Created by ${ldl} on 2016/12/16.
 */
public class ObserverImpl implements Observer {
    private Handler handler;
    public ObserverImpl(Handler handler){
        this.handler=handler;
    }



    @Override
    public void reseiveMes(Object obj, int flag) {
        Message mess=Message.obtain();
        mess.obj=obj;
        handler.sendMessage(mess);



    }
}
