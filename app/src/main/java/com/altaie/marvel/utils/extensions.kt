package com.altaie.marvel.utils

import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils.md5

fun String.toMD5(): String = Hex.encodeHexString(md5(this))
