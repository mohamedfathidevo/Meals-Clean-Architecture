package com.mohamedfathidev.domain.util

sealed class NetworkState {
    object Available : NetworkState()
    object Unavailable : NetworkState()
}