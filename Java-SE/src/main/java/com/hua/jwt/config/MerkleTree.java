package com.hua.jwt.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MerkleTree {
    private List<String> transactions;
    private String root;

    public MerkleTree(List<String> transactions) {
        this.transactions = transactions;
        this.root = buildTree(transactions);
    }

    private String buildTree(List<String> transactions) {
        List<String> tree = new ArrayList<>(transactions);
        while (tree.size() > 1) {
            List<String> tempTree = new ArrayList<>();
            for (int i = 0; i < tree.size(); i += 2) {
                String left = tree.get(i);
                String right = (i + 1 < tree.size()) ? tree.get(i + 1) : "";
                tempTree.add(hash(left + right));
            }
            tree = tempTree;
        }
        return tree.get(0);
    }

    private String hash(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(data.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getRoot() {
        return root;
    }
}
