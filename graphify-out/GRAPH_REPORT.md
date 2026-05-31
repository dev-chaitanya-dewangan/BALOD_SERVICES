# Graph Report - BalodSeva  (2026-05-31)

## Corpus Check
- 24 files · ~4,961 words
- Verdict: corpus is large enough that graph structure adds value.

## Summary
- 173 nodes · 196 edges · 23 communities (17 shown, 6 thin omitted)
- Extraction: 100% EXTRACTED · 0% INFERRED · 0% AMBIGUOUS
- Token cost: 0 input · 0 output

## Community Hubs (Navigation)
- [[_COMMUNITY_Community 0|Community 0]]
- [[_COMMUNITY_Community 1|Community 1]]
- [[_COMMUNITY_Community 2|Community 2]]
- [[_COMMUNITY_Community 3|Community 3]]
- [[_COMMUNITY_Community 4|Community 4]]
- [[_COMMUNITY_Community 5|Community 5]]
- [[_COMMUNITY_Community 6|Community 6]]
- [[_COMMUNITY_Community 7|Community 7]]
- [[_COMMUNITY_Community 8|Community 8]]
- [[_COMMUNITY_Community 9|Community 9]]
- [[_COMMUNITY_Community 10|Community 10]]
- [[_COMMUNITY_Community 11|Community 11]]
- [[_COMMUNITY_Community 12|Community 12]]
- [[_COMMUNITY_Community 13|Community 13]]
- [[_COMMUNITY_Community 14|Community 14]]
- [[_COMMUNITY_Community 15|Community 15]]
- [[_COMMUNITY_Community 16|Community 16]]
- [[_COMMUNITY_Community 17|Community 17]]
- [[_COMMUNITY_Community 18|Community 18]]

## God Nodes (most connected - your core abstractions)
1. `HomeFragment` - 10 edges
2. `MainActivity` - 10 edges
3. `04 — Firebase Setup Guide` - 10 edges
4. `WorkerDetailFragment` - 9 edges
5. `ServicesFragment` - 8 edges
6. `CategoryAdapter` - 7 edges
7. `01 — Product Vision & PM Brief` - 7 edges
8. `WorkerRepository` - 6 edges
9. `BookingsFragment` - 5 edges
10. `ProfileFragment` - 5 edges

## Surprising Connections (you probably didn't know these)
- `MainActivity` --inherits--> `AppCompatActivity`  [EXTRACTED]
  app/src/main/java/com/local/balodseva/ui/home/MainActivity.kt →   _Bridges community 10 → community 6_
- `HomeFragment` --inherits--> `Fragment`  [EXTRACTED]
  app/src/main/java/com/local/balodseva/ui/home/HomeFragment.kt →   _Bridges community 0 → community 3_
- `ServicesFragment` --inherits--> `Fragment`  [EXTRACTED]
  app/src/main/java/com/local/balodseva/ui/services/ServicesFragment.kt →   _Bridges community 0 → community 7_
- `WorkerDetailFragment` --inherits--> `Fragment`  [EXTRACTED]
  app/src/main/java/com/local/balodseva/ui/worker/WorkerDetailFragment.kt →   _Bridges community 0 → community 2_

## Import Cycles
- None detected.

## Communities (23 total, 6 thin omitted)

### Community 0 - "Community 0"
Cohesion: 0.11
Nodes (13): Bundle, LayoutInflater, View, ViewGroup, Bundle, LayoutInflater, View, ViewGroup (+5 more)

### Community 1 - "Community 1"
Cohesion: 0.20
Nodes (10): Int, ServiceCategory, ViewGroup, CategoryViewHolder, DiffUtil, ListAdapter, RecyclerView, CategoryAdapter (+2 more)

### Community 2 - "Community 2"
Cohesion: 0.17
Nodes (9): Bundle, Int, LayoutInflater, String, View, ViewGroup, Worker, FragmentWorkerDetailBinding (+1 more)

### Community 3 - "Community 3"
Cohesion: 0.19
Nodes (7): Bundle, LayoutInflater, String, View, ViewGroup, FragmentHomeBinding, HomeFragment

### Community 4 - "Community 4"
Cohesion: 0.17
Nodes (11): 03 — UI Design Specification, Bottom Navigation Items, Color Palette, Design System Tokens, Reference UI (Source Image), Screen 1 — Home (HomeFragment), Screen 2 — Services List (ServicesFragment), Screen 3 — Worker Detail (WorkerDetailFragment) (+3 more)

### Community 5 - "Community 5"
Cohesion: 0.17
Nodes (11): 04 — Firebase Setup Guide, categories collection, google-services.json Placeholder, Gradle Dependencies Required, Step 1: Create Firebase Project, Step 2: Add Android App, Step 3: Enable Phone Auth, Step 4: Setup Firestore (+3 more)

### Community 6 - "Community 6"
Cohesion: 0.27
Nodes (5): ActivityMainBinding, Bundle, MainActivity, WorkerAdapter, WorkerCategory

### Community 7 - "Community 7"
Cohesion: 0.23
Nodes (7): Bundle, LayoutInflater, View, ViewGroup, CategoryAdapter, FragmentServicesBinding, ServicesFragment

### Community 8 - "Community 8"
Cohesion: 0.33
Nodes (5): ServiceCategory, String, Worker, List, WorkerRepository

### Community 9 - "Community 9"
Cohesion: 0.20
Nodes (9): 01 — Product Vision & PM Brief, Out of Scope (V1), Primary — The Seeker (App User), Problem Statement, Scope — V1 (What We Build First), Secondary — The Worker (App Partner / Revenue Source), Solution, Success Metrics (V1 — 90 Days) (+1 more)

### Community 10 - "Community 10"
Cohesion: 0.33
Nodes (4): ActivityMainBinding, Bundle, AppCompatActivity, MainActivity

### Community 11 - "Community 11"
Cohesion: 0.47
Nodes (5): Int, ViewGroup, onBindViewHolder(), onCreateViewHolder(), WorkerViewHolder

### Community 12 - "Community 12"
Cohesion: 0.33
Nodes (5): 08 — Development Rules & Standards, Coding Standards, DO / DON'T Rules, Git Commit Rules, Naming Conventions

## Knowledge Gaps
- **66 isolated node(s):** `ActivityMainBinding`, `Bundle`, `Worker`, `ServiceCategory`, `Worker` (+61 more)
  These have ≤1 connection - possible missing edges or undocumented components.
- **6 thin communities (<3 nodes) omitted from report** — run `graphify query` to explore isolated nodes.

## Suggested Questions
_Questions this graph is uniquely positioned to answer:_

- **Why does `WorkerDetailFragment` connect `Community 2` to `Community 0`?**
  _High betweenness centrality (0.051) - this node is a cross-community bridge._
- **Why does `HomeFragment` connect `Community 3` to `Community 0`?**
  _High betweenness centrality (0.049) - this node is a cross-community bridge._
- **Why does `ServicesFragment` connect `Community 7` to `Community 0`?**
  _High betweenness centrality (0.040) - this node is a cross-community bridge._
- **What connects `ActivityMainBinding`, `Bundle`, `Worker` to the rest of the system?**
  _66 weakly-connected nodes found - possible documentation gaps or missing edges._
- **Should `Community 0` be split into smaller, more focused modules?**
  _Cohesion score 0.10526315789473684 - nodes in this community are weakly interconnected._