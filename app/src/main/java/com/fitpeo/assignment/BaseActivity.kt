package com.fitpeo.assignment

import android.app.Dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import androidx.activity.ComponentActivity
import com.fitpeo.R
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
abstract class BaseActivity :ComponentActivity() {
    private lateinit var pActivity:BaseActivity
    private  var dialog: Dialog? =null

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         pActivity=this
     }


    open fun showAppDialog() {
        dismissAppDialog()
        // AppLogs.getInstance().e(AppLogs.APP_NETWORK_LOG, "show activity_holiday_destinationlist " + pActivity);
        if (!pActivity.isFinishing) {
            if (dialog == null) {
                dialog = Dialog(pActivity, R.style.DialogSlide)

                dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
                if (dialog?.window != null) {
                    dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                }
                dialog?.setContentView(R.layout.show_dialog_gif)
                dialog?.setCancelable(false)
            }
            dialog?.show()
        }
    }

    open fun dismissAppDialog() {
        try {
            //   AppLogs.getInstance().e(AppLogs.APP_NETWORK_LOG, "dismiss activity_holiday_destinationlist " + pActivity);
            if (!pActivity.isFinishing) {
                if (dialog != null) {
                    dialog?.dismiss()
                    dialog?.cancel()
                }
            }
            dialog = null
        } catch (e: Exception) {
            Timber.e(e)
        }
    }






}