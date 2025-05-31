package com.dating.datexapp.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dating.datexapp.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.ui.graphics.Brush
import com.dating.datexapp.ui.common.GradientButton
import com.dating.datexapp.ui.common.StatusBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvanceFiltersScreen(
    onApplyFilterClick: () -> Unit,
    onBackClick: () -> Unit
) {
    // Filter states
    var heightRange by remember { mutableStateOf(150f..200f) }
    val sexualOrientations = listOf("Straight", "Gay", "Lesbian", "Bisexual", "Asexual", "Demisexual", "Pansexual", "Questioning")
    val educationLevels = listOf("Bachelors", "In College", "High School", "Phd", "In Grad School", "Masters")
    val religions = listOf("Agnostic", "Atheist", "Jain", "Buddhist", "Catholic", "Christian", "Hindu", "Sikh", "Jewish", "Mormon", "Muslim", "Zoroastrian", "Other", "Spiritual")
    val workoutOptions = listOf("Everyday", "Often", "Sometimes")
    val smokingOptions = listOf("Socially", "Never", "Regularly")
    val drinkingOptions = listOf("Socially", "Never")
    val interests = listOf(
        "Party", "Sports", "Travel", "Cinema", "Music", "Acting", "Gaming", "Shopping", "Pets",
        "Cooking", "Books", "Bikes", "Dancing", "Photography", "Romance", "Netflix", "Cars",
        "Sexology", "Television", "Love Stories", "Fitness"
    )

    var selectedSexualOrientation by remember { mutableStateOf(setOf("Straight")) }
    var selectedEducation by remember { mutableStateOf(setOf<String>()) }
    var selectedReligion by remember { mutableStateOf(setOf<String>()) }
    var selectedWorkout by remember { mutableStateOf(setOf<String>()) }
    var selectedSmoking by remember { mutableStateOf(setOf<String>()) }
    var selectedDrinking by remember { mutableStateOf(setOf<String>()) }
    var selectedInterests by remember { mutableStateOf(setOf<String>()) }

    // Colors
    val pink = Color(0xFFF857A6)
    val yellow = Color(0xFFFFE27A)
    val chipBg = Color(0xFFF5F5F5)
    val chipText = Color(0xFFB0B0B0)
    val selectedChipText = Color.White
    val dividerColor = Color(0xFFEDEDED)
    val selectedChipBg = pink


    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Box(Modifier.fillMaxWidth()) {
                        Text(
                            "Advance Filters",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black)
                    }
                },
                actions = {
                    Text(
                        "Clear All",
                        color = chipText,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable { /* TODO: clear logic */ }
                    )
                }
            )
        },
        bottomBar = {
            GradientButton(
                text = "Apply filters",
                onClick = { onApplyFilterClick },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(56.dp)
                    .offset(y = -15.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))

        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            // Height,
            FilterSection(
                title = "Height",
                value = "150CM - 200CM   ",
                icon = painterResource(id = R.drawable.height),
                startPadding = 16.dp
            )


            FilterSlider(
                activeWidth = 75.5.dp,
                startThumbOffsetX = 40.dp,
                endThumbOffsetX = 115.5.dp,
                startPadding = 16.dp
            )

            // Sexual Orientation
            FilterRowWithIcon(
                icon = R.drawable.sexual_orientation,
                label = "Sexual Orientation",
                pink = pink
            ) {
                WrapChips(
                    options = sexualOrientations,
                    selected = selectedSexualOrientation,
                    onSelectionChange = { selectedSexualOrientation = it },
                    chipBg = chipBg,
                    chipText = chipText,
                    selectedChipBg = selectedChipBg,
                    selectedChipText = selectedChipText
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = dividerColor, thickness = 1.dp)

            // Education
            FilterRowWithIcon(
                icon = R.drawable.education,
                label = "Education",
                pink = pink
            ) {
                WrapChips(
                    options = educationLevels,
                    selected = selectedEducation,
                    onSelectionChange = { selectedEducation = it },
                    chipBg = chipBg,
                    chipText = chipText,
                    selectedChipBg = selectedChipBg,
                    selectedChipText = selectedChipText
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = dividerColor, thickness = 1.dp)

            // Religion
            FilterRowWithIcon(
                icon = R.drawable.religion,
                label = "Religion",
                pink = pink
            ) {
                WrapChips(
                    options = religions,
                    selected = selectedReligion,
                    onSelectionChange = { selectedReligion = it },
                    chipBg = chipBg,
                    chipText = chipText,
                    selectedChipBg = selectedChipBg,
                    selectedChipText = selectedChipText
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = dividerColor, thickness = 1.dp)

            // Workout
            FilterRowWithIcon(
                icon = R.drawable.workout,
                label = "Workout",
                pink = pink
            ) {
                WrapChips(
                    options = workoutOptions,
                    selected = selectedWorkout,
                    onSelectionChange = { selectedWorkout = it },
                    chipBg = chipBg,
                    chipText = chipText,
                    selectedChipBg = selectedChipBg,
                    selectedChipText = selectedChipText
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = dividerColor, thickness = 1.dp)

            // Smoking
            FilterRowWithIcon(
                icon = R.drawable.smoking,
                label = "Smoking",
                pink = pink
            ) {
                WrapChips(
                    options = smokingOptions,
                    selected = selectedSmoking,
                    onSelectionChange = { selectedSmoking = it },
                    chipBg = chipBg,
                    chipText = chipText,
                    selectedChipBg = selectedChipBg,
                    selectedChipText = selectedChipText
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = dividerColor, thickness = 1.dp)

            // Drinking
            FilterRowWithIcon(
                icon = R.drawable.drinking,
                label = "Drinking",
                pink = pink
            ) {
                WrapChips(
                    options = drinkingOptions,
                    selected = selectedDrinking,
                    onSelectionChange = { selectedDrinking = it },
                    chipBg = chipBg,
                    chipText = chipText,
                    selectedChipBg = selectedChipBg,
                    selectedChipText = selectedChipText
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Divider(color = dividerColor, thickness = 1.dp)

            // Interests
            FilterRowWithIcon(
                icon = R.drawable.interest,
                label = "Interests",
                pink = pink
            ) {
                WrapChips(
                    options = interests,
                    selected = selectedInterests,
                    onSelectionChange = { selectedInterests = it },
                    chipBg = chipBg,
                    chipText = chipText,
                    selectedChipBg = selectedChipBg,
                    selectedChipText = selectedChipText
                )
            }
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
fun FilterRowWithIcon(
    icon: Int,
    label: String,
    pink: Color,
    rightContent: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 18.dp, bottom = 0.dp, start = 16.dp, end = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = label,
                tint = pink,
                modifier = Modifier.size(20.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = label,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black,
                modifier = Modifier.width(190.dp)
            )
            if (rightContent != null) {
                Spacer(Modifier.weight(1f))
                rightContent()
            }
        }
        Spacer(Modifier.height(8.dp))
        Box(Modifier.fillMaxWidth()) {
            content()
        }
    }
}


@Composable
fun WrapChips(
    options: List<String>,
    selected: Set<String>,
    onSelectionChange: (Set<String>) -> Unit,
    chipBg: Color,
    chipText: Color,
    selectedChipBg: Color,
    selectedChipText: Color
) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        options.forEach { option ->
            val isSelected = selected.contains(option)

            Box(
                modifier = Modifier
                    .border(
                        border = if (!isSelected)
                            BorderStroke(1.dp, Color.Gray)
                        else
                            BorderStroke(0.dp, Color.Transparent),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .background(
                        brush = if (isSelected)
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFF64F8B),
                                    Color(0xFFF8CE61)
                                )
                            )

                        else Brush.verticalGradient(listOf(chipBg, chipBg)),
                        shape = RoundedCornerShape(20.dp)
                    )
            ) {
                FilterChip(
                    selected = isSelected,
                    onClick = {
                        onSelectionChange(
                            if (isSelected) selected - option else selected + option
                        )
                    },
                    label = {
                        Text(
                            option,
                            color = if (isSelected) selectedChipText else chipText,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                        )
                    },
                    shape = RoundedCornerShape(20.dp),
                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.Transparent, // So gradient shows
                        selectedContainerColor = Color.Transparent
                    ),
                    border = null
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AdvanceFiltersScreenPreview() {
    AdvanceFiltersScreen(
        onApplyFilterClick = {},
        onBackClick = {}
    )
}
