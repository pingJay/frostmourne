package com.pj.bigdata.frostmourne.utils;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * 配置文件操作类
 * Created by pingjie on 15-11-19.
 */
public class Props {
    private static final Logger logger = Logger.getLogger(Props.class);
    private final Map<String,String> current;
    private String source;

    public Props(String fileName){
        current = new HashMap<String, String>();
        setSource(fileName);
        File file = new File(fileName);
        try {
            if (file.exists() && file.isFile()){
                logger.info("load frostmourne "+ fileName +" properties file");
                InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
                this.loadFrom(inputStream);
            }
        }catch (FileNotFoundException e) {
            logger.error("file not found '" + fileName + "'.  Could not load frostmourne config file ",e);
        } catch (IOException e) {
            logger.error("File found, but error reading '"+ fileName +"'. Could not load frostmourne config file",e);
        }

    }

    private void loadFrom(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        this.put(properties);
    }

    public void put(Properties properties) {
        for (String key : properties.stringPropertyNames()) {
            current.put(key,properties.getProperty(key));
        }
    }

    public String put(String key, String value) {
        return current.put(key, value);
    }

    /**
     * Put integer
     *
     * @param key
     * @param value
     * @return
     */
    public String put(String key, Integer value) {
        return current.put(key, value.toString());
    }

    /**
     * Put Long. Stores as String.
     *
     * @param key
     * @param value
     * @return
     */
    public String put(String key, Long value) {
        return current.put(key, value.toString());
    }

    /**
     * Put Double. Stores as String.
     *
     * @param key
     * @param value
     * @return
     */
    public String put(String key, Double value) {
        return current.put(key, value.toString());
    }

    /**
     * Put everything in the map into the props.
     *
     * @param m
     */
    public void putAll(Map<? extends String, ? extends String> m) {
        if (m == null) {
            return;
        }

        for (Map.Entry<? extends String, ? extends String> entry : m.entrySet()) {
            this.put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Put all properties in the props into the current props. Will handle null p.
     *
     * @param p
     */
    public void putAll(Props p) {
        if (p == null) {
            return;
        }

        for (String key : p.getKeySet()) {
            this.put(key, p.get(key));
        }
    }


    public Set<String> getKeySet(){
        return current.keySet();
    }
    public boolean containsKey(Object key) {
        return current.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return current.containsValue(value);
    }

    public String get(Object key) {
        if (containsKey(key)) {
            return current.get(key);
        }else{
            return null;
        }
    }

    public int size(){
        return current.size();
    }

    /**
     * Gets the string from the Props. If it doesn't exist, it will return the
     * defaultValue
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public String getString(String key, String defaultValue) {
        if (containsKey(key)) {
            return get(key);
        } else {
            return defaultValue;
        }
    }

    /**
     * Gets the string from the Props. If it doesn't exist, throw and
     * UndefinedPropertiesException
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public String getString(String key) {
        if (containsKey(key)) {
            return get(key);
        } else {
            throw new UndefinedPropertyException("Missing required property '" + key
                    + "'");
        }
    }

    /**
     * Returns a list of strings with the comma as the separator of the value
     *
     * @param key
     * @return
     */
    public List<String> getStringList(String key) {
        return getStringList(key, "\\s*,\\s*");
    }

    /**
     * Returns a list of strings with the sep as the separator of the value
     *
     * @param key
     * @param sep
     * @return
     */
    public List<String> getStringList(String key, String sep) {
        String val = get(key);
        if (val == null || val.trim().length() == 0) {
            return Collections.emptyList();
        }

        if (containsKey(key)) {
            return Arrays.asList(val.split(sep));
        } else {
            throw new UndefinedPropertyException("Missing required property '" + key
                    + "'");
        }
    }

    /**
     * Returns a list of strings with the comma as the separator of the value. If
     * the value is null, it'll return the defaultValue.
     *
     * @param key
     * @return
     */
    public List<String> getStringList(String key, List<String> defaultValue) {
        if (containsKey(key)) {
            return getStringList(key);
        } else {
            return defaultValue;
        }
    }

    /**
     * Returns a list of strings with the sep as the separator of the value. If
     * the value is null, it'll return the defaultValue.
     *
     * @param key
     * @return
     */
    public List<String> getStringList(String key, List<String> defaultValue,
                                      String sep) {
        if (containsKey(key)) {
            return getStringList(key, sep);
        } else {
            return defaultValue;
        }
    }

    /**
     * Returns true if the value equals "true". If the value is null, then the
     * default value is returned.
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        if (containsKey(key)) {
            return "true".equalsIgnoreCase(get(key).trim());
        } else {
            return defaultValue;
        }
    }

    /**
     * Returns true if the value equals "true". If the value is null, then an
     * UndefinedPropertyException is thrown.
     *
     * @param key
     * @return
     */
    public boolean getBoolean(String key) {
        if (containsKey(key))
            return "true".equalsIgnoreCase(get(key));
        else
            throw new UndefinedPropertyException("Missing required property '" + key
                    + "'");
    }

    /**
     * Returns the long representation of the value. If the value is null, then
     * the default value is returned. If the value isn't a long, then a parse
     * exception will be thrown.
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public long getLong(String name, long defaultValue) {
        if (containsKey(name)) {
            return Long.parseLong(get(name));
        } else {
            return defaultValue;
        }
    }

    /**
     * Returns the long representation of the value. If the value is null, then a
     * UndefinedPropertyException will be thrown. If the value isn't a long, then
     * a parse exception will be thrown.
     *
     * @param key
     * @return
     */
    public long getLong(String name) {
        if (containsKey(name)) {
            return Long.parseLong(get(name));
        } else {
            throw new UndefinedPropertyException("Missing required property '" + name
                    + "'");
        }
    }

    /**
     * Returns the int representation of the value. If the value is null, then the
     * default value is returned. If the value isn't a int, then a parse exception
     * will be thrown.
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public int getInt(String name, int defaultValue) {
        if (containsKey(name)) {
            return Integer.parseInt(get(name).trim());
        } else {
            return defaultValue;
        }
    }

    /**
     * Returns the int representation of the value. If the value is null, then a
     * UndefinedPropertyException will be thrown. If the value isn't a int, then a
     * parse exception will be thrown.
     *
     * @param key
     * @return
     */
    public int getInt(String name) {
        if (containsKey(name)) {
            return Integer.parseInt(get(name).trim());
        } else {
            throw new UndefinedPropertyException("Missing required property '" + name
                    + "'");
        }
    }

    /**
     * Returns the double representation of the value. If the value is null, then
     * the default value is returned. If the value isn't a double, then a parse
     * exception will be thrown.
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public double getDouble(String name, double defaultValue) {
        if (containsKey(name)) {
            return Double.parseDouble(get(name).trim());
        } else {
            return defaultValue;
        }
    }

    /**
     * Returns the double representation of the value. If the value is null, then
     * a UndefinedPropertyException will be thrown. If the value isn't a double,
     * then a parse exception will be thrown.
     *
     * @param key
     * @return
     */
    public double getDouble(String name) {
        if (containsKey(name)) {
            return Double.parseDouble(get(name).trim());
        } else {
            throw new UndefinedPropertyException("Missing required property '" + name
                    + "'");
        }
    }

    /**
     * Returns the uri representation of the value. If the value is null, then the
     * default value is returned. If the value isn't a uri, then a
     * IllegalArgumentException will be thrown.
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public URI getUri(String name) {
        if (containsKey(name)) {
            try {
                return new URI(get(name));
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        } else {
            throw new UndefinedPropertyException("Missing required property '" + name
                    + "'");
        }
    }

    /**
     * Returns the double representation of the value. If the value is null, then
     * the default value is returned. If the value isn't a uri, then a
     * IllegalArgumentException will be thrown.
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public URI getUri(String name, URI defaultValue) {
        if (containsKey(name)) {
            return getUri(name);
        } else {
            return defaultValue;
        }
    }

    public URI getUri(String name, String defaultValue) {
        try {
            return getUri(name, new URI(defaultValue));
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    private void setSource(String source){
        this.source = source;
    }
}
