package com.alejandrolora.finalapp.dialogues

import android.support.v7.app.AlertDialog
import android.support.v4.app.DialogFragment

import android.app.Dialog
import android.os.Bundle
import com.alejandrolora.finalapp.R
import com.alejandrolora.finalapp.models.NewRateEvent
import com.alejandrolora.finalapp.models.Rate
import com.alejandrolora.finalapp.toast
import com.alejandrolora.finalapp.utils.RxBus
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.dialog_rate.view.*
import java.util.*

class RateDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val view = activity!!.layoutInflater.inflate(R.layout.dialog_rate, null)

        return AlertDialog.Builder(context!!)
                .setTitle(getString(R.string.dialog_title))
                .setView(view)
                .setPositiveButton(getString(R.string.dialog_ok)) { _, _ ->
                    val textRate = view.editTextRateFeedback.text.toString()
                    if (textRate.isNotEmpty()) {
                        val imgURL = FirebaseAuth.getInstance().currentUser!!.photoUrl?.toString() ?: run { "" }
                        val rate = Rate(textRate, view.ratingBarFeedback.rating, Date(), imgURL)
                        RxBus.publish(NewRateEvent(rate))
                    }
                }
                .setNegativeButton(getString(R.string.dialog_cancel)) { _, _ ->
                    activity!!.toast("Pressed Cancel")
                }
                .create()
    }

}