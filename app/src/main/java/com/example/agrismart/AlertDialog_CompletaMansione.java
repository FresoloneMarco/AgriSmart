package com.example.agrismart;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AlertDialog_CompletaMansione extends AppCompatDialogFragment {
    private String title;
    private String information;
    private String button1;
    private String button2;

    public AlertDialog_CompletaMansione(String title, String information, String button1, String button2){
        this.title = title;
        this.information = information;
        this.button1 = button1;
        this.button2 = button2;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(getActivity());
        if (button2.equals("")) {
            builder.setTitle(title)
                    .setMessage(information)
                    .setPositiveButton(button1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
        }else{
            builder.setTitle(title)
                    .setMessage(information)
                    .setPositiveButton(button1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setNegativeButton(button2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

        }
        return builder.create();
    }
}
