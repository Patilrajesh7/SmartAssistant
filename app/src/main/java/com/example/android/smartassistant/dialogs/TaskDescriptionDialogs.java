package com.example.android.smartassistant.dialogs;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.android.smartassistant.R;

public class TaskDescriptionDialogs extends AppCompatDialogFragment {

    private EditText mDesc;
    private DescriptionDailogListner listner;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder  = new AlertDialog.Builder(getActivity(),R.style.DescDialogeTheme);
        View root = getActivity().getLayoutInflater().inflate(R.layout.create_task_desc_dailog,null);

        mDesc = root.findViewById(R.id.dai_et_desc);

        builder.setView(root)
                .setTitle("Task Description")
                .setPositiveButton("Ok", (dialogInterface , i) -> {
                    String desc = mDesc.getText().toString().trim();
                    listner.getDesc(desc);

                })
                .setNegativeButton("Cancel",((dialogInterface, i) -> {

                }));


         return builder.create();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listner = (DescriptionDailogListner) context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString()+" must Implement ClassCastListner");
        }
    }

    public interface DescriptionDailogListner {
        void getDesc(String desc);
    }

}
