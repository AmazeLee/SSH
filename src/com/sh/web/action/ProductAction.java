package com.sh.web.action;

import java.io.File;

import javax.servlet.jsp.PageContext;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sh.domain.Product;
import com.sh.service.ProductService;
import com.sh.utils.CommonsUtils;
import com.sh.utils.PageBean;

/**
 * @author Amaze_lee
 * @date 2017年10月26日 上午10:11:15 
 * @version V1.0  
 * @Description: 
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	private Product product = new Product();
	private ProductService productService;
	private Integer currentPage;
	private Integer pageSize;
	
	private File photo;
	

	public String list() throws Exception {
		
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		//判断并封装参数
		if(StringUtils.isNotBlank(product.getPname())) {
			dc.add(Restrictions.like("pname","%"+product.getPname()+"%"));
		}
		//1.调用service查询分页数据（PageBean）
		PageBean pb = productService.getPageBean(dc,currentPage,pageSize);
		//2.将PageBean放入request域，转发到页面显示
		ActionContext.getContext().put("pageBean",pb);
		return "list";
	}
	
	
	public String save() throws Exception {
		System.out.println("进入了");
		product.setPid(CommonsUtils.getUUID());
		System.out.println(product);
		File file= new File("product");
		System.out.println(file.getAbsolutePath());
		photo.renameTo(new File("E:/Workspaces/haha.jpg"));
		System.out.println(product);
		//1.调用Service,保存Product对象
		productService.save(product);
		System.out.println(product);
		return "toList";
	}



	public void setProductService(ProductService productService) {
		this.productService = productService;
	}



	@Override
	public Product getModel() {
		return product;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public File getPhoto() {
		return photo;
	}


	public void setPhoto(File photo) {
		this.photo = photo;
	}

	
	
	
}
