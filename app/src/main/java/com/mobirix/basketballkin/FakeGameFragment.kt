package com.mobirix.basketballkin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mobirix.basketballkin.databinding.FragmentFakeGameBinding


class FakeGameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bbgbgbg = FragmentFakeGameBinding.inflate(inflater, container, false)
        return nnhnhnh.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try {
            nnhnhnh.btnPlayGameeee.setOnClickListener {
                try {
                    findNavController().navigate(R.id.action_fakeGameFragment_to_itIsGameFragment)
                } catch (e: Exception) {
                    Snackbar.make(
                        nnhnhnh.root,
                        "Some error, restarting...",
                        Snackbar.LENGTH_LONG
                    )
                        .show()
                }
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

    private var bbgbgbg: FragmentFakeGameBinding? = null
    private val nnhnhnh
        get() = bbgbgbg ?: throw RuntimeException("FragmentFakeGameBinding = null")


}