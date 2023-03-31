package com.saltedge.applink

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handleIntent(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    private fun handleIntent(intent: Intent) {
        val appLinkAction = intent.action
        val appLinkData: Uri? = intent.data
        val titleView = this.findViewById(R.id.titleView) as TextView
        val clientView = this.findViewById(R.id.clientView) as TextView
        val stateView = this.findViewById(R.id.stateView) as TextView
        if (Intent.ACTION_VIEW == appLinkAction) {
            Log.d("APP_LINK_TEST", "appLinkData: $appLinkData")
            appLinkData?.let { data ->
                val path: String? = data.path
                if (path?.contains("ob-app") == true) {
                    //set title
                    titleView.text = "OB Page"
                    val clientId = data.getQueryParameter("client_id") ?: ""
                    clientView.text = "ClientId: $clientId"
                    val state = data.getQueryParameter("state") ?: ""
                    stateView.text = "State: $state"
                }
            }
        }
    }
}