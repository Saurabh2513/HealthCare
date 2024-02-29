plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.retrofit1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.retrofit1"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        dataBinding = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // dependency for loading image from url
    // Image load
//    implementation ("com.squareup.picasso:picasso:2.71828")
    implementation ("com.squareup.picasso:picasso:2.8")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // - - ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    // - - LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    // Page indicator
    implementation("com.tbuonomo:dotsindicator:4.2")

    // retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
// GSON
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
// coroutine
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    kapt ("com.github.bumptech.glide:compiler:4.14.2")

}