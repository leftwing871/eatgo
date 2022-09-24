package kr.co.fastcampus.eatgo.domain;

//import org.junit.Test;


import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.PAEncTSEnc;
//If you're using JUnit 5+, make sure you import the @Test annotation from the correct library

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantTest {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");
        //assertThat(restaurant.getName(), is("Bob ZIP")); // 실패하는 테스트
        assertThat(restaurant.getName(), is("Bob zip"));//import -> option + enter
        assertThat(restaurant.getAddress(), is("Seoul"));
    }

    @Test
    public void information() {
        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");

        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
    }

}