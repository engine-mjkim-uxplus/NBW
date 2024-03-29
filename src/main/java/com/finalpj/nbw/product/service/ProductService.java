package com.finalpj.nbw.product.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import com.finalpj.nbw.product.domain.CategoryFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finalpj.common.FileUploader;
import com.finalpj.nbw.member.dao.MemberDao;
import com.finalpj.nbw.member.domain.Member;
import com.finalpj.nbw.product.dao.ProductDao;
import com.finalpj.nbw.product.domain.Product;
import com.finalpj.nbw.product.domain.Review;

import com.finalpj.nbw.product.domain.Criteria;

import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@Service
@Slf4j
public class ProductService {
    
	private ProductDao productDao;
	private MemberDao memberDao;
	private FileUploader fileUploader;

	@Autowired
	public ProductService(ProductDao productDao,  MemberDao memberDao, FileUploader fileUploader) {
		this.productDao = productDao;
		this.memberDao = memberDao;
		this.fileUploader = fileUploader;
	}
	
	@Transactional
	public Map<String, Object> reviewRegister(Review review, HttpSession session) throws Exception {	
		Member member = (Member) session.getAttribute("member");
		
		Map<String,Object> pointMap = new HashMap<>();
		pointMap.put("mem_id", review.getMem_id());
		pointMap.put("mem_point", member.getMem_point()+100);
		
		if(review.getFiles() != null) {
			List<String> fileNames =  fileUploader.fileUpload(review.getFiles(),"review");
			review.setFileNames(fileNames);
			review.setFileSize(fileNames.size());
			pointMap.put("mem_point", member.getMem_point()+200);
		}
		
		productDao.reviewInsert(review);
		productDao.reviewCountUpdate(review);
		memberDao.updateMemPoint(pointMap);
		
		int mem_point = (Integer) pointMap.get("mem_point");
		member.setMem_point(mem_point);
		session.setAttribute("member", member);
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("success", true);
		map.put("msg", "리뷰가 등록되었습니다.");
		return map;
	}

	public Map<String, Object> reviewModify(Review review) {
		
		if(review.getFiles() != null) {
			System.out.println("파일 존재");
			List<String> fileNames =  fileUploader.fileUpload(review.getFiles(),"review");
			review.setFileNames(fileNames);
			review.setFileSize(fileNames.size());
		}else {
			System.out.println("파일 미 존재");
		}
		
		int result = productDao.reviewUpdate(review);
		System.out.println(result);
		
		Map<String, Object> reviewMap = new HashMap<String,Object>();
		reviewMap.put("rv_content", review.getRv_content());
		reviewMap.put("rv_score", review.getRv_score());
		reviewMap.put("fileNames", review.getFileNames());
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("success", true);
		map.put("msg", "리뷰가 수정되었습니다.");
		map.put("review", reviewMap);
		return map;
	}
	
	public Map<String, Object> reviewDelete(Review review) {
		System.out.println("mem_id: "+review.getMem_id());
		System.out.println("rv_content"+review.getRv_content());
		System.out.println("p_no"+review.getP_no());
		System.out.println("rv_score"+review.getRv_score());
		
		int result = productDao.reviewDelete(review);
		System.out.println(result);
		productDao.reviewCountDelete(review);
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("success", true);
		map.put("msg", "리뷰가 삭제되었습니다.");
		return map;
	}
	
	@Transactional
	public Product getProduct(String p_no) {
		Product product = productDao.getProduct(p_no);
		return product;
	}
	
	public int getReviewTotalCnt(String p_no) {
		return productDao.getReviewTotalCnt(p_no);
	}
	
	public List<Map<String, Object>> getReviewListMap(Map<String, Object> pageMap) {
		List<Map<String, Object>> reviewList = productDao.getReviewListMap(pageMap);
		
		for(Map<String,Object> map : reviewList) {
			Timestamp rv_date = (Timestamp) map.get("RV_DATE");
			String strStamp = String.valueOf(rv_date.getTime());
			Date date = new Date(Long.parseLong(strStamp));
			SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
			map.put("RV_DATE",String.valueOf(sdf.format(date)));
		}

		return reviewList;
	}

	/* 상품 등록 */
	public int insertProduct(Product product) throws Exception{
		return productDao.insertProduct(product);
	}

    /* 상품 목록 조회 > 페이징*/
    public List<Product> searchProduct(Criteria criteria) throws Exception {
//        log.info("SERVICE 에서 매개로 전달될 criteria ====> "+ criteria);
        return productDao.selectProduct(criteria);
    }

    /* 조회된 상품 총 갯수 */
    public int getTotalCount(Criteria criteria) throws Exception{
        //log.info("SERVICE ===> 조회된 상품 총 갯수 ");
        return productDao.selectSearchCnt(criteria);
    }

    /* 조회된 상품의 기존 검색 조건에(Criteria) 카테고리 필터링 추가 */
    public List<CategoryFilter> getCategoryFilter(Criteria criteria) throws Exception {

        List<CategoryFilter> categoryFilterList = new ArrayList<>();
        categoryFilterList = productDao.selectProductCategory(criteria);
        return categoryFilterList;
    }


	/* 관리자 페이지 상품 상세 조회 */
	public Product getAdProduct(String p_no) {
		Product product = productDao.getProduct(p_no);
		return product;
	}

	/* 상품 수정 */
	public int modifyProduct(Product product) throws Exception {
		return productDao.updateProduct(product);
	}

	/* 상품 삭제 */
	public int delProduct(Integer p_no) throws Exception{
		return productDao.deleteProduct(p_no);
	}

	public Review memberReview(Map<String, Object> memberMap) {
		return productDao.getMemberReview(memberMap);
	}

	public List<Product> getBestProducts(String p_no){
		Map<String,Object> ParameterMap = new HashMap<>(); 
		ParameterMap.put("p_no", p_no); // 가져올 상품의 카테고리 비교용 
		ParameterMap.put("count", 5); // 가져올 상품의 개수
		return productDao.getBestProducts(ParameterMap);
	}
}
