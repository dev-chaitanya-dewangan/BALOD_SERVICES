# 02 — System Architecture

## High-Level Architecture

```
┌────────────────────────────────────────────────────────────┐
│                    ANDROID APP (Kotlin)                     │
│                                                            │
│  ┌──────────┐  ┌──────────┐  ┌──────────┐  ┌──────────┐  │
│  │  Home    │  │ Services │  │ Worker   │  │ Profile  │  │
│  │ Fragment │  │ Fragment │  │ Detail   │  │ Fragment │  │
│  └────┬─────┘  └────┬─────┘  └────┬─────┘  └────┬─────┘  │
│       └─────────────┴─────────────┴──────────────┘        │
│                          │                                  │
│              ┌───────────▼──────────────┐                  │
│              │     ViewModel Layer       │                  │
│              │  HomeViewModel            │                  │
│              │  WorkerViewModel          │                  │
│              └───────────┬──────────────┘                  │
│                          │                                  │
│              ┌───────────▼──────────────┐                  │
│              │    Repository Layer        │                  │
│              │  WorkerRepository         │                  │
│              └───────────┬──────────────┘                  │
└──────────────────────────┼─────────────────────────────────┘
                           │
            ┌──────────────▼───────────────┐
            │         FIREBASE              │
            │                              │
            │  ┌────────────────────────┐  │
            │  │   Firebase Auth         │  │
            │  │   (Phone OTP Login)     │  │
            │  └────────────────────────┘  │
            │                              │
            │  ┌────────────────────────┐  │
            │  │   Cloud Firestore       │  │
            │  │   workers/{workerId}   │  │
            │  │   categories/{catId}   │  │
            │  │   reviews/{reviewId}   │  │
            │  └────────────────────────┘  │
            │                              │
            │  ┌────────────────────────┐  │
            │  │   Firebase Storage      │  │
            │  │   worker-photos/       │  │
            │  └────────────────────────┘  │
            └──────────────────────────────┘

## App Architecture Pattern: MVVM + Repository

Layer               Technology
─────────────────── ──────────────────────────────
UI Layer            Fragments + ViewBinding + Material 3
ViewModel           AndroidX ViewModel + LiveData/StateFlow
Repository          Single source of truth (Firestore + local cache)
Data Source         Firebase Firestore (remote) + Room DB (local cache, V2)
DI                  Manual DI (V1) → Hilt (V2)

## Navigation Architecture
MainActivity (NavHost)
    ├── HomeFragment          /home
    ├── ServicesFragment      /services
    ├── WorkerDetailFragment  /worker/{workerId}
    └── ProfileFragment       /profile

## Firebase Firestore Schema

workers/
  {workerId}/
    name: String              "Ramesh Vishwakarma"
    nameHindi: String         "रमेश विश्वकर्मा"
    trade: String             "Electrician"
    tradeHindi: String        "बिजली मिस्त्री"
    categoryId: String        "electrician"
    phone: String             "+919876543210"
    whatsapp: String          "+919876543210"
    location: String          "Balod Chowk"
    distanceKm: Double        0.8
    rating: Double            4.8
    totalReviews: Int         120
    totalJobs: Int            340
    yearsExperience: Int      9
    isVerified: Boolean       true
    isActive: Boolean         true
    services: [String]        ["Home Wiring", "Meter Fitting"]
    photoUrls: [String]       ["gs://..."]
    subscriptionExpiry: Timestamp
    createdAt: Timestamp

categories/
  {categoryId}/
    name: String              "Electrician"
    nameHindi: String         "बिजली मिस्त्री"
    icon: String              "ic_electrician"
    color: String             "#7C4DFF"
    description: String       "बिजली फिटिंग, वायरिंग..."
    descriptionHindi: String

## Security Rules (Firestore)
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    // Anyone can read workers
    match /workers/{workerId} {
      allow read: if true;
      // Only authenticated worker can write their own doc
      allow write: if request.auth != null 
                   && request.auth.uid == workerId;
    }
    // Only admins can write categories
    match /categories/{catId} {
      allow read: if true;
      allow write: if false; // Admin only via console
    }
  }
}
```
