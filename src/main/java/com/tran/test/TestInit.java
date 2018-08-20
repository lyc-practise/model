package com.tran.test;


import com.tran.dao.OtherDao;
import com.tran.dao.TranDao;
import com.tran.model.Tran;
import com.utils.BeanUtils;
import com.utils.ExecutorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestInit {

    public static final Logger LOGGER = LoggerFactory.getLogger(TestInit.class);
    private TranDao tranDao = BeanUtils.getBean("TranDao");   // sqlTemplate 1
    private OtherDao otherDao = BeanUtils.getBean("OtherDao");  // sqlTemplate 2

    public static void main(String[] args) {

      TestInit init = new TestInit();
      init.executeList(10);

//      System.out.println("-------------------");
//      init.executeListOther(10);

    }

    public void executeList(int threadNum){
        for(int i = 0 ; i < threadNum ; i ++){
            ExecutorUtils.execute( ()-> tranDao.queryList(new Tran()));
        }
    }

    public void executeListOther(int threadNum){
        for(int i = 0 ; i < threadNum ; i ++){
            ExecutorUtils.execute( ()-> otherDao.queryList(new Tran()));
        }
    }


}
