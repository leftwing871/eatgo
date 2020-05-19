package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.RestaurantRepository;
import kr.co.fastcampus.eatgo.domain.RestaurantRepositoryImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)//Spring을 통해 이 Test 를 수행할 수 있게 한다
@WebMvcTest(RestController.class)//RestaurantController를 테스트 한다는 것을 명시해 줌
public class RestaurantControllerTest {

    @Autowired
    private MockMvc mvc;
//    주입된 MockMvc는 컨트롤러 테스트시 모든 의존성을 로드하는 것이아닌 RestController관련된 빈만 로드하여 가벼운 MVC 테스트를 수행합니다.

    @SpyBean(RestaurantRepositoryImpl.class)
    private RestaurantRepository restaurantRepository;

    @Test
    public void list() throws Exception {//예외가 있을 수 있다는 표

        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                //.andExpect(content().string(containsString("Bob zip")));
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
        ;
        //http://127.0.0.1:8080/restaurants
    }

//6. Spring-Test에서 테스트를 지원하는 어노테이션
//@RunWith(SpringJUnit4ClassRunner.class)
//- @RunWith는 jUnit 프레임워크의 테스트 실행방법을 확장할 때 사용하는 어노테이션이다.
//        - SpringJUnit4ClassRunner라는 클래스를 지정해주면 jUnit이 테스트를 진행하는 중에 ApplicationContext를 만들고 관리하는 작업을 진행해준다.
//        - @RunWith 어노테이션은 각각의 테스트 별로 객체가 새성되더라도 싱글톤(Singletone)의 ApplicationContext를 보장한다.
//

//@WebMvcTest
//MVC를 위한 테스트, 웹에서 테스트하기 힘든 컨트롤러를 테스트하는데 적합하다.
//        웹상에서 요청과 응답에 대한 테스트 진행
//        시쿠리티 혹은 필터까지 자동으로 테스트하며 수동으로 추가/삭제 가능
//@WebMvcTest 어노테이션을 사용하면 MVC 관련된 설정인 @Controller, @ControllerAdvice,
//@JsonCompoent와 Filter, WebMvcConfiguer, HandlerMetohdAgumentResolver만 로드되기 때문에
//@SpringBootTest 어노테이션 보다 가볍게 테스트할수 있습니다.

    @Test
    public void detail() throws Exception {
        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":1004")))
                .andExpect(content().string(containsString("\"name\":\"Bob zip\"")))
        ;

        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"id\":2020")))
                .andExpect(content().string(containsString("\"name\":\"Cyber Food\"")))
        ;
    }

}

