package com.kashwaa.shared

actual fun toJsonString(obj: Any) : String {
    return obj.toString()
}