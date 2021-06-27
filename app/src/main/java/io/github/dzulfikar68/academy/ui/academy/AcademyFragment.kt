package io.github.dzulfikar68.academy.ui.academy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.dzulfikar68.academy.databinding.FragmentAcademyBinding
import io.github.dzulfikar68.academy.utils.DataDummy
import io.github.dzulfikar68.academy.viewmodel.ViewModelFactory

class AcademyFragment : Fragment() {

    private lateinit var fragmentAcademyBinding: FragmentAcademyBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentAcademyBinding = FragmentAcademyBinding.inflate(layoutInflater, container, false)
        return fragmentAcademyBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[AcademyViewModel::class.java]

            val academyAdapter = AcademyAdapter()

            fragmentAcademyBinding.progressBar.visibility = View.VISIBLE
            viewModel.getCourses().observe(requireActivity(), { courses ->
                fragmentAcademyBinding.progressBar.visibility = View.GONE
                academyAdapter.setCourses(courses)
                academyAdapter.notifyDataSetChanged()
            })

            with(fragmentAcademyBinding.rvAcademy) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = academyAdapter
            }
        }
    }

}