package com.example.platziconf.view.ui.fragments.Speakers

import android.app.Dialog
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
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.platziconf.R
import com.example.platziconf.model.Conference
import com.example.platziconf.model.Speaker
import kotlinx.android.synthetic.main.fragment_schedule_detail_dialog.*
import kotlinx.android.synthetic.main.fragment_speakers_detail_dialog.*
import java.text.SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SpeakersDetailDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpeakersDetailDialogFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_speakers_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbarSpeaker.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_baseline_close_24_white)

        toolbarSpeaker.setTitleTextColor(Color.WHITE)
        toolbarSpeaker.setNavigationOnClickListener {
            dismiss()
        }

        val speaker = arguments?.getSerializable("speaker") as Speaker
        toolbarSpeaker.title = speaker.name
        tvDetailSpeakerName.text = speaker.name
        tvDetailSpeakerBiography.text = speaker.biography
        tvDetailSpeakerJobtitle.text = speaker.jobtitle
        tvDetailSpeakerWorkplace.text = speaker.workplace

        Glide.with(ivDetailSpeakerImage.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(ivDetailSpeakerImage)

        ivDetailSpeakerTwitter.setOnClickListener{
            val url = speaker.twitter
            val uri = Uri.parse("https://twitter.com/"+url)
            val launchBrowser = Intent(Intent.ACTION_VIEW, uri)
            startActivity(launchBrowser)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SpeakersDetailDialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SpeakersDetailDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}