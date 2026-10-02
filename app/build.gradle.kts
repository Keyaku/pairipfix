plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "io.github.ahmedmani.io.github.ahmedmani.pairipfixio.github.ahmedmani.pairipfix"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.ahmedmani.io.github.ahmedmani.pairipfixio.github.ahmedmani.pairipfix"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
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
}

dependencies {
    compileOnly(project(":xposed-api"))
}
