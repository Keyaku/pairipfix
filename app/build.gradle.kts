plugins {
    alias(libs.plugins.android.application)
}

val appName = "pairipfix"
val appVersionName = "1.2"
val appVersionCode = 2

// Release signing: uses a keystore from environment variables when provided (CI secrets),
// otherwise falls back to the debug key so the APK is still installable.
val releaseKeystore = System.getenv("SIGNING_KEYSTORE_FILE")?.let { file(it) }?.takeIf { it.exists() }

android {
    namespace = "io.github.ahmedmani.io.github.ahmedmani.pairipfixio.github.ahmedmani.pairipfix"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.ahmedmani.io.github.ahmedmani.pairipfixio.github.ahmedmani.pairipfix"
        minSdk = 26
        targetSdk = 34
        versionCode = appVersionCode
        versionName = appVersionName
    }

    signingConfigs {
        if (releaseKeystore != null) {
            create("release") {
                storeFile = releaseKeystore
                storePassword = System.getenv("SIGNING_STORE_PASSWORD")
                keyAlias = System.getenv("SIGNING_KEY_ALIAS")
                keyPassword = System.getenv("SIGNING_KEY_PASSWORD")
            }
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.findByName("release") ?: signingConfigs.getByName("debug")
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

base {
    archivesName.set("$appName-$appVersionName")
}

tasks.register("printVersion") {
    doLast { println("$appName $appVersionName") }
}

dependencies {
    compileOnly(project(":xposed-api"))
}
