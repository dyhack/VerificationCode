/*
 * This file is generated by jOOQ.
*/
package swust.xl.pojo.po.mysql.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


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
public class Comments implements Serializable {

    private static final long serialVersionUID = 217510093;

    private String name;
    private String comment;

    public Comments() {}

    public Comments(Comments value) {
        this.name = value.name;
        this.comment = value.comment;
    }

    public Comments(
        String name,
        String comment
    ) {
        this.name = name;
        this.comment = comment;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Comments (");

        sb.append(name);
        sb.append(", ").append(comment);

        sb.append(")");
        return sb.toString();
    }
}