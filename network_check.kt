...

private fun networkCheck(): Boolean {  //checking network
        val connMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            connMgr.allNetworks.forEach { network ->
                connMgr.getNetworkInfo(network).apply {
                    if (this!!.type == ConnectivityManager.TYPE_WIFI ||
                            this!!.type == ConnectivityManager.TYPE_MOBILE) {
                        return true
                    }
                }
            }
        }
        return false
    }
 
 if(!networkCheck()){  //if network disconnecting, alert dialog showing
    val dialogBuilder = AlertDialog.Builder(this)
    val layoutView = layoutInflater.inflate(R.layout.dialog_network_retry, null)
    val okButton: TextView = layoutView.findViewById(R.id.splash_network_retry_button)
    dialogBuilder.setView(layoutView)
    val alertDialog = dialogBuilder.create()
    alertDialog.setCancelable(false)
    alertDialog.show()

    okButton.setOnClickListener {
        alertDialog.cancel()
    }
  } 
  
...
