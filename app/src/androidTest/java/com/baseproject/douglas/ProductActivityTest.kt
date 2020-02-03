package com.baseproject.douglas


import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.baseproject.douglas.feature.product.view.ProductActivity
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.AdditionalMatchers.not


@RunWith(AndroidJUnit4::class)
class ProductActivityTest {

    @Rule
    @JvmField
    var productActivityTestRule =
        ActivityTestRule(ProductActivity::class.java, true, true)

    @Test
    fun shouldClickItemInRecyclerView() {
        loadData()
        onView(withId(R.id.productList))
            .inRoot(withDecorView(Matchers.`is`(productActivityTestRule.activity.window.decorView)))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

    }

    @Test
    fun checkCardDescriptionIsDisplayed() {
        loadData()
        onView(withId(R.id.productList))
            .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        onView(withId(R.id.productDescription)).check(matches(not(isDisplayed())))

    }

    @Test
    fun testSampleRecyclerVisible() {
        onView(withId(R.id.productList))
            .inRoot(withDecorView(Matchers.`is`(productActivityTestRule.activity.window.decorView)))
            .check(matches(isDisplayed()))
    }

    private fun loadData() {
        startActivityWithWithStubbedTask()
    }

    private fun startActivityWithWithStubbedTask() {
        val startIntent = Intent()
        productActivityTestRule.launchActivity(startIntent)
    }
}