plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
    alias(libs.plugins.anvil) apply false
}

tasks.wrapper {
    distributionType = Wrapper.DistributionType.ALL
    version = libs.versions.gradle.get()
}