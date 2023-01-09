package com.hua.steam;

import com.hua.entity.UserDTO;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class SteamDemo {
    private static List<UserDTO> getUserList() {
        UserDTO userDTO = new UserDTO();
        userDTO.setName("小冬");
        userDTO.setAge(18);
        userDTO.setSex("男");
        userDTO.setHasOrientation(false);
        UserDTO userDTO2 = new UserDTO();
        userDTO2.setName("小秋");
        userDTO2.setAge(30);
        userDTO2.setSex("男");
        userDTO2.setHasOrientation(true);
        UserDTO userDTO3 = new UserDTO();
        userDTO3.setName("春");
        userDTO3.setAge(18);
        userDTO3.setSex("女");
        userDTO3.setHasOrientation(true);
        List<UserDTO> userList = new ArrayList<>();
        userList.add(userDTO);
        userList.add(userDTO2);
        userList.add(userDTO3);
        return userList;
    }

    //1转换成其他集合/数组
    @Test
    public void testSwapCollect(){
        List<UserDTO> userList = getUserList();
        //转换为set
        Set<UserDTO> set = userList.stream().collect(Collectors.toCollection(HashSet::new));
        Set<UserDTO> set2 = userList.stream().collect(Collectors.toSet());
        set.forEach(System.out::println);
        //转换为arraylist
        ArrayList<UserDTO> arrayList = userList.stream().collect(Collectors.toCollection(ArrayList::new));
        arrayList.forEach(System.out::println);
        //转化为Object[]
        Object[] objects = userList.stream().toArray();

        //转化为UserDTO[]
        UserDTO[] userDTOArr = userList.stream().toArray(UserDTO[]::new);
    }

    //2
    @Test
    public void testAggregate(){
        List<UserDTO> userList = getUserList();
        //找出年龄最大的
        Optional<UserDTO> max = userList.stream().max((s1, s2) -> s1.getAge() - s2.getAge());
        userList.stream().max(Comparator.comparingInt(UserDTO::getAge));
        if (max.isPresent()) {
            UserDTO masUser = max.get();
            System.out.println(masUser.toString());
        }
    }
}
