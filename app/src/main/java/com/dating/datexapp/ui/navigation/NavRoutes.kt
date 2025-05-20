package com.dating.datexapp.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object SplashScreen

@Serializable
object GetStartedScreen

@Serializable
object LoginScreen

@Serializable
object MyNumberIsScreen


@Serializable
data class VerificationCodeScreen(
    val phoneNumber: String
)

@Serializable
object YourNameScreen

@Serializable
object EmailAddressScreen

@Serializable
object DOBScreen

@Serializable
object GenderScreen

@Serializable
object LookingForScreen

@Serializable
object InterestScreen

@Serializable
object PictureScreen

@Serializable
object LocationScreen




// Add more screens here as needed...
