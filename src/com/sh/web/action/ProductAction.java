package com.sh.web.action;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
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
public class ProductAction extends ActionSupport implements ModelDriven<Product> {

	private Product product = new Product();
	private ProductService productService;
	private Integer currentPage;
	private Integer pageSize;

	private File photo;
	
	/**
	 * 分页展示商品
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {

		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		// 判断并封装参数
		if (StringUtils.isNotBlank(product.getPname())) {
			dc.add(Restrictions.like("pname", "%" + product.getPname() + "%"));
		}
		// 1.调用service查询分页数据（PageBean）
		PageBean pb = productService.getPageBean(dc, currentPage, pageSize);
		// 2.将PageBean放入request域，转发到页面显示
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	/**
	 * 添加商品
	 * @return
	 * @throws Exception
	 */
	public String save() throws Exception {
		System.out.println("进入了");
		// 设置商品编号
		product.setPid(CommonsUtils.getUUID());
		// 获取当前时间设置为上架日期
		product.setPdate(new Date());
		// 设置pflag
		product.setPflag(0);
		System.out.println(product);

		HttpServletRequest request = ServletActionContext.getRequest();
		String realPath = request.getServletContext().getRealPath("products/1");
		String uuid = CommonsUtils.getUUID();
		photo.renameTo(new File(realPath + "/" + uuid + ".jpg"));
		product.setPimage("products/1/" + uuid + ".jpg");
		System.out.println(realPath);
		System.out.println(product);
		// 1.调用Service,保存Product对象
		productService.save(product);
		System.out.println(product);
		return "toList";
	}
	
	/**
	 * 拿到数据转发到修改页面
	 * @return
	 * @throws Exception
	 */
	public String updateProductUI() throws Exception {
		// 1.调用service根据pid获得商品对象
		System.out.println("取到了：" + product.getPid());
		Product p = productService.getById(product.getPid());
		System.out.println(p);
		// 2.将商品对象放置到request域，并转发到编辑页面
		ActionContext.getContext().put("product", p);
		return "productui";
	}
	
	/**
	 * 商品编辑
	 * @return
	 * @throws Exception
	 */
	public String edit() throws Exception {
		/*// 设置商品编号
		product.setPid(CommonsUtils.getUUID());
		// 获取当前时间设置为上架日期
		product.setPdate(new Date());
		// 设置pflag
		product.setPflag(0);
		System.out.println(product);*/
		HttpServletRequest request = ServletActionContext.getRequest();
		String realPath = request.getServletContext().getRealPath("products/1");
		String uuid = CommonsUtils.getUUID();
		photo.renameTo(new File(realPath + "/" + uuid + ".jpg"));
		product.setPimage("products/1/" + uuid + ".jpg");
		System.out.println(realPath);
		System.out.println(product);
		// 1.调用Service,保存Product对象
		productService.update(product);
		System.out.println(product);
		return "toList";
	}
	
	
	/**
	 * 删除商品
	 * @return
	 * @throws Exception
	 */
	public String delProduct() throws Exception {
		productService.delById(product.getPid());
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
