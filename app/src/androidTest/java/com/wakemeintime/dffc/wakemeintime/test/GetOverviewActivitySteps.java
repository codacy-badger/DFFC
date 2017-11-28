package com.wakemeintime.dffc.wakemeintime.test;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.wakemeintime.dffc.wakemeintime.GetOverviewActivity;

import org.junit.Rule;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by User on 26.11.2017.
 */

@CucumberOptions(features = "features")
class GetOverviewActivitySteps {
    @Rule
    public ActivityTestRule<GetOverviewActivity> activityTestRule = new ActivityTestRule<>(GetOverviewActivity.class);
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

    @Then("^user should see his managed appointments$")
    public void userShouldSeeHisManagedAppointments() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^chooses an appointment$")
    public void choosesAnAppointment() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the detail view should open$")
    public void theDetailViewShouldOpen() {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^user should see the details of the managed appointment$")
    public void userShouldSeeTheDetailsOfTheManagedAppointment() {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^the detail view is open$")
    public void theDetailViewIsOpen() {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^the user presses the delete alarm button$")
    public void theUserPressesTheDeleteAlarmButton() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the alarm should be deleted$")
    public void theAlarmShouldBeDeleted() {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^the user presses the minimize button$")
    public void theUserPressesTheMinimizeButton() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the detail view should be closed$")
    public void theDetailViewShouldBeClosed() {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^the user is back at the overview$")
    public void theUserIsBackAtTheOverview() {
        // Write code here that turns the phrase above into concrete actions
    }
}
