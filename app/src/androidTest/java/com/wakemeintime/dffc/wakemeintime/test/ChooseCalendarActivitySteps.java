package com.wakemeintime.dffc.wakemeintime.test;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.wakemeintime.dffc.wakemeintime.activities.ChooseCalendarActivity;

import org.junit.Rule;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by User on 26.11.2017.
 */

@CucumberOptions(features = "features")
public class ChooseCalendarActivitySteps {
    @Rule
    public ActivityTestRule<ChooseCalendarActivity> activityTestRule = new ActivityTestRule<>(ChooseCalendarActivity.class);
    private Activity activity;
    private Intent intent = new Intent();

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

    }
}

