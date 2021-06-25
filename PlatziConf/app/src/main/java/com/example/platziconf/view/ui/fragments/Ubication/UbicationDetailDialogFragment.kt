package com.example.platziconf.view.ui.fragments.Ubication

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.platziconf.R
import com.example.platziconf.model.Ubication
import kotlinx.android.synthetic.main.fragment_schedule_detail_dialog.*
import kotlinx.android.synthetic.main.fragment_schedule_detail_dialog.toolbarConference
import kotlinx.android.synthetic.main.fragment_ubication_detail_dialog.*

class UbicationDetailDialogFragment : DialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ubication_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        super.onViewCreated(view, savedInstanceState)
        toolbarUbication.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_baseline_close_24)
        toolbarUbication.setTitleTextColor(Color.WHITE)
        toolbarUbication.setNavigationOnClickListener {
            dismiss()
        }

        val ubication = Ubication()
        toolbarUbication.title = ubication.name
        tvDetailUbicationName.text = ubication.name
        tvUbicationDetailDireccion.text = ubication.address
        tvUbicationDetailTelefono.text = ubication.phone
        tvUbicationDetailLink.text = ubication.website

        llTelefonoLugar.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL).apply{
                val data = Uri.parse("tel:${ubication.phone}")
            }
        }

        llSitioweb.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(ubication.website)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

}