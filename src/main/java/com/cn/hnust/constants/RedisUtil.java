package com.cn.hnust.constants;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public final class RedisUtil {
    
    //Redis������IP
    private static String ADDR = "121.42.197.56";
    
    //Redis�Ķ˿ں�
    private static int PORT = 6379;
    
    //��������
    private static String AUTH = "admin";
    
    //��������ʵ��������Ŀ��Ĭ��ֵΪ8��
    //���ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�����ʱpool��״̬Ϊexhausted(�ľ�)��
    private static int MAX_ACTIVE = 8;
    
    //����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ��Ĭ��ֵҲ��8��
    private static int MAX_IDLE = 8;
    
    //�ȴ�������ӵ����ʱ�䣬��λ���룬Ĭ��ֵΪ-1����ʾ������ʱ������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��
    private static int MAX_WAIT = -1;
    
    private static int TIMEOUT = 1000;
    
    //��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ����ǿ��õģ�
    private static boolean TEST_ON_BORROW = true;
    
    private static JedisPool jedisPool = null;
    
    /**
     * ��ʼ��Redis���ӳ�
     */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxActive(MAX_ACTIVE);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWait(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * ��ȡJedisʵ��
     * @return
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * �ͷ�jedis��Դ
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }
}