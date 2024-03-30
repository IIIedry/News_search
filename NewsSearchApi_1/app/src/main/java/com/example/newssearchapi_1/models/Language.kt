package com.example.newssearchapi_1.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class language{
    @SerialName("ar")
    AR,

    @SerialName("de")
    DE,

    @SerialName("en")
    EN,

    @SerialName("es")
    ES,

    @SerialName("fr")
    FR,

    @SerialName("he")
    HE,

    @SerialName("it")
    IT,

    @SerialName("nl")
    NL,

    @SerialName("no")
    NO,

    @SerialName("pt")
    PT,

    @SerialName("ru")
    RU,

    @SerialName("sv")
    SV,

    @SerialName("ud")
    UD,

    @SerialName("zh")
    ZH

}