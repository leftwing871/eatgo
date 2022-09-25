package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import sun.security.krb5.internal.PAEncTSEnc;
//If you're using JUnit 5+, make sure you import the @Test annotation from the correct library

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class RestaurantServiceTest {

    //@SpyBean(RestaurantService.class)
    private RestaurantService restaurantService;

    private RestaurantRepository restaurantRepository;

    private MenuItemRepository menuItemRepository;

    @Before
    public void setUp() {
        restaurantRepository = new RestaurantRepositoryImpl();

        menuItemRepository = new MenuItemRepositoryImpl();

        restaurantService = new RestaurantService(restaurantRepository, menuItemRepository);

    }

    @Test
    public void getRestaurants() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();
        Restaurant restaurant = restaurants.get(0);

        assertThat(restaurant.getId(), is(1004L));
    }

    @Test
    public void getRestaurant()
    {
        Restaurant restaurant = restaurantService.getRestaurant(1004L);

        assertThat(restaurant.getId(), is(1004L));

        MenuItem menuItem = restaurant.getMenuItems().get(0);
        assertThat(menuItem.getName(), is("Kimchi"));
    }


}