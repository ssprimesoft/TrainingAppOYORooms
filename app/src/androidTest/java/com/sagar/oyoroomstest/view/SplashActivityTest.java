package com.sagar.oyoroomstest.view;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.sagar.oyoroomstest.R;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class SplashActivityTest {

    @Test
    public void test_Activity(){
        ActivityScenario.launch(SplashActivity.class);
        onView(withId(R.id.splashProgress)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewWelcomeMessage)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewSplash)).check(matches(isDisplayed()));
    }

}