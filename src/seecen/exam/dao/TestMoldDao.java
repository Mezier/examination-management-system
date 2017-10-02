package seecen.exam.dao;

import java.util.List;

import seecen.exam.po.ModelDetail;
import seecen.exam.po.TestMold;
import seecen.utils.PageUtil;



public interface TestMoldDao {
   public boolean addTestModel(TestMold model,List<ModelDetail> details);
   public boolean delTestModel(int id,List<ModelDetail> details);
   public boolean updateTestModel(TestMold model,List<ModelDetail> details);
   public int MoldCount();
   public List<TestMold> findAllMoldByPage(PageUtil page);
   public List<ModelDetail> findDetailsByModelId(int id);
   public TestMold getTestMoldById(int moldId);
}
