package com.ctffftcmhr.demorecyclerview;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomMethord {

    public void checkEditText(View view, EditText editText,int type) {


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

    ////////////////recycler_view firebase get data request ---start----//////////////////////////////


/*database.getReference().child("charts").orderByChild("timestamp").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            list.clear();
            for(DataSnapshot dataSnapshot : snapshot.getChildren() ){
                messagesesModel models = dataSnapshot.getValue(messagesesModel.class);
                list.add(models);


            }
            Adapter.notifyDataSetChanged();
            addNotification();
            Toast.makeText(sms.this, "New sms Found", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {



        }
    });
    */


    ///////////////////////////////////recycler_view firebase get data request ---end----////////////////////////////


}
