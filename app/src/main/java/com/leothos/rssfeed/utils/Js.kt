package com.leothos.rssfeed.utils

fun jsInjection2():String = "javascript:(function() { " +
        "var info = document.getElementById('ncontent');" +
        "var objRef = document.body;" +
        "objRef.innerHTML = 'replace body!';" +
        "objRef.parentNode.replaceChild(info, objRef);" +
        "document.getElementsByClassName('medium_txt')[0].style.display = 'none';"+
        "})()"

