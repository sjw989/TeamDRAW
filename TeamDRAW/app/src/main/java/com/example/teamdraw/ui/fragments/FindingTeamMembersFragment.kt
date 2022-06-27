package com.example.teamdraw.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.teamdraw.databinding.FragmentFindingTeamMembersBinding
import com.example.teamdraw.adapters.RecruitRVAdapter
import com.example.teamdraw.adapters.WantingRVAdapter
import com.example.teamdraw.ui.dialog.RecruitingDialog
import com.example.teamdraw.ui.dialog.RecruitingDialogInterface

class FindingTeamMembersFragment : Fragment(), RecruitingDialogInterface {

    private lateinit var binding: FragmentFindingTeamMembersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFindingTeamMembersBinding.inflate(
            inflater,
            container,
            false
        )

        val recruitAdapter = RecruitRVAdapter(object : RecruitRVAdapter.ItemClickListener {
            override fun onClick() {


                val dialog = RecruitingDialog(this@FindingTeamMembersFragment, "패키지 삭제?", 0)
                dialog.show(activity?.supportFragmentManager!!, "Confirm")
            }
        })
        val wantingAdapter = WantingRVAdapter(object : WantingRVAdapter.ItemClickListener {
            override fun onClick() {
                findNavController().navigate(FindingTeamMembersFragmentDirections.actionFindingTeamMembersFragmentToUserProfileFragment())
            }
        })
        recruitAdapter.setList(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        wantingAdapter.setList(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
        binding.apply {
            with(recruitRv) {
                adapter = recruitAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
            with(wantingRv1) {
                adapter = wantingAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
            iv1.setOnClickListener {
                findNavController().navigate(FindingTeamMembersFragmentDirections.actionFindingTeamMembersFragmentToWantingTeamFragment())
            }
            iv2.setOnClickListener {
                findNavController().navigate(FindingTeamMembersFragmentDirections.actionFindingTeamMembersFragmentToWriteRecruitingFragment())
            }
        }

        return binding.root
    }

    override fun onYesButtonClick(id: Int) {

    }
}