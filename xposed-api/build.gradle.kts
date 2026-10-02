// Compile-only stubs of the Xposed API used by this module.
// The real implementation is provided at runtime by LSPosed; nothing here is packaged into the APK.
plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
