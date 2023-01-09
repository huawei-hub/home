package com.hua.forDemo;

import org.junit.Test;

public class ForDemo {
    //1
    @Test
    public void testContinue(){
        for (int i = 0; i < 5; i++) {
            if (i == 3)
                continue;
            System.out.println("i = " + i);
        }
    }
}
