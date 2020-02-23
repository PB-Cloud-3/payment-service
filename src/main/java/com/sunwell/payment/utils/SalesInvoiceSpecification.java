package com.sunwell.payment.utils;

import java.util.Calendar;


import java.util.LinkedList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.sunwell.payment.model.SalesInvoice;
import com.sunwell.payment.utils.Filters.Filter;


public class SalesInvoiceSpecification extends GenericSpecification<SalesInvoice>
{
	public static final String PROPERTY_CUSTOMER_NAME = "customerName";
	private static final String ATTR_CUSTOMER_NAME = "customer";
	private static final String NESTED_CUSTOMER_NAME = "name";
//	public static final List<String> LIST_NESTED_PROPERTY = new LinkedList<>();
//	
//	static {
//		LIST_NESTED_PROPERTY.add(PROPERTY_CUSTOMER);
//	}
	
	public SalesInvoiceSpecification(Filters _f) {
		super(_f, SalesInvoice.class);
	}
	
	@Override
	protected Predicate convertUnknownFilterToPredicate(Filter _f, Path _root, CriteriaQuery<?> _cq, CriteriaBuilder _cb) throws Exception {
		switch(_f.getKey()) {
			case PROPERTY_CUSTOMER_NAME :
				switch(_f.getComparison()) {
					case Filters.COMPARISON_LIKE :
						return _cb.like(_root.get(ATTR_CUSTOMER_NAME).get(NESTED_CUSTOMER_NAME), (String)_f.getValue());
					default :
						throw new Exception("Error, invalid comparison: " + _f.getComparison() + " for attribute: " + PROPERTY_CUSTOMER_NAME );
				}
			default:
				throw new Exception("Error, invalid attribute: " + _f.getKey() );
		}
	}
}
