package observer.ldl.com.observerdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;

import observer.ldl.com.observerdemo.activity.SecondActivity;
import observer.ldl.com.observerdemo.base.Observer;
import observer.ldl.com.observerdemo.imp.ObserverImpl;
import observer.ldl.com.observerdemo.utils.ObserverUtils;

public class MainActivity extends AppCompatActivity{

    private TextView mTvShowData;
private Handler handler=new MyHandler(this);
    private Observer mObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvShowData = (TextView) findViewById(R.id.tv_showData);
        mObserver = new ObserverImpl(handler);
        ObserverUtils.getInstance().registObserver(mObserver);
    }
     class MyHandler extends Handler{
        WeakReference<Activity> mActivityReference;
        MyHandler(Activity activity){
            mActivityReference=new WeakReference<Activity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
                mTvShowData.setText(msg.obj.toString());

        }
    }

    public void btnJump(View v){
        Intent intent=new Intent(this,SecondActivity.class);
        startActivity(intent);
//        intent.setAction()
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ObserverUtils.getInstance().unRegistObserver(mObserver);
    }
}
