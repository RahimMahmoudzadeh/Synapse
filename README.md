# Synapse 💬📱

Synapse is a modern, open-source, cross-platform communication application designed to deliver seamless chat, voice/video calling, and group conversations. Built from the ground up using **Compose Multiplatform (CMP)**, the project currently targets mobile platforms (Android & iOS) with a robust, scalable, and modular architecture.

---

## 🔗 Project Links

* **Mobile Repository (CMP):** [github.com/RahimMahmoudzadeh/Synapse](https://github.com/RahimMahmoudzadeh/Synapse)
* **Backend Repository:** [github.com/Amir-Golmoradi/Synapse](https://github.com/Amir-Golmoradi/Synapse)

---

## 🚀 Features

### Current & In-Development
* **Cross-Platform UI:** Shared codebase using Compose Multiplatform for a consistent experience across Android and iOS.
* **Authentication:** Secure and seamless Social Login with Google.
* **Modern Navigation:** Powered by the latest **Navigation 3** for compose-based component routing.
* **Local Storage:** Native reactive data persistence utilizing **Room 3** (Multiplatform).

### Roadmap & Future Scope
* **Rich Communication:** Implementation of Real-time Group Chats, Voice, and Video Calling.
* **Adaptive Layouts:** Fully optimized interfaces for Large Screens, Tablets, Foldables (Android), and iPadOS.
* **Expanded Target Support:** Future platform expansions as Compose Multiplatform capabilities mature.

---

## 🏗️ Architecture & Project Structure

Synapse is built upon strict software engineering principles to ensure maintainability, testability, and scalability.

### Clean Architecture
The project enforces a separation of concerns by splitting the codebase into layers:
1.  **Presentation Layer:** Contains UI components (Compose) and State Management handlers.
2.  **Domain Layer:** Holds the core business logic, Use Cases, and domain models (completely independent of frameworks).
3.  **Data Layer:** Manages data coordination between network resources (Ktor) and local persistence (Room).

### MVI (Model-View-Intent) Pattern
To achieve a predictable unidirectional data flow (UDF):
* **Intent:** Represents user actions or system events.
* **Model/State:** A single source of truth representing the current UI state.
* **View:** Renders the state and dispatches intents.

### Build System
* **Gradle Convention Plugins:** Build logic is fully modularized using custom pre-compiled convention plugins to ensure clean, reusable, and single-source-of-truth dependency management across modules.

---

## 🛠️ Tech Stack & Libraries

* **UI Framework:** [Compose Multiplatform (CMP)](https://github.com/JetBrains/compose-multiplatform)
* **Language:** Kotlin (100%)
* **Navigation:** Navigation 3
* **Database:** Room 3 (Kotlin Multiplatform support)
* **Networking:** [Ktor Client](https://ktor.io/)
* **Serialization:** *TBD* (Evaluating `kotlinx.serialization` / Gson / Moshi)
* **Dependency Injection:** *TBD* (e.g., Koin / Hilt)

---

## 📱 Platform Support

| Platform | Status | Notes |
| :--- | :--- | :--- |
| **Android Mobile** | 🟢 Active Development | Core focus, launching first |
| **iOS Mobile** | 🟡 Upcoming | Next immediate phase |
| **Android Tablet / Foldables** | ⏳ Planned | UI/UX adjustments for large screens |
| **iPadOS** | ⏳ Planned | Optimized scaling via CMP |

---

## 🛠️ Getting Started

### Prerequisites
* Android Studio Ladybug / Meerkat (or latest stable version)
* Xcode (for iOS development, running on macOS)
* JDK 17 or higher

### Installation & Setup

1.  Clone the repository:
    ```bash
    git clone [https://github.com/RahimMahmoudzadeh/Synapse.git](https://github.com/RahimMahmoudzadeh/Synapse.git)
    cd Synapse
    ```

2.  Open the project in Android Studio.
3.  Sync Gradle projects and let dependencies download.
4.  To run on Android, select the `composeApp` run configuration and choose your device/emulator.

*(Instructions for iOS building will be updated as the iOS target pipeline completes).*

---

## 🤝 Contributing

Synapse is an open-source project and welcomes contributions! Whether you want to fix a bug, suggest a feature, or improve the documentation:

1.  Fork the Project.
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`).
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`).
4.  Push to the Branch (`git push origin feature/AmazingFeature`).
5.  Open a Pull Request.

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.