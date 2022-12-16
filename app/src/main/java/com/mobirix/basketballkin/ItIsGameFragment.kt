package com.mobirix.basketballkin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mobirix.basketballkin.databinding.FragmentItIsGameBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ItIsGameFragment : Fragment() {
    var sum = 0

    private var vfvfvf: FragmentItIsGameBinding? = null
    private val juujju
        get() = vfvfvf ?: throw RuntimeException("FragmentItIsGameBinding = null")

    val totto =
        "In Egyptian society, religion was central to everyday life. One of the roles of the king was as an intermediary between the deities and the people. The king thus was deputised for the deities in a role that was both as civil and religious administrator. The king owned all of the land in Egypt, enacted laws, collected taxes, and defended Egypt from invaders as the commander-in-chief of the army.[8] Religiously, the king officiated over religious ceremonies and chose the sites of new temples. The king was responsible for maintaining Maat (mꜣꜥt), or cosmic order, balance, and justice, and part of this included going to war when necessary to defend the country or attacking others when it was believed that this would contribute to Maat, such as to obtain resources."

    val liiist by lazy {
        listOf(
            ContextCompat.getDrawable(requireActivity(), R.drawable.el1),
            ContextCompat.getDrawable(requireActivity(), R.drawable.coiin),
        ).shuffled()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        vfvfvf = FragmentItIsGameBinding.inflate(inflater, container, false)
        return juujju.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            amkfkrfrf()
            juujju.btnElem8888.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem9999.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem10000.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem13333.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem122222.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }


            if (totto == "555") {
                Snackbar.make(
                    juujju.root,
                    totto,
                    Snackbar.LENGTH_LONG
                ).show()
            }

            juujju.root.background.alpha = 230



            juujju.btnElem11111.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem2222.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem33333.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem4444.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem55555.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem66666.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem77777.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem1444.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }
            juujju.btnElem1555.setOnClickListener {
                it.visibility = View.GONE
                polskks()
            }


        } catch (e: Exception) {
            afrhgthUygt()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun amkfkrfrf() {
        juujju.btnElem11111.setImageDrawable(liiist.random())
        juujju.btnElem2222.setImageDrawable(liiist.random())
        juujju.btnElem33333.setImageDrawable(liiist.random())
        juujju.btnElem4444.setImageDrawable(liiist.random())
        juujju.btnElem55555.setImageDrawable(liiist.random())
        juujju.btnElem66666.setImageDrawable(liiist.random())
        juujju.btnElem77777.setImageDrawable(liiist.random())
        juujju.btnElem8888.setImageDrawable(liiist.random())
        juujju.btnElem9999.setImageDrawable(liiist.random())
        juujju.btnElem10000.setImageDrawable(liiist.random())
        juujju.btnElem122222.setImageDrawable(liiist.random())
        juujju.btnElem13333.setImageDrawable(liiist.random())
        juujju.btnElem1444.setImageDrawable(liiist.random())
        juujju.btnElem1555.setImageDrawable(liiist.random())
    }


    override fun onDestroy() {
        vfvfvf = null
        super.onDestroy()
    }

    private fun afrhgthUygt() {
        Snackbar.make(
            juujju.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }


    private fun slonny(imageView: ImageView) {
        lifecycleScope.launch {
            while (true) {
                var ismsms = bgbgbbg
                var gtjitji = plfr
                imageView.alpha = ismsms
                if (ismsms >= 1f) {
                    gtjitji = -0.05f
                }
                if (ismsms <= 0.1f) {
                    gtjitji = 0.05f
                }
                delay(30)
                ismsms += gtjitji
            }
        }
    }

    private fun isisKfjr(imageView: ImageView): Boolean {
        if (imageView.visibility == View.GONE) {
            return true
        }
        return false
    }

    override fun onPause() {
        onDestroy()
        super.onPause()
    }

    private fun polskks() {
        sum += 1
        val ggttg = "COLLECTED: $sum"
        juujju.tvSum.text = ggttg

        if (isisKfjr(juujju.btnElem11111) && isisKfjr(juujju.btnElem2222) && isisKfjr(
                juujju.btnElem33333
            ) && isisKfjr(juujju.btnElem4444) && isisKfjr(juujju.btnElem55555) && isisKfjr(
                juujju.btnElem66666
            ) && isisKfjr(juujju.btnElem77777) && isisKfjr(juujju.btnElem8888) && isisKfjr(
                juujju.btnElem9999
            ) && isisKfjr(juujju.btnElem10000) && isisKfjr(juujju.btnElem13333) && isisKfjr(
                juujju.btnElem122222
            )&& isisKfjr(juujju.btnElem1444) && isisKfjr(juujju.btnElem1555)
        ) {
            findNavController().navigate(R.id.action_itIsGameFragment_to_gameTvooooFragment)
        }
    }

    private fun alalalet() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Exit, realy?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().finish()
            }
            .setNegativeButton("Deny") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }

    var bgbgbbg = 0.8f
    var plfr = 0.05f

}