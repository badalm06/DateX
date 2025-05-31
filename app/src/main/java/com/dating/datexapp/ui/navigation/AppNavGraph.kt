package com.dating.datexapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import androidx.compose.runtime.*
import com.dating.datexapp.ui.screens.AdvanceFiltersScreen
import com.dating.datexapp.ui.screens.IPhone13Mini3Screen
import com.dating.datexapp.ui.screens.IPhone13Mini5Screen
import com.dating.datexapp.ui.screens.IPhone13Mini6Screen
import com.dating.datexapp.ui.screens.EditProfileNotVerifiedScreen
import com.dating.datexapp.ui.screens.EditProfileNotVerified2Screen
import com.dating.datexapp.ui.screens.PremiumScreen
import com.dating.datexapp.ui.screens.Premium2Screen
import com.dating.datexapp.ui.screens.VerificationProcessingScreen
import com.dating.datexapp.ui.screens.Premium3Screen
import com.dating.datexapp.ui.screens.LocationSettingsScreen
import com.dating.datexapp.ui.screens.AboutUsScreen
import com.dating.datexapp.ui.screens.BlockedUsersScreen
import com.dating.datexapp.ui.screens.NotificationScreen
import com.dating.datexapp.ui.screens.AllImageViewScreen
import com.dating.datexapp.ui.screens.CupidArrowScreen
import com.dating.datexapp.ui.screens.WhomYouLikeScreen
import com.dating.datexapp.ui.screens.PictureScreen
import com.dating.datexapp.ui.screens.WhoLikeYouScreen
import com.dating.datexapp.ui.screens.UpdateNumberScreen
import com.dating.datexapp.ui.screens.UpdateEmailAddressScreen
import com.dating.datexapp.ui.screens.ChatsScreen
import com.dating.datexapp.ui.screens.CupidArrowFilterScreen
import com.dating.datexapp.ui.screens.DOBScreen
import com.dating.datexapp.ui.screens.EmailScreen
import com.dating.datexapp.ui.screens.FullCardScreen
import com.dating.datexapp.ui.screens.GenderScreen
import com.dating.datexapp.ui.screens.GetStartedScreen
import com.dating.datexapp.ui.screens.InterestScreen
import com.dating.datexapp.ui.screens.ItsMatchScreen
import com.dating.datexapp.ui.screens.LocationScreen
import com.dating.datexapp.ui.screens.LoginScreen
import com.dating.datexapp.ui.screens.LookingForScreen
import com.dating.datexapp.ui.screens.MyNumberIsScreen
import com.dating.datexapp.ui.screens.SettingScreen
import com.dating.datexapp.ui.screens.VerificationCodeScreen
import com.dating.datexapp.ui.screens.YourNameScreen
import com.dating.datexapp.ui.screens.splash.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    val nameState = rememberSaveable { mutableStateOf("") }

    NavHost(
        navController = navController,
        startDestination = SplashScreen
    ) {
        composable<SplashScreen> {
            SplashScreen(
                onNavigateNext = {
                    navController.navigate(GetStartedScreen)
                }
            )
        }

        composable<GetStartedScreen> {
            GetStartedScreen(
                onLoginClick = {
                    navController.navigate(LoginScreen)
                },
                onSignUpClick = {
                    // We'll add SignUpScreen later
                }
            )
        }


        composable<LoginScreen> {
            LoginScreen(
                onContinueClick = {
                    navController.navigate(MyNumberIsScreen)
                },
                onFacebookLogin = { /* handle or skip */ },
                onGoogleLogin = { /* handle or skip */ },
                onSignUpClick = { /* navController.navigate(SignUpScreen) maybe */ }
            )
        }

        composable<MyNumberIsScreen> {
            MyNumberIsScreen(
                onContinue = { phoneNumber ->
                    navController.navigate(VerificationCodeScreen(phoneNumber = phoneNumber))
                },
                onBackClick = { navController.popBackStack() },
            )
        }

        composable<VerificationCodeScreen> {
            val args = it.toRoute<VerificationCodeScreen>()
            VerificationCodeScreen(
                phoneNumber = args.phoneNumber,
                onBackClick = { navController.popBackStack() },
                onContinueClick = {
                    navController.navigate(YourNameScreen)
                },
                onResendCodeClick = {
                    // Resend logic
                }
            )
        }

        composable<YourNameScreen> {
            YourNameScreen(
                name = nameState.value,
                onNameChange = { nameState.value = it },
                onContinueClick = {
                    navController.navigate(EmailAddressScreen)
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable<EmailAddressScreen> {
            var email by rememberSaveable { mutableStateOf("") }

            EmailScreen(
                email = email,
                onEmailChange = { email = it },
                onContinueClick = {
                    navController.navigate(DOBScreen)
                },
                onBackClick = { navController.popBackStack() }
            )
        }

        composable<DOBScreen> {
            var age by rememberSaveable { mutableIntStateOf(25) }

            DOBScreen(
                selectedAge = age,
                onAgeSelected = { age = it },
                onBackClick = { navController.popBackStack() },
                onContinueClick = {
                    navController.navigate(GenderScreen)
                }
            )
        }

            composable<GenderScreen> {
                GenderScreen(
                    selectedGender = "Male",
                    onGenderSelected = { },
                    onBackClick = { navController.popBackStack() },
                    onContinueClick = {
                        navController.navigate(LookingForScreen)
                    }
                )
            }

        composable<LookingForScreen> {
            LookingForScreen(
                onBackClick = { navController.popBackStack() },
                onContinueClick = {
                    navController.navigate(InterestScreen)
                }
            )
        }

        composable<InterestScreen> {
            InterestScreen(
                onBackClick = { navController.popBackStack() },
                onContinueClick = {
                    navController.navigate(PictureScreen)
                }
            )
        }

        composable<PictureScreen> {
            PictureScreen(
                onBackClick = { navController.popBackStack() },
                onContinueClick = {
                      navController.navigate(LocationScreen)
                }
            )
        }

        composable<LocationScreen> {
            LocationScreen(
                onAllowAccessClick = {
                    navController.navigate(CupidArrowScreen)
                },
                onEnterManuallyClick = {
                    navController.navigate(CupidArrowScreen)
                }
            )
        }

        composable<CupidArrowScreen> {
            CupidArrowScreen(
                onMainImageClick = { navController.navigate(FullCardScreen) },
                onLikeClick = { navController.navigate(ItsMatchScreen) },
                onBottomMainClick = { navController.navigate(CupidArrowScreen) },
                onBottomHeartClick = { navController.navigate(WhoLikeYouScreen) },
                onChatClick = { navController.navigate(ChatScreen) },
                onProfileClick = { navController.navigate(EditProfileScreen) },
                onFilterClick = {navController.navigate(CupidArrowFilterScreen)}
            )
        }

        composable<CupidArrowFilterScreen> {
            CupidArrowFilterScreen(
               onCloseClick = {navController.navigate(CupidArrowScreen)},
                onTryAgainClick = {navController.navigate(CupidArrowScreen)},
                onAdvanceFilterClick = {navController.navigate(AdvanceFilterScreen)}
            )
        }

        composable<AdvanceFilterScreen> {
            AdvanceFiltersScreen(
                onBackClick = {navController.navigate(CupidArrowFilterScreen)},
                onApplyFilterClick = {navController.navigate(CupidArrowScreen)})
        }

        composable<FullCardScreen> {
            FullCardScreen(
                onMainImageClick = {},
                onBackClick = { navController.navigate(CupidArrowScreen) },
                onBottomHeartClick = { navController.navigate(WhoLikeYouScreen) },
                onChatClick = { navController.navigate(ChatScreen) },
                onProfileClick = { navController.navigate(EditProfileScreen) },
                onLikeClick = { navController.navigate(ItsMatchScreen)}
            )
        }

        composable<AllImageViewScreen> {
            AllImageViewScreen(
                onBackClick = { navController.navigate(CupidArrowScreen)}
            )
        }
        composable<ItsMatchScreen> {
            ItsMatchScreen(
                onHelloClick = { navController.navigate(ChatScreen) },
                onNotNowClick = { navController.navigate(CupidArrowScreen) }
            )
        }
        composable<WhoLikeYouScreen> {
            WhoLikeYouScreen(
                onGetPremiumClick = { navController.navigate(PremiumScreen) },
                onBottomMainScreen = { navController.navigate(CupidArrowScreen)},
                onBottomHeartClick = {navController.navigate(WhoLikeYouScreen)},
                onChatClick = {navController.navigate(ChatScreen)},
                onProfileClick = {navController.navigate(EditProfileScreen)},
                onWhomYouLikeClick = {navController.navigate(WhomYouLikeScreen)}
            )
        }

        composable<WhomYouLikeScreen> {
            WhomYouLikeScreen(
                onBottomMainScreen = { navController.navigate(CupidArrowScreen)},
                onBottomHeartClick = {navController.navigate(WhomYouLikeScreen)},
                onChatClick = {navController.navigate(ChatScreen)},
                onProfileClick = {navController.navigate(EditProfileScreen)},
                onWhoLikeYouClick = {navController.navigate(WhoLikeYouScreen)},
                onLikeClick = { navController.navigate(ItsMatchScreen)}
            )
        }

        composable<ChatScreen> {
            ChatsScreen(
                onBottomMainClick = { navController.navigate(CupidArrowScreen) },
                onBottomHeartClick = { navController.navigate(WhoLikeYouScreen) },
                onChatClick = { navController.navigate(ChatScreen) },
                onProfileClick = { navController.navigate(EditProfileScreen) },
                onPartiChatClick = { navController.navigate(IPhone13Mini3Screen)}
            )
        }


        composable<IPhone13Mini3Screen> {
            IPhone13Mini3Screen(
                onBackClick = { navController.navigate(ChatScreen)}
            )
        }

        composable<PremiumScreen> {
            PremiumScreen(
                onBottomMainClick = { navController.navigate(CupidArrowScreen) },
                onBottomHeartClick = { navController.navigate(WhoLikeYouScreen) },
                onChatClick = { navController.navigate(ChatScreen) },
                onProfileClick = { navController.navigate(EditProfileScreen) },
                onBackClick = {navController.navigate(WhoLikeYouScreen)},
                onEditButtonClick = { navController.navigate(VerificationProcessingScreen)},
                onFirstDownArrowClick = { navController.navigate(Premium2Screen)},
                onSecondDownArrowClick = { navController.navigate(Premium3Screen)},
                onGetClick = { navController.navigate(IPhone13Mini5Screen)}
            )
        }

        composable<Premium2Screen> {
            Premium2Screen(
                navController = navController,
                onBottomMainClick = { navController.navigate(CupidArrowScreen) },
                onBottomHeartClick = { navController.navigate(WhoLikeYouScreen) },
                onChatClick = { navController.navigate(ChatScreen) },
                onProfileClick = { navController.navigate(EditProfileScreen) },
                onBackClick = {navController.navigate(WhoLikeYouScreen)},
                onFirstDownArrowClick = { navController.navigate(Premium2Screen)},
                onSecondDownArrowClick = { navController.navigate(Premium3Screen)}
            )
        }

        composable<Premium3Screen> {
            Premium3Screen(
                navController = navController,
                onBottomMainClick = { navController.navigate(CupidArrowScreen) },
                onBottomHeartClick = { navController.navigate(WhoLikeYouScreen) },
                onChatClick = { navController.navigate(ChatScreen) },
                onProfileClick = { navController.navigate(EditProfileScreen) },
                onBackClick = {navController.navigate(WhoLikeYouScreen)},
                onFirstDownArrowClick = { navController.navigate(Premium2Screen)},
                onSecondDownArrowClick = { navController.navigate(Premium3Screen)}
            )
        }

        composable<VerificationProcessingScreen> {
            VerificationProcessingScreen(
                onDemoImgClick = { navController.navigate(EditProfileNotVerifiedScreen)}
            )
        }

        composable<EditProfileNotVerifiedScreen>{
            EditProfileNotVerifiedScreen(
                onDeletePhotoClick = { navController.navigate(EditProfileNotVerified2Screen)},
                onAnyOtherClick = { navController.navigate(VerificationProcessingScreen)}
            )
        }

        composable<EditProfileNotVerified2Screen>{
            EditProfileNotVerified2Screen(
                onOkayClick = { navController.navigate(VerificationProcessingScreen)}
            )
        }

        composable<IPhone13Mini5Screen> {
            IPhone13Mini5Screen(
                onAnyOtherClick = { navController.navigate(PremiumScreen)},
                onButtonClick = { navController.navigate(IPhone13Mini6Screen)}
            )
        }

        composable<IPhone13Mini6Screen> {
            IPhone13Mini6Screen(
                onAnyOtherClick = { navController.navigate(PremiumScreen)},
                onOkClick = { navController.navigate(PremiumScreen)}
            )
        }

        composable<EditProfileScreen> {
            SettingScreen(
                onBackClick = {navController.popBackStack()},
                onLocationClick = {navController.navigate(LocationSettingsScreen)},
                onAboutUsClick = {navController.navigate(AboutUsScreen)},
                onBlockedUsersClick = {navController.navigate(BlockedUsersScreen)},
                onNotificationClick = {navController.navigate(NotificationScreen)},
                onPhNumClick = {navController.navigate(UpdateNumberScreen)},
                onEmailClick = {navController.navigate(UpdateEmailAddressScreen)}
            )
        }


        composable<LocationSettingsScreen> {
            LocationSettingsScreen(
                onBackClick = {navController.popBackStack()},
                onContinueClick = {navController.navigate(EditProfileScreen)}
            )
        }

        composable<AboutUsScreen> {
            AboutUsScreen(
                onBackClick = {navController.popBackStack()}
            )
        }

        composable<BlockedUsersScreen> {
            BlockedUsersScreen(
                onBackClick = {navController.popBackStack()}
            )
        }

        composable<NotificationScreen> {
            NotificationScreen(
                onBackClick = {navController.popBackStack()}
            )
        }

        composable<UpdateNumberScreen> {
            UpdateNumberScreen(
                onContinueClick = { navController.navigate(EditProfileScreen) },
                onBackClick = { navController.popBackStack() },
            )
        }

        composable<UpdateEmailAddressScreen> {
            var email by rememberSaveable { mutableStateOf("") }

            UpdateEmailAddressScreen(
                email = email,
                onEmailChange = { email = it },
                onContinueClick = { navController.navigate(EditProfileScreen) },
                onBackClick = { navController.popBackStack() }
            )
        }




    }
}
