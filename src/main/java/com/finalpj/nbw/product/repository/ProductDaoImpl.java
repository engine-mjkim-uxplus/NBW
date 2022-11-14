
package com.finalpj.nbw.product.repository;

import com.finalpj.nbw.product.domain.CategoryFilter;
import com.finalpj.nbw.product.domain.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.finalpj.nbw.product.dao.ProductDao;
import com.finalpj.nbw.product.domain.Product;
import com.finalpj.nbw.product.domain.Review;

import java.util.List;
import java.util.Map;

@Repository
@Slf4j
public class ProductDaoImpl implements ProductDao {
	
	private final String namespace = "com.finalpj.nbw.product.dao.ProductMapper.";
	
    private SqlSession sqlSession;
    
    public ProductDaoImpl(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
	

	@Override
	public Product getProduct(String number) {

		return sqlSession.selectOne(namespace+"getProduct", number);
	}

	/* 상품 등록 */
	@Override
	public int insertProduct(Product product) throws Exception {
		return sqlSession.insert(namespace+"insertProduct", product);
	}

	/* 상품 수정 */
	@Override
	public int updateProduct(Product product) throws Exception {
		return sqlSession.update(namespace+"updateProduct", product);
	}

	/* 상품 삭제 */
	@Override
	public int deleteProduct(Integer p_no) throws Exception {
		return sqlSession.update(namespace+"deleteProduct", p_no);
	}

	@Override
	public List<Product> selectProductByWord(String keyword) throws Exception {
		return null;
	}

	/* 추천 검색어 조회 */
	@Override
	public List<Map<String, Object>> selectProductByWord(Map<String, Object> paramMap) throws Exception {
		// log.info("DAO ==> "+ sqlSession.selectList("selectProductByWord", paramMap));
		return sqlSession.selectList(namespace+"selectProductByWord", paramMap);
	}

	/* 상품 목록 조회 > 페이징 포함 */
	@Override
	public List<Product> selectProduct(Criteria criteria) {
		log.info("DAO 에서 매개로 전달될 criteria ====> " + criteria);
		return sqlSession.selectList(namespace+"selectProduct", criteria);
	}

	/* 조건검색 결과 게시물 개수 */
	@Override
	public int selectSearchCnt(Criteria criteria) {
		return sqlSession.selectOne(namespace+"selectTotalProduct", criteria);
	}

	/* 조회된 상품의 카테고리를 다시 조회 > 첫 번째 기준(Criteria)에 의해서 반환된 카테고리 필터를 반환 */
	@Override
	public List<CategoryFilter> selectProductCategory(Criteria criteria) throws Exception {
		// log.info("selectProductCategory"+sqlSession.selectList("selectProductCategory",
		// criteria));
		return sqlSession.selectList(namespace+"selectProductCategory", criteria);
	}

	/* 검색된 카테고리 개수 반환 */
	@Override
	public List<CategoryFilter> selectProductCateInfo(Criteria criteria) throws Exception {
		// log.info("selectProductCategory"+sqlSession.selectList("selectProductCategory",
		// criteria));
		return sqlSession.selectList(namespace+"selectProductCateInfo", criteria);
	}

	@Override
	public void updateLike(Map<String, Object> map) {
		sqlSession.update(namespace+"updateLike", map);
	}

	@Override
	public int updateProductCount(List<Map<String, Object>> productList) throws Exception {
		return sqlSession.update(namespace + "updateProductCount" , productList);
	}

	/* 결제 후 해당 상품 재고 감소 */
	@Override
	public void reviewCountUpdate(Review review) {
		sqlSession.update(namespace+"reviewCountUpdate", review);
	}

	@Override
	public void reviewInsert(Review review) {
		sqlSession.insert(namespace+"reviewInsert", review);
	}

	@Override
	public List<Review> SelectReviewList(Map<String,Object> map) {
		return sqlSession.selectList(namespace+"SelectReviewList",map);
	}


	@Override
	public int getReviewTotalCnt(String p_no) {
		return sqlSession.selectOne(namespace+"getReviewTotalCnt",p_no);
	}


	@Override
	public List<Map<String, Object>> getReviewListMap(Map<String, Object> pageMap) {
		return sqlSession.selectList(namespace+"getReviewListMap",pageMap);
	}


	@Override
	public Review getMemberReview(Map<String, Object> memberMap) {
		return sqlSession.selectOne(namespace+"getMemberReview",memberMap);
	}


	@Override
	public int reviewUpdate(Review review) {
		return sqlSession.update(namespace+"reviewUpdate",review);
	}


	@Override
	public int reviewDelete(Review review) {
		return sqlSession.delete(namespace+"reviewDelete",review);
	}

	@Override
	public void reviewCountDelete(Review review) {
		sqlSession.update(namespace+"reviewCountDelete", review);
	}


	@Override
	public List<Product> getBestProducts(Map<String, Object> map) {
		return sqlSession.selectList(namespace+"getBestProducts",map);
	}
}
