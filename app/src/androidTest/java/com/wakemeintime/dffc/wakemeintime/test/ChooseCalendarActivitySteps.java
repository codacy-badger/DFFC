package com.wakemeintime.dffc.wakemeintime.test;

import android.app.Activity;
import android.content.Intent;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.wakemeintime.dffc.wakemeintime.activities.ChooseCalendarActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by User on 26.11.2017.
 */

@CucumberOptions(features = "features")
public class ChooseCalendarActivitySteps {
    @Rule
    public ActivityTestRule<ChooseCalendarActivity> activityTestRule = new ActivityTestRule<>(ChooseCalendarActivity.class);
    private Activity activity;
    private Intent intent = new Intent();

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new org.hamcrest.TypeSafeMatcher<View>() {
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

    @Given("^user is on choose calendar activity$")
    public void userIsOnChooseCalendarActivity() {
        assertNotNull(activity);
    }

    @When("^user selects calendar$")
    public void userSelectsCalendar() {

    }

    @Then("^calendar should be added to synchronized calendars$")
    public void calendarShouldBeAddedToSynchronizedCalendars() {
        ViewInteraction checkBox =
                onData(allOf(is(instanceOf(String.class)), is("testName1"))) // Use Hamcrest matchers to match item
                        .inAdapterView(withId(com.wakemeintime.dffc.wakemeintime.R.id.myCalendarsListView)) // Specify the explicit id of the ListView
                        .check(matches(isChecked()));
    }
}

