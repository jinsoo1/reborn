package com.reborn.reborn.ui.view.main

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.databinding.ActivityMainBinding
import com.reborn.reborn.ui.view.main.search.SearchResultActivity
import com.reborn.reborn.util.EventObserver
import com.reborn.reborn.util.KeepStateNavigator
import org.jetbrains.anko.intentFor

class MainActivity : BaseVmActivity<ActivityMainBinding>(
    R.layout.activity_main,
    MainViewModel::class.java
) {
    override val viewModel: MainViewModel by lazy { vm as MainViewModel }



    override val toolbarId: Int = 0

    var waitTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager.findFragmentById(binding.navHost.id) as NavHostFragment
        val navController = navHostFragment.navController

        val navigator = KeepStateNavigator(this, navHostFragment.childFragmentManager, binding.navHost.id)
        navController.navigatorProvider.addNavigator(navigator)

        navController.setGraph(R.navigation.nav_graph)

        binding.navBottom.setupWithNavController(navController)

        binding.imageviewSdsd.setOnClickListener {
            startActivity(
                intentFor<SearchResultActivity>()
            )
            overridePendingTransition(R.anim.fadein,R.anim.fadeout)
        }


    }

    override fun initActivity() {

        viewModel.setObserves()



        val keyHash = Utility.getKeyHash(this)
        Log.d("HASH!", keyHash)

    }

    private fun MainViewModel.setObserves(){

        action.observe(this@MainActivity, EventObserver{
            when(it){
                MainViewModel.MainAction.HOME ->{
                    binding.navBottom.menu.getItem(0).isChecked = true
                }
            }
        })

    }


//    override fun onBackPressed() {
//
//        if(System.currentTimeMillis() - waitTime >= 2000){
//            waitTime = System.currentTimeMillis();
//            toast("한번더 누르면 종료됩니다.")
//
//        } else if(System.currentTimeMillis() - waitTime < 2000 ){
//
//            finish();
//        }
//
//    }
}