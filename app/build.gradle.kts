plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp") // KSP (Para Room)
    id("dagger.hilt.android.plugin") // Hilt
    kotlin("kapt") // KAPT (Para Hilt)
    id("kotlin-parcelize")
}

android {
    namespace = "com.kodeleku.appstorage_examen"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.kodeleku.appstorage_examen"
        minSdk = 31
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
    viewBinding{
        enable=true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation (libs.androidx.core.core.ktx.v190.x10)
    implementation (libs.androidx.appcompat.v151)
    implementation (libs.androidx.recyclerview)
    implementation (libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.androidx.lifecycle.livedata.ktx)
    implementation (libs.androidx.activity.ktx)
    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.kotlinx.coroutines.android)
    implementation (libs.hilt.android)
    kapt (libs.hilt.android.compiler)
    implementation (libs.picasso)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}