package com.ease.service.impl;

import com.ease.dao.ContentDao;
import com.ease.model.Content;
import com.ease.service.ContentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/*可查的异常（checked exceptions）:Exception下除了RuntimeException外的异常
 不可查的异常（unchecked exceptions）:RuntimeException及其子类和错误（Error）
 @Transactional默认unchecked
  1 让checked例外也回滚：在整个方法前加上 @Transactional(rollbackFor=Exception.class)
2 让unchecked例外不回滚： @Transactional(notRollbackFor=RunTimeException.class)
3 不需要事务管理的(只查询的)方法：@Transactional(propagation=Propagation.NOT_SUPPORTED)
 */
@Service
/*当@Transactional作用于类上时，该类的所有 public 方法将都具有该类型的事务属性*/
public class ContentServiceImpl implements ContentService {
    @Resource
    private ContentDao contentDao;

    public List<Content> getAllContent() {
        return contentDao.selectAllContent();
    }

    public List<Content> getContentIsSale() {
        return contentDao.selectContentIsSale();
    }

    public Content getContentDetailById(Long contentId) {
        return contentDao.selectContentDetailById(contentId);
    }

    /* https://blog.csdn.net/bao19901210/article/details/41724355
    虽然 @Transactional 注解可以作用于接口、接口方法、类以及类方法上，但是 Spring 建议不要在接口或者接口方法上使用该注解，因为这只有在使用基于接口的代理时它才会生效。另外， @Transactional 注解应该只被应用到 public 方法上，这是由 Spring AOP 的本质决定的。如果你在 protected、private 或者默认可见性的方法上使用 @Transactional 注解，这将被忽略，也不会抛出任何异常。*/
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateContentAndDetailById(Content content) {
        if (content == null || content.getId() == null) {
            return false;
        }
        content.setModifyTime(new Date());
        content.setIsDelete((short) 0);
        contentDao.updateContentDetailById(content);
        //参数传递过来的content id 是detail Id 不是简略版content id
        //注意contentId 和 detailId 不是一个ID！，更新时需要查询contend id
        Content tmp = contentDao.selectContentByDetailId(content.getId());
        content.setId(tmp.getId());
        contentDao.updateContentById(content);

        return true;
    }

    /**
     * https://blog.csdn.net/trigl/article/details/50968079
     * 1.添加事务注解
     * 使用propagation 指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时如何使用事务。
     * 默认取值为REQUIRED，即使用调用方法的事务
     * REQUIRES_NEW：使用自己的事务，调用的事务方法的事务被挂起。
     * 2.使用isolation 指定事务的隔离级别，最常用的取值为READ_COMMITTED
     * 3.默认情况下 Spring 的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置。通常情况下，默认值即可。
     * 4.使用readOnly 指定事务是否为只读。 表示这个事务只读取数据但不更新数据，这样可以帮助数据库引擎优化事务。若真的是一个只读取数据库值得方法，应设置readOnly=true
     * 5.使用timeOut 指定强制回滚之前事务可以占用的时间。
     */
    @Transactional(rollbackFor = Exception.class)
    public Long addContentAndDetail(Content content) {
        if (content == null) {
            return 0L;
        }
        content.setCreateTime(new Date());
        content.setModifyTime(new Date());
        content.setIsDelete((short) 0);
        content.setIsSale((short) 1);
        contentDao.addContentDetail(content);
        content.setDetailId(content.getId());
        content.setId(null);
        contentDao.addContent(content);
        return content.getDetailId();
    }

    @Transactional(rollbackFor = Exception.class)
    public Integer deleteItem(Long id) {
        if (id == null) {
            return 0;
        }
        contentDao.deleteContentDetailById(id);
        Integer res = contentDao.deleteContentByDetailId(id);
        return res;
    }
}
