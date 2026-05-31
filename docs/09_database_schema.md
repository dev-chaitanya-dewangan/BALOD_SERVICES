# Firebase Database Schema

This document outlines the NoSQL structure for BalodSeva in Cloud Firestore.

## Collections

### 1. `users`
Stores information about the app users (customers).
- Document ID: `userId` (from Firebase Authentication UID)
- Fields:
  - `name`: string (Full Name)
  - `phone`: string (Phone number used for OTP auth)
  - `profilePicUrl`: string (URL to image in Firebase Storage, optional)
  - `createdAt`: timestamp

### 2. `workers`
Stores information about the local skilled tradesmen.
- Document ID: `workerId` (Auto-generated or custom)
- Fields:
  - `name`: string
  - `nameHindi`: string
  - `trade`: string
  - `tradeHindi`: string
  - `categoryId`: string (Reference to service category)
  - `phone`: string
  - `whatsapp`: string
  - `location`: string
  - `distanceKm`: number
  - `rating`: number
  - `totalReviews`: number
  - `totalJobs`: number
  - `yearsExperience`: number
  - `isVerified`: boolean
  - `services`: array of strings
  - `photoUrl`: string (URL to worker portrait)

### 3. `bookings`
Stores the service requests made by users.
- Document ID: auto-generated
- Fields:
  - `userId`: string (Reference to `users`)
  - `workerId`: string (Reference to `workers`)
  - `status`: string ("PENDING", "ACCEPTED", "COMPLETED", "CANCELLED")
  - `requestedDate`: timestamp
  - `description`: string
  - `createdAt`: timestamp
