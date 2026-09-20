/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.ai.edge.gallery.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.google.ai.edge.gallery.proto.Theme

private val lightScheme =
  lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
  )

private val darkScheme =
  darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
  )

@Immutable
data class CustomColors(
  val appTitleGradientColors: List<Color> = listOf(),
  val tabHeaderBgColor: Color = Color.Transparent,
  val taskCardBgColor: Color = Color.Transparent,
  val taskBgColors: List<Color> = listOf(),
  val taskBgGradientColors: List<List<Color>> = listOf(),
  val taskIconColors: List<Color> = listOf(),
  val taskIconShapeBgColor: Color = Color.Transparent,
  val homeBottomGradient: List<Color> = listOf(),
  val userBubbleBgColor: Color = Color.Transparent,
  val agentBubbleBgColor: Color = Color.Transparent,
  val linkColor: Color = Color.Transparent,
  val successColor: Color = Color.Transparent,
  val positiveStrokeColor: Color = Color.Transparent,
  val negativeStrokeColor: Color = Color.Transparent,
  val lassoStrokeColor: Color = Color.Transparent,
  val recordButtonBgColor: Color = Color.Transparent,
  val waveFormBgColor: Color = Color.Transparent,
  val modelInfoIconColor: Color = Color.Transparent,
  val warningContainerColor: Color = Color.Transparent,
  val warningTextColor: Color = Color.Transparent,
  val errorContainerColor: Color = Color.Transparent,
  val errorTextColor: Color = Color.Transparent,
  val newFeatureContainerColor: Color = Color.Transparent,
  val newFeatureTextColor: Color = Color.Transparent,
  val bgStarColor: Color = Color.Transparent,
  val promoBannerBgBrush: Brush = Brush.verticalGradient(listOf(Color.Transparent)),
  val promoBannerIconBgBrush: Brush = Brush.verticalGradient(listOf(Color.Transparent)),
)

val LocalCustomColors = staticCompositionLocalOf { CustomColors() }

val lightCustomColors =
  CustomColors(
    appTitleGradientColors = listOf(Color(0xFFD6A27E), Color(0xFF6B3F2A)),
    tabHeaderBgColor = Color(0xFF6B3F2A),
    taskCardBgColor = surfaceContainerLowestLight,
    taskBgColors =
      listOf(
        // red
        Color(0xFFFFF1E8),
        // green
        Color(0xFFF6E9DC),
        // blue
        Color(0xFFF2E7DE),
        // yellow
        Color(0xFFFAF0D8),
      ),
    taskBgGradientColors =
      listOf(
        // red
        listOf(Color(0xFFB97955), Color(0xFF6B3F2A)),
        // green
        listOf(Color(0xFFA66B4F), Color(0xFF7B4A35)),
        // blue
        listOf(Color(0xFF669DF6), Color(0xFF6B3F2A)),
        // yellow
        listOf(Color(0xFFE4C27A), Color(0xFF9A7838)),
      ),
    taskIconColors =
      listOf(
        // red.
        Color(0xFF8A4F35),
        // green
        Color(0xFF7B4A35),
        // blue
        Color(0xFF6B3F2A),
        // yellow
        Color(0xFF9A7838),
      ),
    taskIconShapeBgColor = Color(0xFFFFFCF8),
    homeBottomGradient = listOf(Color(0x00FFF8F0), Color(0xFFF0D7BF)),
    agentBubbleBgColor = Color(0xFFF0E2D8),
    userBubbleBgColor = Color(0xFF6B3F2A),
    linkColor = Color(0xFF6B3F2A),
    successColor = Color(0xFF6D9A4B),
    positiveStrokeColor = Color(0xFF6D9A4B),
    negativeStrokeColor = Color(0xFFD85C52),
    lassoStrokeColor = Color(0xFF8A5A44),
    recordButtonBgColor = Color(0xFF9B5A3C),
    waveFormBgColor = Color(0xFF9A877B),
    modelInfoIconColor = Color(0xFFC9B5A8),
    warningContainerColor = Color(0xFFFAEED0),
    warningTextColor = Color(0xFFB66A2C),
    errorContainerColor = Color(0xFF4E2927),
    errorTextColor = Color(0xFFD85C52),
    newFeatureContainerColor = Color(0xFFE7D7E8),
    newFeatureTextColor = Color(0xFF5B315E),
    bgStarColor = Color(0x3A8A5A44),
    promoBannerBgBrush =
      Brush.linearGradient(
        colorStops =
          arrayOf(
            0.0f to Color(0x42D6A27E),
            0.6154f to Color(0x426B3F2A),
            1.0f to Color(0x428A5A44),
          ),
        start = Offset(0f, 0f),
        end = Offset(0f, Float.POSITIVE_INFINITY),
      ),
    promoBannerIconBgBrush =
      Brush.linearGradient(
        colorStops =
          arrayOf(
            0.2442f to Color(0x3BD6A27E),
            0.4296f to Color(0x3B8A5A44),
            0.6651f to Color(0x3BBE8A63),
          ),
        start = Offset(0f, 1f),
        end = Offset(1f, 0f),
      ),
  )

val darkCustomColors =
  CustomColors(
    appTitleGradientColors = listOf(Color(0xFFD6A27E), Color(0xFF6B3F2A)),
    tabHeaderBgColor = Color(0xFF6B3F2A),
    taskCardBgColor = surfaceContainerHighDark,
    taskBgColors =
      listOf(
        // red
        Color(0xFF181210),
        // green
        Color(0xFF131711),
        // blue
        Color(0xFF191924),
        // yellow
        Color(0xFF1A1813),
      ),
    taskBgGradientColors =
      listOf(
        // red
        listOf(Color(0xFFB97955), Color(0xFF6B3F2A)),
        // green
        listOf(Color(0xFFA66B4F), Color(0xFF7B4A35)),
        // blue
        listOf(Color(0xFF669DF6), Color(0xFF6B3F2A)),
        // yellow
        listOf(Color(0xFFE4C27A), Color(0xFF9A7838)),
      ),
    taskIconColors =
      listOf(
        // red.
        Color(0xFFE25F57),
        // green
        Color(0xFF41A15F),
        // blue
        Color(0xFF669DF6),
        // yellow
        Color(0xFF9A7838),
      ),
    taskIconShapeBgColor = Color(0xFF202124),
    homeBottomGradient = listOf(Color(0x001A120E), Color(0x406B3F2A)),
    agentBubbleBgColor = Color(0xFF2B211C),
    userBubbleBgColor = Color(0xFF5A3829),
    linkColor = Color(0xFFF0BFA4),
    successColor = Color(0xFFA1CE83),
    positiveStrokeColor = Color(0xFF6D9A4B),
    negativeStrokeColor = Color(0xFFD85C52),
    lassoStrokeColor = Color(0xFF8A5A44),
    recordButtonBgColor = Color(0xFF9B5A3C),
    waveFormBgColor = Color(0xFF9A877B),
    modelInfoIconColor = Color(0xFFC9B5A8),
    warningContainerColor = Color(0xff554c33),
    warningTextColor = Color(0xfffcc934),
    errorContainerColor = Color(0xff523a3b),
    errorTextColor = Color(0xFFE58A79),
    newFeatureContainerColor = Color(0xFFE7D7E8),
    newFeatureTextColor = Color(0xFF5B315E),
    bgStarColor = Color(0x198A5A44),
    promoBannerBgBrush =
      Brush.linearGradient(
        colorStops = arrayOf(0.0f to Color(0x82183570), 0.8077f to Color(0x820A122D)),
        start = Offset(0f, 0f),
        end = Offset(0f, Float.POSITIVE_INFINITY),
      ),
    promoBannerIconBgBrush =
      Brush.linearGradient(
        colorStops =
          arrayOf(
            0.2442f to Color(0x6F5A3020),
            0.4296f to Color(0x6F8A5A44),
            0.6651f to Color(0x6FD6A27E),
          ),
        start = Offset(0f, 1f),
        end = Offset(1f, 0f),
      ),
  )

val MaterialTheme.customColors: CustomColors
  @Composable @ReadOnlyComposable get() = LocalCustomColors.current

/**
 * Controls the color of the phone's status bar icons based on whether the app is using a dark
 * theme.
 */
@Composable
fun StatusBarColorController(useDarkTheme: Boolean) {
  val view = LocalView.current
  val currentWindow = (view.context as? Activity)?.window

  if (currentWindow != null) {
    SideEffect {
      WindowCompat.setDecorFitsSystemWindows(currentWindow, false)
      val controller = WindowCompat.getInsetsController(currentWindow, view)
      controller.isAppearanceLightStatusBars = !useDarkTheme // Set to true for light icons
    }
  }
}

@Composable
fun GalleryTheme(content: @Composable () -> Unit) {
  val themeOverride = ThemeSettings.themeOverride
  val darkTheme: Boolean =
    (isSystemInDarkTheme() || themeOverride.value == Theme.THEME_DARK) &&
      themeOverride.value != Theme.THEME_LIGHT
  val view = LocalView.current

  StatusBarColorController(useDarkTheme = darkTheme)

  val colorScheme =
    when {
      darkTheme -> darkScheme
      else -> lightScheme
    }

  val customColorsPalette = if (darkTheme) darkCustomColors else lightCustomColors

  CompositionLocalProvider(LocalCustomColors provides customColorsPalette) {
    MaterialTheme(colorScheme = colorScheme, typography = AppTypography, content = content)
  }

  // Make sure the navigation bar stays transparent on manual theme changes.
  LaunchedEffect(darkTheme) {
    val window = (view.context as Activity).window

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
      window.isNavigationBarContrastEnforced = false
    }
  }
}
