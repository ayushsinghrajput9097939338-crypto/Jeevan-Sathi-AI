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
package com.google.ai.edge.gallery.customtasks.mobileactions

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Apps
import androidx.compose.material.icons.outlined.Brightness6
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.FlashOff
import androidx.compose.material.icons.outlined.FlashlightOn
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.PersonAdd
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.VolumeDown
import androidx.compose.material.icons.outlined.VolumeUp
import androidx.compose.material.icons.outlined.Wifi
import androidx.compose.ui.graphics.vector.ImageVector

// Supported action types.
enum class ActionType {
  ACTION_FLASHLIGHT_ON,
  ACTION_FLASHLIGHT_OFF,
  ACTION_CREATE_CONTACT,
  ACTION_SEND_EMAIL,
  ACTION_SHOW_LOCATION_ON_MAP,
  ACTION_OPEN_WIFI_SETTINGS,
  ACTION_CREATE_CALENDAR_EVENT,
  ACTION_OPEN_APP,
  ACTION_VOLUME_UP,
  ACTION_VOLUME_DOWN,
  ACTION_SET_VOLUME,
  ACTION_SET_BRIGHTNESS,
  ACTION_OPEN_SETTINGS,
  ACTION_OPEN_QUICK_SETTINGS,
  ACTION_OPEN_INTERNET_PANEL,
  ACTION_OPEN_BLUETOOTH_SETTINGS,
}

data class FunctionCallDetails(
  val functionName: String,
  val parameters: List<Pair<String, String>>,
  val ts: Long = System.currentTimeMillis(),
)

// Base action class.
abstract class Action(
  // The type of the action.
  val type: ActionType,
  // The icon to be displayed next to the model response bubble.
  val icon: ImageVector,
  // The function call details to be displayed in the model response.
  val functionCallDetails: FunctionCallDetails,
)

// Action to turn on flashlight.
class FlashlightOnAction() :
  Action(
    type = ActionType.ACTION_FLASHLIGHT_ON,
    icon = Icons.Outlined.FlashlightOn,
    functionCallDetails =
      FunctionCallDetails(functionName = "turnOnFlashlight", parameters = listOf()),
  )

// Action to turn off flashlight.
class FlashlightOffAction() :
  Action(
    type = ActionType.ACTION_FLASHLIGHT_OFF,
    icon = Icons.Outlined.FlashOff,
    functionCallDetails =
      FunctionCallDetails(functionName = "turnOffFlashlight", parameters = listOf()),
  )

// Action to create contact.
class CreateContactAction(
  val firstName: String,
  val lastName: String,
  val phoneNumber: String,
  val email: String,
) :
  Action(
    type = ActionType.ACTION_CREATE_CONTACT,
    icon = Icons.Outlined.PersonAdd,
    functionCallDetails =
      FunctionCallDetails(
        functionName = "createContact",
        parameters =
          listOf(
            Pair("firstName", firstName),
            Pair("lastName", lastName),
            Pair("phoneNumber", phoneNumber),
            Pair("email", email),
          ),
      ),
  )

// Action to send email.
class SendEmailAction(val to: String, val subject: String, val body: String) :
  Action(
    type = ActionType.ACTION_SEND_EMAIL,
    icon = Icons.Outlined.Email,
    functionCallDetails =
      FunctionCallDetails(
        functionName = "sendEmail",
        parameters = listOf(Pair("to", to), Pair("subject", subject), Pair("body", body)),
      ),
  )

// Action to show a location on map.
class ShowLocationOnMap(val location: String) :
  Action(
    type = ActionType.ACTION_SHOW_LOCATION_ON_MAP,
    icon = Icons.Outlined.Map,
    functionCallDetails =
      FunctionCallDetails(
        functionName = "showLocationOnMap",
        parameters = listOf(Pair("location", location)),
      ),
  )

// Action to open wifi settings.
class OpenWifiSettingsAction() :
  Action(
    type = ActionType.ACTION_OPEN_WIFI_SETTINGS,
    icon = Icons.Outlined.Wifi,
    functionCallDetails =
      FunctionCallDetails(functionName = "openWifiSettings", parameters = listOf()),
  )

// Action to create calendar event.
class CreateCalendarEventAction(val datetime: String, val title: String) :
  Action(
    type = ActionType.ACTION_CREATE_CALENDAR_EVENT,
    icon = Icons.Outlined.CalendarMonth,
    functionCallDetails =
      FunctionCallDetails(
        functionName = "createCalendarEvent",
        parameters = listOf(Pair("datetime", datetime), Pair("title", title)),
      ),
  )


// Action to open an installed app by its visible name.
class OpenAppAction(val appName: String) :
  Action(
    type = ActionType.ACTION_OPEN_APP,
    icon = Icons.Outlined.Apps,
    functionCallDetails =
      FunctionCallDetails(functionName = "openApp", parameters = listOf(Pair("appName", appName))),
  )

// Action to increase media volume.
class VolumeUpAction() :
  Action(
    type = ActionType.ACTION_VOLUME_UP,
    icon = Icons.Outlined.VolumeUp,
    functionCallDetails = FunctionCallDetails(functionName = "volumeUp", parameters = listOf()),
  )

// Action to decrease media volume.
class VolumeDownAction() :
  Action(
    type = ActionType.ACTION_VOLUME_DOWN,
    icon = Icons.Outlined.VolumeDown,
    functionCallDetails = FunctionCallDetails(functionName = "volumeDown", parameters = listOf()),
  )

// Action to set media volume percentage.
class SetVolumeAction(val percent: Int) :
  Action(
    type = ActionType.ACTION_SET_VOLUME,
    icon = Icons.Outlined.VolumeUp,
    functionCallDetails =
      FunctionCallDetails(functionName = "setVolume", parameters = listOf(Pair("percent", percent.toString()))),
  )

// Action to set screen brightness percentage.
class SetBrightnessAction(val percent: Int) :
  Action(
    type = ActionType.ACTION_SET_BRIGHTNESS,
    icon = Icons.Outlined.Brightness6,
    functionCallDetails =
      FunctionCallDetails(functionName = "setBrightness", parameters = listOf(Pair("percent", percent.toString()))),
  )

// Action to open the main Android settings screen.
class OpenSettingsAction() :
  Action(
    type = ActionType.ACTION_OPEN_SETTINGS,
    icon = Icons.Outlined.Settings,
    functionCallDetails = FunctionCallDetails(functionName = "openSettings", parameters = listOf()),
  )

// Action to open the Android quick settings panel.
class OpenQuickSettingsAction() :
  Action(
    type = ActionType.ACTION_OPEN_QUICK_SETTINGS,
    icon = Icons.Outlined.Settings,
    functionCallDetails = FunctionCallDetails(functionName = "openQuickSettings", parameters = listOf()),
  )

// Action to open the Android internet connectivity panel.
class OpenInternetPanelAction() :
  Action(
    type = ActionType.ACTION_OPEN_INTERNET_PANEL,
    icon = Icons.Outlined.Wifi,
    functionCallDetails = FunctionCallDetails(functionName = "openInternetControlPanel", parameters = listOf()),
  )

// Action to open Bluetooth settings.
class OpenBluetoothSettingsAction() :
  Action(
    type = ActionType.ACTION_OPEN_BLUETOOTH_SETTINGS,
    icon = Icons.Outlined.Settings,
    functionCallDetails = FunctionCallDetails(functionName = "openBluetoothSettings", parameters = listOf()),
  )
