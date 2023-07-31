package com.example.bmicalculators003;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
public class Dialog extends DialogFragment{
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("警告");
        builder.setMessage("適切な肥満度を求めるには、6歳未満の場合はカウブ指数が、6歳から15歳まではローレル指数が使われます。本アプリはBMIのみに対応しています");
        builder.setPositiveButton("確認", new DiaLogButtonClickListener());
        AlertDialog dialog = builder.create();
        return dialog;
    }
    private class DiaLogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            String msg = "確認しました。";
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
