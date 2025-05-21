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
import com.dating.datexapp.ui.screens.PictureScreen
import com.dating.datexapp.ui.screens.DOBScreen
import com.dating.datexapp.ui.screens.EmailScreen
import com.dating.datexapp.ui.screens.GenderScreen
import com.dating.datexapp.ui.screens.GetStartedScreen
import com.dating.datexapp.ui.screens.InterestScreen
import com.dating.datexapp.ui.screens.LocationScreen
import com.dating.datexapp.ui.screens.LoginScreen
import com.dating.datexapp.ui.screens.LookingForScreen
import com.dating.datexapp.ui.screens.MyNumberIsScreen
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
                    selectedGender = "",
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
            LocationScreen()
        }















    }
}
