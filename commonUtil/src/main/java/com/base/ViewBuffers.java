package com.base;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/**
 * 测试nio的缓冲
 *
 * @author xuxinbin
 * @version $$Id: nettyJoin, v 0.1 2017/8/11 8:44 xuxinbin Exp $$
 */
public class ViewBuffers {

    public static void main(String[] args) {
        differEndians();
    }

    public static void viewBuffers() {
        //ByteBuffer通过一个被包装过的8字节数组产生，然后通过各种不同的基本类型的视图缓冲器显示了出来
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
        bb.rewind();
        System.out.println("Byte Buffer");
        while (bb.hasRemaining()) {
            System.out.println(bb.position() + "->" + bb.get() + ".");
        }

        CharBuffer cb = ((ByteBuffer) bb.rewind()).asCharBuffer();
        System.out.println("Char Buffer");
        while (cb.hasRemaining()) {
            System.out.println(cb.position() + "->" + cb.get() + ".");
        }

        FloatBuffer fb = ((ByteBuffer) bb.rewind()).asFloatBuffer();
        System.out.println("Float Buffer");
        while (fb.hasRemaining()) {
            System.out.println(fb.position() + "->" + fb.get() + ".");
        }

        IntBuffer ib = ((ByteBuffer) bb.rewind()).asIntBuffer();
        System.out.println("Int Buffer");
        while (ib.hasRemaining()) {
            System.out.println(ib.position() + "->" + ib.get() + ".");
        }

        LongBuffer lb = ((ByteBuffer) bb.rewind()).asLongBuffer();
        System.out.println("Long Buffer");
        while (lb.hasRemaining()) {
            System.out.println(lb.position() + "->" + lb.get() + ".");
        }

        ShortBuffer sb = ((ByteBuffer) bb.rewind()).asShortBuffer();
        System.out.println("Short Buffer");
        while (sb.hasRemaining()) {
            System.out.println(sb.position() + "->" + sb.get() + ".");
        }

        DoubleBuffer db = ((ByteBuffer) bb.rewind()).asDoubleBuffer();
        System.out.println("Long Buffer");
        while (db.hasRemaining()) {
            System.out.println(db.position() + "->" + db.get() + ".");
        }
    }

    public static void differEndians() {
        ByteBuffer bb = getBb();
        bb.order(ByteOrder.BIG_ENDIAN);
        ShortBuffer sb = ((ByteBuffer)bb.rewind()).asShortBuffer();
        System.out.println("Short BIG_ENDIAN");
        while (sb.hasRemaining()) {
            System.out.println(sb.position() + "->" + sb.get() + ".");
        }

        bb.order(ByteOrder.LITTLE_ENDIAN);
        ShortBuffer sb2 = ((ByteBuffer)bb.rewind()).asShortBuffer();
        System.out.println("Short LITTLE_ENDIAN");
        while (sb2.hasRemaining()) {
            System.out.println(sb2.position() + "->" + sb2.get() + ".");
        }
    }

    public static ByteBuffer getBb() {
        //ByteBuffer通过一个被包装过的8字节数组产生，然后通过各种不同的基本类型的视图缓冲器显示了出来
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0,0,0,0,0,0,0,'a'});
        bb.rewind();
        System.out.println("Byte Buffer");
        while (bb.hasRemaining()) {
            System.out.println(bb.position() + "->" + bb.get() + ".");
        }
        return bb;
    }
}
