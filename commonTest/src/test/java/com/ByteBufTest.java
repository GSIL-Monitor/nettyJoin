package com;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author xuxinbin
 * @version $$Id: nettyJoin, v 0.1 2017/8/17 12:58 xuxinbin Exp $$
 */
public class ByteBufTest {
    public static void main(String[] args) {
        test1();

        System.out.println("=================================");

        test2();
    }

    /**
     * 复制一个ByteBuf
     */
    private static void test4() {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in action rocks!", utf8);
        ByteBuf copy = buf.copy(0, 15);
        System.out.println(copy.toString(utf8)); //Netty in action
        buf.setByte(0, 'J');
        System.out.println(buf.toString(utf8)); //Jetty in action rocks!
        System.out.println(copy.toString(utf8));  //Netty in action



    }

    /**
     * 对ByteBuf进行切片
     */
    private static void test3() {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in action rocks!", utf8);
        System.out.println(buf);
        ByteBuf sliced = buf.slice(0, 15);
        System.out.println(sliced.toString(utf8)); //Netty in action
        buf.setByte(0, 'J');
        System.out.println("buf.getByte(0) == " + buf.getByte(0)); //buf.getByte(0) == 74
        System.out.println("sliced.getByte(0) == " + sliced.getByte(0)); //sliced.getByte(0) == 74
        System.out.println(buf.toString(utf8));//Jetty in action rocks!
        System.out.println(sliced.toString(utf8));  //Jetty in action
    }

    /**
     * ByteBuf的get和set方法不会移动索引值
     */
    private static void test2() {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        System.out.println((char)buf.getByte(0)); //N
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        buf.setByte(0, 'B');
        System.out.println(buf.toString(utf8)); //Betty in Action rocks!
        System.out.println(readerIndex); //0
        System.out.println(writerIndex); //22
        System.out.println(buf.readerIndex()); //0
        System.out.println(buf.writerIndex()); //22
    }

    /**
     * ByteBuf的writeXXX方法会移动索引值
     */
    private static void test1() {
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);
        System.out.println((char)buf.readByte());  //N
        int readerIndex = buf.readerIndex();
        int writerIndex = buf.writerIndex();
        System.out.println((char)buf.getByte(buf.readerIndex())); //e
        buf.writeByte('?');
        System.out.println(readerIndex); //1
        System.out.println(writerIndex); //22
        System.out.println(buf.readerIndex()); //1
        System.out.println(buf.writerIndex()); //23
    }
}
