# 03 — UI Design Specification

## Reference UI (Source Image)
The UI reference shows 3 screens:
1. **Home Screen**: Greeting, search, category chips, trust badges, hero CTA banner
2. **Services List Screen**: Category cards with icon + Hindi name + description + CTA
3. **Worker Detail Screen**: Profile hero, stats row, services chips, work photos, WhatsApp + Call

## Design System Tokens

### Color Palette
| Token | Hex | Usage |
|:---|:---|:---|
| `colorPrimary` | `#6B4EFF` | Primary purple — buttons, active chips, FAB |
| `colorPrimaryDark` | `#4A2FCC` | Status bar, pressed state |
| `colorSecondary` | `#25D366` | WhatsApp button only |
| `colorAccentOrange` | `#FF7043` | Category icon backgrounds (warm) |
| `colorAccentGreen` | `#4CAF50` | Verified badge, available status |
| `colorAccentBlue` | `#2196F3` | Category icon backgrounds (cool) |
| `colorBackground` | `#F8F9FE` | Screen background |
| `colorCardBg` | `#FFFFFF` | Card white |
| `colorTextPrimary` | `#1A1A2E` | Headings |
| `colorTextSecondary` | `#6B7280` | Subtext, labels |
| `colorDivider` | `#E8E8F0` | Dividers |

### Typography (Noto Sans Devanagari + Inter)
| Style | Size | Weight | Usage |
|:---|:---:|:---:|:---|
| Headline Large | 26sp | Bold | Home screen greeting |
| Headline Medium | 20sp | Bold | Category title |
| Title Large | 18sp | SemiBold | Worker name on detail |
| Title Medium | 16sp | SemiBold | Card titles |
| Body Large | 14sp | Regular | Descriptions |
| Body Small | 12sp | Regular | Tags, labels |
| Label | 10sp | Medium | Chips, badges |

### Spacing & Radius
| Token | Value |
|:---|:---|
| Corner radius — Cards | 16dp |
| Corner radius — Chips | 20dp |
| Corner radius — Buttons | 12dp |
| Horizontal margin | 16dp |
| Card padding | 16dp |
| Gap between cards | 12dp |

## Screen-by-Screen Breakdown

### Screen 1 — Home (HomeFragment)
```
┌─────────────────────────────┐
│ [Avatar]  नमस्ते,            │  ← Greeting bar (user profile row)
│           Arjun Sahu  📍  🛒│
├─────────────────────────────┤
│ Balod Services              │  ← Brand title (bold purple)
│ स्थानीय सेवा, आपके द्वार     │  ← Subtitle (Hindi tagline)
├─────────────────────────────┤
│ 🔍 कोई भी सेवा खोजें...     │  ← Search bar (rounded, grey bg)
├─────────────────────────────┤
│ [सभी] [प्लंबर] [इलेक्ट्री...]│  ← Horizontal chip row (scrollable)
├─────────────────────────────┤
│ ┌──────────┐ ┌───────────┐  │  ← Trust badges (2 column)
│ │24/7 सपोर्ट│ │100% सत्याप│  │
│ └──────────┘ └───────────┘  │
├─────────────────────────────┤
│ ┌───────────────────────┐   │  ← Hero banner card (purple bg)
│ │ बेहतरीन सेवा के लिए   │   │
│ │ भरोसेमंद कारीगर चुनें │   │
│ │ [अभी खोजें →]  [img]  │   │
│ └───────────────────────┘   │
├─────────────────────────────┤
│ 🏠  🔧  📅  👤             │  ← Bottom Navigation Bar
└─────────────────────────────┘
```

### Screen 2 — Services List (ServicesFragment)
```
┌─────────────────────────────┐
│ ☰  सेवाएँ             🔔    │  ← Top app bar
├─────────────────────────────┤
│ 📍 Balod, Chhattisgarh ⌄   │  ← Location selector chip
├─────────────────────────────┤
│ 🔍 कोई भी सेवा खोजें...  ⚙ │  ← Search bar with filter icon
├─────────────────────────────┤
│ ┌─────────────────────────┐ │
│ │ 🔧 प्लंबर               │ │  ← Category Card (Plumber)
│ │   नल, पाइप, टंकी...     │ │
│ │   [सेवा देखें →]        │ │
│ └─────────────────────────┘ │
│ ┌─────────────────────────┐ │
│ │ ⚡ इलेक्ट्रीशियन         │ │  ← Category Card (Electrician)
│ │   बिजली फिटिंग, वायरिंग │ │
│ │   [सेवा देखें →]        │ │
│ └─────────────────────────┘ │
│    ... more categories ...   │
└─────────────────────────────┘
```

### Screen 3 — Worker Detail (WorkerDetailFragment)
```
┌─────────────────────────────┐
│ ←          ♡  ↗            │  ← Back, fav, share
├─────────────────────────────┤
│ ┌────────────────────────┐  │
│ │      [Profile Photo]   │  │  ← Full-width hero image (pink/neutral bg)
│ │  [✓ Balod Services     │  │
│ │     द्वारा सत्यापित]   │  │
│ └────────────────────────┘  │
├─────────────────────────────┤
│ मिस्टर विल्सन  [प्लंबर]     │  ← Name + trade badge
│ ⭐ 4.9 (3.9k रेटिंग)        │
│ 📍 Balod Chowk, Balod       │
├─────────────────────────────┤
│ ┌────┐ ┌────┐ ┌────┐       │  ← Stats row (3 columns)
│ │ 9+ │ │340+│ │हिंदी│       │
│ │yrs │ │jobs│ │lang│       │
└─────────────────────────────┘
│ सेवाएं प्रदान की जाने वाली  │  ← Services label
│ [पाइप][टंकी][लीकेज][बाथरूम]│  ← Horizontal chip list
├─────────────────────────────┤
│ काम के फोटो          और देखें│  ← Work photos label
│ [img1] [img2] [img3]        │  ← Horizontal scroll photos
├─────────────────────────────┤
│ [  WhatsApp  ] [ अभी कॉल करें ]│  ← Fixed bottom action bar
└─────────────────────────────┘
```

## Bottom Navigation Items
| Icon | Label | Fragment |
|:---|:---|:---|
| Home | होम | HomeFragment |
| Grid | सेवाएँ | ServicesFragment |
| Calendar | मेरे बुकिंग | BookingsFragment (V2) |
| Person | प्रोफाइल | ProfileFragment |
