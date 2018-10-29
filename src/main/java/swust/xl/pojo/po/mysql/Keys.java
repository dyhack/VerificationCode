/*
 * This file is generated by jOOQ.
*/
package swust.xl.pojo.po.mysql;


import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

import swust.xl.pojo.po.mysql.tables.Article;
import swust.xl.pojo.po.mysql.tables.Comments;
import swust.xl.pojo.po.mysql.tables.Users;
import swust.xl.pojo.po.mysql.tables.records.ArticleRecord;
import swust.xl.pojo.po.mysql.tables.records.CommentsRecord;
import swust.xl.pojo.po.mysql.tables.records.UsersRecord;


/**
 * A class modelling foreign key relationships between tables of the <code>user</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<ArticleRecord, Long> IDENTITY_ARTICLE = Identities0.IDENTITY_ARTICLE;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<ArticleRecord> KEY_ARTICLE_PRIMARY = UniqueKeys0.KEY_ARTICLE_PRIMARY;
    public static final UniqueKey<CommentsRecord> KEY_COMMENTS_PRIMARY = UniqueKeys0.KEY_COMMENTS_PRIMARY;
    public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = UniqueKeys0.KEY_USERS_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<ArticleRecord, Long> IDENTITY_ARTICLE = createIdentity(Article.ARTICLE, Article.ARTICLE.AID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<ArticleRecord> KEY_ARTICLE_PRIMARY = createUniqueKey(Article.ARTICLE, "KEY_article_PRIMARY", Article.ARTICLE.AID);
        public static final UniqueKey<CommentsRecord> KEY_COMMENTS_PRIMARY = createUniqueKey(Comments.COMMENTS, "KEY_comments_PRIMARY", Comments.COMMENTS.COMMENT, Comments.COMMENTS.NAME);
        public static final UniqueKey<UsersRecord> KEY_USERS_PRIMARY = createUniqueKey(Users.USERS, "KEY_users_PRIMARY", Users.USERS.ID);
    }
}