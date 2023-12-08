package com.hua.数据结构;

import com.hua.se.config.MerkleTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MerkleTreeDemo {
    //1
    @Test
    public void testMerkleTree(){
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("zxc");
        MerkleTree merkleTree = new MerkleTree(list);
        String root = merkleTree.getRoot();
        System.out.println(root.length() + "->" + root);

        List<String> list2 = new ArrayList<>();
        list2.add("123123123123123");
        list2.add("456456456456456");
        list2.add("789789789789789");
        MerkleTree merkleTree2 = new MerkleTree(list2);
        String root2 = merkleTree2.getRoot();
        System.out.println(root2.length() + "->" + root2);
    }
}
