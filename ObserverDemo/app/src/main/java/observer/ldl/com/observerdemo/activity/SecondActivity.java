package observer.ldl.com.observerdemo.activity;

import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import observer.ldl.com.observerdemo.R;
import observer.ldl.com.observerdemo.utils.ObserverUtils;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final EditText et_context = (EditText) findViewById(R.id.et_context);
        Button btn_test = (Button) findViewById(R.id.btn_test);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(et_context.getText().toString())){
                    Toast.makeText(SecondActivity.this,"",Toast.LENGTH_LONG).show();
                    return;
                }
                ObserverUtils.getInstance().notifyMessage(et_context.getText().toString(),0);
                finish();
            }
        });
    }
}
