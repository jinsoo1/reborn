package com.reborn.reborn.ui.view.main.search

import androidx.lifecycle.Observer
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.base.BaseVmActivity
import com.reborn.reborn.data.common.model.MainSearch
import com.reborn.reborn.databinding.ActivitySearchresultBinding
import com.reborn.reborn.databinding.ItemSearchListBinding
import com.reborn.reborn.ui.view.main.search.related.disease.DiseaseActivity
import com.reborn.reborn.ui.view.main.search.related.exercise.ExerciseActivity
import org.jetbrains.anko.intentFor


class SearchResultActivity : BaseVmActivity<ActivitySearchresultBinding>(
    R.layout.activity_searchresult,
    SearchResultViewModel::class.java
){
    override val viewModel by lazy { vm as SearchResultViewModel }
    override val toolbarId = 0

    val searchState : Boolean by lazy {
        intent.getBooleanExtra("searchState", false)
    }

    val searchData : String? by lazy {
        intent.getStringExtra("searchData")
    }

    val selectToken : String? by lazy {
        intent.getStringExtra("selectToken")
    }

    val selectType : String? by lazy {
        intent.getStringExtra("selectType")
    }

    override fun initActivity() {

        viewModel._searchState.value = searchState
        viewModel._searchData.value = searchData
        viewModel._selectToken.value = selectToken
        viewModel._selectType.value = selectType



        if(searchState){
            if(selectType == "exercise"){
                startActivity(
                    intentFor<ExerciseActivity>(
                        "title" to searchData,
                        "token" to selectToken
                    )
                )
            }else{
                startActivity(
                    intentFor<DiseaseActivity>(
                        "title" to searchData,
                        "token" to selectToken
                    )
                )
            }

        }

        binding.apply {
            rvExercise.apply {
                adapter = RelatedAdapter(viewModel)
            }
            rvDisease.apply {
                adapter = RelatedAdapter(viewModel)
            }
        }

        viewModel.setObserves()

    }

    private fun SearchResultViewModel.setObserves(){

        searchData.observe(this@SearchResultActivity, Observer {
            searchData()
        })

        selectItem.observe(this@SearchResultActivity, Observer {
            if(it.type == "exercise"){
                startActivity(
                    intentFor<ExerciseActivity>(
                        "title" to it.title,
                        "token" to it.token
                    )
                )
            }else{
                startActivity(
                    intentFor<DiseaseActivity>(
                        "title" to it.title,
                        "token" to it.token
                    )
                )
            }
        })

    }

}

class RelatedAdapter(vm : SearchResultViewModel) : BaseRecyclerAdapter<MainSearch, ItemSearchListBinding>(
    R.layout.item_search_list, vm
)