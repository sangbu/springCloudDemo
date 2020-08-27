package com.sjc.api;

import org.springframework.web.bind.annotation.*;

/**
 * @author by SangJiacun
 * @Date 2020/8/25 17:37
 */
@RequestMapping("/user")
public interface ServiceAInterface {
    @RequestMapping(value = "/sayHello/{id}", method = RequestMethod.GET)
    String sayHello(@PathVariable("id") Long id,
                    @RequestParam("name") String name,
                    @RequestParam("age") Integer age);

    @RequestMapping(value = "/", method = RequestMethod.POST)
    String createUser(@RequestBody User user);

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    String updateUser(@PathVariable("id") Long id, @RequestBody User user);

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    String deleteUser(@PathVariable("id") Long id);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User getById(@PathVariable("id") Long id);
}
