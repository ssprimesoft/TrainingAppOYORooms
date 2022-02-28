package com.sagar.oyoroomstest.view;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.sagar.oyoroomstest.R;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class DetailsActivityTest {

    @Test
    public void test_Activity() {
        ActivityScenario.launch(DetailsActivity.class);
        onView(withId(R.id.imageViewPoster)).check(matches(isDisplayed()));
        onView(withId(R.id.cardHotelDetails)).check(matches(isDisplayed()));
        onView(withId(R.id.textViewHotelName)).check(matches(isDisplayed()));
    }
}