package com.websarva.wings.android.menU;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.AdapterView;

import androidx.fragment.app.DialogFragment;

public class DeleteConfirmDialogFragment extends DialogFragment {
    private AdapterView<?> _parent;
    private int _positon;

    DeleteConfirmDialogFragment(AdapterView<?> parent, int position){
        super();

        _parent = parent;
        _positon = position;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInterfaceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_msg);
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        builder.setNegativeButton(R.string.dialog_byn_ng, new DialogButtonClickListener());

        AlertDialog dialog = builder.create();
        return dialog;
    }

    public class DialogButtonClickListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which){
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    MenuResultActivity activity = (MenuResultActivity) getActivity();
                    activity.onDialogPositiveButtonClick(_parent, _positon);
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                default: break;
            }
        }
    }
}
