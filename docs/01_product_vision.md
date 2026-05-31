# 01 — Product Vision & PM Brief

## Problem Statement
In Balod, Chhattisgarh (pop. ~120,000), when a pipe breaks at 9 PM, a homeowner opens
WhatsApp, asks 5 people, gets 3 wrong numbers, and waits until morning to find a plumber.
There is NO reliable, local, searchable directory of skilled workers.

Mainstream platforms (Urban Company, Sulekha) do NOT serve Tier-3+ towns. Local people
rely entirely on word-of-mouth. This creates:
- **For Seekers**: Delay, wrong contacts, overcharging, no trust signals
- **For Workers**: Zero online presence, irregular income, no professional identity
- **For the Market**: ₹40,000+/mo untapped subscription revenue opportunity

## Solution
**BalodSeva** — A hyperlocal, Hindi-first Android app that:
1. Lists verified skilled workers (plumbers, electricians, masons, carpenters, etc.)
2. Lets seekers find and contact them with **ONE tap** (Phone or WhatsApp)
3. Requires **zero payment gateway** — all transactions happen offline
4. Charges workers a small **monthly subscription** for listing visibility

## Target Users

### Primary — The Seeker (App User)
- **Name**: Arjun Sahu, 32, Balod
- **Device**: Android (budget, 4G)
- **Literacy**: Hindi-speaking, moderate smartphone usage
- **Need**: Find a reliable plumber/electrician/mason within 30 minutes
- **Pain**: No online directory, has to call multiple people to find anyone

### Secondary — The Worker (App Partner / Revenue Source)
- **Name**: Ramesh Vishwakarma, 38, Balod
- **Trade**: Electrician, 9 years experience
- **Digital Skills**: WhatsApp, basic Android
- **Need**: More clients, professional credibility
- **Pain**: No way to advertise except word of mouth

## Success Metrics (V1 — 90 Days)
| Metric | Target |
|:---|:---:|
| Listed Workers (paying subscribers) | 50+ |
| Monthly Active Seekers | 500+ |
| Direct Calls / WhatsApp actions per day | 30+ |
| Monthly Revenue | ₹7,000+ |

## Scope — V1 (What We Build First)
- [x] Home Screen with greeting + search + category chips
- [x] Service category list (browse all categories)
- [x] Worker list per category
- [x] Worker detail page (profile, stats, services, call/WA buttons)
- [x] Firebase Phone Auth (OTP login for workers)
- [x] Firestore real-time worker data
- [ ] Worker self-registration portal (V2)
- [ ] Reviews system (V2)
- [ ] Subscription billing (V2)

## Out of Scope (V1)
- In-app payment or booking engine
- AI-based matching or scheduling
- Real-time location tracking
