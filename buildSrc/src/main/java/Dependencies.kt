object Versions {
    const val KOTLIN_VERSION = "1.5.31"
    const val BUILD_GRADLE = "4.2.2"

    const val COMPILE_SDK_VERSION = 31

    const val MIN_SDK_VERSION = 24
    const val TARGET_SDK_VERSION = 31

    // Kotlin
    const val COROUTINES = "1.5.0"

    // AndroidX
    const val CORE_KTX = "1.7.0"
    const val APP_COMPAT = "1.3.1"
    const val CONSTRAINT_LAYOUT = "2.1.1"
    const val LIFECYCLE_KTX = "2.4.0"
    const val ROOM = "2.4.0-beta01"

    // Google
    const val MATERIAL = "1.4.0"
    const val GSON = "2.8.6"

    // Test
    const val JUNIT = "4.13.2"
    const val ANDROID_JUNIT = "1.1.3"
    const val ESPRESSO_CORE = "3.4.0"

    // Logger
    const val LOGGER = "2.2.0"

    // Koin
    const val KOIN = "3.1.1"

    // Network
    const val RETROFIT = "2.9.0"
    const val OKHTTP = "5.0.0-alpha.2"

    // Glide
    const val GLIDE = "4.12.0"

    // RxBind
    const val RXBIND = "4.0.0"
}

object Kotlin {
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN_VERSION}"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
}

object AndroidX {
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"

    const val LIFECYCLE_VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_KTX}"
    const val LIFECYCLE_LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_KTX}"

    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"
}

object Google {
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
}

object TestCode {
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val ANDROID_JUNIT = "androidx.test.ext:junit:${Versions.ANDROID_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
}

object LogUtil {
    const val LOGGER = "com.orhanobut:logger:${Versions.LOGGER}"
}

object Koin {
    const val KOIN_ANDROID = "io.insert-koin:koin-android:${Versions.KOIN}"
    const val KOIN_ANDROID_COMPAT = "io.insert-koin:koin-android-compat:${Versions.KOIN}"
}

object Network {
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
}

object Glide {
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
}

object RxBind {
    const val RXBIND_CORE = "com.jakewharton.rxbinding4:rxbinding-core:${Versions.RXBIND}"
    const val RXBIND_APPCOMPAT = "com.jakewharton.rxbinding4:rxbinding-appcompat:${Versions.RXBIND}"
}