package com.reborn.reborn.ui.view.assessment.rehab

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.reborn.reborn.R
import com.reborn.reborn.base.BaseRecyclerAdapter
import com.reborn.reborn.base.BaseVmFragment
import com.reborn.reborn.databinding.FragmentSpotLocationBinding
import com.reborn.reborn.databinding.ItemSpotLocationListBinding
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.util.EventObserver
import kotlinx.android.synthetic.main.item_spot_location_list.view.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class SpotLocationFragment : BaseVmFragment<FragmentSpotLocationBinding>(
    R.layout.fragment_spot_location,
    SpotLocationViewModel::class.java
) {

    override val viewModel by lazy { vm as SpotLocationViewModel }
    private val activityViewModel by sharedViewModel<AssessmentViewModel>()


    override fun initFragment() {

        activityViewModel.spotData.value.apply {
            when(this!!){
                "N" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("A", 4, R.drawable.n_a),
                    SpotLocation("P", 5, R.drawable.n_p)
                ) }
                "S" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("LA", 3, R.drawable.s_la),
                    SpotLocation("RA", 3, R.drawable.s_ra),
                    SpotLocation("LP", 3, R.drawable.s_lp),
                    SpotLocation("RP", 3, R.drawable.s_rp)
                ) }
                "P" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("L", 5, R.drawable.p_l),
                    SpotLocation("R", 5, R.drawable.p_r)
                ) }
                "AB" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("L", 5, R.drawable.ab_l),
                    SpotLocation("R", 5, R.drawable.ab_r)
                ) }
                "UA" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("LA", 4, R.drawable.ua_la),
                    SpotLocation("RA", 4, R.drawable.ua_ra)
//                    ,
//                    SpotLocation("LP", 4, R.drawable.ua_lp),
//                    SpotLocation("RP", 4, R.drawable.ua_rp)
                ) }
                "E" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("L", 4, R.drawable.e_l),
                    SpotLocation("R", 4, R.drawable.e_r)
                ) }
                "LA" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("LA", 7, R.drawable.la_la),
                    SpotLocation("RA", 7, R.drawable.la_ra),
                    SpotLocation("LP", 4, R.drawable.la_lp),
                    SpotLocation("RP", 4, R.drawable.la_rp)
                ) }
                "B" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("L", 6, R.drawable.b_l),
                    SpotLocation("R", 6, R.drawable.b_r)
                ) }
                "LB" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("L", 4, R.drawable.lb_l),
                    SpotLocation("R", 4, R.drawable.lb_r)
                ) }
                "G" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("L", 4, R.drawable.g_l),
                    SpotLocation("R", 4, R.drawable.g_r)
                ) }
                "UL" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("LA", 8, R.drawable.ul_la),
                    SpotLocation("RA", 8, R.drawable.ul_ra),
                    SpotLocation("LP", 8, R.drawable.ul_lp),
                    SpotLocation("RP", 8, R.drawable.ul_rp)
                ) }
                "K" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("LA", 8, R.drawable.k_la),
                    SpotLocation("RA", 8, R.drawable.k_ra),
                    SpotLocation("LP", 6, R.drawable.k_lp),
                    SpotLocation("RP", 6, R.drawable.k_rp)
                ) }
                "LL" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("LA", 5, R.drawable.ll_la),
                    SpotLocation("RA", 5, R.drawable.ll_ra),
                    SpotLocation("LP", 4, R.drawable.ll_lp),
                    SpotLocation("RP", 4, R.drawable.ll_rp)
                ) }
                "A" ->{ viewModel.spotData.value = listOf(
                    SpotLocation("LA", 5, R.drawable.a_la),
                    SpotLocation("RA", 5, R.drawable.a_ra),
                    SpotLocation("LP", 4, R.drawable.a_lp),
                    SpotLocation("RP", 4, R.drawable.a_rp)
                ) }
            }
        }


        binding.apply {

            locationPager.apply {
                adapter = SpotViewPagerAdapter(viewModel.spotData.value!!)
                registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                    override fun onPageSelected(position: Int) {
                        super.onPageSelected(position)
                        activityViewModel.spotPain.value = viewModel.spotData.value!![position].spot2

                        when(viewModel.spotData.value!![position].spotList){
                            3 ->{
                                binding.btn1.visibility = View.VISIBLE
                                binding.btn2.visibility = View.VISIBLE
                                binding.btn3.visibility = View.VISIBLE
                                binding.btn4.visibility = View.INVISIBLE
                                binding.btn5.visibility = View.INVISIBLE
                                binding.btn6.visibility = View.INVISIBLE
                                binding.btn7.visibility = View.INVISIBLE
                                binding.btn8.visibility = View.INVISIBLE

                            }
                            4 ->{
                                binding.btn1.visibility = View.VISIBLE
                                binding.btn2.visibility = View.VISIBLE
                                binding.btn3.visibility = View.VISIBLE
                                binding.btn4.visibility = View.VISIBLE
                                binding.btn5.visibility = View.INVISIBLE
                                binding.btn6.visibility = View.INVISIBLE
                                binding.btn7.visibility = View.INVISIBLE
                                binding.btn8.visibility = View.INVISIBLE
                            }
                            5 ->{
                                binding.btn1.visibility = View.VISIBLE
                                binding.btn2.visibility = View.VISIBLE
                                binding.btn3.visibility = View.VISIBLE
                                binding.btn4.visibility = View.VISIBLE
                                binding.btn5.visibility = View.VISIBLE
                                binding.btn6.visibility = View.INVISIBLE
                                binding.btn7.visibility = View.INVISIBLE
                                binding.btn8.visibility = View.INVISIBLE
                            }
                            6 ->{
                                binding.btn1.visibility = View.VISIBLE
                                binding.btn2.visibility = View.VISIBLE
                                binding.btn3.visibility = View.VISIBLE
                                binding.btn4.visibility = View.VISIBLE
                                binding.btn5.visibility = View.VISIBLE
                                binding.btn6.visibility = View.VISIBLE
                                binding.btn7.visibility = View.INVISIBLE
                                binding.btn8.visibility = View.INVISIBLE
                            }
                            7 ->{
                                binding.btn1.visibility = View.VISIBLE
                                binding.btn2.visibility = View.VISIBLE
                                binding.btn3.visibility = View.VISIBLE
                                binding.btn4.visibility = View.VISIBLE
                                binding.btn5.visibility = View.VISIBLE
                                binding.btn6.visibility = View.VISIBLE
                                binding.btn7.visibility = View.VISIBLE
                                binding.btn8.visibility = View.INVISIBLE
                            }
                            8 ->{
                                binding.btn1.visibility = View.VISIBLE
                                binding.btn2.visibility = View.VISIBLE
                                binding.btn3.visibility = View.VISIBLE
                                binding.btn4.visibility = View.VISIBLE
                                binding.btn5.visibility = View.VISIBLE
                                binding.btn6.visibility = View.VISIBLE
                                binding.btn7.visibility = View.VISIBLE
                                binding.btn8.visibility = View.VISIBLE
                            }
                        }

                        when(viewModel.spotData.value!![position].spot2){
                            "A" -> binding.indicatorText.text = "전면"
                            "P" -> binding.indicatorText.text = "후면"
                            "LA" -> binding.indicatorText.text = "왼쪽 전면"
                            "RA" -> binding.indicatorText.text = "오른쪽 전면"
                            "LP" -> binding.indicatorText.text = "왼쪽 후면"
                            "RP" -> binding.indicatorText.text = "오른쪽 후면"
                            "L" -> binding.indicatorText.text = "왼쪽"
                            "R" -> binding.indicatorText.text = "오른쪽"
                        }

                    }
                })
            }
        }


        viewModel.setObserves()
    }



    fun SpotLocationViewModel.setObserves(){

        action.observe(viewLifecycleOwner, EventObserver{
            when(it){
                SpotLocationViewModel.LocationActions.PREV -> {
                    requireActivity().onBackPressed()
                }
                SpotLocationViewModel.LocationActions.STOP -> {
                    activityViewModel.finish()
                }
            }
        })

        num.observe(viewLifecycleOwner, EventObserver {
            activityViewModel.spotPainNum.value = it
            val action = SpotLocationFragmentDirections.actionSpotLocationFragmentToStaticFragment()
            findNavController().navigate(action)

        })
    }
}


class SpotViewPagerAdapter(item : List<SpotLocation>) : RecyclerView.Adapter<SpotViewPagerAdapter.MyViewHolder>(){

    val spotItem = item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_spot_location_list, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindSliderImage(spotItem[position].spotImg)
    }

    public class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ImageView = itemView.findViewById<AppCompatImageView>(R.id.image_list)

        fun bindSliderImage(img : Int){
            Glide.with(itemView)
                .load(img)
                .into(ImageView)
        }
    }

    override fun getItemCount(): Int {
        return spotItem.size
    }
}


//    //'목'
//    private val neckList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//    }
//    //어깨
//    private val sholderList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//
//    }
//    //가슴
//    private val chestList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//    }
//    //복부
//    private val abdomenList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//    }
//    //위팔
//    private val topArmList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//    }
//    //팔꿈치
//    private val elbowList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//    }
//    //아래팔
//    private val lowArmList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//
//    }
//    //손목
//    private val wristList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//
//    }
//    //등
//    private val backList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//
//    }
//    //허리
//    private val waistList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//
//    }
//    //엉덩이
//    private val hipList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//
//    }
//    //윗다리
//    private val topLegList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//
//    }
//    //무릎
//    private val kneeList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//
//    }
//    //아랫다리
//    private val lowLegList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//
//    }
//    //발목
//    private val ankleList = mutableListOf<Int>().apply {
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//        add(R.drawable.test_img)
//    }
//
//    private val textList = mutableListOf<String>().apply {
//        add("전면")
//        add("후면")
//        add("왼쪽 전면")
//        add("오른쪽 전면")
//        add("왼쪽 후면")
//        add("오른쪽 후면")
//        add("왼쪽")
//        add("오른쪽")
//        add("왼쪽")
//        add("오른쪽")
//        add("왼쪽 전면")
//        add("오른쪽 전면")
//        add("왼쪽 후면")
//        add("오른쪽 후면")
//        add("왼쪽")
//        add("오른쪽")
//        add("왼쪽 전면")
//        add("오른쪽 전면")
//        add("왼쪽 후면")
//        add("오른쪽 후면")
//        add("왼쪽")
//        add("오른쪽")
//        add("왼쪽")
//        add("오른쪽")
//        add("왼쪽")
//        add("오른쪽")
//        add("왼쪽 전면")
//        add("오른쪽 전면")
//        add("왼쪽 후면")
//        add("오른쪽 후면")
//        add("왼쪽 전면")
//        add("오른쪽 전면")
//        add("왼쪽 후면")
//        add("오른쪽 후면")
//        add("왼쪽 전면")
//        add("오른쪽 전면")
//        add("왼쪽 후면")
//        add("오른쪽 후면")
//        add("왼쪽 전면")
//        add("오른쪽 전면")
//        add("왼쪽 후면")
//        add("오른쪽 후면")
//    }
//
//    private fun locationViewPager(){
//        binding.locationPager.apply {
//            clipToPadding = false
//            clipChildren = false
//            offscreenPageLimit = 1
//            if(activityViewModel.spotData.value == "N") adapter = ViewPager2Adapter(requireActivity(), neckList)
//            else if (activityViewModel.spotData.value == "S") adapter = ViewPager2Adapter(requireActivity(), sholderList)
//            else if (activityViewModel.spotData.value == "P") adapter = ViewPager2Adapter(requireActivity(), chestList)
//            else if (activityViewModel.spotData.value == "AB") adapter = ViewPager2Adapter(requireActivity(), abdomenList)
//            else if (activityViewModel.spotData.value == "UA") adapter = ViewPager2Adapter(requireActivity(), topArmList)
//            else if (activityViewModel.spotData.value == "E") adapter = ViewPager2Adapter(requireActivity(), elbowList)
//            else if (activityViewModel.spotData.value == "LA") adapter = ViewPager2Adapter(requireActivity(), lowArmList)
////            else if (activityViewModel.spotData.value == "손목") adapter = ViewPager2Adapter(requireActivity(), wristList)
//            else if (activityViewModel.spotData.value == "B") adapter = ViewPager2Adapter(requireActivity(), backList)
//            else if (activityViewModel.spotData.value == "LB") adapter = ViewPager2Adapter(requireActivity(), waistList)
//            else if (activityViewModel.spotData.value == "G") adapter = ViewPager2Adapter(requireActivity(), hipList)
//            else if (activityViewModel.spotData.value == "UL") adapter = ViewPager2Adapter(requireActivity(), topLegList)
//            else if (activityViewModel.spotData.value == "K") adapter = ViewPager2Adapter(requireActivity(), kneeList)
//            else if (activityViewModel.spotData.value == "LL") adapter = ViewPager2Adapter(requireActivity(), lowLegList)
//            else adapter = ViewPager2Adapter(requireActivity(), ankleList)
//
//
//        }
//        binding.locationPager.setPageTransformer(MarginPageTransformer(50))
//        mainViewChangeEvent()
//    }
//
//    private fun mainViewChangeEvent(){
//        binding.locationPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
//            override fun onPageSelected(position: Int) {
//                binding.indicatorText.text = textList[position]
//            }
//
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//                //1,2,3
//
//                if(position == 2 || position ==3 || position ==4 || position ==5){
//                    binding.btn1.visibility = View.VISIBLE
//                    binding.btn2.visibility = View.VISIBLE
//                    binding.btn3.visibility = View.VISIBLE
//                    binding.btn4.visibility = View.INVISIBLE
//                    binding.btn5.visibility = View.INVISIBLE
//                    binding.btn6.visibility = View.INVISIBLE
//                    binding.btn7.visibility = View.INVISIBLE
//                    binding.btn8.visibility = View.INVISIBLE
//
//                    Log.d("테스트", "포지션 : "+position)
//
//                }
//
//                //1,2,3,4
//                else if(position == 0 || position ==10 || position ==11 || position ==12 || position ==13 || position ==14 || position ==15 || position ==18 || position ==19
//                    || position ==22 || position ==23 || position ==24 || position ==25  || position ==36 || position ==36 || position ==37 || position ==40 || position ==41){
//                    binding.btn1.visibility = View.VISIBLE
//                    binding.btn2.visibility = View.VISIBLE
//                    binding.btn3.visibility = View.VISIBLE
//                    binding.btn4.visibility = View.VISIBLE
//                    binding.btn5.visibility = View.INVISIBLE
//                    binding.btn6.visibility = View.INVISIBLE
//                    binding.btn7.visibility = View.INVISIBLE
//                    binding.btn8.visibility = View.INVISIBLE
//                    Log.d("테스트", "포지션 : "+position)
//
//                }
//
//                //1,2,3,4,5
//                else if(position == 1 || position ==6 || position ==7 || position ==8 || position ==9 || position ==34 || position ==35 || position ==38 || position ==39){
//                    binding.btn1.visibility = View.VISIBLE
//                    binding.btn2.visibility = View.VISIBLE
//                    binding.btn3.visibility = View.VISIBLE
//                    binding.btn4.visibility = View.VISIBLE
//                    binding.btn5.visibility = View.VISIBLE
//                    binding.btn6.visibility = View.INVISIBLE
//                    binding.btn7.visibility = View.INVISIBLE
//                    binding.btn8.visibility = View.INVISIBLE
//                    Log.d("테스트", "포지션 : "+position)
//
//                }
//
//                //1,2,3,4,5,6
//                else if(position == 21 || position ==22 || position ==33 || position ==34){
//                    binding.btn1.visibility = View.VISIBLE
//                    binding.btn2.visibility = View.VISIBLE
//                    binding.btn3.visibility = View.VISIBLE
//                    binding.btn4.visibility = View.VISIBLE
//                    binding.btn5.visibility = View.VISIBLE
//                    binding.btn6.visibility = View.VISIBLE
//                    binding.btn7.visibility = View.INVISIBLE
//                    binding.btn8.visibility = View.INVISIBLE
//                    Log.d("테스트", "포지션 : "+position)
//
//                }
//
//                //1,2,3,4,5,6,7
//                else if(position == 16 || position ==17){
//                    binding.btn1.visibility = View.VISIBLE
//                    binding.btn2.visibility = View.VISIBLE
//                    binding.btn3.visibility = View.VISIBLE
//                    binding.btn4.visibility = View.VISIBLE
//                    binding.btn5.visibility = View.VISIBLE
//                    binding.btn6.visibility = View.VISIBLE
//                    binding.btn7.visibility = View.VISIBLE
//                    binding.btn8.visibility = View.INVISIBLE
//                    Log.d("테스트", "포지션 : "+position)
//
//                }
//                //1,2,3,4,5,6,7,8
//                else {
//                    binding.btn1.visibility = View.VISIBLE
//                    binding.btn2.visibility = View.VISIBLE
//                    binding.btn3.visibility = View.VISIBLE
//                    binding.btn4.visibility = View.VISIBLE
//                    binding.btn5.visibility = View.VISIBLE
//                    binding.btn6.visibility = View.VISIBLE
//                    binding.btn7.visibility = View.VISIBLE
//                    binding.btn8.visibility = View.VISIBLE
//                    Log.d("테스트", "포지션 : "+position.toString())
//                }
//            }
//        })
//    }