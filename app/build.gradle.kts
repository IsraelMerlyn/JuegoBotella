plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.juegobotella"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.juegobotella"
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
}

dependencies {


    val nav_version ="2.8.4"
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //animacion lottie
    implementation("com.airbnb.android:lottie:5.0.3")
    //llamando activity
    implementation("androidx.activity:activity-ktx:1.9.3")
    //llamando viewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    //llamando fragment
    implementation("androidx.fragment:fragment-ktx:1.8.5")
    //liveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")
    //navigator
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
}