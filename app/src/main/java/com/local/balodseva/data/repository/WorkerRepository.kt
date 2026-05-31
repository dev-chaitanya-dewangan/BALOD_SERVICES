package com.local.balodseva.data.repository

import com.local.balodseva.R
import com.local.balodseva.data.model.ServiceCategory
import com.local.balodseva.data.model.Worker

/**
 * WorkerRepository — Single source of truth for worker data.
 * V1: Returns local mock data.
 * V2: Will switch to Firestore with local Room cache.
 */
object WorkerRepository {

    // =========================================================
    // MOCK DATA — Replace with Firestore calls in V2
    // =========================================================
    private val mockWorkers = listOf(
        Worker(
            id = "w001",
            name = "Mr. Wilson",
            nameHindi = "मिस्टर विल्सन",
            trade = "Plumber",
            tradeHindi = "प्लंबर",
            categoryId = "plumber",
            phone = "tel:+919876543210",
            whatsapp = "https://wa.me/919876543210",
            location = "Balod Chowk, Balod",
            distanceKm = 0.5,
            rating = 4.9,
            totalReviews = 3900,
            totalJobs = 340,
            yearsExperience = 9,
            language = "हिंदी",
            isVerified = true,
            services = listOf("पाइप फिटिंग", "टंकी सफाई", "लीकेज रिपेयर", "बाथरूम फिटिंग", "वाटर पंप"),
            photoUrls = emptyList()
        ),
        Worker(
            id = "w002",
            name = "Ramesh Vishwakarma",
            nameHindi = "रमेश विश्वकर्मा",
            trade = "Electrician",
            tradeHindi = "इलेक्ट्रीशियन",
            categoryId = "electrician",
            phone = "tel:+919876543211",
            whatsapp = "https://wa.me/919876543211",
            location = "Station Road, Balod",
            distanceKm = 0.8,
            rating = 4.8,
            totalReviews = 120,
            totalJobs = 340,
            yearsExperience = 9,
            language = "हिंदी",
            isVerified = true,
            services = listOf("होम वायरिंग", "मीटर फिटिंग", "इन्वर्टर सेटअप", "फैन इंस्टॉलेशन"),
            photoUrls = emptyList()
        ),
        Worker(
            id = "w003",
            name = "Suresh Kumar",
            nameHindi = "सुरेश कुमार",
            trade = "Mason",
            tradeHindi = "मिस्त्री",
            categoryId = "mason",
            phone = "tel:+919876543212",
            whatsapp = "https://wa.me/919876543212",
            location = "Gandhi Nagar, Balod",
            distanceKm = 1.5,
            rating = 4.7,
            totalReviews = 200,
            totalJobs = 420,
            yearsExperience = 15,
            language = "हिंदी",
            isVerified = true,
            services = listOf("प्लास्टरिंग", "टाइल वर्क", "ईंट का काम", "छत ढलाई"),
            photoUrls = emptyList()
        ),
        Worker(
            id = "w004",
            name = "Mahesh Thakur",
            nameHindi = "महेश ठाकुर",
            trade = "Contractor",
            tradeHindi = "ठेकेदार",
            categoryId = "contractor",
            phone = "tel:+919876543213",
            whatsapp = "https://wa.me/919876543213",
            location = "Dalli Road, Balod",
            distanceKm = 2.0,
            rating = 4.6,
            totalReviews = 80,
            totalJobs = 55,
            yearsExperience = 12,
            language = "हिंदी",
            isVerified = false,
            services = listOf("मकान निर्माण", "दुकान निर्माण", "रिनोवेशन", "बिल्डिंग"),
            photoUrls = emptyList()
        ),
        Worker(
            id = "w005",
            name = "Dilip Mechanic",
            nameHindi = "दिलीप मैकेनिक",
            trade = "Mechanic",
            tradeHindi = "मैकेनिक",
            categoryId = "mechanic",
            phone = "tel:+919876543214",
            whatsapp = "https://wa.me/919876543214",
            location = "Balod Market",
            distanceKm = 0.3,
            rating = 4.5,
            totalReviews = 300,
            totalJobs = 1200,
            yearsExperience = 8,
            language = "हिंदी",
            isVerified = true,
            services = listOf("बाइक सर्विस", "कार सर्विस", "इंजन रिपेयर", "गियर बॉक्स"),
            photoUrls = emptyList()
        )
    )

    private val mockCategories = listOf(
        ServiceCategory("plumber", "Plumber", "प्लंबर",
            "Pipe, tap, tank repair & fitting",
            "नल, पाइप, टंकी आदि की मरम्मत और फिटिंग",
            R.drawable.ic_nav_services, "#7C4DFF", 1),
        ServiceCategory("electrician", "Electrician", "इलेक्ट्रीशियन",
            "Wiring, fitting, fans & lights",
            "बिजली फिटिंग, वायरिंग, पंखा, लाइट आदि",
            R.drawable.ic_nav_services, "#FF6D00", 2),
        ServiceCategory("mason", "Mason", "मिस्त्री",
            "Wall, plaster, tiles work",
            "दीवार, प्लास्टर, टाइल्स का काम",
            R.drawable.ic_nav_services, "#00897B", 3),
        ServiceCategory("contractor", "Contractor", "ठेकेदार",
            "Construction, house, building",
            "निर्माण कार्य, मकान, बिल्डिंग आदि",
            R.drawable.ic_nav_services, "#F57F17", 4),
        ServiceCategory("mechanic", "Mechanic", "मैकेनिक",
            "Bike, car, scooter servicing",
            "बाइक, कार, स्कूटर की सर्विसिंग और सर्विस",
            R.drawable.ic_nav_services, "#1565C0", 5)
    )

    fun getAllWorkers(): List<Worker> = mockWorkers

    fun getWorkersByCategory(categoryId: String): List<Worker> {
        if (categoryId == "all") return mockWorkers
        return mockWorkers.filter { it.categoryId == categoryId }
    }

    fun searchWorkers(query: String): List<Worker> {
        if (query.isBlank()) return mockWorkers
        val q = query.lowercase()
        return mockWorkers.filter {
            it.name.lowercase().contains(q) ||
            it.nameHindi.contains(q) ||
            it.trade.lowercase().contains(q) ||
            it.tradeHindi.contains(q) ||
            it.location.lowercase().contains(q) ||
            it.services.any { s -> s.lowercase().contains(q) }
        }
    }

    fun getWorkerById(id: String): Worker? = mockWorkers.find { it.id == id }

    fun getAllCategories(): List<ServiceCategory> = mockCategories
}
