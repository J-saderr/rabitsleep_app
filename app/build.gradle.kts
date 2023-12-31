plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.demo"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        javaCompileOptions {
            annotationProcessorOptions {
                "org.gradle.jvmargs" to "-Xmx2g"
            }
        }
    }
    testOptions {
        emulatorSnapshots {
            maxSnapshotsForTestFailures = 0
        }
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

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    }
    dependencies {
        implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.9.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.recyclerview:recyclerview:1.3.1")
        implementation("androidx.databinding:databinding-runtime:8.1.1")
        implementation("androidx.cardview:cardview:1.0.0")
        implementation("com.google.code.gson:gson:2.8.9")
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
        implementation ("androidx.lifecycle:lifecycle-livedata:2.6.2")
        implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
        implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.0")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    }