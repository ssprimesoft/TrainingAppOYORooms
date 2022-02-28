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
public class SearchActivityTest {

    @Test
    public void test_Activity(){
        ActivityScenario.launch(SearchActivity.class);
        onView(withId(R.id.searchView)).check(matches(isDisplayed()));
    }
}