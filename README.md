# TODO: PROJECT NOT FINISHED

# Open Budget - Android
Open-source Android project for managing budgets for autonomous professionals.
The idea was to create an Android application using the latest AndroidX and Jetpack components (2022) and a modular/clean architecture.

## Architecture
MVVM following the official Android's architecture guide. (https://developer.android.com/jetpack/guide)
![image](https://developer.android.com/topic/libraries/architecture/images/mad-arch-overview-data.png)

Presentation > ViewModel > Use Case (Domain) > Repository > Data Source

## Frameworks & Tools
* **Koin** for Dependency Injection
* **ViewBinding** for UI access
* **Room** for local storage
* **Navigation** for navigation (oh, rly?)
* **Flow** instead of **LiveData**

If you want to have more details about how the code works, take a look at the repo.
And if you have any questions or suggestions, contact me.
