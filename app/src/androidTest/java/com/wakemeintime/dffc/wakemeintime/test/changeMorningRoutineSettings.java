package com.wakemeintime.dffc.wakemeintime.test;

import android.app.Activity;
import android.content.Intent;
import android.support.test.espresso.DataInteraction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.wakemeintime.dffc.wakemeintime.activities.SettingsActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

/**
 * Created by Florian Christof on 11.12.2017.
 */

@CucumberOptions(features = "features")
public class changeMorningRoutineSettings {

    @Rule
    public ActivityTestRule<SettingsActivity> activityTestRule = new ActivityTestRule<>(SettingsActivity.class);

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

    @Given("^user is on setting activity$")
    public void userIsOnSettingActivity() {
        assertNotNull(activity);
    }

    @When("^user changes the wake up time$")
    public void userChangesTheWakeUpTime() {
        /*ViewInteraction appCompatButton = onView(
         allOf(withId(com.wakemeintime.dffc.wakemeintime.R.id.Settings), withText("Settings"),
         childAtPosition(
         childAtPosition(
         withClassName(is("android.support.constraint.ConstraintLayout")),
         1),
         0),
         isDisplayed()));
         appCompatButton.perform(click());**/


        DataInteraction appCompatCheckedTextView = onData(anything())
                .inAdapterView(allOf(withClassName(is("com.android.internal.app.AlertController$RecycleListView")),
                        childAtPosition(
                                withClassName(is("android.widget.FrameLayout")),
                                0)))
                .atPosition(2);
        appCompatCheckedTextView.perform(click());
    }

    @Then("^the wake up time should be changed and displayed$")
    public void theWakeUpTimeShouldBeChangedAndDisplayed() {
        /*ViewInteraction textView = onView(
         allOf(withId(android.R.id.summary), withText("15 minutes"),
         childAtPosition(
         childAtPosition(
         IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
         0),
         1),
         isDisplayed()));
         textView.check(matches(withText("15 minutes")));**/
    }

    @When("^user changes the the information shown on wake up$")
    public void userChangesTheTheInformationShownOnWakeUp() {
        ViewInteraction editText = onView(
                allOf(withId(android.R.id.edit),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.LinearLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1)));
        editText.perform(scrollTo(), replaceText("Have a great day!"));

        ViewInteraction editText2 = onView(
                allOf(withId(android.R.id.edit),
                        childAtPosition(
                                allOf(withClassName(is("android.widget.LinearLayout")),
                                        childAtPosition(
                                                withClassName(is("android.widget.ScrollView")),
                                                0)),
                                1),
                        isDisplayed()));
        editText2.perform(closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(android.R.id.button1), withText("OK"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                3)));
        appCompatButton2.perform(scrollTo(), click());
    }

    @Then("^the information shown on wake should be changed and displayed$")
    public void theInformationShownOnWakeShouldBeChangedAndDisplayed() {
        /*ViewInteraction textView2 = onView(
         allOf(withId(android.R.id.summary), withText("Have a great day!"),
         childAtPosition(
         childAtPosition(
         IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
         0),
         1),
         isDisplayed()));
         textView2.check(matches(withText("Have a great day!")));**/
    }

    @When("^user clicks morningroutine button$")
    public void userClicksMorningroutineButton() {
        DataInteraction linearLayout = onData(anything())
                .inAdapterView(allOf(withId(android.R.id.list),
                        childAtPosition(
                                withClassName(is("android.widget.LinearLayout")),
                                0)))
                .atPosition(0);
        linearLayout.perform(click());
    }

    @And("^user clicks timeitem$")
    public void userClicksTimeItem() {
        DataInteraction linearLayout2 = onData(anything())
                .inAdapterView(allOf(withId(android.R.id.list),
                        childAtPosition(
                                withId(android.R.id.list_container),
                                0)))
                .atPosition(0);
        linearLayout2.perform(click());
    }

    @And("^user clicks messageitem$")
    public void userClicksMessageitem() {
        DataInteraction linearLayout3 = onData(anything())
                .inAdapterView(allOf(withId(android.R.id.list),
                        childAtPosition(
                                withId(android.R.id.list_container),
                                0)))
                .atPosition(1);
        linearLayout3.perform(click());
    }
}
