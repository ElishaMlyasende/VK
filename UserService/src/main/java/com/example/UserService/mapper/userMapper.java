package com.example.UserService.mapper;



import com.example.UserService.Model.permission;
import com.example.UserService.Model.role;
import com.example.UserService.Model.user;
import com.example.UserService.Model.menu;
import com.example.shareDTO.commonDTO.userResponse;

import java.util.List;
import java.util.stream.Collectors;

public class userMapper {

    public static userResponse mapToUserResponse(user user) {
        List<String> roles = user.getRoles()
                .stream()
                .map(role::getName)
                .collect(Collectors.toList());

        List<String> permissions = user.getPermissions()
                .stream()
                .map(permission::getName)
                .distinct()
                .collect(Collectors.toList());

        List<userResponse.MenuResponse> menuResponses = user.getUserMenus()
                .stream()
                .map(userMenu -> userMenu.getMenu()) // Chukua menu object kutoka userMenu
                .map(menu -> {
                    List<userResponse.SubMenuResponse> subMenus = menu.getSubMenus()
                            .stream()
                            .map(sub -> new userResponse.SubMenuResponse(
                                    sub.getTitle(),
                                    sub.getComponent(),
                                    sub.getPath()
                            ))
                            .collect(Collectors.toList());

                    return new userResponse.MenuResponse(
                            menu.getTitle(),
                            menu.getComponent(),
                            menu.getPath(),
                            subMenus
                    );
                })
                .collect(Collectors.toList());



        userResponse response = new userResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setPassword(user.getPassword());
        response.setRoles(roles);
        response.setPermissions(permissions);
        response.setMenus(menuResponses);

        return response;
    }
}
