package com.zk.springboot.proxy.staticproxy;

/**
 * 静态代理
 * 优点：在不修改目标对象的功能的前提下，能通过代理对象对目标功能扩展
 * 缺点：因为代理对象需要与目标对象实现一样的接口，所以会有很多代理类，一旦接口增加方法
 *       目标对象和代理对象都要维护
 */
public class TeachDaoProxy implements ITeachDao {

    private ITeachDao teachDao;

    public TeachDaoProxy(ITeachDao teachDao) {
        this.teachDao = teachDao;
    }

    @Override
    public void teach() {
        System.out.println("代理开始");

        teachDao.teach();

        System.out.println("代理结束");
    }


    public static void main(String[] args) {

        // 创建目标对象
        TeachDao teachDao = new TeachDao();
         // 创建代理对象
        TeachDaoProxy proxy = new TeachDaoProxy(teachDao);
        proxy.teach();
    }
}
