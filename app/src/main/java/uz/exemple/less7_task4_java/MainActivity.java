package uz.exemple.less7_task4_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et_userName;
    EditText et_password;
    Button btn_confirm;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        et_userName = findViewById(R.id.et_userName);
        et_password = findViewById(R.id.et_password);
        btn_confirm = findViewById(R.id.btn_confirm);
        textView = findViewById(R.id.textview);

        et_userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String userNameInput = et_userName.getText().toString().trim();
                if(!userNameInput.isEmpty() ){
                    et_password.setEnabled(true);
                }else{
                    et_password.setEnabled(false);
                    btn_confirm.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String passwordInput = s.toString().trim();
                if( !passwordInput.isEmpty()){
                    btn_confirm.setEnabled(true);
                }else {
                    btn_confirm.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String abc = et_password.getText().toString().trim();
                if(!abc.isEmpty()){
                    textView.setText(abc);
                }else {
                    textView.setText("OnKeyListener");
                }
                return false;
            }
        });
    }

}