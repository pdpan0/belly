package com.pdpano.belly.domain.exceptions

class ConflictException(val research: String, override val message: String?): Exception()