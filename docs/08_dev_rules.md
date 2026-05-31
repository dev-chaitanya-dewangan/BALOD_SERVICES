# 08 — Development Rules & Standards

## Coding Standards
1. **Language**: Kotlin only — no Java files
2. **Architecture**: MVVM — no business logic in Fragments
3. **ViewBinding**: Always use ViewBinding, never `findViewById`
4. **Coroutines**: Use `viewModelScope.launch` for async work
5. **Resource IDs**: snake_case (e.g., `tv_worker_name`, `btn_call`)
6. **String resources**: ALL user-visible strings must be in `strings.xml`

## Naming Conventions
| Type | Convention | Example |
|:---|:---|:---|
| Activity | PascalCase + Activity | `MainActivity` |
| Fragment | PascalCase + Fragment | `HomeFragment` |
| ViewModel | PascalCase + ViewModel | `WorkerViewModel` |
| Layout — Activity | `activity_` | `activity_main.xml` |
| Layout — Fragment | `fragment_` | `fragment_home.xml` |
| Layout — Item | `item_` | `item_worker_card.xml` |
| Colors | snake_case | `color_primary_purple` |
| Drawables | `ic_` for icons | `ic_plumber.xml` |

## Git Commit Rules
- `feat:` New feature
- `fix:` Bug fix
- `style:` UI/layout changes
- `docs:` Documentation
- `refactor:` Code restructure
- `chore:` Dependency updates

## DO / DON'T Rules
| DO | DON'T |
|:---|:---|
| Use LiveData/StateFlow | Use callbacks in ViewModel |
| Use string resources | Hardcode Hindi text in XML |
| Handle null safely with `?.` | Force-unwrap `!!` |
| Use Material 3 components | Create custom views from scratch |
| Use Glide for images | Use Picasso or manual bitmap loading |
| Log with `Timber` | Use raw `Log.d()` |
