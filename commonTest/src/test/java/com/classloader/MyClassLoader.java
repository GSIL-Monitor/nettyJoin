package com.classloader;

import java.io.InputStream;

/**
 * @author anthony_xu
 * @create $ID: MyClassLoader, v0.1 2018年06月02日 23:44 anthony_xu Exp $
 */
public class MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {

            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

            InputStream is = getClass().getResourceAsStream(fileName);

            if (is == null) {

                return super.loadClass(name);

            }

            byte[] b = new byte[is.available()];

            is.read(b);

            return defineClass(name, b, 0, b.length);

        }

        catch (Exception e) {

            throw new ClassNotFoundException(name);

        }
    }
}
