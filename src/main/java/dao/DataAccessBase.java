package dao;

import entity.*;
import java.util.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * データアクセスクラス
 *
 * @author yamazaki
 * @param <T> DBアクセスに指定するエンティティ
 */
public abstract class DataAccessBase<T extends IsEntity> {

    /**
     * 指定されたクラス
     */
    protected Class<T> entityClass;

    /**
     * エンティティマネージャー
     */
    @PersistenceContext
    protected EntityManager em;

    /**
     * コンストラクタ
     *
     * @param entityClass 指定する型
     */
    public DataAccessBase(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * 新規登録
     *
     * @param entity 新規登録を行うエンティティ
     */
    public void create(T entity) {        
        em.persist(entity);
    }

    /**
     * 更新（上書き）
     *
     * @param entity 更新（上書き）を行うエンティティ
     */
    public void update(T entity) {
        em.merge(entity);
    }

    /**
     * 削除
     *
     * @param entity 削除を行うエンティティ
     */
    public void delete(T entity) {
        em.remove(em.merge(entity));
    }

    /**
     * IDを指定して1件取得
     *
     * @param id 指定するID
     * @return 取得したデータ
     */
    public T search(Object id) {
        return em.find(entityClass, id);
    }

    /**
     * データを全件取得
     *
     * @return 取得したデータ
     */
    public List<T> searchAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    /**
     * データをDBに反映させる
     */
    public void flush() {
        em.flush();
    }
}
