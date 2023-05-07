package net.lab1024.sa.admin.module.business.path.service;

import java.util.Date;
import java.util.List;

import net.lab1024.sa.admin.config.AuthenticationInfo;
import net.lab1024.sa.admin.module.business.path.dao.PathDao;
import net.lab1024.sa.admin.module.business.path.domain.entity.PathEntity;
import net.lab1024.sa.admin.module.business.path.domain.form.PathAddForm;
import net.lab1024.sa.admin.module.business.path.domain.form.PathQueryForm;
import net.lab1024.sa.admin.module.business.path.domain.form.PathUpdateForm;
import net.lab1024.sa.admin.module.business.path.domain.vo.PathVO;
import net.lab1024.sa.common.common.util.SmartBeanUtil;
import net.lab1024.sa.common.common.util.SmartPageUtil;
import net.lab1024.sa.common.common.domain.ResponseDTO;
import net.lab1024.sa.common.common.domain.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 设备路线 Service
 *
 * @Author pengch
 * @Date 2023-04-27 17:39:58
 * @Copyright pengch
 */

@Service
public class PathService {

    @Autowired
    private PathDao pathDao;

    @Resource
    private AuthenticationInfo authenticationInfo;

    /**
     * 分页查询
     *
     * @param queryForm
     * @return
     */
    public PageResult<PathVO> queryPage(PathQueryForm queryForm) {
        Page<?> page = SmartPageUtil.convert2PageQuery(queryForm);
        List<PathVO> list = pathDao.queryPage(page, queryForm);
        PageResult<PathVO> pageResult = SmartPageUtil.convert2PageResult(page, list);
        return pageResult;
    }

    /**
     * 添加
     */
    public ResponseDTO<String> add(PathAddForm addForm) {
        PathEntity pathEntity = SmartBeanUtil.copy(addForm, PathEntity.class);
        pathEntity.setCempName(authenticationInfo.getAuthentication().getName());
        pathEntity.setCtime(new Date());
        pathEntity.setTs01(System.currentTimeMillis());
        pathDao.insert(pathEntity);
        return ResponseDTO.ok();
    }

    /**
     * 更新
     *
     * @param updateForm
     * @return
     */
    public ResponseDTO<String> update(PathUpdateForm updateForm) {
        PathEntity pathEntity = SmartBeanUtil.copy(updateForm, PathEntity.class);
        pathEntity.setUempName(authenticationInfo.getAuthentication().getName());
        pathEntity.setUtime(new Date());
        pathEntity.setNew_ts01(System.currentTimeMillis());
        int row=pathDao.updatePathById(pathEntity);
        if (row==0){
            throw new RuntimeException("数据已改变,请查询后再操作!");
        }
        return ResponseDTO.ok();
    }

    /**
     * 批量删除
     *
     * @param idList
     * @return
     */
    public ResponseDTO<String> batchDelete(List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)){
            return ResponseDTO.ok();
        }

        pathDao.deleteBatchIds(idList);
        return ResponseDTO.ok();
    }

    /**
     * 单个删除
     */
    public ResponseDTO<String> delete(Long id) {
        if (null == id){
            return ResponseDTO.ok();
        }
        pathDao.deleteById(id);
        return ResponseDTO.ok();
    }
}
