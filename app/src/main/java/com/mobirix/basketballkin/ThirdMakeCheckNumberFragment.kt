package com.mobirix.basketballkin

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.mobirix.basketballkin.DataStoreManager.Companion.appsCheckerDataStoreKey
import com.mobirix.basketballkin.DataStoreManager.Companion.firstStartDataStoreKey
import com.mobirix.basketballkin.DataStoreManager.Companion.namingDataStoreKey
import com.mobirix.basketballkin.databinding.FragmentThirdMakeCheckNumberBinding
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
class ThirdMakeCheckNumberFragment : Fragment() {

    var temNaming = "loading"

    @Inject
    lateinit var dataManager: DataStoreManager

    private var _binding: FragmentThirdMakeCheckNumberBinding? = null
    private val binding
        get() = _binding ?: throw RuntimeException("FragmentThirdMakeCheckNumberBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdMakeCheckNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Log.d("lolo", "three frag")

        try {

            lifecycleScope.launch {
                val isAppsLaunched =
                    dataManager.readStringFromDataStore(key = appsCheckerDataStoreKey)
                        ?: Constance.KEY_NO_DATA

                Log.d("lolo", "isAppsLaunched $isAppsLaunched")

                when (isAppsLaunched) {
                    "yes" -> {
                        Log.d("lolo", "i am in branch Apps YES")
                        launchApps()
                    }
                    "no" -> {
                        findNavController().navigate(R.id.action_thirdMakeCheckNumberFragment_to_fourMakeGeoCheckFragment)

                    }
                    Constance.KEY_NO_DATA -> {
                        findNavController().navigate(R.id.action_thirdMakeCheckNumberFragment_to_fakeGameFragment)
                    }

                }

            }


        } catch (e: Exception) {
            detdefdfe()
        }
        super.onViewCreated(view, savedInstanceState)
    }

    private suspend fun launchApps() {
        Log.d("lolo", "launchApps")
        initAppsFlyerLibeer(context = requireActivity())

        val preNaming = dataManager.readStringFromDataStore(namingDataStoreKey)

        while (true) {
            if (temNaming != "loading") {
                delay(1000)
                Log.d("lolo", "temNaming not null")
                withContext(Dispatchers.IO) {
                    Snackbar.make(
                        binding.root, "naming != null $preNaming",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                if (preNaming == null) {
                    dataManager.saveStringToDataStore(key = namingDataStoreKey, value = temNaming)
                }
                delay(500)
                findNavController().navigate(R.id.action_thirdMakeCheckNumberFragment_to_fourMakeGeoCheckFragment)
                break
            } else {
                withContext(Dispatchers.Main) {
                    Snackbar.make(
                        binding.root, "naming null in delay",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                delay(1000)
            }
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun kpkpkpkp() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Current data will not be saved, EXIT?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().onBackPressed()
            }
            .setNegativeButton("No") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }


    private fun detdefdfe() {
        Snackbar.make(
            binding.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        Log.d("lolo", "catch exception in ThirdMakeCheckNumberFragment")
        requireActivity().finish()
    }

    private fun initAppsFlyerLibeer(context: Context) {
        AppsFlyerLib.getInstance()
            .init(Constance.KEY_APPS_ID, conversionDataListener, context)
        Log.d("lolo", "initAppsFlyerLibeer")
        AppsFlyerLib.getInstance().start(context)
    }

    private val conversionDataListener = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            Log.d("lolo", "onConversionDataSuccess before loading")
            val dataGotten = data?.get("campaign").toString().apply {
                temNaming = this
                Log.d("lolo", "onConversionDataSuccess")

//                lifecycleScope.launch {
//                    val preNamingg = dataManager.readStringFromDataStore(key = namingDataStoreKey)
//                    if (preNamingg == null) {
//                        dataManager.saveStringToDataStore(
//                            key = namingDataStoreKey,
//                            value = this@apply
//                        )
//                    }
//                }
            }


        }

        override fun onConversionDataFail(p0: String?) {
            Log.d("lolo", "onConversionDataFail")

            Snackbar.make(
                binding.root, "onConversionDataFail",
                Snackbar.LENGTH_SHORT
            ).show()

        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
            Log.d("lolo", "onAppOpenAttribution")
        }

        override fun onAttributionFailure(p0: String?) {
            Log.d("lolo", "onAttributionFailure")
        }
    }


}