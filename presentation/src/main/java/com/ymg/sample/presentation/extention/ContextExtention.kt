package com.ymg.sample.presentation.extention

import android.content.Context
import android.content.DialogInterface
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.ymg.sample.presentation.R



fun Context.toast(msg : String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun Context.errorToast(msg : String?) {
    Toast.makeText(this, msg ?: getString(R.string.toast_error_unknown), Toast.LENGTH_SHORT).show()
}

fun Context.alert(
    message: String,
    positiveListener: DialogInterface.OnClickListener?,
    negativeListener: DialogInterface.OnClickListener?
) {
    AlertDialog.Builder(this, R.style.PopupTheme)
        .setMessage(message)
        .setPositiveButton(android.R.string.ok, positiveListener)
        .setNegativeButton(android.R.string.cancel, negativeListener)
        .setCancelable(false)
        .create()
        .show()
}
