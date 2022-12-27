package com.example.demo.utils;

import javax.persistence.criteria.Expression;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author Nermin Pasalic
 */
public class QueryUtils {

    public static final String TO_DATE_FUNC = "TO_DATE";
    public static final String TRUNC_FUNC = "TRUNC";

    private QueryUtils() {

    }

    public static String contains(String expression) {
        return MessageFormat.format("%{0}%", expression.toLowerCase());
    }

    public static String startingWith(String expression) {
        return MessageFormat.format("{0}%", expression);
    }

    public static String endingWith(String expression) {
        return MessageFormat.format("%{0}", expression);
    }

    public static Expression<LocalDate> toLocalDateExpression(Expression<Date> expression) {
        return expression.as(LocalDate.class);
    }

    public static Expression<Date> toDateExpression(Expression<Timestamp> expression) {
        return expression.as(Date.class);
    }

    public static Expression<String> toStringExpression(Expression<Long> expression) {
        return expression.as(String.class);
    }
}
