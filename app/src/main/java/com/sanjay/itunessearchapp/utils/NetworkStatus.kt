package com.sanjay.itunessearchapp.utils

sealed class NetworkStatus {
    object Success : NetworkStatus()
    object Loading : NetworkStatus()
    object Error : NetworkStatus()
}
