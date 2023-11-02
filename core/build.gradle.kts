plugins {
    if (ModuleCore.isApp) {
        alias(libs.plugins.com.android.application)
    } else {
        alias(libs.plugins.com.android.library)
    }

    alias(libs.plugins.org.jetbrains.kotlin.android)
}

android {
    namespace = "com.lycc.core"
    compileSdk = 34

    defaultConfig {
        if (ModuleCore.isApp) {
            // library插件中已经删除了下面几个，切换为Lib的时候需要注释掉
//            applicationId = "com.lycc.core"
//            versionCode = 1
//            versionName = "1.0.0"
//            targetSdk = 34
        }
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    sourceSets.getByName("main") {
        if (ModuleCore.isApp) {
            manifest.srcFile("src/main/AndroidManifest.xml")
        } else {
            manifest.srcFile("src/main/module/AndroidManifest.xml")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.logger)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}