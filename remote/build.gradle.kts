import java.util.Properties

// local.properties 파일을 읽음
val localProperties = Properties()
val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(localPropertiesFile.inputStream())
}


plugins {
    id("module.android")
}
android {
    namespace = "ted.gun0912.movie.remote"

    defaultConfig {
        buildConfigField("String", "API_KEY", "\"${localProperties["api_key"]}\"")

    }
}
dependencies {
    implementation(projects.common)
    implementation(projects.component)
    implementation(projects.data)

    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
}
