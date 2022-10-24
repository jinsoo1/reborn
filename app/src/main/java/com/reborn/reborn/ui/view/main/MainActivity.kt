package com.reborn.reborn.ui.view.main

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.kakao.sdk.common.util.Utility
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.data.common.model.MainSearch
import com.reborn.reborn.databinding.ActivityMainBinding
import com.reborn.reborn.databinding.ItemSearchResultBinding
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
            if(viewModel.searchQuery.value!!.isNotEmpty()){
                startActivity(
                    intentFor<SearchResultActivity>(
                        "searchState" to false,
                        "searchData" to viewModel.searchQuery.value
                    )
                )
            }
            overridePendingTransition(R.anim.fadein,R.anim.fadeout)
        }


    }

    override fun initActivity() {

        binding.apply {
            rvSearch.apply {
                adapter = SearchAdapter(viewModel)
            }
        }

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

        searchQuery.observe(this@MainActivity, Observer {
            if(it.isNotEmpty()){
                mainSearch()
            }else{
                searchGone()
            }
        })

        selectItem.observe(this@MainActivity, Observer {
            startActivity(
                intentFor<SearchResultActivity>(
                    "searchState" to true,
                    "searchData" to it.title,
                    "selectToken" to it.token,
                    "selectType" to it.type
                )
            )
        })

    }
}


class SearchAdapter(vm : MainViewModel) : BaseRecyclerAdapter<MainSearch, ItemSearchResultBinding>(
    R.layout.item_search_result, vm
)
