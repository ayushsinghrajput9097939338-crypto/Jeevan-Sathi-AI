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

import android.util.Log
import com.google.ai.edge.litertlm.Tool
import com.google.ai.edge.litertlm.ToolParam
import com.google.ai.edge.litertlm.ToolSet

private const val TAG = "AGMATools"

class MobileActionsTools(val onFunctionCalled: (Action) -> Unit) : ToolSet {
  /** Turns on flashlight. */
  @Tool(description = "Turns the flashlight on")
  fun turnOnFlashlight(): Map<String, String> {
    Log.d(TAG, "turn on flashlight")

    // Call the callback with the recognized action.
    onFunctionCalled(FlashlightOnAction())

    // Return a response object to the model confirming the action.
    return mapOf("result" to "success")
  }

  /** Turns off flashlight. */
  @Tool(description = "Turns the flashlight off")
  fun turnOffFlashlight(): Map<String, String> {
    Log.d(TAG, "turn off flashlight")

    // Call the callback with the recognized action.
    onFunctionCalled(FlashlightOffAction())

    // Return a response object to the model confirming the action.
    return mapOf("result" to "success")
  }

  /** Creates contact. */
  @Tool(description = "Creates a contact in the phone's contact list.")
  fun createContact(
    @ToolParam(description = "The first name of the contact.") firstName: String,
    @ToolParam(description = "The last name of the contact.") lastName: String,
    @ToolParam(description = "The phone number of the contact.") phoneNumber: String,
    @ToolParam(description = "The email address of the contact.") email: String,
  ): Map<String, String> {
    Log.d(
      TAG,
      "create contact. First name: '$firstName', last name: '$lastName', phone number: '$phoneNumber', email: '$email'",
    )

    onFunctionCalled(
      CreateContactAction(
        firstName = firstName,
        lastName = lastName,
        phoneNumber = phoneNumber,
        email = email,
      )
    )

    return mapOf(
      "result" to "success",
      "first_name" to firstName,
      "last_name" to lastName,
      "phone_number" to phoneNumber,
      "email" to email,
    )
  }

  /** Sends email. */
  @Tool(description = "Sends an email.")
  fun sendEmail(
    @ToolParam(description = "The email address of the recipient.") to: String,
    @ToolParam(description = "The subject of the email.") subject: String,
    @ToolParam(description = "The body of the email.") body: String,
  ): Map<String, String> {
    Log.d(TAG, "send email. To: '$to', subject: '$subject', body: '$body'")

    onFunctionCalled(SendEmailAction(to = to, subject = subject, body = body))

    return mapOf("result" to "success", "to" to to, "subject" to subject, "body" to body)
  }

  /** Shows location on map. */
  @Tool(description = "Shows a location on the map.")
  fun showLocationOnMap(
    @ToolParam(
      description =
        "The location to search for. May be the name of a place, a business, or an address."
    )
    location: String
  ): Map<String, String> {
    Log.d(TAG, "Show location on map. Location: '$location'")

    onFunctionCalled(ShowLocationOnMap(location = location))

    return mapOf("result" to "success", "location" to location)
  }

  /** Opens wifi settings. */
  @Tool(description = "Opens the WiFi settings.")
  fun openWifiSettings(): Map<String, String> {
    Log.d(TAG, "Open wifi settings")

    onFunctionCalled(OpenWifiSettingsAction())

    return mapOf("result" to "success")
  }

  /** Opens an installed app by its visible app name. */
  @Tool(description = "Opens an installed Android app by its visible name, such as YouTube, Chrome, WhatsApp, Calculator, or Gmail.")
  fun openApp(
    @ToolParam(description = "The visible name of the installed app to open.") appName: String,
  ): Map<String, String> {
    Log.d(TAG, "open app: '$appName'")
    onFunctionCalled(OpenAppAction(appName = appName))
    return mapOf("result" to "success", "app_name" to appName)
  }

  /** Increases media volume. */
  @Tool(description = "Increases the phone media volume by one step.")
  fun volumeUp(): Map<String, String> {
    Log.d(TAG, "volume up")
    onFunctionCalled(VolumeUpAction())
    return mapOf("result" to "success")
  }

  /** Decreases media volume. */
  @Tool(description = "Decreases the phone media volume by one step.")
  fun volumeDown(): Map<String, String> {
    Log.d(TAG, "volume down")
    onFunctionCalled(VolumeDownAction())
    return mapOf("result" to "success")
  }

  /** Sets media volume percentage. */
  @Tool(description = "Sets the phone media volume to a percentage from 0 to 100.")
  fun setVolume(
    @ToolParam(description = "Desired media volume percentage from 0 to 100.") percent: Int,
  ): Map<String, String> {
    val safePercent = percent.coerceIn(0, 100)
    Log.d(TAG, "set volume: $safePercent%")
    onFunctionCalled(SetVolumeAction(percent = safePercent))
    return mapOf("result" to "success", "percent" to safePercent.toString())
  }

  /** Sets screen brightness percentage. */
  @Tool(description = "Sets the screen brightness to a percentage from 0 to 100. If Android requires the special write-settings permission, the permission screen is opened.")
  fun setBrightness(
    @ToolParam(description = "Desired screen brightness percentage from 0 to 100.") percent: Int,
  ): Map<String, String> {
    val safePercent = percent.coerceIn(0, 100)
    Log.d(TAG, "set brightness: $safePercent%")
    onFunctionCalled(SetBrightnessAction(percent = safePercent))
    return mapOf("result" to "success", "percent" to safePercent.toString())
  }

  /** Opens Android Settings. */
  @Tool(description = "Opens the main Android Settings app.")
  fun openSettings(): Map<String, String> {
    Log.d(TAG, "open settings")
    onFunctionCalled(OpenSettingsAction())
    return mapOf("result" to "success")
  }

  /** Opens Android Quick Settings. */
  @Tool(description = "Opens the Android Quick Settings panel / control panel.")
  fun openQuickSettings(): Map<String, String> {
    Log.d(TAG, "open quick settings")
    onFunctionCalled(OpenQuickSettingsAction())
    return mapOf("result" to "success")
  }

  /** Opens the Android internet connectivity panel. */
  @Tool(description = "Opens the Android internet connectivity control panel where the user can control Wi-Fi and mobile data.")
  fun openInternetControlPanel(): Map<String, String> {
    Log.d(TAG, "open internet control panel")
    onFunctionCalled(OpenInternetPanelAction())
    return mapOf("result" to "success")
  }

  /** Opens Bluetooth settings. */
  @Tool(description = "Opens Android Bluetooth settings.")
  fun openBluetoothSettings(): Map<String, String> {
    Log.d(TAG, "open bluetooth settings")
    onFunctionCalled(OpenBluetoothSettingsAction())
    return mapOf("result" to "success")
  }

  /** Creates calendar events. */
  @Tool(description = "Creates a new calendar event.")
  fun createCalendarEvent(
    @ToolParam(description = "The date and time of the event in the format YYYY-MM-DDTHH:MM:SS.")
    datetime: String,
    @ToolParam(description = "The title of the event.") title: String,
  ): Map<String, String> {
    Log.d(TAG, "Create calendar event. Datetime: '$datetime', title: '$title'")

    onFunctionCalled(CreateCalendarEventAction(datetime = datetime, title = title))

    return mapOf("result" to "success", "datetime" to datetime, "title" to title)
  }
}
