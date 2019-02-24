package com.mgj.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	@RequestMapping("article-spider")
	public String article_spider() {
		return "html/article/article-spider";
	}
	@RequestMapping("article-list")
	public String article_list() {
		return "html/article/article-list";
	}
	@RequestMapping("article-add")
	public String article_add() {
		return "html/article/article-add";
	}
	@RequestMapping("article-class-edit")
	public String article_class_edit() {
		return "html/article/article-class-edit";
	}
	@RequestMapping("article-class")
	public String article_class() {
		return "html/article/article-class";
	}
	@RequestMapping("article-show")
	public String article_show() {
		return "html/article/article-show";
	}
	@RequestMapping("picture-list")
	public String picture_list() {
		return "html/picture/picture-list";
	}
	@RequestMapping("picture-add")
	public String picture_add() {
		return "html/picture/picture-add";
	}
	@RequestMapping("picture-show")
	public String picture_show() {
		return "html/picture/picture-show";
	}
	@RequestMapping("product-brand")
	public String product_brand() {
		return "html/product/product-brand";
	}
	@RequestMapping("product-add")
	public String product_add() {
		return "html/product/product-add";
	}
	@RequestMapping("product-category-add")
	public String product_category_add() {
		return "html/product/product-category-add";
	}
	@RequestMapping("product-category")
	public String product_category() {
		return "html/product/product-category";
	}
	@RequestMapping("product-list")
	public String product_list() {
		return "html/product/product-list";
	}
	@RequestMapping("feedback-list")
	public String feedback_list() {
		return "html/comments/feedback-list";
	}
	@RequestMapping("member-add")
	public String member_add() {
		return "html/member/member-add";
	}
	@RequestMapping("member-del")
	public String member_del() {
		return "html/member/member-del";
	}
	@RequestMapping("member-list")
	public String member_list() {
		return "html/member/member-list";
	}
	@RequestMapping("member-record-browse")
	public String member_record_browse() {
		return "html/member/member-record-browse";
	}
	@RequestMapping("member-record-download")
	public String member_record_download() {
		return "html/member/member-record-download";
	}
	@RequestMapping("member-record-share")
	public String member_record_share() {
		return "html/member/member-record-share";
	}
	@RequestMapping("member-show")
	public String member_show() {
		return "html/member/member-show";
	}
	@RequestMapping("admin-add")
	public String admin_add() {
		return "html/admin/admin-add";
	}
	@RequestMapping("admin-list")
	public String admin_list() {
		return "html/admin/admin-list";
	}
	@RequestMapping("admin-password-edit")
	public String admin_password_edit() {
		return "html/admin/admin-password-edit";
	}
	@RequestMapping("admin-permission")
	public String admin_permission() {
		return "html/admin/admin-permission";
	}
	@RequestMapping("admin-role-add")
	public String admin_role_add() {
		return "html/admin/admin-role-add";
	}
	@RequestMapping("admin-role")
	public String admin_role() {
		return "html/admin/admin-role";
	}
	@RequestMapping("admin-permission-add")
	public String admin_permission_add() {
		return "html/admin/admin-permission";
	}
	@RequestMapping("charts-1")
	public String charts_1() {
		return "html/charts/charts-1";
	}
	@RequestMapping("charts-2")
	public String charts_2() {
		return "html/charts/charts-2";
	}
	@RequestMapping("charts-3")
	public String charts_3() {
		return "html/charts/charts-3";
	}
	@RequestMapping("charts-4")
	public String charts_4() {
		return "html/charts/charts-4";
	}
	@RequestMapping("charts-5")
	public String charts_5() {
		return "html/charts/charts-5";
	}
	@RequestMapping("charts-6")
	public String charts_6() {
		return "html/charts/charts-6";
	}
	@RequestMapping("charts-7")
	public String charts_7() {
		return "html/charts/charts-7";
	}
	@RequestMapping("system-base")
	public String system_base() {
		return "html/system/system-base";
	}
	@RequestMapping("system-category-add")
	public String system_category_add() {
		return "html/system/system-category-add";
	}
	@RequestMapping("system-category")
	public String system_category() {
		return "html/system/system-category";
	}
	@RequestMapping("system-data")
	public String system_data() {
		return "html/system/system-data";
	}
	@RequestMapping("system-log")
	public String system_log() {
		return "html/system/system-log";
	}
	@RequestMapping("system-shielding")
	public String system_shielding() {
		return "html/system/system-shielding";
	}
}
