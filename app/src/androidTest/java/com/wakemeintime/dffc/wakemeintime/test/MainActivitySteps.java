package com.wakemeintime.dffc.wakemeintime.test;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.wakemeintime.dffc.wakemeintime.activities.MainActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.internal.matchers.TypeSafeMatcher;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.allOf;

@CucumberOptions(features = "features")
public class MainActivitySteps {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    private Activity activity;
    private Intent intent = new Intent();

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Before
    public void setup() {
        activityTestRule.launchActivity(null);
        activity = activityTestRule.getActivity();
    }

    @After
    public void tearDown() {
        activityTestRule.finishActivity();
    }

    @Given("^user is on main activity$")
    public void userIsOnMainActivity() {
        assertNotNull(activity);
    }

    @Then("^helloWorld should be displayed$")
    public void helloworldShouldBeDisplayed() {
        onView(
                allOf(withText("Hello World!"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));


    }

    @When("^menubar is displayed$")
    public void menubarIsDisplayed() {
        onView(
                allOf(withId(com.wakemeintime.dffc.wakemeintime.R.id.action_bar),
                        childAtPosition(
                                allOf(withId(com.wakemeintime.dffc.wakemeintime.R.id.action_bar_container),
                                        childAtPosition(
                                                withId(com.wakemeintime.dffc.wakemeintime.R.id.decor_content_parent),
                                                0)),
                                0),
                        isDisplayed()));


    }
}
