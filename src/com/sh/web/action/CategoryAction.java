package com.sh.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sh.domain.Category;
import com.sh.service.CategoryService;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**
 * @author Amaze_lee
 * @date 2017年10月26日 下午8:10:11
 * @version V1.0
 * @Description:
 */
public class CategoryAction extends ActionSupport implements ModelDriven<Category> {

	private Category category = new Category();
	private CategoryService categoryService;

	public String list() throws Exception {

		// 1.调用service查询类别数据
		List<Category> list = categoryService.getCategoryList();
		// 2.将list转化为json数据
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] { "products" });// 去除级联关系

		String json = JSONArray.fromObject(list, jsonConfig).toString();

		// 3.将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;// 告诉struts2不需要进行结果处理
	}

	public String all() throws Exception {
		// 1.调用service查询类别数据
		List<Category> categoryList = categoryService.getCategoryList();
		// 2.将categoryList放入request域，转发到页面显示
		ActionContext.getContext().put("categoryList", categoryList);
		return "list";
	}

	/**
	 * 拿到商品信息进行回显
	 * 
	 * @return
	 * @throws Exception
	 */
	public String updateCategoryUI() throws Exception {
		// 1.调用service根据cid获得类别对象
		Category c = categoryService.getById(category.getCid());
		// 2.将类别放到request域
		ActionContext.getContext().put("category", c);
		return "categoryui";
	}

	/**
	 * 修改类别
	 * 
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		System.out.println(category);
		categoryService.update(category);
		System.out.println(666666);
		return "tolist";
	}

	@Override
	public Category getModel() {
		return category;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

}
