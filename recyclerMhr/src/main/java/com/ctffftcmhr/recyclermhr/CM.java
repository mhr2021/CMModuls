package com.ctffftcmhr.recyclermhr;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CM {

    public void checkEditText(View view, EditText editText, int type) {


        String tempText = "";
        tempText = editText.getText().toString();

        if(type==0){
            if(!TextUtils.isEmpty(tempText)) {
                Snackbar.make(view, tempText, Snackbar.LENGTH_SHORT).show();

            } else {
                editText.setError("Input  required");
                editText.requestFocus();
            }
        }else if (type==1){
            if (isEditTextContainEmail(editText)==true){
                Snackbar.make(view, tempText, Snackbar.LENGTH_SHORT).show();
            }else {
                editText.setError("Input valid email address required");
                editText.requestFocus();
            }
        }



    }
    public static boolean isEditTextContainEmail(EditText argEditText) {

        try {
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher matcher = pattern.matcher(argEditText.getText());
            return matcher.matches();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public void toast(Context context, String sms, int LENGTH) {


        if (LENGTH == 0) {
            Toast.makeText(context, sms, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, sms, Toast.LENGTH_LONG).show();
        }

    }

}
