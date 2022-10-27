package com.pdpano.belly.domain

class NotFoundException(research: String): Exception("Research: $research was not found.")