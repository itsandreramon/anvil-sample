plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.anvil)
}

android {
    namespace = "com.example.anvil"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.anvil"

        minSdk = 24
        targetSdk = 34

        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        buildConfig = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.viewmodel)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)

    implementation(libs.anvil.annotations)

    implementation(libs.dagger.lib)
    kapt(libs.dagger.compiler)

    implementation(libs.material)
    implementation(libs.timber)
}