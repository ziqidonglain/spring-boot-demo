package com.xkcoding.ldap;

import com.xkcoding.ldap.entity.Person;
import com.xkcoding.ldap.entity.Result;
import com.xkcoding.ldap.request.LoginRequest;
import com.xkcoding.ldap.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * LdapDemoApplicationTest
 *
 * @author fxbin
 * @version v1.0
 * @since 2019/8/26 1:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LdapDemoApplicationTests {

    @Resource
    private PersonService personService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void loginTest() {
        LoginRequest loginRequest = LoginRequest.builder().username("wangwu").password("123456").build();
        Result login = personService.login(loginRequest);
        System.out.println(login);
    }

    @Test
    public void listAllPersonTest() {
        Result result = personService.listAllPerson();
        System.out.println(result);
    }

    @Test
    public void saveTest() {
        Person person = new Person();

        person.setUid("zhaosi");

        person.setSurname("赵");
        person.setGivenName("四");
        person.setUserPassword("123456");

        // required field
        person.setPersonName("赵四");
        person.setUidNumber("666");
        person.setGidNumber("666");
        person.setHomeDirectory("/home/zhaosi");
        person.setLoginShell("/bin/bash");

        personService.save(person);
    }


    @Test
    public void deleteTest() {
        Person person = new Person();
        person.setUid("zhaosi");

        personService.delete(person);
    }




}
