/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sm.utils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smazumder
 */
public class Serializer {

    /**
     * Serialize a list of strings into a byte array.
     *
     * @param ls
     * @return
     */
    public byte[][] serialize(List<String> ls) {

        byte[][] buff = new byte[ls.size()][];
        int i = 0;

        for (String s : ls) {
            buff[i] = s.getBytes();
            i++;
        }
        return buff;
    }

    /**
     *
     * @param buff
     * @return
     */
    public List<String> deSerialize(byte[][] buff) {

        List<String> data = new ArrayList(buff.length);
        for (byte[] buff1tem : buff) {
            data.add(new String(buff1tem, Charset.defaultCharset()));
        }
        return data;

    }

}
