package com.example.mvvmnote.utils

import android.content.Context
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object MessageCallback {
    fun makeToast(context: Context,message:String) {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }
    fun makeMaterialDialog(context: Context,
                           title:String,
                           dialogMessage:String,
                           message: String,
                           positiveButtonText:String,
                           negativeButtonText:String,
                           callback: MaterialDialogCallback
                           ) {
        MaterialAlertDialogBuilder(context)
            .setTitle(title)
            .setMessage(dialogMessage)
            .setPositiveButton(positiveButtonText) {_,_->
                callback.positivetask()
                makeToast(context,message)
            }
            .setNegativeButton(negativeButtonText) {_,_->

            }
            .show()

    }
}