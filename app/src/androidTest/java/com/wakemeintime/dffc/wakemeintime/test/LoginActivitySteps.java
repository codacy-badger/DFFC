package com.wakemeintime.dffc.wakemeintime.test;

import android.app.Activity;
import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.wakemeintime.dffc.wakemeintime.LoginActivity;

import org.junit.Rule;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by User on 26.11.2017.
 */

@CucumberOptions(features = "features")
class LoginActivitySteps {
    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(LoginActivity.class);
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

    @And("^user presses the login button$")
    public void userPressesTheLoginButton() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^user is on login activity$")
    public void userIsOnLoginActivity() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^user provides username \"([^\"]*)\"$")
    public void userProvidesUsername(String arg0) {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^user provides password \"([^\"]*)\"$")
    public void userProvidesPassword(String arg0) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^user should be successfully logged in as \"([^\"]*)\"$")
    public void userShouldBeSuccessfullyLoggedInAs(String arg0) {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^User provides username <username>$")
    public void userProvidesUsernameUsername() {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^User provides password <password>$")
    public void userProvidesPasswordPassword() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^User should not be logged in$")
    public void userShouldNotBeLoggedIn() {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^User should be shown an error message$")
    public void userShouldBeShownAnErrorMessage() {
        // Write code here that turns the phrase above into concrete actions
    }
}
