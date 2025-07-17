
# 🛒 E-Commerce Android App

![Home Screen](screenshots/home.png)
![Product Details](screenshots/details.png)

A **fully functional E-Commerce Android App** built using **Kotlin (MVVM Architecture)** and **XML layouts** in Android Studio.  
This project is inspired by the beautiful UI showcased in this [UI Lover video](https://www.youtube.com/watch?v=PtBiFPYnUWE), and extended with backend logic, model classes, live data binding, and a modular code structure for scalability.

---

## 🔗 Download & Run

1. **Clone the repo:**
   ```bash
   git clone https://github.com/RishulGupta/E-Commerce-App.git
   ```

2. **Open in Android Studio**  
   Launch Android Studio and open the cloned project directory.

3. **Build & Run**  
   Connect your device or start an emulator, then click ▶️ **Run**.

---

## 🚀 Features

- 🛍️ **Product Listing UI** with name, price, and image
- 🖼️ Dynamic product list using **RecyclerView**
- 💖 Wishlist feature with toggle support
- 🔍 Search bar (UI in place, easily extendable)
- 🛒 Cart and Add-to-Cart button with logic implemented
- 📦 Product details screen
- 💡 Clean and modular MVVM Architecture
- 🌐 Backend-ready structure using dummy data (can be switched to Firebase or REST API)

---

## 🧠 Architecture

The app follows **MVVM (Model-View-ViewModel)** pattern:

- **Model**: Defines data classes and provides sample product data (can be connected to backend).
- **ViewModel**: Handles business logic and exposes LiveData to the UI.
- **View (Activities/Fragments)**: Observes LiveData and updates the UI accordingly.
- **Repository**: Acts as the single source of truth, can be extended to fetch data from APIs or Firebase.
- **Adapters**: Custom adapters for RecyclerView to render product lists and wishlist.

---

## 🔧 Tech Stack

- **Language**: Kotlin
- **UI**: XML (ConstraintLayout, CardView, RecyclerView)
- **Architecture**: MVVM
- **Image Loading**: Glide
- **State Management**: LiveData + ViewModel
- **IDE**: Android Studio

---

## 📚 Tutorial Source

UI inspired from:  
🎥 [UI Lover: Simple Ecommerce App UI in Android Studio](https://www.youtube.com/watch?v=PtBiFPYnUWE)

---

## 📌 Future Improvements

- 🔐 User authentication using Firebase
- 🔄 Real-time product data via Firebase or REST APIs
- 🛒 Cart management and checkout flow
- 📦 Order summary and purchase history
- 💳 Payment gateway integration (Stripe, Razorpay)

---

## 📄 License

This project is open-source and built for learning and educational purposes only.
