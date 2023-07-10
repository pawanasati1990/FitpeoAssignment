package com.fitpeo.assignment.screen.loaddata


import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test

internal class LoadDataActivityTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.fitpeo", appContext.packageName)
    }

}