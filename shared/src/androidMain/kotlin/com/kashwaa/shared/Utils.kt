package com.kashwaa.shared
import com.google.gson.Gson

actual fun toJsonString(obj: Any) : String {
    return Gson().toJson(obj)
}