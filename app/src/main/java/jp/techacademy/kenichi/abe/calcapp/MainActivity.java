package jp.techacademy.kenichi.abe.calcapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {   //入力データチェック
        String str1 = mEditText1.getText().toString();
        String str2 = mEditText2.getText().toString();
        try {
            Double a = Double.parseDouble(str1);
            Double b = Double.parseDouble(str2);
            calc(v,a,b);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "有効なデータではありません", Toast.LENGTH_LONG).show();
        }
    }

    private void calc(View v, double a, double b){
        Double calcResult=0.0;
        switch ( v.getId() ){        //演算処理
            case R.id.button1:  calcResult=a+b;  break;
            case R.id.button2:  calcResult=a-b;  break;
            case R.id.button3:  calcResult=a*b;  break;
            case R.id.button4:  calcResult=a/b;  break;
        }
        Intent intent = new Intent(this, SecondActivity.class);//画面遷移
        intent.putExtra("VALUE", calcResult);
        startActivity(intent);
    }
}
