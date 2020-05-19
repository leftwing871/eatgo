package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;// = new RestaurantRepository();

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
//        List<Restaurant> restaurants = new ArrayList<>();
//
//        Restaurant restaurant = new Restaurant(1004L,"Bob zip", "Seoul");
//        restaurants.add(restaurant);

        List<Restaurant> restaurants = repository.findAll();

        return restaurants;
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {

//        List<Restaurant> restaurants = new ArrayList<>();
//
//        restaurants.add(new Restaurant(1004L,"Bob zip", "Seoul"));
//        restaurants.add(new Restaurant(2020L,"Cyber Food", "Seoul"));

//        long 은 64bit 정수값을 표현하는 데이터 타입으로 8byte 의 메모리 공간을 사용한다.
//                Long 은 long 과 마찬가지로 64bit 정수 값을 표현하지만 이것은 클래스다.
//         성능과 메모리에 장점이 있는 원시타입을 먼저 고려해봅니다. 만약 Null을 다뤄야 하거나, 제네릭 타입에서 사용되어야 한다면 참조타입을 사용합니다.

//        Restaurant x = restaurants.stream()
//                .filter(r -> r.getId().equals(id))
//                .findFirst()
//                .orElse(null);

//        if (id == 1004L)
//            restaurant = new Restaurant(id,"Bob zip", "Seoul");
//
//        if (id == 2020L)
//            restaurant = new Restaurant(id,"Cyber Food", "Seoul");

        return repository.findById(id);

//        Restaurant x = restaurants.stream()
//        .filter(r -> r.getId().equals(id))
//        .findFirst()
//        .orElse(null);
//
//        return x;
    }

}
