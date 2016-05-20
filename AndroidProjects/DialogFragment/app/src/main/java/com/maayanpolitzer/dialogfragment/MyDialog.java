package com.maayanpolitzer.dialogfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by maayanpolitzer on 20/05/2016.
 */
public class MyDialog extends DialogFragment {

    Context context;
    OnDialogCloseListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        
        //      get data from activity...
        Bundle bundle = getArguments();
        String title = bundle.getString(MainActivity.TITLE);
        builder.setTitle(title);

        //      display custom view...
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_my, null, false);
        builder.setView(view);

        final EditText usernameEditText = (EditText) view.findViewById(R.id.dialog_my_username_edit_text);
        final EditText passwordEditText = (EditText) view.findViewById(R.id.dialog_my_password_edit_text);
        Button loginButton = (Button) view.findViewById(R.id.dialog_my_login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                listener.onClose(username, password);   // send data back to activity by listener interface.
                dismiss();      //      close the dialog
            }
        });

        /*
        //      display android build in design...
        builder.setMessage("message");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // close dialog by default...
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // close dialog by default...
            }
        });
        */

        return builder.create();
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        this.context = context;
        listener = (OnDialogCloseListener) context;
    }
}
