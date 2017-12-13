package com.wakemeintime.dffc.wakemeintime

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.common.api.Status
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {
    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        Log.d("DFFC", "connection failed" + connectionResult)
    }

    @Suppress("PrivatePropertyName")
    private val RC_SIGN_IN = 9001
    private var mStatusTextView: TextView? = null
    private var mGoogleApiClient: GoogleApiClient? = null
    private var isLogin: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        updateUI2(isLogin)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        mGoogleApiClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build()


        sign_in_button.setOnClickListener({
            val signInIntend = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
            startActivityForResult(signInIntend, RC_SIGN_IN)
        })

        sign_out_and_disconnect.setOnClickListener({
            Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback {
                object : ResultCallback<Status> {
                    override fun onResult(status: Status) {
                        updateUI2(status.isSuccess)
                    }
                }
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            updateUI2(result.isSuccess)
        }
    }

    private fun updateUI2(isLogin: Boolean) {
        if (isLogin) {
            val account: GoogleSignInAccount? = GoogleSignIn.getLastSignedInAccount(this)
            mStatusTextView?.setText(getString(R.string.signed_in_fmt, account?.displayName))

            sign_in_button.visibility = View.GONE
            sign_out_and_disconnect.visibility = View.VISIBLE
        } else {
            mStatusTextView?.setText(R.string.signed_out)

            sign_in_button.visibility = View.VISIBLE
            sign_out_and_disconnect.visibility = View.GONE
        }
    }
}
