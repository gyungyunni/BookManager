package com.selfstudy.jpa.bookmanager.repository.dto;

import com.selfstudy.jpa.bookmanager.domain.Gender;
import com.selfstudy.jpa.bookmanager.domain.User;
import com.selfstudy.jpa.bookmanager.repository.dto.UserHistoryRepository;
import com.selfstudy.jpa.bookmanager.repository.dto.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@SpringBootTest //spring context를 로딩을해서 테스트에 활용하겠다는 의미
class UserRepositoryTest {
    @Autowired //의존성 추가
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
   // @Transactional
    void crud() { // create, read, update, delete
        // userRepository.save(new User()); //user 생성하고 저장
        //System.out.println(">>> "+userRepository.findAll());
        // userRepository.findAll().forEach(System.out::println); //findAll 하고 print를 하면 한줄로 쭉 나오는데
        //람다, 스트림 이용하여 한줄씩 출력, 아래와 같은 코드
        /*for(User user : userRepository.findAll()){
           System.out.println(user);
          }
         */
       // List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
       // List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
       // users.forEach(System.out::println);

        /*
        User user1 = new User("karina", "karina@mutsa.com");
        User user2 = new User("winter", "winter@mutsa.com");

        userRepository.saveAll(Lists.newArrayList(user1,user2)); // 한번에 여러개 저장

        List<User> users = userRepository.findAll(); // 조회

        users.forEach(System.out::println); // 출력
         */
        // User user = userRepository.getOne(1L);
        // System.out.println(user);
        // User user = userRepository.findById(1L). orElse(null);
        // System.out.println(user);
        /*
        userRepository.save(new User("new martin","newmartin@mutsa.com"));
        userRepository.flush();
        userRepository.findAll().forEach(System.out::println);
         */
        //long count = userRepository.count();
        //boolean exists = userRepository.existsById(1L);
        //System.out.println(exists);

        // userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        //userRepository.deleteById(1L);
        //userRepository.deleteAllInBatch();
        //userRepository.findAll().forEach(System.out::println);

//        Page<User> users = userRepository.findAll(PageRequest.of(1,3));
//
//        System.out.println("page : " + users);
//        System.out.println("totalElements : " + users.getTotalElements());
//        System.out.println("totalPages : " +users.getTotalPages());
//        System.out.println("numberOfElements : " + users.getNumberOfElements());
//        System.out.println("sort : " + users.getSort());
//        System.out.println("size : " + users.getSize());
//
//        users.getContent().forEach(System.out::println);

//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email", endsWith()); // Matcher 생성
//
//        Example<User> example = Example.of(new User("hue", "nate.com"), matcher);
//
//        userRepository.findAll(example).forEach(System.out::println);

        User user = new User();
        user.setEmail("nate");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email", contains());
        Example<User> example = Example.of(user, matcher);

        userRepository.findAll(example).forEach(System.out::println);
    }
    @Test
    void select(){
        // System.out.println(userRepository.findByName("martin"));

//        System.out.println("findByEmail : " + userRepository.findByEmail("martin@mutsa.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("martin@mutsa.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("martin@mutsa.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@mutsa.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@mutsa.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@mutsa.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@mutsa.com"));

//        System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("martin"));
//        System.out.println("findTop2ByName : " + userRepository.findTop2ByName("martin"));

//        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastcampus.com", "martin"));
//        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastcampus.com", "dennis"));
//
//        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
//        System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

//        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
//        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));
//
//        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());

//        System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "dennis")));
//
//        System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
//        System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
//        System.out.println("findByNameContains : " + userRepository.findByNameContains("art"));
//
//        System.out.println("findByNameLike : " + userRepository.findByNameLike("%" + "art" + "%"));
    }
    @Test
    void pagingAndSortingTest() {
        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
        System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("martin"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Sort.Order.asc("id"), Sort.Order.asc("email"))));
        System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", getSort()));
        System.out.println("findByNameWithPaging : " + userRepository.findByName("martin", PageRequest.of(0, 2, Sort.by(Sort.Order.desc("id")))).getContent());
    }
    private Sort getSort(){
        return Sort.by(
                Sort.Order.desc("id"),
                Sort.Order.asc("email"),
                Sort.Order.desc("createdAt"),
                Sort.Order.asc("updatedAt")
        );
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);  //userRepository에서 가져온 첫번째 객체의 Gender를 Male로 설정

        userRepository.save(user); //user값 업데이트

        userRepository.findAll().forEach(System.out::println); // 다 출력

        System.out.println(userRepository.findRawRecord().get("gender"));
    }
    @Test
    void listenerTest() {
        User user = new User();
        user.setEmail("martin2@mutsa.com");
        user.setName("martin");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrrtin");

        userRepository.save(user2);

        userRepository.deleteById(4L);
    }
    @Test
    void prePersistTest() {
        User user = new User();
        user.setEmail("martin2@mutsa.com");
        user.setName("martin");
//        user.setCreatedAt(LocalDateTime.now());
//        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("martin2@mutsa.com"));
    }
    @Test
    void preUpdateTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("martin22");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest(){
        User user = new User();
        user.setEmail("martin-new@mutsa.com");
        user.setName("martin-new");

        userRepository.save(user); // insert

        user.setName("martin-new-new");

        userRepository.save(user); // update

        userHistoryRepository.findAll().forEach(System.out::println);

    }

}