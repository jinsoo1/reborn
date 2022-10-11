package com.reborn.reborn.ui.view.assessment.rehab

import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentCodeBinding
import com.reborn.reborn.databinding.FragmentSpotLocationBinding
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.util.EventObserver
import org.koin.android.viewmodel.ext.android.sharedViewModel

class SpotLocationFragment : BaseVmFragment<FragmentSpotLocationBinding>(
    R.layout.fragment_spot_location,
    SpotLocationViewModel::class.java
) {

    override val viewModel by lazy { vm as SpotLocationViewModel }
    private val activityViewModel by sharedViewModel<AssessmentViewModel>()


    override fun initFragment() {

        locationViewPager()

        viewModel.setObserves()
    }

    //'목'
    private val neckList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)
    }
    //어깨
    private val sholderList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)

    }
    //가슴
    private val chestList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)
    }
    //복부
    private val abdomenList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)
    }
    //위팔
    private val topArmList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)
    }
    //팔꿈치
    private val elbowList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)
    }
    //아래팔
    private val lowArmList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)

    }
    //손목
    private val wristList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)

    }
    //등
    private val backList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)

    }
    //허리
    private val waistList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)

    }
    //엉덩이
    private val hipList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)

    }
    //윗다리
    private val topLegList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)

    }
    //무릎
    private val kneeList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)

    }
    //아랫다리
    private val lowLegList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)

    }
    //발목
    private val ankleList = mutableListOf<Int>().apply {
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)
        add(R.drawable.test_img)
    }

    private val textList = mutableListOf<String>().apply {
        add("전면")
        add("후면")
        add("왼쪽 전면")
        add("오른쪽 전면")
        add("왼쪽 후면")
        add("오른쪽 후면")
        add("왼쪽")
        add("오른쪽")
        add("왼쪽")
        add("오른쪽")
        add("왼쪽 전면")
        add("오른쪽 전면")
        add("왼쪽 후면")
        add("오른쪽 후면")
        add("왼쪽")
        add("오른쪽")
        add("왼쪽 전면")
        add("오른쪽 전면")
        add("왼쪽 후면")
        add("오른쪽 후면")
        add("왼쪽")
        add("오른쪽")
        add("왼쪽")
        add("오른쪽")
        add("왼쪽")
        add("오른쪽")
        add("왼쪽 전면")
        add("오른쪽 전면")
        add("왼쪽 후면")
        add("오른쪽 후면")
        add("왼쪽 전면")
        add("오른쪽 전면")
        add("왼쪽 후면")
        add("오른쪽 후면")
        add("왼쪽 전면")
        add("오른쪽 전면")
        add("왼쪽 후면")
        add("오른쪽 후면")
        add("왼쪽 전면")
        add("오른쪽 전면")
        add("왼쪽 후면")
        add("오른쪽 후면")
    }

    private fun locationViewPager(){
        binding.locationPager.apply {
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 1
            if(activityViewModel.spotData.value == "목"){
                adapter = ViewPager2Adapter(requireActivity(), neckList)
            } else if (activityViewModel.spotData.value == "어깨"){}
            else if (activityViewModel.spotData.value == "가슴"){}
            else if (activityViewModel.spotData.value == "복부"){}
            else if (activityViewModel.spotData.value == "위팔"){}
            else if (activityViewModel.spotData.value == "팔꿈치"){}
            else if (activityViewModel.spotData.value == "아래팔"){}
            else if (activityViewModel.spotData.value == "손목"){}
            else if (activityViewModel.spotData.value == "등"){}
            else if (activityViewModel.spotData.value == "허리"){}
            else if (activityViewModel.spotData.value == "엉덩이"){}
            else if (activityViewModel.spotData.value == "윗다리"){}
            else if (activityViewModel.spotData.value == "무릎"){}
            else if (activityViewModel.spotData.value == "아랫다리"){}
            else{//발목

            }


        }
        binding.locationPager.setPageTransformer(MarginPageTransformer(50))
        mainViewChangeEvent()
    }

    private fun mainViewChangeEvent(){
        binding.locationPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                binding.indicatorText.text = textList[position]
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                //1,2,3

                if(position == 2 || position ==3 || position ==4 || position ==5){
                    binding.btn1.visibility = View.VISIBLE
                    binding.btn2.visibility = View.VISIBLE
                    binding.btn3.visibility = View.VISIBLE
                    binding.btn4.visibility = View.INVISIBLE
                    binding.btn5.visibility = View.INVISIBLE
                    binding.btn6.visibility = View.INVISIBLE
                    binding.btn7.visibility = View.INVISIBLE
                    binding.btn8.visibility = View.INVISIBLE

                    Log.d("테스트", "포지션 : "+position)

                }

                //1,2,3,4
                else if(position == 0 || position ==10 || position ==11 || position ==12 || position ==13 || position ==14 || position ==15 || position ==18 || position ==19
                    || position ==22 || position ==23 || position ==24 || position ==25  || position ==36 || position ==36 || position ==37 || position ==40 || position ==41){
                    binding.btn1.visibility = View.VISIBLE
                    binding.btn2.visibility = View.VISIBLE
                    binding.btn3.visibility = View.VISIBLE
                    binding.btn4.visibility = View.VISIBLE
                    binding.btn5.visibility = View.INVISIBLE
                    binding.btn6.visibility = View.INVISIBLE
                    binding.btn7.visibility = View.INVISIBLE
                    binding.btn8.visibility = View.INVISIBLE
                    Log.d("테스트", "포지션 : "+position)

                }

                //1,2,3,4,5
                else if(position == 1 || position ==6 || position ==7 || position ==8 || position ==9 || position ==34 || position ==35 || position ==38 || position ==39){
                    binding.btn1.visibility = View.VISIBLE
                    binding.btn2.visibility = View.VISIBLE
                    binding.btn3.visibility = View.VISIBLE
                    binding.btn4.visibility = View.VISIBLE
                    binding.btn5.visibility = View.VISIBLE
                    binding.btn6.visibility = View.INVISIBLE
                    binding.btn7.visibility = View.INVISIBLE
                    binding.btn8.visibility = View.INVISIBLE
                    Log.d("테스트", "포지션 : "+position)

                }

                //1,2,3,4,5,6
                else if(position == 21 || position ==22 || position ==33 || position ==34){
                    binding.btn1.visibility = View.VISIBLE
                    binding.btn2.visibility = View.VISIBLE
                    binding.btn3.visibility = View.VISIBLE
                    binding.btn4.visibility = View.VISIBLE
                    binding.btn5.visibility = View.VISIBLE
                    binding.btn6.visibility = View.VISIBLE
                    binding.btn7.visibility = View.INVISIBLE
                    binding.btn8.visibility = View.INVISIBLE
                    Log.d("테스트", "포지션 : "+position)

                }

                //1,2,3,4,5,6,7
                else if(position == 16 || position ==17){
                    binding.btn1.visibility = View.VISIBLE
                    binding.btn2.visibility = View.VISIBLE
                    binding.btn3.visibility = View.VISIBLE
                    binding.btn4.visibility = View.VISIBLE
                    binding.btn5.visibility = View.VISIBLE
                    binding.btn6.visibility = View.VISIBLE
                    binding.btn7.visibility = View.VISIBLE
                    binding.btn8.visibility = View.INVISIBLE
                    Log.d("테스트", "포지션 : "+position)

                }
                //1,2,3,4,5,6,7,8
                else {
                    binding.btn1.visibility = View.VISIBLE
                    binding.btn2.visibility = View.VISIBLE
                    binding.btn3.visibility = View.VISIBLE
                    binding.btn4.visibility = View.VISIBLE
                    binding.btn5.visibility = View.VISIBLE
                    binding.btn6.visibility = View.VISIBLE
                    binding.btn7.visibility = View.VISIBLE
                    binding.btn8.visibility = View.VISIBLE
                    Log.d("테스트", "포지션 : "+position.toString())
                }
            }
        })
    }

    fun SpotLocationViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                SpotLocationViewModel.LocationActions.PREV -> {
                    activityViewModel.locationPrev()
                }
                SpotLocationViewModel.LocationActions.STOP -> {
                    activityViewModel.finish()
                }
            }
        })

        clickAction.observe(viewLifecycleOwner, Observer {
            val action = SpotLocationFragmentDirections.actionSpotLocationFragmentToStaticFragment()
            findNavController().navigate(action)

        })
    }
}