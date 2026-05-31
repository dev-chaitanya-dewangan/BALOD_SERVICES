package com.local.balodseva.data.model

/**
 * Core data model for a skilled worker listed on BalodSeva.
 * This matches the Firestore document schema defined in docs/04_firebase_setup.md
 */
data class Worker(
    val id: String = "",
    val name: String = "",
    val nameHindi: String = "",
    val trade: String = "",
    val tradeHindi: String = "",
    val categoryId: String = "",
    val phone: String = "",
    val whatsapp: String = "",
    val location: String = "",
    val distanceKm: Double = 0.0,
    val rating: Double = 0.0,
    val totalReviews: Int = 0,
    val totalJobs: Int = 0,
    val yearsExperience: Int = 0,
    val language: String = "हिंदी",
    val isVerified: Boolean = false,
    val isActive: Boolean = true,
    val services: List<String> = emptyList(),
    val photoUrls: List<String> = emptyList()
)

/**
 * Service category model (Plumber, Electrician, Mason etc.)
 */
data class ServiceCategory(
    val id: String = "",
    val name: String = "",
    val nameHindi: String = "",
    val description: String = "",
    val descriptionHindi: String = "",
    val iconResId: Int = 0,
    val personaResId: Int = 0,
    val color: String = "#6B4EFF",
    val order: Int = 0
)
