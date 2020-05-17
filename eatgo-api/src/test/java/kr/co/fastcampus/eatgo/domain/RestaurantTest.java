package kr.co.fastcampus.eatgo.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTest {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant(1004,"Bob zip", "Seoul");
        assertThat(restaurant.getName(), is("Bob zip"));//import -> option + enter
        assertThat(restaurant.getAddress(), is("Seoul"));
    }

    @Test
    public void information() {
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");

        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
    }

}