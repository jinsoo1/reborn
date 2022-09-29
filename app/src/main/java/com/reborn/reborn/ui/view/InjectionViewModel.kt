package com.reborn.reborn.ui.view

import com.reborn.reborn.ui.view.account.AccountViewModel
import com.reborn.reborn.ui.view.account.experience.ExperienceViewModel
import com.reborn.reborn.ui.view.account.height.HeightViewModel
import com.reborn.reborn.ui.view.account.weight.WeightViewModel
import com.reborn.reborn.ui.view.assessment.AssessmentViewModel
import com.reborn.reborn.ui.view.assessment.purpose.PurposeViewModel
import com.reborn.reborn.ui.view.assessment.rehab.CodeViewModel
import com.reborn.reborn.ui.view.assessment.rehab.SpotLocationViewModel
import com.reborn.reborn.ui.view.assessment.rehab.SpotViewModel
import com.reborn.reborn.ui.view.assessment.vas.DynamicViewModel
import com.reborn.reborn.ui.view.assessment.vas.StaticViewModel
import com.reborn.reborn.ui.view.login.LoginViewModel
import com.reborn.reborn.ui.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel() }
    viewModel { LoginViewModel() }
    viewModel { AccountViewModel() }
    viewModel { AssessmentViewModel() }
    viewModel { ExperienceViewModel() }
    viewModel { HeightViewModel() }
    viewModel { WeightViewModel() }
    viewModel { PurposeViewModel() }
    viewModel { CodeViewModel() }
    viewModel { SpotViewModel() }
    viewModel { SpotLocationViewModel() }
    viewModel { StaticViewModel() }
    viewModel { DynamicViewModel() }



}