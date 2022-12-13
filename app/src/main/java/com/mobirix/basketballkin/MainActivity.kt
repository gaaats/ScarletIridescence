package com.mobirix.basketballkin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.mobirix.basketballkin.DataStoreManager.Companion.advertIDDataStoreKey
import com.mobirix.basketballkin.utiiils.Constance
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
@ActivityScoped
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var dataManager: DataStoreManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        getAdId()


    }

    private fun getAdId(){
        Log.d("lolo", "in getAdId before")

        val advertising = AdvertisingIdClient(applicationContext)
        advertising.start()
        val advertID = advertising.info.id?: Constance.KEY_NO_DATA

        Log.d("lolo", "after advertising.start()")

        lifecycleScope.launch {
            dataManager.saveStringToDataStore(key = advertIDDataStoreKey, advertID)
        }

    }
}