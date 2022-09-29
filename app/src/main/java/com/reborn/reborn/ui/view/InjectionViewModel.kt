package com.reborn.reborn.ui.view

import com.reborn.reborn.ui.view.main.search.related.exercise.ExerciseViewModel
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
import com.reborn.reborn.ui.view.main.community.CommunityViewModel
import com.reborn.reborn.ui.view.main.home.HomeViewModel
import com.reborn.reborn.ui.view.main.search.SearchResultViewModel
import com.reborn.reborn.ui.view.main.myPage.MyPageNavViewModel
import com.reborn.reborn.ui.view.main.myPage.MyPageViewModel
import com.reborn.reborn.ui.view.main.myPage.bookmark.BookmarkViewModel
import com.reborn.reborn.ui.view.main.myPage.history.HistoryViewModel
import com.reborn.reborn.ui.view.main.myPage.information.InformationViewModel
import com.reborn.reborn.ui.view.main.myPage.profile.ProfileViewModel
import com.reborn.reborn.ui.view.main.search.related.RelatedViewModel
import com.reborn.reborn.ui.view.main.search.related.disease.DiseaseViewModel
import com.reborn.reborn.ui.view.myroutine.MyRoutineViewModel
import com.reborn.reborn.ui.view.myroutine.complete.CompleteRoutineViewModel
import com.reborn.reborn.ui.view.myroutine.complete.CompleteViewModel
import com.reborn.reborn.ui.view.myroutine.exerciselist.ExerciseListViewModel
import com.reborn.reborn.ui.view.myroutine.feedback.FeedbackViewModel
import com.reborn.reborn.ui.view.myroutine.routinelist.RoutineListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    //main(activity, Fragment)관련
    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
    viewModel { CommunityViewModel() }
    viewModel { MyPageViewModel() }
    viewModel { SearchResultViewModel() }

    //MyPage 관련
    viewModel { MyPageNavViewModel() }
    viewModel { ProfileViewModel() }
    viewModel { InformationViewModel() }
    viewModel { BookmarkViewModel() }
    viewModel { HistoryViewModel() }

    //Related 관련
    viewModel { RelatedViewModel() }
    viewModel { ExerciseViewModel() }
    viewModel { DiseaseViewModel() }

    //MyRoutine 관련
    viewModel { MyRoutineViewModel() }
    viewModel { RoutineListViewModel() }
    viewModel { ExerciseListViewModel() }
    viewModel { CompleteViewModel() }
    viewModel { FeedbackViewModel() }
    viewModel { CompleteRoutineViewModel() }


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