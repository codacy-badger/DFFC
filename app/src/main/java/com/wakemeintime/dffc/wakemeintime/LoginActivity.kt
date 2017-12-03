package com.wakemeintime.dffc.wakemeintime

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {
    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        Log.d("DFFC", "connection failed" + connectionResult)
    }


    private val RC_SIGN_IN = 9001
    private var mStatusTextView: TextView? = null
    private var mGoogleSignInClient: GoogleSignInClient? = null
    private var mGoogleApiClient: GoogleApiClient? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        val account = GoogleSignIn.getLastSignedInAccount(this)
        updateUI(account)

        sign_in_button.setOnClickListener({
            val signInIntend = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
            startActivityForResult(signInIntend, RC_SIGN_IN)
        })

        sign_out_and_disconnect.setOnClickListener({
            Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback { updateUI(account) }
        })
    }

    private fun updateUI(account: GoogleSignInAccount?) {
        if (account != null) {
            mStatusTextView?.text = getString(R.string.signed_in_fmt, account.displayName)

            sign_in_button.visibility = View.GONE
            sign_out_and_disconnect.visibility = View.VISIBLE
        } else {
            mStatusTextView?.setText(R.string.signed_out)

            sign_in_button.visibility = View.VISIBLE
            sign_out_and_disconnect.visibility = View.GONE
        }
    }
}
