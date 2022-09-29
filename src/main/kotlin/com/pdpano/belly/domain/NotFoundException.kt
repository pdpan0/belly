package com.pdpano.belly.domain

class NotFoundException(research: String): Exception("Recurso: $research não encontrado.") {
}