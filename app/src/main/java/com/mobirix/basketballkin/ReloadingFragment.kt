package com.mobirix.basketballkin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mobirix.basketballkin.databinding.FragmentFakeGameBinding
import com.mobirix.basketballkin.databinding.FragmentReloadingBinding


class ReloadingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bbgbgbg = FragmentReloadingBinding.inflate(inflater, container, false)
        return nnhnhnh.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try {
            nnhnhnh.btnRestart.setOnClickListener {
                try {
                    findNavController().navigate(R.id.action_reloadingFragment_to_fakeGameFragment)
                } catch (e: Exception) {
                    Snackbar.make(
                        nnhnhnh.root,
                        "Some error, restarting...",
                        Snackbar.LENGTH_LONG
                    )
                        .show()
                }
            }
            nnhnhnh.btnImgExit.setOnClickListener {
                requireActivity().finish()
            }

        } catch (e: Exception) {
            Snackbar.make(nnhnhnh.root, "Some error, reload...", Snackbar.LENGTH_LONG)
                .show()
        }
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        bbgbgbg = null
        super.onDestroyView()
    }

    private var bbgbgbg: FragmentReloadingBinding? = null
    private val nnhnhnh
        get() = bbgbgbg ?: throw RuntimeException("FragmentReloadingBinding = null")


}