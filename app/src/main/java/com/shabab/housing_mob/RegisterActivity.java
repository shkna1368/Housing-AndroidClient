package com.shabab.housing_mob;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.shabab.housing_mob.model.User;
import com.shabab.housing_mob.services.RegisterService;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

public class RegisterActivity extends Activity {
Button btnRigester;
    EditText textName,textCity,textPhone;

RegisterService registerService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRigester= (Button) findViewById(R.id.btnRegister);
     textName= (EditText) findViewById(R.id.editText);
     textCity= (EditText) findViewById(R.id.editText2);
     textPhone= (EditText) findViewById(R.id.editText3);
        registerService=new RegisterService(this);

btnRigester.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
callWebServiceRegister();
    }
});
    }

    public void callWebServiceRegister(){
        String name=textName.getText().toString();
        String city=textCity.getText().toString();
        String phone=textPhone.getText().toString();

        User user=new User();
        user.setName(name);
        user.setCity(city);

        user.setPhone(phone);

        try {
            registerService.sendToServer(user);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
