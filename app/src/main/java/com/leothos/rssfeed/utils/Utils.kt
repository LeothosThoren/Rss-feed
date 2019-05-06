package com.leothos.rssfeed.utils

import java.text.SimpleDateFormat
import java.util.*

fun jsInjection2():String = "javascript:(function() { " +
        "var info = document.getElementById('ncontent');" +
        "var objRef = document.body;" +
        "objRef.innerHTML = 'replace body!';" +
        "objRef.parentNode.replaceChild(info, objRef);" +
        "document.getElementsByClassName('medium_txt')[0].style.display = 'none';"+
        "})()"

/**
 * dateFormatterEn display the pattern dd/MM/yyyy HH:mm:ss and return a string value
 * @param str: String
 * */
fun dateFormatterFR(str: String?): String {
    val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
    val toFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return sdf.format(toFormat.parse(str))
}