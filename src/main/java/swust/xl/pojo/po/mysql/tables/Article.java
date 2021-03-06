/*
 * This file is generated by jOOQ.
*/
package swust.xl.pojo.po.mysql.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import swust.xl.pojo.po.mysql.Keys;
import swust.xl.pojo.po.mysql.User;
import swust.xl.pojo.po.mysql.tables.records.ArticleRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Article extends TableImpl<ArticleRecord> {

    private static final long serialVersionUID = -1787328980;

    /**
     * The reference instance of <code>user.article</code>
     */
    public static final Article ARTICLE = new Article();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ArticleRecord> getRecordType() {
        return ArticleRecord.class;
    }

    /**
     * The column <code>user.article.aid</code>.
     */
    public final TableField<ArticleRecord, Long> AID = createField("aid", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>user.article.type</code>.
     */
    public final TableField<ArticleRecord, String> TYPE = createField("type", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>user.article.title</code>.
     */
    public final TableField<ArticleRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>user.article.content</code>.
     */
    public final TableField<ArticleRecord, String> CONTENT = createField("content", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>user.article.picturepath</code>.
     */
    public final TableField<ArticleRecord, String> PICTUREPATH = createField("picturepath", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * Create a <code>user.article</code> table reference
     */
    public Article() {
        this("article", null);
    }

    /**
     * Create an aliased <code>user.article</code> table reference
     */
    public Article(String alias) {
        this(alias, ARTICLE);
    }

    private Article(String alias, Table<ArticleRecord> aliased) {
        this(alias, aliased, null);
    }

    private Article(String alias, Table<ArticleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return User.USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ArticleRecord, Long> getIdentity() {
        return Keys.IDENTITY_ARTICLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ArticleRecord> getPrimaryKey() {
        return Keys.KEY_ARTICLE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ArticleRecord>> getKeys() {
        return Arrays.<UniqueKey<ArticleRecord>>asList(Keys.KEY_ARTICLE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Article as(String alias) {
        return new Article(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Article rename(String name) {
        return new Article(name, null);
    }
}
