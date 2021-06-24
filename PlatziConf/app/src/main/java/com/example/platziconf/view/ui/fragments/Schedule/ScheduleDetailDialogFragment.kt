package com.example.platziconf.view.ui.fragments.Schedule

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.platziconf.R
import com.example.platziconf.model.Conference
import kotlinx.android.synthetic.main.fragment_schedule_detail_dialog.*
import kotlinx.android.synthetic.main.item_schedule.*
import java.text.SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ScheduleDetailDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScheduleDetailDialogFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)

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
        return inflater.inflate(R.layout.fragment_schedule_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarConference.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_baseline_close_24)
        toolbarConference.setTitleTextColor(Color.WHITE)
        toolbarConference.setNavigationOnClickListener {
            dismiss()
        }

        val conference = arguments?.getSerializable("conference") as Conference
        toolbarConference.title = conference.title
        tvDetailConferenceTitulo.text = conference.title

        val pattern = "dd//MM/yyyy hh:mm a"
        val simpleDF = SimpleDateFormat(pattern)
        val date = simpleDF.format(conference.datetime)
        tvDetailConferenceHour.text = date

        tvDetailConferenceSpeaker.text = conference.speaker
        tvDetailConferenceTag.text = conference.tag
        tvDetailConferenceDescription.text = conference.description


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ScheduleDetailDialogFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ScheduleDetailDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}