package com.pdpano.belly.domain.exceptions

class NotFoundException(val research: String): Exception("Research: $research was not found.")