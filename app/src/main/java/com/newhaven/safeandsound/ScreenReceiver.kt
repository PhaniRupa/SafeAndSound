package com.newhaven.safeandsound

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log


class ScreenReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.e("LOB", "onReceive")
        if (intent.action == Intent.ACTION_SCREEN_OFF) {
            // do whatever you need to do here
            wasScreenOn = false
            Log.e("LOB", "wasScreenOn" + wasScreenOn)
        } else if (intent.action == Intent.ACTION_SCREEN_ON) {
            // and do whatever you need to do here
            wasScreenOn = true
        } else if (intent.action == Intent.ACTION_USER_PRESENT) {
            Log.e("LOB", "userpresent")
            Log.e("LOB", "wasScreenOn" + wasScreenOn)
            val url = "http://www.stackoverflow.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            i.data = Uri.parse(url)
            context.startActivity(i)
        }
    }

    companion object {
        var wasScreenOn = true
    }
}
