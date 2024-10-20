package com.lespinel.camel.routes;

import com.lespinel.camel.domain.User;
import com.lespinel.camel.domain.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Slf4j
@Component
public class UsersRoutes extends RouteBuilder {
    @Autowired
    UserRepository userRepository;

    @Override
    public void configure() {
        /*
        from("timer:mainTimer?period={{timer.period}}")
                .routeId("timer-query-users")
                .choice()
                    .when(simple("${properties:application.queryType} == 'repo'"))
                            .to("direct:getUsersByRepository")
                    .when(simple("${properties:application.queryType} == 'jpa'"))
                            .to("direct:getUsersDirectlyByJPA")
                    .when(simple("${properties:application.queryType} == 'repo-bean'"))
                            .to("direct:getUsersByBeanRepository")
                    .otherwise()
                            .log("queryType not supported")
                .end()
                .log("Total results: ${body.size}");
         */

        from("direct:getUsersByRepository")
                .routeId("users-from-repo")
                .process(exchange -> {
                    List<User> users = userRepository.findAll();
                    exchange.getMessage().setBody(users);
                });

        from("direct:getUsersDirectlyByJPA")
                .routeId("users-from-jpa")
                .to("jpa://com.formadoresit.camel.domain.User?query=SELECT u FROM User u");

        from("direct:insertUser")
                .routeId("insert-user")
                .to("jpa://com.formadoresit.camel.domain.User")
                .end();

        from("direct:notifyNewUser")
                .routeId("notify-new-user")
                .log("Notifying")
                .process(exchange -> {
                    User createdUser = exchange.getMessage().getBody(User.class);
                    if(createdUser == null) {
                        throw new RuntimeException("Created user object is null");
                    }
                    log.info("Notifying new user with ID {}", createdUser.getId());
                    if(createdUser.getId() % 2 == 0){
                        throw new RuntimeException("Even IDs not allowed");
                    }
                });

        from("direct:queryUsersByNameWithJpa")
                .routeId("users-by-name-jpa")
                .process(exchange -> {
                    Map<String, Object> parameters = new HashMap<>();
                    parameters.put("name", "Luis Espinel");
                    exchange.getIn().setHeader("CamelJpaParameters", parameters);
                })
                .to("jpa://com.formadoresit.camel.domain.User?query=SELECT u FROM User u WHERE u.name = :name");
    }

}